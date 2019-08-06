package de.ropemc.rv2.api.minecraft.util.math;

public class BlockPos extends Vec3i {
    public BlockPos(int x, int y, int z) {
        super(x, y, z);
    }

    public BlockPos(double x, double y, double z) {
        super(x, y, z);
    }

    public BlockPos(Object handle) {
        super(handle);
    }

    public BlockPos(Vec3d vec3d) {
        super(vec3d.getX(), vec3d.getY(), vec3d.getZ());
    }

    public BlockPos(Vec3i vec3i) {
        super(vec3i.getX(), vec3i.getY(), vec3i.getZ());
    }
}
