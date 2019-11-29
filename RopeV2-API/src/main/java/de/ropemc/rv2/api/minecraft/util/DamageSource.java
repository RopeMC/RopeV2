package de.ropemc.rv2.api.minecraft.util;

import de.ropemc.rv2.api.MinecraftWrapperFactory;
import de.ropemc.rv2.api.Rope;
import lombok.Getter;
import lombok.experimental.Delegate;

public class DamageSource {

    private static MinecraftWrapperFactory getMinecraftWrapperFactory(){
        return Rope.getRopeMC().getImplementation(MinecraftWrapperFactory.class);
    }

    @Delegate
    @Getter
    private Wrapper wrapper;

    public DamageSource(String name) {
        this.wrapper = getMinecraftWrapperFactory().damageSource(name);
    }

    public DamageSource(Object handle) {
        this.wrapper = getMinecraftWrapperFactory().damageSource(handle);
    }

    public interface Wrapper {
        String getDamageType();
        Object getHandle();
    }
}
