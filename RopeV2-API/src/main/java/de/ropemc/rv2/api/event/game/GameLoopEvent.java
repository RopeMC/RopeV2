package de.ropemc.rv2.api.event.game;

import de.ropemc.rv2.api.event.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GameLoopEvent extends Event {
    private boolean renderWorldIn;
}
