package de.ropemc.rv2.mc114.minecraft.client;

import de.ropemc.rv2.api.minecraft.client.Minecraft;
import de.ropemc.rv2.api.minecraft.client.entity.player.ClientPlayerEntity;
import de.ropemc.rv2.api.minecraft.client.world.ClientWorld;
import de.ropemc.rv2.mc114.minecraft.client.entity.player.ClientPlayerEntityImpl;
import de.ropemc.rv2.mc114.minecraft.client.world.ClientWorldImpl;
import de.ropemc.rv2.util.ReflectAccessor;

public class MinecraftImpl implements Minecraft {
    private static ReflectAccessor accessor = ReflectAccessor.getByName("cyc");

    private static int fPlayer = accessor.getFieldAccess().getIndex("i");
    private static int fWorld = accessor.getFieldAccess().getIndex("g");

    private Object handle;

    public MinecraftImpl(Object handle) {
        this.handle = handle;
    }

    public ClientPlayerEntity getPlayer() {
        return new ClientPlayerEntityImpl(accessor.getFieldAccess().get(this.handle, fPlayer));
    }

    public ClientWorld getWorld() {
        return new ClientWorldImpl(accessor.getFieldAccess().get(this.handle, fWorld));
    }
}
