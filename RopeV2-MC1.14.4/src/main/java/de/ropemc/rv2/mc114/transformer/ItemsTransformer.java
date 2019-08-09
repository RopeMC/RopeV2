package de.ropemc.rv2.mc114.transformer;

import de.ropemc.rv2.api.ClassTransformer;
import de.ropemc.rv2.api.Rope;
import de.ropemc.rv2.mc114.manager.BlockManagerImpl;
import de.ropemc.rv2.mc114.manager.ItemManagerImpl;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtConstructor;

public class ItemsTransformer implements ClassTransformer {
    public String[] getTransformedClasses() {
        return new String[]{"bck"};
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
            System.out.println("Error transforming Items!");
            return;
        }
        try {
            constructor.insertAfter("ItemsTransformer.registerItems();");
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }
    public static void registerItems(){
        ItemManagerImpl itemManager = (ItemManagerImpl) Rope.getRopeMC().getItemManager();
        itemManager.ready();
    }
}
