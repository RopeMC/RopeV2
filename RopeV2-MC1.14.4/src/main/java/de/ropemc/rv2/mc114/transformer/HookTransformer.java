package de.ropemc.rv2.mc114.transformer;

import de.ropemc.rv2.api.ClassTransformer;
import de.ropemc.rv2.api.minecraft.client.Minecraft;
import de.ropemc.rv2.api.Rope;
import de.ropemc.rv2.api.minecraft.util.text.StringTextComponent;
import de.ropemc.rv2.mc114.minecraft.client.MinecraftImpl;
import javassist.*;

import javax.swing.*;
import java.lang.reflect.Field;

public class HookTransformer implements ClassTransformer {

    public HookTransformer() {
        JFrame frame = new JFrame();
        JButton button = new JButton("Klick mich");
        button.addActionListener(e -> Rope.getMinecraft().getPlayer().sendMessage(new StringTextComponent("Hey")));
        frame.add(button);
        frame.setVisible(true);
    }

    public String[] getTransformedClasses() {
        return new String[]{"cyc"};
    }

    public void transform(CtClass cc) {
        try {
            cc.getClassPool().importPackage("de.ropemc.rv2.mc114.transformer");
            CtMethod runMethod = cc.getDeclaredMethod("b");
            runMethod.insertBefore("{HookTransformer.setMinecraft(this);}");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
