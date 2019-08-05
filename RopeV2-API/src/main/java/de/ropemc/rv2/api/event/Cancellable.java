package de.ropemc.rv2.api.event;

public interface Cancellable {
    boolean isCancelled();

    void setCancelled(boolean cancelled);

    default void cancel() {
        setCancelled(true);
    }
}
