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
            cc.getClassPool().importPackage("de.ropemc.rv2.api");
            cc.getClassPool().importPackage("de.ropemc.rv2.api.event");
            cc.getClassPool().importPackage("de.ropemc.rv2.api.event.game");
            CtMethod sendChatMessageMethod = cc.getDeclaredMethod("a");
            sendChatMessageMethod.insertBefore("ClientChatEvent event = new ClientChatEvent($1); Rope.getEventBus().fire(event); if (event.isCancelled()) return;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
