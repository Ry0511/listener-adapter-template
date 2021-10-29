package entity.events;

import base.ActionEvent;
import base.VisualEvent;
import entity.Entity;
import javafx.scene.image.ImageView;

public class EntityDamagedEvent extends ActionEvent implements VisualEvent {

    private final ImageView view;
    private final int damageTaken;

    public EntityDamagedEvent(final Entity target,
                              final int damageTaken,
                              final ImageView view) {
        super(EntityDamagedEvent.class.getSimpleName(), target);
        this.damageTaken = damageTaken;
        this.view = view;
    }

    public Entity getTarget() {
        return (Entity) super.getTarget();
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    @Override
    public ImageView getImage() {
        return null;
    }
}
