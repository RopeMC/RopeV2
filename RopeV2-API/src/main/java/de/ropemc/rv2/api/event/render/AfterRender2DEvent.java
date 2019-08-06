package de.ropemc.rv2.api.event.render;

import de.ropemc.rv2.api.event.Event;

public class AfterRender2DEvent extends Event {
    private float partialTicks;

    public AfterRender2DEvent(float partialTicks) {
        this.partialTicks = partialTicks;
    }

    public float getPartialTicks() {
        return partialTicks;
    }
}
