package de.ropemc.rv2.api.event.render;

import de.ropemc.rv2.api.event.Event;
import de.ropemc.rv2.api.minecraft.client.gui.IngameGui;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Render2DEvent extends Event {
    private IngameGui gui;
    private float partialTicks;
}
