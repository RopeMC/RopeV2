package de.ropemc.rv2.mc114.minecraft.util.text;

import de.ropemc.rv2.api.minecraft.util.text.StringTextComponent;
import de.ropemc.rv2.util.ReflectAccessor;

public class StringTextComponentImpl implements StringTextComponent.Wrapper {

    private static ReflectAccessor accessor = ReflectAccessor.getByName("jx");

    private static int cStringTextComponent = accessor.getConstructorAccess().getIndex(String.class);
    private static int mGetText = accessor.getMethodAccess().getIndex("i", new Class[0]);

    protected Object handle;

    public StringTextComponentImpl(Object handle) {
        this.handle = handle;
    }

    public StringTextComponentImpl(String text) {
        this.handle = accessor.getConstructorAccess().newInstance(cStringTextComponent, text);
    }

    public String getText() {
        return (String) accessor.getMethodAccess().invoke(this.handle, mGetText);
    }

    public Object getHandle() {
        return handle;
    }
}
