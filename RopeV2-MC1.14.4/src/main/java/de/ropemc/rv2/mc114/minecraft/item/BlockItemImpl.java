package de.ropemc.rv2.mc114.minecraft.item;

import de.ropemc.rv2.api.minecraft.block.Block;
import de.ropemc.rv2.api.minecraft.item.BlockItem;
import de.ropemc.rv2.api.minecraft.item.Item;
import de.ropemc.rv2.mc114.minecraft.block.BlockImpl;
import de.ropemc.rv2.util.ReflectAccessor;

public class BlockItemImpl extends ItemImpl implements BlockItem.Wrapper {

    private static ReflectAccessor accessor = ReflectAccessor.getByName("bam");
    private static int cBlockItem = accessor.getConstructorAccess().getIndex(BlockImpl.getClazz(), ItemImpl.PropertiesImpl.getClazz());

    public BlockItemImpl(Object handle) {
        super(handle);
    }
    public BlockItemImpl(Block block, Item.Properties properties){
        this(construct(block, properties));
    }
    private static Object construct(Block block, Item.Properties properties){
        Object propertiesHandle = ((ItemImpl.PropertiesImpl) properties.getWrapper()).getHandle();
        Object blockHandle = ((BlockImpl) block.getWrapper()).getHandle();
        return accessor.getConstructorAccess().newInstance(cBlockItem, blockHandle, propertiesHandle);
    }
}
