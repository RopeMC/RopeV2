package de.ropemc.rv2.api.event;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public interface EventBus {
    HashMap<Class<Event>, List<Consumer<Event>>> getListeners();

    <T extends Event> void listen(Class<T> type, Consumer<T> listener);

    void listen(Class<?> clazz);

    void fire(Event event);
}
