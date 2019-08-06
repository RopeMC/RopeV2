package de.ropemc.rv2.api.event.render;

import de.ropemc.rv2.api.event.Event;

public class BeforeRender2DEvent extends Event {
    private float partialTicks;

    public BeforeRender2DEvent(float partialTicks) {
        this.partialTicks = partialTicks;
    }

    public float getPartialTicks() {
        return partialTicks;
    }
}
