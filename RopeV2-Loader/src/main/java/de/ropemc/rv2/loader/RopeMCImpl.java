package de.ropemc.rv2.loader;

import de.ropemc.rv2.api.ClassTransformer;
import de.ropemc.rv2.api.MinecraftWrapperFactory;
import de.ropemc.rv2.api.Rope;
import de.ropemc.rv2.api.event.EventBus;
import de.ropemc.rv2.api.event.game.ClientChatEvent;
import de.ropemc.rv2.api.event.game.GameLoopEvent;
import de.ropemc.rv2.api.event.render.Render2DEvent;
import de.ropemc.rv2.api.minecraft.client.Minecraft;
import de.ropemc.rv2.api.RopeMC;
import de.ropemc.rv2.api.minecraft.client.entity.player.ClientPlayerEntity;
import de.ropemc.rv2.api.minecraft.util.math.Vec3d;
import de.ropemc.rv2.api.minecraft.util.text.StringTextComponent;
import de.ropemc.rv2.api.mod.Mod;
import de.ropemc.rv2.api.mod.ModLoader;
import de.ropemc.rv2.mc114.MinecraftWrapperFactoryImpl;
import de.ropemc.rv2.mc114.transformer.ClientPlayerEntityTransformer;
import de.ropemc.rv2.mc114.transformer.HookTransformer;
import de.ropemc.rv2.mc114.transformer.GameLoopTransformer;
import de.ropemc.rv2.mc114.transformer.IngameGuiTransformer;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RopeMCImpl implements RopeMC {

    private Minecraft minecraft = null;
    private EventBus eventBus;
    private Map<String,List<ClassTransformer>> transformerMap = new HashMap<>();
    private MinecraftWrapperFactory minecraftWrapperFactory;
    private ModLoader modLoader = new SimpleModLoader();
    private File ropeDir = new File("RopeV2");

    public RopeMCImpl(){
        this.eventBus = new EventBus();
        this.minecraftWrapperFactory = new MinecraftWrapperFactoryImpl();
    }

    public Minecraft getMinecraft() {
        return minecraft;
    }

    public EventBus getEventBus(){
        return eventBus;
    }

    public File getRopeFolder(){
        if(!ropeDir.exists())
            ropeDir.mkdir();
        return ropeDir;
    }

    public File getModsFolder(){
        File modsFolder = new File(getRopeFolder(), "Mods");
        if(!modsFolder.exists())
            modsFolder.mkdir();
        return modsFolder;
    }

    public void addTransformer(ClassTransformer transformer) {
        for(String className : transformer.getTransformedClasses()){
            List<ClassTransformer> transformers = transformerMap.get(className);
            if(transformers == null)
                transformers = new ArrayList<>();
            transformers.add(transformer);
            transformerMap.put(className, transformers);
        }
    }

    public MinecraftWrapperFactory getMinecraftWrapperFactory(){
        return minecraftWrapperFactory;
    }

    public byte[] transform(String className){
        if(transformerMap.containsKey(className)){
            try {
                ClassPool cp = ClassPool.getDefault();
                CtClass ctClass = cp.get(className);
                for(ClassTransformer transformer : transformerMap.get(className)){
                    transformer.transform(ctClass);
                }
                byte[] bytecode = ctClass.toBytecode();
                ctClass.detach();
                return bytecode;
            } catch (NotFoundException | CannotCompileException | IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void run(){
        modLoader.loadMods(getModsFolder());
        modLoader.getMods().forEach(Mod::onEnable);
        addTransformer(new HookTransformer());
        addTransformer(new GameLoopTransformer());
        addTransformer(new IngameGuiTransformer());
        addTransformer(new ClientPlayerEntityTransformer());
        System.out.println("Hello World from RopeV2");
    }

    public ModLoader getModLoader(){
        return modLoader;
    }

}
