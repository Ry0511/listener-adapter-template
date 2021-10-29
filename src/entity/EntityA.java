package entity;

import base.ActionListener;
import base.RandomInteger;

public class EntityA extends Entity implements RandomInteger {

    public EntityA(int x, int y, ActionListener ls) {
        super(x, y, ls);
    }

    @Override
    public void update() {
        if (rng(100) > 50) {
            this.setPosition(rng(100), rng(100));

        } else {
            this.damage(rng(50));
        }
    }
}
