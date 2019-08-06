package de.ropemc.rv2.mc114.transformer;

import de.ropemc.rv2.api.ClassTransformer;
import javassist.CtClass;
import javassist.CtMethod;

public class ClientPlayerEntityTransformer implements ClassTransformer {
    public String[] getTransformedClasses() {
        return new String[] {"dmp"};
    }

    public void transform(CtClass cc) {
        try {
            cc.getClassPool().importPackage("de.ropemc.rv2.mc114");
            CtMethod sendChatMessageMethod = cc.getDeclaredMethod("f", new CtClass[] {cc.getClassPool().get("java.lang.String")});
            sendChatMessageMethod.insertBefore("if(EventFactory.onClientChat($1))return;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
