package de.ropemc.rv2.mc114.transformer;

import de.ropemc.rv2.api.ClassTransformer;
import de.ropemc.rv2.api.Rope;
import de.ropemc.rv2.api.event.game.PacketRegistryEvent;
import de.ropemc.rv2.util.TransformUtil;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtConstructor;

public class ProtocolTypeTransformer implements ClassTransformer {
    public String[] getTransformedClasses() {
        return new String[]{"jd"};
    }
    public void transform(CtClass ctClass) {
        CtConstructor constructor = TransformUtil.getClassInitializer(ctClass);
        try {
            constructor.insertAfter("ProtocolTypeTransformer.registerPackets();");
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }
    public static void registerPackets(){
        Rope.getEventBus().fire(new PacketRegistryEvent());
    }
}
