package de.ropemc.rv2.mc114.minecraft.util;

import de.ropemc.rv2.api.minecraft.util.ResourceLocation;
import de.ropemc.rv2.util.ReflectAccessor;

public class ResourceLocationImpl implements ResourceLocation.Wrapper {

    private static ReflectAccessor accessor = ReflectAccessor.getByName("qv");

    private static int cResourceLocation1 = accessor.getConstructorAccess().getIndex(String.class);
    private static int cResourceLocation2 = accessor.getConstructorAccess().getIndex(String.class, String.class);
    private static int mGetNamespace = accessor.getMethodAccess().getIndex("b");
    private static int mGetPath = accessor.getMethodAccess().getIndex("a");

    public static Class<?> getClazz(){
        return accessor.getClazz();
    }

    private Object handle;

    public ResourceLocationImpl(Object handle){
        this.handle = handle;
    }

    public ResourceLocationImpl(String id){
        this(accessor.getConstructorAccess().newInstance(cResourceLocation1, id));
    }

    public ResourceLocationImpl(String group, String id){
        this(accessor.getConstructorAccess().newInstance(cResourceLocation2, group, id));
    }

    public String getNamespace(){
        return (String) accessor.getMethodAccess().invoke(handle, mGetNamespace);
    }

    public String getPath(){
        return (String) accessor.getMethodAccess().invoke(handle, mGetPath);
    }

    public Object getHandle(){
        return handle;
    }

}
