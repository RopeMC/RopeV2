package de.ropemc.rv2.api;

import de.ropemc.rv2.api.minecraft.util.math.Vec3d;
import de.ropemc.rv2.api.minecraft.util.math.Vec3i;
import de.ropemc.rv2.api.minecraft.util.text.StringTextComponent;

public interface MinecraftWrapperFactory {

    Vec3d.Wrapper vec3d(double x, double y, double z);
    Vec3d.Wrapper vec3d(Object handle);

    Vec3i.Wrapper vec3i(int x, int y, int z);
    Vec3i.Wrapper vec3i(double x, double y, double z);
    Vec3i.Wrapper vec3i(Object handle);

    StringTextComponent.Wrapper stringTextComponent(String text);
    StringTextComponent.Wrapper stringTextComponent(Object handle);
}
