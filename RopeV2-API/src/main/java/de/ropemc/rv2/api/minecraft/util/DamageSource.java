package de.ropemc.rv2.api.minecraft.util;

import de.ropemc.rv2.api.Rope;

public class DamageSource {
    private Wrapper wrapper;

    public DamageSource(String name) {
        this.wrapper = Rope.getRopeMC().getMinecraftWrapperFactory().damageSource(name);
    }

    public DamageSource(Object handle) {
        this.wrapper = Rope.getRopeMC().getMinecraftWrapperFactory().damageSource(handle);
    }

    public Wrapper getWrapper() {
        return wrapper;
    }

    public interface Wrapper {
        Object getHandle();
    }
}
