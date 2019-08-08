package de.ropemc.rv2.util;

public class ReflectAccessor {

    private Class<?> clazz;
    private FieldAccess fieldAccess;
    private MethodAccess methodAccess;
    private ConstructorAccess constructorAccess;

    public ReflectAccessor(Class<?> clazz) {
        this.clazz = clazz;
        fieldAccess = new FieldAccess(this.clazz);
        methodAccess = new MethodAccess(this.clazz);
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
