package de.ropemc.rv2.mc114.transformer;

import de.ropemc.rv2.api.ClassTransformer;
import javassist.*;

public class GameLoopTransformer implements ClassTransformer {

    public void transform(CtClass cc) {
        try {
            cc.getClassPool().importPackage("de.ropemc.rv2.api");
            cc.getClassPool().importPackage("de.ropemc.rv2.api.event");
            cc.getClassPool().importPackage("de.ropemc.rv2.api.event.game");
            CtMethod gameLoopMethod = cc.getDeclaredMethod("e", new CtClass[]{CtClass.booleanType});
            gameLoopMethod.insertBefore("Rope.getEventBus().fire(new GameLoopEvent($1));");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] getTransformedClasses() {
        return new String[]{"cyc"};
    }
}
