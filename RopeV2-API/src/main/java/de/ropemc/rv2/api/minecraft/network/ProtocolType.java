package de.ropemc.rv2.api.minecraft.network;

import de.ropemc.rv2.api.Rope;

public enum ProtocolType {
    HANDSHAKING,
    PLAY,
    STATUS,
    LOGIN;
    public ProtocolType registerPacket(PacketDirection packetDirection, Class<? extends IModPacket> packetClass){
        Rope.getRopeMC().getImplementation(Wrapper.class).registerPacket(this, packetDirection, packetClass);
        return this;
    }
    public interface Wrapper {
        void registerPacket(ProtocolType protocolType, PacketDirection packetDirection, Class<? extends IModPacket> packetClass);
    }
}
