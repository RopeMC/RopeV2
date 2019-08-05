package de.ropemc.rv2.api;

import javassist.CtClass;

public interface ClassTransformer {
    String[] getTransformedClasses();
    void transform(CtClass ctClass);
}
