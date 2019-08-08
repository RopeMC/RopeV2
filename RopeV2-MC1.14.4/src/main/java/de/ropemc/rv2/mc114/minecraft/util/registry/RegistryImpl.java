package de.ropemc.rv2.mc114.minecraft.util.registry;

import de.ropemc.rv2.api.minecraft.item.Item;
import de.ropemc.rv2.api.minecraft.util.ResourceLocation;
import de.ropemc.rv2.api.minecraft.util.registry.Registry;
import de.ropemc.rv2.mc114.minecraft.util.ResourceLocationImpl;
import de.ropemc.rv2.util.ReflectAccessor;

public class RegistryImpl implements Registry {

    private static ReflectAccessor accessor = ReflectAccessor.getByName("fn");
    private static int mRegister = accessor.getMethodAccess().getIndex("a", accessor.getClazz(), ResourceLocationImpl.getClazz(), Object.class);
    private static int fItem = accessor.getFieldAccess().getIndex("m");

    public static class StaticImpl implements Registry.Static {
        public Item register(ResourceLocation resourceLocation, Item item){
            Object registryHandle = accessor.getFieldAccess().get(null, fItem);
            Object resourceLocationHandle = ((ResourceLocationImpl) resourceLocation.getWrapper()).getHandle();
            Object value = accessor.getMethodAccess().invoke(null, mRegister, registryHandle, resourceLocationHandle, item);
            return new Item(value);
        }
    }

}
