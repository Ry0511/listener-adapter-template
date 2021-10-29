package adapter;

import entity.events.EntityDamagedEvent;
import entity.events.EntityMovedEvent;

public enum GameEvent {
    ENTITY_MOVED(EntityMovedEvent.class.getSimpleName()),
    ENTITY_DAMAGED(EntityDamagedEvent.class.getSimpleName());

    private final String eventName;

    GameEvent(String name) {
        this.eventName = name;
    }

    public String getEventName() {
        return this.eventName;
    }
}
