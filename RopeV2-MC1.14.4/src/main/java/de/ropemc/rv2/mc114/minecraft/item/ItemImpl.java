package de.ropemc.rv2.mc114.minecraft.item;

import de.ropemc.rv2.api.minecraft.item.Item;
import de.ropemc.rv2.api.minecraft.item.ItemGroup;
import de.ropemc.rv2.api.minecraft.item.Rarity;
import de.ropemc.rv2.util.ReflectAccessor;

public class ItemImpl implements Item.Wrapper {

    private static ReflectAccessor accessor = ReflectAccessor.getByName("bce");

    private Object handle;

    public ItemImpl(Object handle){
        this.handle = handle;
    }

    public ItemImpl(Item.Properties properties){

    }

    public Object getHandle(){
        return handle;
    }

    public static class PropertiesImpl implements Item.Properties.Wrapper {
        private static ReflectAccessor accessor = ReflectAccessor.getByName("bce$a");
        private static int cProperties = accessor.getConstructorAccess().getIndex();
        private static int mMaxStackSize = accessor.getMethodAccess().getIndex("a", int.class);
        private static int mMaxDamage = accessor.getMethodAccess().getIndex("c", int.class);
        private static int mDefaultMaxDamage = accessor.getMethodAccess().getIndex("b", int.class);
        private static int mGroup = accessor.getMethodAccess().getIndex("a", ItemGroupImpl.getClazz());
        private Object handle;
        public PropertiesImpl(Object handle){
            this.handle = handle;
        }
        public PropertiesImpl(){
            this(accessor.getConstructorAccess().newInstance(cProperties));
        }
        public void maxStackSize(int maxStackSizeIn) {
            accessor.getMethodAccess().invoke(handle, mMaxStackSize, maxStackSizeIn);
        }
        public void rarity(Rarity rarity) {
            //TODO
        }
        public void maxDamage(int maxDamageIn) {
            accessor.getMethodAccess().invoke(handle, mMaxDamage, maxDamageIn);
        }
        public void defaultMaxDamage(int maxDamageIn) {
            accessor.getMethodAccess().invoke(handle, mDefaultMaxDamage, maxDamageIn);
        }
        public void group(ItemGroup groupIn) {
            Object value = ItemGroupImpl.get(groupIn);
            if(value == null)
                return;
            accessor.getMethodAccess().invoke(handle, mGroup, value);
        }
        public Object getHandle(){
            return handle;
        }
    }

}
