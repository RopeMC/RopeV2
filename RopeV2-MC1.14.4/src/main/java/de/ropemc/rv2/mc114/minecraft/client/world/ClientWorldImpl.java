package de.ropemc.rv2.mc114.minecraft.client.world;

import de.ropemc.rv2.api.minecraft.client.world.ClientWorld;
import de.ropemc.rv2.api.minecraft.entity.player.PlayerEntity;
import de.ropemc.rv2.mc114.minecraft.client.entity.player.AbstractClientPlayerEntityImpl;
import de.ropemc.rv2.util.ReflectAccessor;

import java.util.List;
import java.util.stream.Collectors;

public class ClientWorldImpl implements ClientWorld {
    private static ReflectAccessor accessor = ReflectAccessor.getByName("dkf");

    private static int mGetPlayers = accessor.getMethodAccess().getIndex("A", new Class[0]);

    protected Object handle;

    public ClientWorldImpl(Object handle) {
        this.handle = handle;
    }

    public List<? extends PlayerEntity> getPlayers() {
        List<Object> playerHandles = (List<Object>) accessor.getMethodAccess().invoke(this.handle, mGetPlayers);
        return playerHandles
                .stream()
                .map(AbstractClientPlayerEntityImpl::new)
                .collect(Collectors.toList());
    }
}
