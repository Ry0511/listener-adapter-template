package entity.events;

import base.ActionEvent;
import entity.Entity;

public class EntityDiedEvent extends ActionEvent {

    public EntityDiedEvent(Entity target) {
        super(EntityDiedEvent.class.getSimpleName(), target);
    }

    public Entity getTarget() {
        return (Entity) super.getTarget();
    }
}
