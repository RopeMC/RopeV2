package de.ropemc.rv2.mc114.minecraft.network;

import de.ropemc.rv2.api.minecraft.network.PacketBuffer;
import de.ropemc.rv2.util.ReflectAccessor;

public class PacketBufferImpl implements PacketBuffer {

    private static ReflectAccessor accessor = ReflectAccessor.getByName("je");

    private static int mWriteByte = accessor.getMethodAccess().getIndex("writeByte", byte.class);
    private static int mWriteBoolean = accessor.getMethodAccess().getIndex("writeBoolean", boolean.class);
    private static int mWriteInt = accessor.getMethodAccess().getIndex("writeInt", int.class);
    private static int mWriteChar = accessor.getMethodAccess().getIndex("writeChar", char.class);
    private static int mWriteFloat = accessor.getMethodAccess().getIndex("writeFloat", float.class);
    private static int mWriteDouble = accessor.getMethodAccess().getIndex("writeDouble", double.class);
    private static int mWriteShort = accessor.getMethodAccess().getIndex("writeShort", short.class);
    private static int mWriteLong = accessor.getMethodAccess().getIndex("writeLong", long.class);
    private static int mWriteString = accessor.getMethodAccess().getIndex("a", String.class);

    private Object handle;

    public PacketBufferImpl(Object handle){
        this.handle = handle;
    }

    public PacketBuffer writeByte(byte value) {
        accessor.getMethodAccess().invoke(handle, mWriteByte, value);
        return this;
    }

    public PacketBuffer writeBoolean(boolean value){
        accessor.getMethodAccess().invoke(handle, mWriteBoolean, value);
        return this;
    }

    public PacketBuffer writeInt(int value) {
        accessor.getMethodAccess().invoke(handle, mWriteInt, value);
        return this;
    }

    public PacketBuffer writeChar(char value) {
        accessor.getMethodAccess().invoke(handle, mWriteChar, value);
        return this;
    }

    public PacketBuffer writeFloat(float value) {
        accessor.getMethodAccess().invoke(handle, mWriteFloat, value);
        return this;
    }

    public PacketBuffer writeDouble(double value) {
        accessor.getMethodAccess().invoke(handle, mWriteDouble, value);
        return this;
    }

    public PacketBuffer writeShort(short value) {
        accessor.getMethodAccess().invoke(handle, mWriteShort, value);
        return this;
    }

    public PacketBuffer writeLong(long value) {
        accessor.getMethodAccess().invoke(handle, mWriteLong, value);
        return this;
    }

    public PacketBuffer writeString(String value) {
        accessor.getMethodAccess().invoke(handle, mWriteString, value);
        return this;
    }

    public byte readByte() {
        return 0;
    }

    public boolean readBoolean(){
        return false;
    }

    public int readInt() {
        return 0;
    }

    public char readChar() {
        return 0;
    }

    public float readFloat() {
        return 0;
    }

    public double readDouble() {
        return 0;
    }

    public short readShort() {
        return 0;
    }

    public long readLong() {
        return 0;
    }

    public String readString() {
        return null;
    }
}
