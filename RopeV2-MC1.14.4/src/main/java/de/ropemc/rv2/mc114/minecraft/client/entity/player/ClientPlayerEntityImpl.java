package de.ropemc.rv2.mc114.minecraft.client.entity.player;

import de.ropemc.rv2.api.minecraft.client.entity.player.ClientPlayerEntity;
import de.ropemc.rv2.util.ReflectAccessor;

public class ClientPlayerEntityImpl extends AbstractClientPlayerEntityImpl implements ClientPlayerEntity {
    private static ReflectAccessor accessor = ReflectAccessor.getByName("dmp");

    public ClientPlayerEntityImpl(Object handle) {
        super(handle);
    }
}
