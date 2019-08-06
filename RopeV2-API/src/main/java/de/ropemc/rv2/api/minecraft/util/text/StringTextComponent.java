package de.ropemc.rv2.api.minecraft.util.text;

import de.ropemc.rv2.api.Rope;

public class StringTextComponent implements TextComponent {
    private Wrapper wrapper;

    public StringTextComponent(String text) {
        this.wrapper = Rope.getRopeMC().getMinecraftWrapperFactory().stringTextComponent(text);
    }

    public StringTextComponent(Object handle) {
        this.wrapper = Rope.getRopeMC().getMinecraftWrapperFactory().stringTextComponent(handle);
    }

    public String getText() {
        return wrapper.getText();
    }

    public Wrapper getWrapper() {
        return wrapper;
    }

    public Object getHandle() {
        return wrapper.getHandle();
    }

    public interface Wrapper extends TextComponent {
        String getText();
    }
}
