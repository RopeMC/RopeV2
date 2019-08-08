package de.ropemc.rv2.mc114.minecraft.util.registry;

import de.ropemc.rv2.api.minecraft.block.Block;
import de.ropemc.rv2.api.minecraft.item.Item;
import de.ropemc.rv2.api.minecraft.util.ResourceLocation;
import de.ropemc.rv2.api.minecraft.util.registry.Registry;
import de.ropemc.rv2.mc114.minecraft.block.BlockImpl;
import de.ropemc.rv2.mc114.minecraft.item.ItemImpl;
import de.ropemc.rv2.mc114.minecraft.util.ResourceLocationImpl;
import de.ropemc.rv2.util.ReflectAccessor;

public class RegistryImpl implements Registry {

    private static ReflectAccessor accessor = ReflectAccessor.getByName("fn");
    private static int mRegister = accessor.getMethodAccess().getIndex("a", accessor.getClazz(), ResourceLocationImpl.getClazz(), Object.class);
    private static int fItem = accessor.getFieldAccess().getIndex("m");
    private static int fBlock = accessor.getFieldAccess().getIndex("j");

    public static class StaticImpl implements Registry.Static {
        public Item register(ResourceLocation resourceLocation, Item item){
            return new Item(register(fItem, resourceLocation, ((ItemImpl)item.getWrapper()).getHandle()));
        }
        public Block register(ResourceLocation resourceLocation, Block block){
            return new Block(register(fBlock, resourceLocation, ((BlockImpl)block.getWrapper()).getHandle()));
        }
        private Object register(int registry, ResourceLocation resourceLocation, Object element){
            Object registryHandle = accessor.getFieldAccess().get(null, fItem);
            Object resourceLocationHandle = ((ResourceLocationImpl) resourceLocation.getWrapper()).getHandle();
            return accessor.getMethodAccess().invoke(null, mRegister, registryHandle, resourceLocationHandle, element);
        }
    }

}
