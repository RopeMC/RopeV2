package de.ropemc.rv2.api.minecraft.entity;

import de.ropemc.rv2.api.minecraft.util.math.Vec3d;

public interface Entity {

    boolean isOnGround();
    Vec3d getMotion();
    void setMotion(Vec3d motion);

}
