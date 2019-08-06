package de.ropemc.rv2.mc114.transformer;

import de.ropemc.rv2.api.ClassTransformer;
import javassist.*;

public class GameLoopTransformer implements ClassTransformer {

    public String[] getTransformedClasses() {
        return new String[]{"cyc"};
    }

    public void transform(CtClass cc) {
        try {
            cc.getClassPool().importPackage("de.ropemc.rv2.mc114");
            CtMethod gameLoopMethod = cc.getDeclaredMethod("e", new CtClass[]{CtClass.booleanType});
            gameLoopMethod.insertBefore("EventFactory.onGameLoop($1);");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
