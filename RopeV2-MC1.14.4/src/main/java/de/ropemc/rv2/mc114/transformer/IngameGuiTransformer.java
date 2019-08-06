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
            cc.getClassPool().importPackage("de.ropemc.rv2.mc114");
            CtMethod renderGameOverlayMethod = cc.getDeclaredMethod("a", new CtClass[]{CtClass.floatType});
            renderGameOverlayMethod.insertBefore("EventFactory.onPreRender2D(this,$1);");
            renderGameOverlayMethod.insertAfter("EventFactory.onRender2D(this,$1);");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
