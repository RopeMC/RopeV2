package de.ropemc.rv2.mc114;

import de.ropemc.rv2.api.Rope;
import de.ropemc.rv2.api.event.game.ClientChatEvent;
import de.ropemc.rv2.api.event.render.PreRender2DEvent;
import de.ropemc.rv2.api.event.render.Render2DEvent;
import de.ropemc.rv2.mc114.minecraft.client.gui.IngameGuiImpl;

public class EventFactory {

    public static void onPreRender2D(Object instance, float partialTicks){
        Rope.getEventBus().fire(new PreRender2DEvent(new IngameGuiImpl(instance), partialTicks));
    }

    public static void onRender2D(Object instance, float partialTicks){
        Rope.getEventBus().fire(new Render2DEvent(new IngameGuiImpl(instance), partialTicks));
    }

    public static boolean onClientChat(String text){
        ClientChatEvent clientChatEvent = new ClientChatEvent(text);
        Rope.getEventBus().fire(clientChatEvent);
        return clientChatEvent.isCancelled();
    }

}
