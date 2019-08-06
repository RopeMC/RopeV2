package de.ropemc.rv2.mc114.minecraft.client.gui;

import de.ropemc.rv2.api.minecraft.client.gui.AbstractGui;
import de.ropemc.rv2.util.ReflectAccessor;

public class AbstractGuiImpl implements AbstractGui {

    private static ReflectAccessor accessor = ReflectAccessor.getByName("cyw");

    private static int mHLine = accessor.getMethodAccess().getIndex("hLine", int.class, int.class, int.class, int.class);
    private static int mVLine = accessor.getMethodAccess().getIndex("vLine", int.class, int.class, int.class, int.class);
    private static int mFill = accessor.getMethodAccess().getIndex("fill", int.class, int.class, int.class, int.class, int.class);

    protected Object handle;

    protected AbstractGuiImpl(Object handle){
        this.handle = handle;
    }

    public void hLine(int x, int y, int width, int color) {
        accessor.getMethodAccess().invoke(this.handle, mHLine, x, y, width, color);
    }

    public void vLine(int x, int y, int height, int color) {
        accessor.getMethodAccess().invoke(this.handle, mVLine, x, y, height, color);
    }

    public void fill(int x1, int y1, int x2, int y2, int color) {
        accessor.getMethodAccess().invoke(this.handle, mFill, x1, y1, x2, y2, color);
    }

}
