package de.ropemc.rv2.mc114;

import de.ropemc.rv2.api.ClassTransformer;
import de.ropemc.rv2.api.Minecraft;
import de.ropemc.rv2.api.Rope;
import javassist.*;

import javax.swing.*;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Field;
import java.security.ProtectionDomain;

public class HookTransformer implements ClassTransformer {

    public HookTransformer() {
        JFrame frame = new JFrame();
        JButton button = new JButton("Klick mich");
        button.addActionListener(e -> Rope.getMinecraft().getPlayer().setHealth(10));
        frame.add(button);
        frame.setVisible(true);
    }

    public byte[] transform(String s) {
        if ("cyc".equals(s)) {
            try {
                ClassPool cp = ClassPool.getDefault();
                cp.importPackage("de.ropemc.rv2.mc114");
                CtClass cc = cp.get("cyc");
                CtMethod runMethod = cc.getDeclaredMethod("b");
                runMethod.insertBefore("{HookTransformer.setMinecraft(this);}");
                byte[] byteCode = cc.toBytecode();
                cc.detach();
                return byteCode;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void setMinecraft(Object object) {
        Minecraft minecraft = new MinecraftImpl(object);
        try {
            Field minecraftField = Rope.getRopeMC().getClass().getDeclaredField("minecraft");
            minecraftField.setAccessible(true);
            minecraftField.set(Rope.getRopeMC(), minecraft);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
