package entity.events;

import base.ActionEvent;
import base.VisualEvent;
import entity.Entity;
import javafx.scene.image.ImageView;


public class EntityMovedEvent extends ActionEvent implements VisualEvent {

    /**
     * GUI Would like this if it needs to display a visual event.
     */
    private final ImageView view;

    private final int oldX;
    private final int oldY;

    public EntityMovedEvent(final Entity target,
                            final ImageView view,
                            final int oldX,
                            final int oldY) {
        super(EntityMovedEvent.class.getSimpleName(), target);
        this.view = view;
        this.oldX = oldX;
        this.oldY = oldY;
    }

    public int getOldX() {
        return this.oldX;
    }

    public int getOldY() {
        return this.oldY;
    }

    @Override
    public Entity getTarget() {
        return (Entity) super.getTarget();
    }

    @Override
    public ImageView getImage() {
        return null;
    }
}
