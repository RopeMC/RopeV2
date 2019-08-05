package de.ropemc.rv2.api;

import de.ropemc.rv2.api.minecraft.util.math.Vec3d;

public interface MinecraftWrapperFactory {

    Vec3d.Wrapper vec3d(double x, double y, double z);
    Vec3d.Wrapper vec3d(Object handle);

}
