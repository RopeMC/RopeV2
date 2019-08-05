package de.ropemc.rv2.mc114.entity;

import de.ropemc.rv2.api.entity.AbstractClientPlayerEntity;
import de.ropemc.rv2.api.entity.Entity;
import de.ropemc.rv2.util.ReflectAccessor;

public class AbstractClientPlayerEntityImpl extends PlayerEntityImpl implements AbstractClientPlayerEntity {
    private static ReflectAccessor accessor = ReflectAccessor.getByName("dmm");

    public AbstractClientPlayerEntityImpl(Object handle) {
        super(handle);
    }
}
