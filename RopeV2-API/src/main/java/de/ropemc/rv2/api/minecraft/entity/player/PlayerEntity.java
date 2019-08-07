package de.ropemc.rv2.api.minecraft.entity.player;

import de.ropemc.rv2.api.minecraft.entity.LivingEntity;

public interface PlayerEntity extends LivingEntity {
    boolean canAttackPlayer(PlayerEntity other);
}
