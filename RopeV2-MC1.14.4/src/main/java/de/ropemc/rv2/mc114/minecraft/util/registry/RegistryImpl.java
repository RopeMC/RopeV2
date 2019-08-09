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

    private static ReflectAccessor accessor;
    private static int mRegister;
    private static int fItem;
    private static int fBlock;

    private static void access(){
        if(accessor != null)
            return;
        accessor = ReflectAccessor.getByName("fn");
        mRegister = accessor.getMethodAccess().getIndex("a", accessor.getClazz(), ResourceLocationImpl.getClazz(), Object.class);
        fItem = accessor.getFieldAccess().getIndex("m");
        fBlock = accessor.getFieldAccess().getIndex("j");
    }

    public static class StaticImpl implements Registry.Static {
        public Item register(ResourceLocation resourceLocation, Item item){
            access();
            return new Item(register(fItem, resourceLocation, ((ItemImpl)item.getWrapper()).getHandle()));
        }
        public Block register(ResourceLocation resourceLocation, Block block){
            access();
            return new Block(register(fBlock, resourceLocation, ((BlockImpl)block.getWrapper()).getHandle()));
        }
        private Object register(int registry, ResourceLocation resourceLocation, Object element){
            Object registryHandle = accessor.getFieldAccess().get(null, registry);
            Object resourceLocationHandle = ((ResourceLocationImpl) resourceLocation.getWrapper()).getHandle();
            return accessor.getMethodAccess().invoke(null, mRegister, registryHandle, resourceLocationHandle, element);
        }
    }

}
