package de.ropemc.rv2.mc114.entity;

import de.ropemc.rv2.api.entity.Player;
import de.ropemc.rv2.util.ReflectAccessor;

public class PlayerImpl extends LivingEntityImpl implements Player {
    private static ReflectAccessor accessor = ReflectAccessor.getByName("dmp");

    public PlayerImpl(Object handle) {
        super(handle);
    }
}
