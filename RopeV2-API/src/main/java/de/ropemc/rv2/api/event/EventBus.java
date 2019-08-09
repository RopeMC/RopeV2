package de.ropemc.rv2.api.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class EventBus {
    private HashMap<Class<Event>, List<Consumer<Event>>> listeners = new HashMap<>();

    public HashMap<Class<Event>, List<Consumer<Event>>> getListeners() {
        return listeners;
    }

    public <T extends Event> void listen(Class<T> type, Consumer<T> listener) {
        if (!listeners.containsKey(type)) listeners.put((Class<Event>) type, new ArrayList<>());
        listeners.get(type).add((Consumer<Event>) listener);
    }

    public void listen(Object instance) {
        for (Method m : instance.getClass().getDeclaredMethods()) {
            if (m.getParameterCount() == 1) {
                Class<?> paramType = m.getParameterTypes()[0];
                if (paramType.getSuperclass().equals(Event.class)) {
                    m.setAccessible(true);
                    Class<Event> eventType = (Class<Event>) paramType;
                    listen(eventType, e -> {
                        try {
                            m.invoke(instance, e);
                        } catch (IllegalAccessException | InvocationTargetException ex) {
                            ex.printStackTrace();
                        }
                    });
                }
            }
        }
    }

    public void fire(Event event) {
        listeners.getOrDefault(event.getClass(), new ArrayList<>()).forEach(eventConsumer -> eventConsumer.accept(event));
    }
}