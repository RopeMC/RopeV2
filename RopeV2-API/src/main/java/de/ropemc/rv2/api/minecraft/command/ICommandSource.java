package de.ropemc.rv2.api.minecraft.command;

import de.ropemc.rv2.api.minecraft.util.text.ITextComponent;

public interface ICommandSource {
    void sendMessage(ITextComponent text);
}
