package de.ropemc.rv2.mc114.minecraft.client.entity.player;

import de.ropemc.rv2.api.minecraft.client.entity.player.AbstractClientPlayerEntity;
import de.ropemc.rv2.mc114.minecraft.entity.player.PlayerEntityImpl;
import de.ropemc.rv2.util.ReflectAccessor;

public class AbstractClientPlayerEntityImpl extends PlayerEntityImpl implements AbstractClientPlayerEntity {
    private static ReflectAccessor accessor = ReflectAccessor.getByName("dmm");

    public AbstractClientPlayerEntityImpl(Object handle) {
        super(handle);
    }
}
