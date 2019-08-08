package de.ropemc.rv2.api.minecraft.client.gui.screen.inventory;

import de.ropemc.rv2.api.Rope;
import de.ropemc.rv2.api.minecraft.entity.LivingEntity;

public abstract class InventoryScreen {
    public static void drawEntityOnScreen(int x, int y, int diagonal, float lookX, float lookY, LivingEntity entity) {
        Rope.getRopeMC().getImplementation(Static.class).drawEntityOnScreen(x, y, diagonal, lookX, lookY, entity);
    }

    public interface Static {
        void drawEntityOnScreen(int x, int y, int diagonal, float lookX, float lookY, LivingEntity entity);
    }
}
