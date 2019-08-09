package de.ropemc.rv2.mc114.transformer;

import de.ropemc.rv2.api.ClassTransformer;
import de.ropemc.rv2.api.Rope;
import de.ropemc.rv2.mc114.manager.BlockManagerImpl;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtConstructor;

public class BlocksTransformer implements ClassTransformer {
    public String[] getTransformedClasses() {
        return new String[]{"bmw"};
    }
    public void transform(CtClass ctClass) {
        ctClass.getClassPool().importPackage("de.ropemc.rv2.mc114.transformer");
        CtConstructor constructor = ctClass.getClassInitializer();
        if(constructor == null){
            try {
                constructor = ctClass.makeClassInitializer();
            } catch (CannotCompileException e) {
                e.printStackTrace();
            }
        }
        if(constructor == null){
            System.out.println("Error transforming Blocks!");
            return;
        }
        try {
            constructor.insertAfter("BlocksTransformer.registerBlocks();");
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }
    public static void registerBlocks(){
        BlockManagerImpl blockManager = (BlockManagerImpl) Rope.getRopeMC().getBlockManager();
        blockManager.ready();
    }
}
