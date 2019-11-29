package de.ropemc.rv2.api.event.game;

import de.ropemc.rv2.api.event.Cancellable;
import de.ropemc.rv2.api.event.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientChatEvent extends Event implements Cancellable {
    private boolean cancelled = false;
    private String message;

    public ClientChatEvent(String message) {
        this.message = message;
    }
}
