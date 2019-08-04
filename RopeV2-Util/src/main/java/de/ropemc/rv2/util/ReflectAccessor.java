package de.ropemc.rv2.util;

import com.esotericsoftware.reflectasm.FieldAccess;
import com.esotericsoftware.reflectasm.MethodAccess;

public class ReflectAccessor {
    private Class<?> clazz;
    private FieldAccess fieldAccess;
    private MethodAccess methodAcess;

    public ReflectAccessor(Class<?> clazz) {
        this.clazz = clazz;
        this.fieldAccess = FieldAccess.get(this.clazz);
        this.methodAcess = MethodAccess.get(this.clazz);
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

    public MethodAccess getMethodAcess() {
        return methodAcess;
    }
}
