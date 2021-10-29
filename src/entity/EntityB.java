package entity;

import base.ActionListener;
import base.RandomInteger;

public class EntityB extends Entity implements RandomInteger {

    public EntityB(int x, int y, ActionListener ls) {
        super(x, y, ls);
    }

    @Override
    public void update() {
        if (rng(100) > 50) {
            damage(rng(50));

        } else {
            setPosition(rng(100), rng(100));
        }
    }
}
