package de.ropemc.rv2.mc114.minecraft.client.gui;

import de.ropemc.rv2.api.minecraft.client.gui.IngameGui;
import de.ropemc.rv2.util.ReflectAccessor;

public class IngameGuiImpl extends AbstractGuiImpl implements IngameGui {

    private static ReflectAccessor accessor = ReflectAccessor.getByName("cyv");

    private static int mSetOverlayMessage = accessor.getMethodAccess().getIndex("a", String.class, boolean.class);
    private static int mDisplayTitle = accessor.getMethodAccess().getIndex("a", String.class, String.class, int.class, int.class, int.class);
    private static int fScaledWidth = accessor.getFieldAccess().getIndex("D");
    private static int fScaledHeight = accessor.getFieldAccess().getIndex("E");

    public IngameGuiImpl(Object handle) {
        super(handle);
    }

    public void setOverlayMessage(String message, boolean animateColor){
        accessor.getMethodAccess().invoke(handle, mSetOverlayMessage, message, animateColor);
    }

    public void displayTitle(String title, String subTitle, int timeFadeIn, int displayTime, int timeFadeOut){
        accessor.getMethodAccess().invoke(handle, mDisplayTitle, title, subTitle, timeFadeIn, displayTime, timeFadeOut);
    }

    public int getScaledWidth() {
        return accessor.getFieldAccess().getInt(handle, fScaledWidth);
    }

    public int getScaledHeight() {
        return accessor.getFieldAccess().getInt(handle, fScaledHeight);
    }

}
