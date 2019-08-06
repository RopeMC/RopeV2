package de.ropemc.rv2.mc114;

import de.ropemc.rv2.api.MinecraftWrapperFactory;
import de.ropemc.rv2.api.minecraft.util.math.Vec3d;
import de.ropemc.rv2.api.minecraft.util.math.Vec3i;
import de.ropemc.rv2.mc114.minecraft.util.math.Vec3dImpl;
import de.ropemc.rv2.mc114.minecraft.util.math.Vec3iImpl;

public class MinecraftWrapperFactoryImpl implements MinecraftWrapperFactory {
    public Vec3d.Wrapper vec3d(double x, double y, double z) {
        return new Vec3dImpl(x, y, z);
    }
    public Vec3d.Wrapper vec3d(Object handle) {
        return new Vec3dImpl(handle);
    }

    public Vec3i.Wrapper vec3i(int x, int y, int z) {
        return new Vec3iImpl(x, y, z);
    }

    public Vec3i.Wrapper vec3i(double x, double y, double z) {
        return new Vec3iImpl(x, y, z);
    }

    public Vec3i.Wrapper vec3i(Object handle) {
        return new Vec3iImpl(handle);
    }
}
