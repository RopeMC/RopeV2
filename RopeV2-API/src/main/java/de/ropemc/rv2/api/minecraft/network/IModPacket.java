package de.ropemc.rv2.api.minecraft.network;

public interface IModPacket {
    void readPacketData(PacketBuffer buffer);
    void writePacketData(PacketBuffer buffer);
    void processPacket();
}
