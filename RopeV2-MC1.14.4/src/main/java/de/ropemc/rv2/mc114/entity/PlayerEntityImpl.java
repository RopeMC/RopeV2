package de.ropemc.rv2.mc114.entity;

import de.ropemc.rv2.api.entity.PlayerEntity;
import de.ropemc.rv2.util.ReflectAccessor;

public class PlayerEntityImpl extends LivingEntityImpl implements PlayerEntity {
    private static ReflectAccessor accessor = ReflectAccessor.getByName("awg");

    public PlayerEntityImpl(Object handle) {
        super(handle);
    }
}
