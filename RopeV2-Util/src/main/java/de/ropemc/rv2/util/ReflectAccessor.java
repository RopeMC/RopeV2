package de.ropemc.rv2.util;

import com.esotericsoftware.reflectasm.FieldAccess;
import com.esotericsoftware.reflectasm.MethodAccess;

public class ReflectAccessor {

    private Class<?> clazz;
    private FieldAccess fieldAccess;
    private MethodAccess methodAccess;
    private ConstructorAccess constructorAccess;

    public ReflectAccessor(Class<?> clazz) {
        this(clazz, true, true);
    }

    public ReflectAccessor(Class<?> clazz, boolean fields, boolean methods) {
        this.clazz = clazz;
        if(fields)
            this.fieldAccess = FieldAccess.get(this.clazz);
        if(methods)
            this.methodAccess = MethodAccess.get(this.clazz);
        constructorAccess = new ConstructorAccess(this.clazz);
    }

    public static ReflectAccessor getByName(String name) {
        try {
            return new ReflectAccessor(Class.forName(name));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public FieldAccess getFieldAccess() {
        return fieldAccess;
    }

    public MethodAccess getMethodAccess() {
        return methodAccess;
    }

    public ConstructorAccess getConstructorAccess(){
        return constructorAccess;
    }

}
