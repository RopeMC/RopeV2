package de.ropemc.rv2.api.minecraft.network;

public interface PacketBuffer {
    PacketBuffer writeByte(byte value);
    PacketBuffer writeBoolean(boolean value);
    PacketBuffer writeInt(int value);
    PacketBuffer writeChar(char value);
    PacketBuffer writeFloat(float value);
    PacketBuffer writeDouble(double value);
    PacketBuffer writeShort(short value);
    PacketBuffer writeLong(long value);
    PacketBuffer writeString(String value);
    byte readByte();
    boolean readBoolean();
    int readInt();
    char readChar();
    float readFloat();
    double readDouble();
    short readShort();
    long readLong();
    String readString();
}
