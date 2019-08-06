package de.ropemc.rv2.mc114.transformer;

import de.ropemc.rv2.api.ClassTransformer;
import javassist.CtClass;
import javassist.CtMethod;

public class IngameGuiTransformer implements ClassTransformer {
    public String[] getTransformedClasses() {
        return new String[] {"cyv"};
    }

    public void transform(CtClass cc) {
        try {
            cc.getClassPool().importPackage("de.ropemc.rv2.api");
            cc.getClassPool().importPackage("de.ropemc.rv2.api.event");
            cc.getClassPool().importPackage("de.ropemc.rv2.api.event.render");
            CtMethod renderGameOverlayMethod = cc.getDeclaredMethod("a", new CtClass[]{CtClass.floatType});
            renderGameOverlayMethod.insertBefore("Rope.getEventBus().fire(new BeforeRender2DEvent($1));");
            renderGameOverlayMethod.insertAfter("Rope.getEventBus().fire(new AfterRender2DEvent($1));");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
