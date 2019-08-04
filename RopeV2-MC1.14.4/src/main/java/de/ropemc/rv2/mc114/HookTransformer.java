package de.ropemc.rv2.mc114;

import de.ropemc.rv2.api.Minecraft;
import javassist.*;

import javax.swing.*;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class HookTransformer implements ClassFileTransformer {
    private static Minecraft minecraft;

    public HookTransformer() {
        JFrame frame = new JFrame();
        JButton button = new JButton("Klick mich");
        button.addActionListener(e -> button.setText("" + minecraft.getPlayer().getHealth()));
        frame.add(button);
        frame.setVisible(true);
    }

    public byte[] transform(ClassLoader loader, String s, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if ("cyc".equals(s)) {
            try {
                ClassPool cp = ClassPool.getDefault();
                CtClass cc = cp.get("cyc");
                CtMethod runMethod = cc.getDeclaredMethod("b");
                runMethod.insertBefore("{System.out.println(1337);}");
                byte[] byteCode = cc.toBytecode();
                cc.detach();
                return byteCode;
            } catch (NotFoundException | CannotCompileException | IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static void setMinecraft(Object object) {
        System.out.println("======================");
        System.out.println("SET MINECRAFT YEEET");
        System.out.println("======================");
        minecraft = new MinecraftImpl(object);
    }
}
