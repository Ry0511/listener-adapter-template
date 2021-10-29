package entity;

import base.ActionEvent;
import base.ActionListener;
import entity.events.EntityDamagedEvent;
import entity.events.EntityDiedEvent;
import entity.events.EntityMovedEvent;

public abstract class Entity {

    private static long countID = 0;
    private final long ID;
    private final ActionListener listener;
    private int x;
    private int y;
    private int health;

    /**
     * Our implementation won't have ActionListener as a parameter; it will
     * need to be set through a method since we may not always have access to
     * the listener when we create the Entity.
     */
    public Entity(int x, int y, ActionListener ls) {
        this.x = x;
        this.y = y;
        this.health = 100;
        this.listener = ls;
        ID = countID;
        ++countID;
    }

    public long getID() {
        return this.ID;
    }

    protected void setPosition(int x, int y) {
        // null is the image view; it's just there to showcase how a visual
        // event will work
        final ActionEvent event
                = new EntityMovedEvent(this, null, this.x, this.y);
        this.x = x;
        this.y = y;
        fireListener(event);
    }

    private void setHealth(final int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    protected void kill() {
        this.setHealth(0);
        fireListener(new EntityDiedEvent(this));
    }

    protected void damage(final int damage) {
        // Create event
        final ActionEvent event
                = new EntityDamagedEvent(this, damage, null);

        // Update state
        final int newHp = this.health - damage;
        if (newHp > 0) {
            setHealth(newHp);
        } else {
            kill();
        }

        // Fire event
        fireListener(event);
    }

    public abstract void update();

    protected void fireListener(final ActionEvent event) {
        this.listener.action(event);
    }

    @Override
    public String toString() {
        return String.format("%s, [%s, %s, %s]", ID, x, y, health);
    }
}
