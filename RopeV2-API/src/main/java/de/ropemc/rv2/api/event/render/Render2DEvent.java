package de.ropemc.rv2.api.event.render;

import de.ropemc.rv2.api.event.Event;

public class Render2DEvent extends Event {
    private float partialTicks;

    public Render2DEvent(float partialTicks) {
        this.partialTicks = partialTicks;
    }

    public float getPartialTicks() {
        return partialTicks;
    }
}
