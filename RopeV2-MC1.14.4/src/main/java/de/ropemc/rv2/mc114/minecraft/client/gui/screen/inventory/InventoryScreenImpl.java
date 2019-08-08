package de.ropemc.rv2.mc114.minecraft.client.gui.screen.inventory;

import de.ropemc.rv2.api.minecraft.client.gui.screen.inventory.InventoryScreen.StaticWrapper;
import de.ropemc.rv2.api.minecraft.entity.LivingEntity;
import de.ropemc.rv2.util.ReflectAccessor;

public class InventoryScreenImpl {
    private static ReflectAccessor accessor = ReflectAccessor.getByName("deb");

    public static class StaticImpl implements StaticWrapper {
        private static int mDrawEntityOnScreen;

        static {
            try {
                mDrawEntityOnScreen = accessor.getMethodAccess().getIndex("a", int.class, int.class, int.class, float.class, float.class, Class.forName("aix"));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void drawEntityOnScreen(int x, int y, int diagonal, float lookX, float lookY, LivingEntity entity) {

        }
    }
}
