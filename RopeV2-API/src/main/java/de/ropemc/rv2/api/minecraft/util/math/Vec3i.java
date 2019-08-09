package de.ropemc.rv2.api.minecraft.util.math;

import de.ropemc.rv2.api.MinecraftWrapperFactory;
import de.ropemc.rv2.api.Rope;

public class Vec3i {

    private static MinecraftWrapperFactory getMinecraftWrapperFactory(){
        return Rope.getRopeMC().getImplementation(MinecraftWrapperFactory.class);
    }

    private Wrapper wrapper;

    public Vec3i(int x, int y, int z) {
        this.wrapper = getMinecraftWrapperFactory().vec3i(x, y, z);
    }

    public Vec3i(double x, double y, double z) {
        this.wrapper = getMinecraftWrapperFactory().vec3i(x, y, z);
    }

    public Vec3i(Object handle) {
        this.wrapper = getMinecraftWrapperFactory().vec3i(handle);
    }

    public int getX() {
        return wrapper.getX();
    }

    public int getY() {
        return wrapper.getY();
    }

    public int getZ() {
        return wrapper.getZ();
    }

    public Wrapper getWrapper() {
        return wrapper;
    }

    public interface Wrapper {
        int getX();

        int getY();

        int getZ();

        Object getHandle();
    }
}
