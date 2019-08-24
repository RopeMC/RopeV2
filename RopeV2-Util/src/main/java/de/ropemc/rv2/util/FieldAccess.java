package de.ropemc.rv2.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class FieldAccess {
    private Class<?> clazz;

    public FieldAccess(Class<?> clazz){
        this.clazz = clazz;
    }

    private List<Field> fields = new ArrayList<>();

    public int getIndex(String name){
        Field field = getField(name);
        if(field == null)
            return -1;
        fields.add(field);
        return fields.size()-1;
    }

    private Field getField(String name, Class... types){
        try {
            Field field = clazz.getDeclaredField(name);
            if(!field.isAccessible())
                field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void set(Object instance, int index, Object value) {
        if(index < 0 || index >= fields.size())
            return;
        try {
            fields.get(index).set(instance, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void setBoolean(Object instance, int index, boolean value) {
        set(instance, index, value);
    }

    public void setByte(Object instance, int index, byte value) {
        set(instance, index, value);
    }

    public void setShort(Object instance, int index, short value) {
        set(instance, index, value);
    }

    public void setInt(Object instance, int index, int value) {
        set(instance, index, value);
    }

    public void setLong(Object instance, int index, long value) {
        set(instance, index, value);
    }

    public void setDouble(Object instance, int index, double value) {
        set(instance, index, value);
    }

    public void setFloat(Object instance, int index, float value) {
        set(instance, index, value);
    }

    public void setChar(Object instance, int index, char value) {
        set(instance, index, value);
    }

    public Object get(Object instance, int index) {
        if(index < 0)
            return null;
        if(index >= fields.size())
            return null;
        try {
            return fields.get(index).get(instance);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getString(Object instance, int index) {
        return (String) get(instance, index);
    }

    public char getChar(Object instance, int index) {
        return (char) get(instance, index);
    }

    public boolean getBoolean(Object instance, int index) {
        return (boolean) get(instance, index);
    }

    public byte getByte(Object instance, int index) {
        return (byte) get(instance, index);
    }

    public short getShort(Object instance, int index) {
        return (short) get(instance, index);
    }

    public int getInt(Object instance, int index) {
        return (int) get(instance, index);
    }

    public long getLong(Object instance, int index) {
        return (long) get(instance, index);
    }

    public double getDouble(Object instance, int index) {
        return (double) get(instance, index);
    }

    public float getFloat(Object instance, int index) {
        return (float) get(instance, index);
    }
}
