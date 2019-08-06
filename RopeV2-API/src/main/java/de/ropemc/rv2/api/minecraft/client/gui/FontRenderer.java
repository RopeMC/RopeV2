package de.ropemc.rv2.api.minecraft.client.gui;

public interface FontRenderer {

    int drawStringWithShadow(String text, float x, float y, int color);
    int drawString(String text, float x, float y, int color);

}
