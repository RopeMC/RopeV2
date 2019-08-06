package de.ropemc.rv2.api.event.render;

import de.ropemc.rv2.api.event.Event;
import de.ropemc.rv2.api.minecraft.client.gui.IngameGui;

public class Render2DEvent extends Event {
    private IngameGui gui;
    private float partialTicks;

    public Render2DEvent(IngameGui gui, float partialTicks) {
        this.gui = gui;
        this.partialTicks = partialTicks;
    }

    public IngameGui getGui(){
        return gui;
    }

    public float getPartialTicks() {
        return partialTicks;
    }
}