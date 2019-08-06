package de.ropemc.rv2.api.minecraft.entity;

import de.ropemc.rv2.api.minecraft.util.math.Vec3d;

public interface Entity {

    Vec3d getMotion();
    void setMotion(Vec3d motion);
    boolean isGlowing();
    void setGlowing(boolean glowingIn);

}
