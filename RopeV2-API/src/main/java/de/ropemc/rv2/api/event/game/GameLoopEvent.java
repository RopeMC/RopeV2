package de.ropemc.rv2.api.event.game;

import de.ropemc.rv2.api.event.Event;

public class GameLoopEvent extends Event {

    private boolean renderWorldIn;

    public GameLoopEvent(boolean renderWorldIn){
        this.renderWorldIn = renderWorldIn;
    }

    public boolean isRenderWorldIn(){
        return renderWorldIn;
    }

}
