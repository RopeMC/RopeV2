package de.ropemc.rv2.mc114.transformer;

import de.ropemc.rv2.api.ClassTransformer;
import javassist.CtClass;
import javassist.CtMethod;

public class KeyboardListenerTransformer implements ClassTransformer {
    public String[] getTransformedClasses() {
        return new String[]{"cya"};
    }
    public void transform(CtClass ctClass) {
        try {
            ctClass.getClassPool().importPackage("de.ropemc.rv2.mc114");
            CtMethod method = ctClass.getDeclaredMethod("a", new CtClass[]{CtClass.longType, CtClass.intType, CtClass.intType, CtClass.intType, CtClass.intType});
            method.insertBefore("EventFactory.onKey($1,$2,$3,$4,$5);");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
