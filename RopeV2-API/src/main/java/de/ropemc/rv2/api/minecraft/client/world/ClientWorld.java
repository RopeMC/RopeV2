package de.ropemc.rv2.api.minecraft.client.world;

import de.ropemc.rv2.api.minecraft.entity.player.PlayerEntity;
import de.ropemc.rv2.api.minecraft.world.World;

import java.util.List;

public interface ClientWorld extends World {

    List<? extends PlayerEntity> getPlayers();

}
