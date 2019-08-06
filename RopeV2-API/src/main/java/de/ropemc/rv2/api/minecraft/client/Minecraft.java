package de.ropemc.rv2.api.minecraft.client;

import de.ropemc.rv2.api.minecraft.client.entity.player.ClientPlayerEntity;
import de.ropemc.rv2.api.minecraft.client.world.ClientWorld;

public interface Minecraft {

    ClientPlayerEntity getPlayer();

    ClientWorld getWorld();
}
