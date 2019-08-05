package de.ropemc.rv2.loader.event;

import de.ropemc.rv2.api.event.Event;
import de.ropemc.rv2.api.event.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class DefaultEventBus implements EventBus {
    private HashMap<Class<Event>, List<Consumer<Event>>> listeners = new HashMap<>();

    public HashMap<Class<Event>, List<Consumer<Event>>> getListeners() {
        return listeners;
    }

    public <T extends Event> void listen(Class<T> type, Consumer<T> listener) {
        if (!listeners.containsKey(type)) listeners.put((Class<Event>) type, new ArrayList<>());
        listeners.get(type).add((Consumer<Event>) listener);
    }

    public void listen(Class<?> clazz) {}

    public void fire(Event event) {
        listeners.getOrDefault(event.getClass(), new ArrayList<>()).forEach(eventConsumer -> eventConsumer.accept(event));
    }
}
