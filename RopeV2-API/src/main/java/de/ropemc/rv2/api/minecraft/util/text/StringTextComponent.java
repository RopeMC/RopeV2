package de.ropemc.rv2.api.minecraft.util.text;

import de.ropemc.rv2.api.MinecraftWrapperFactory;
import de.ropemc.rv2.api.Rope;
import lombok.Getter;
import lombok.experimental.Delegate;

public class StringTextComponent implements TextComponent {

    private static MinecraftWrapperFactory getMinecraftWrapperFactory(){
        return Rope.getRopeMC().getImplementation(MinecraftWrapperFactory.class);
    }

    @Delegate
    @Getter
    private Wrapper wrapper;

    public StringTextComponent(String text) {
        this.wrapper = getMinecraftWrapperFactory().stringTextComponent(text);
    }

    public StringTextComponent(Object handle) {
        this.wrapper = getMinecraftWrapperFactory().stringTextComponent(handle);
    }

    public interface Wrapper extends TextComponent {
        String getText();
    }
}
