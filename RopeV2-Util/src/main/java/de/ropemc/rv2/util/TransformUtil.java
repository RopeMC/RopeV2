package de.ropemc.rv2.util;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtConstructor;

public class TransformUtil {
    public static CtConstructor getClassInitializer(CtClass ctClass) {
        CtConstructor constructor = ctClass.getClassInitializer();
        if (constructor == null) {
            try {
                constructor = ctClass.makeClassInitializer();
            } catch (CannotCompileException e) {
                e.printStackTrace();
            }
        }
        if (constructor == null) {
            System.out.println("Error transforming ProtocolType!");
            return null;
        }

        return constructor;
    }
}
