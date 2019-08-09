package de.ropemc.rv2.api.minecraft.util;

import de.ropemc.rv2.api.MinecraftWrapperFactory;
import de.ropemc.rv2.api.Rope;

public class DamageSource {

    private static MinecraftWrapperFactory getMinecraftWrapperFactory(){
        return Rope.getRopeMC().getImplementation(MinecraftWrapperFactory.class);
    }

    private Wrapper wrapper;

    public DamageSource(String name) {
        this.wrapper = getMinecraftWrapperFactory().damageSource(name);
    }

    public DamageSource(Object handle) {
        this.wrapper = getMinecraftWrapperFactory().damageSource(handle);
    }

    public Wrapper getWrapper() {
        return wrapper;
    }

    public String getDamageType() {
        return wrapper.getDamageType();
    }

    public interface Wrapper {
        String getDamageType();
        Object getHandle();
    }
}
