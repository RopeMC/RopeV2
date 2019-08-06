package de.ropemc.rv2.api.event.render;

import de.ropemc.rv2.api.event.Event;

public class PreRender2DEvent extends Event {
    private float partialTicks;

    public PreRender2DEvent(float partialTicks) {
        this.partialTicks = partialTicks;
    }

    public float getPartialTicks() {
        return partialTicks;
    }
}
