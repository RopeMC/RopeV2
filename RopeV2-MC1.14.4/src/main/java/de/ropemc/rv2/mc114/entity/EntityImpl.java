package de.ropemc.rv2.mc114.entity;

import de.ropemc.rv2.api.entity.Entity;
import de.ropemc.rv2.util.ReflectAccessor;

public class EntityImpl implements Entity {
    private static ReflectAccessor accessor = ReflectAccessor.getByName("aio");

    protected Object handle;

    public EntityImpl(Object handle) {
        this.handle = handle;
    }

    public boolean isOnGround() {
        return false;
    }
}
