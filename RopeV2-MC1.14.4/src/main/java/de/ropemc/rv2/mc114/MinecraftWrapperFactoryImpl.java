package de.ropemc.rv2.mc114;

import de.ropemc.rv2.api.MinecraftWrapperFactory;
import de.ropemc.rv2.api.minecraft.util.math.Vec3d;
import de.ropemc.rv2.mc114.minecraft.util.math.Vec3dImpl;

public class MinecraftWrapperFactoryImpl implements MinecraftWrapperFactory {
    public Vec3d.Wrapper vec3d(double x, double y, double z) {
        return new Vec3dImpl(x, y, z);
    }
    public Vec3d.Wrapper vec3d(Object handle) {
        return new Vec3dImpl(handle);
    }
}
