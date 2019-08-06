package de.ropemc.rv2.api.minecraft.client.gui;

public interface AbstractGui {

    void hLine(int x, int y, int width, int color);
    void vLine(int x, int y, int height, int color);
    void fill(int x1, int y1, int x2, int y2, int color);

}
