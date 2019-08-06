package de.ropemc.rv2.mc114.minecraft.client.gui;

import de.ropemc.rv2.api.minecraft.client.gui.FontRenderer;
import de.ropemc.rv2.util.ReflectAccessor;

public class FontRendererImpl implements FontRenderer {

    private static ReflectAccessor accessor = ReflectAccessor.getByName("cyu");

    private static int mDrawStringWithShadow = accessor.getMethodAccess().getIndex("a", String.class, float.class, float.class, int.class);
    private static int mDrawString = accessor.getMethodAccess().getIndex("b", String.class, float.class, float.class, int.class);

    private Object handle;

    public FontRendererImpl(Object handle){
        this.handle = handle;
    }

    public int drawStringWithShadow(String text, float x, float y, int color) {
        return (int) accessor.getMethodAccess().invoke(this.handle, mDrawStringWithShadow, text, x, y, color);
    }

    public int drawString(String text, float x, float y, int color) {
        return (int) accessor.getMethodAccess().invoke(this.handle, mDrawString, text, x, y, color);
    }
}
