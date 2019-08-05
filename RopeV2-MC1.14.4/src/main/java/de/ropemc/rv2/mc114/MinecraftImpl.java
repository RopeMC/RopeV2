package de.ropemc.rv2.mc114;

import de.ropemc.rv2.api.Minecraft;
import de.ropemc.rv2.api.entity.ClientPlayerEntity;
import de.ropemc.rv2.mc114.entity.ClientPlayerEntityImpl;
import de.ropemc.rv2.util.ReflectAccessor;

public class MinecraftImpl implements Minecraft {
    private static ReflectAccessor accessor = ReflectAccessor.getByName("cyc");

    private static int fPlayer = accessor.getFieldAccess().getIndex("i");

    private Object handle;

    public MinecraftImpl(Object handle) {
        this.handle = handle;
    }

    public ClientPlayerEntity getPlayer() {
        return new ClientPlayerEntityImpl(accessor.getFieldAccess().get(this.handle, fPlayer));
    }
}
