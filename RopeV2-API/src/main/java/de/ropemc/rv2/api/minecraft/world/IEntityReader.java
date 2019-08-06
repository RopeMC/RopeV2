package de.ropemc.rv2.api.minecraft.world;

import de.ropemc.rv2.api.minecraft.entity.player.PlayerEntity;

import java.util.List;

public interface IEntityReader {

    List<? extends PlayerEntity> getPlayers();

}
