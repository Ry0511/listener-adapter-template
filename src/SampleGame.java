import base.ActionListener;
import base.RandomInteger;
import entity.Entity;
import entity.EntityA;
import entity.EntityB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SampleGame implements RandomInteger {

    private final List<Entity> entities;
    private final Timer timer;

    public SampleGame() {
        this.entities = new ArrayList<>();
        this.timer = new Timer(300, this::gameLoop);
    }

    private void gameLoop(ActionEvent actionEvent) {

        if (entities.size() > 0) {
            ListIterator<Entity> iter = entities.listIterator();

            while (iter.hasNext()) {
                Entity e = iter.next();

                if (e.getHealth() > 0) {
                    e.update();
                } else {
                    iter.remove();
                }
            }
            System.out.println();
        }

    }

    /**
     * Adds either EntityA or EntityB to the game.
     * @param listener
     */
    public void addEntity(ActionListener listener) {
        if (rng(10) > 5) {
            entities.add(new EntityA(rng(10), rng(10), listener));
        } else {
            entities.add(new EntityB(rng(10), rng(10), listener));
        }
    }

    public void startGame() {
        this.timer.start();
    }

    public void endGame() {
        this.timer.stop();
    }
}
