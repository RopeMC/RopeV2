package de.ropemc.rv2.api.event.game;

import de.ropemc.rv2.api.event.Cancellable;
import de.ropemc.rv2.api.event.Event;

public class ClientChatEvent extends Event implements Cancellable {
    private boolean cancelled = false;
    private String message;

    public ClientChatEvent(String message) {
        this.message = message;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
