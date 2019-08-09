package de.ropemc.rv2.api.minecraft.item;

import de.ropemc.rv2.api.MinecraftWrapperFactory;
import de.ropemc.rv2.api.Rope;

public class Item {

    private static MinecraftWrapperFactory getMinecraftWrapperFactory(){
        return Rope.getRopeMC().getImplementation(MinecraftWrapperFactory.class);
    }

    private Wrapper wrapper;

    public Item(Properties properties){
        wrapper = getMinecraftWrapperFactory().item(properties);
    }

    public Item(Object handle){
        wrapper = getMinecraftWrapperFactory().item(handle);
    }

    public Wrapper getWrapper(){
        return wrapper;
    }

    public interface Wrapper {

    }

    public static class Properties {

        private Wrapper wrapper;

        public Properties(){
            wrapper = getMinecraftWrapperFactory().itemProperties();
        }

        public Properties(Object handle){
            wrapper = getMinecraftWrapperFactory().itemProperties(handle);
        }

        public Properties maxStackSize(int maxStackSizeIn){
            wrapper.maxStackSize(maxStackSizeIn);
            return this;
        }

        public Properties rarity(Rarity rarity){
            wrapper.rarity(rarity);
            return this;
        }

        public Properties defaultMaxDamage(int maxDamageIn){
            wrapper.defaultMaxDamage(maxDamageIn);
            return this;
        }

        public Properties maxDamage(int maxDamageIn){
            wrapper.maxDamage(maxDamageIn);
            return this;
        }

        public Properties group(ItemGroup groupIn){
            wrapper.group(groupIn);
            return this;
        }

        public Wrapper getWrapper(){
            return wrapper;
        }

        public interface Wrapper {
            void maxStackSize(int maxStackSizeIn);
            void rarity(Rarity rarity);
            void maxDamage(int maxDamageIn);
            void defaultMaxDamage(int maxDamageIn);
            void group(ItemGroup groupIn);
        }

    }

}
