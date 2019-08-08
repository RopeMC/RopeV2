package de.ropemc.rv2.api.minecraft.client.gui;

public interface IngameGui extends AbstractGui {

    void setOverlayMessage(String message, boolean animateColor);

    void displayTitle(String title, String subTitle, int timeFadeIn, int displayTime, int timeFadeOut);

    int getScaledWidth();

    int getScaledHeight();
}
