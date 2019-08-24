package de.ropemc.rv2.mc114.transformer;

import de.ropemc.rv2.api.ClassTransformer;
import de.ropemc.rv2.api.Rope;
import de.ropemc.rv2.api.event.game.RegistryEvent;
import de.ropemc.rv2.api.manager.BlockManager;
import de.ropemc.rv2.api.manager.ItemManager;
import de.ropemc.rv2.mc114.manager.BlockManagerImpl;
import de.ropemc.rv2.mc114.manager.ItemManagerImpl;
import de.ropemc.rv2.util.TransformUtil;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtConstructor;

public class BlocksTransformer implements ClassTransformer {
    public String[] getTransformedClasses() {
        return new String[]{"bmw"};
    }
    public void transform(CtClass ctClass) {
        CtConstructor constructor = TransformUtil.getClassInitializer(ctClass);
        try {
            constructor.insertAfter("BlocksTransformer.registerBlocks();");
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }
    public static void registerBlocks(){
        Rope.getRopeMC().implement(BlockManager.class, new BlockManagerImpl());
        Rope.getRopeMC().implement(ItemManager.class, new ItemManagerImpl());
        Rope.getEventBus().fire(new RegistryEvent());
    }
}
