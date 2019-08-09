package de.ropemc.rv2.mc114.minecraft.block;

import de.ropemc.rv2.api.minecraft.block.Block;
import de.ropemc.rv2.api.minecraft.block.material.Material;
import de.ropemc.rv2.api.minecraft.block.material.MaterialColor;
import de.ropemc.rv2.mc114.minecraft.block.material.MaterialColorImpl;
import de.ropemc.rv2.mc114.minecraft.block.material.MaterialImpl;
import de.ropemc.rv2.util.ReflectAccessor;

public class BlockImpl implements Block.Wrapper {

    private static ReflectAccessor accessor = ReflectAccessor.getByName("bmv");
    private static int cBlock = accessor.getConstructorAccess().getIndex(PropertiesImpl.getClazz());

    public static Class<?> getClazz(){
        return accessor.getClazz();
    }

    private Object handle;

    public BlockImpl(Object handle){
        this.handle = handle;
    }

    public BlockImpl(Block.Properties properties){
        this(accessor.getConstructorAccess().newInstance(cBlock, ((PropertiesImpl) properties.getWrapper()).getHandle()));
    }

    public Object getHandle(){
        return handle;
    }

    public static class PropertiesImpl implements Block.Properties.Wrapper {
        private static ReflectAccessor accessor = ReflectAccessor.getByName("bmv$c");
        private static int cProperties = accessor.getConstructorAccess().getIndex(MaterialImpl.getClazz(), MaterialColorImpl.getClazz());
        public static Class<?> getClazz(){
            return accessor.getClazz();
        }
        private Object handle;
        public PropertiesImpl(Object handle){
            this.handle = handle;
        }
        public PropertiesImpl(Material material, MaterialColor materialColor){
            this(accessor.getConstructorAccess().newInstance(cProperties, MaterialImpl.getValue(material), MaterialColorImpl.getValue(materialColor)));
        }
        public Object getHandle(){
            return handle;
        }
    }

}
