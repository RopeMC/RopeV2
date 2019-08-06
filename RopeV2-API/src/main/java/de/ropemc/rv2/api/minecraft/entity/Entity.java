package de.ropemc.rv2.api.minecraft.entity;

import de.ropemc.rv2.api.minecraft.command.ICommandSource;
import de.ropemc.rv2.api.minecraft.util.math.BlockPos;
import de.ropemc.rv2.api.minecraft.util.math.Vec3d;
import de.ropemc.rv2.api.minecraft.util.text.ITextComponent;

public interface Entity extends ICommandSource {

    Vec3d getMotion();

    void setMotion(Vec3d motion);

    boolean isGlowing();

    void setGlowing(boolean glowingIn);

    BlockPos getPosition();

    Vec3d getPositionVector();

    default boolean getFlag(Flags flag){
        return getFlag(flag.value);
    }

    boolean getFlag(int flag);

    default void setFlag(Flags flag, boolean state){
        setFlag(flag.value, state);
    }

    void setFlag(int flag, boolean state);

    default void sendMessage(ITextComponent text) {}

    enum Flags {
        BURNING(0),
        SNEAKING(1),
        SPRINTING(3),
        SWIMMING(4),
        INVISIBLE(5),
        GLOWING(6),
        ELYTRA_FLYING(7);
        Flags(int value){
            this.value = value;
        }
        private int value;
    }

}
