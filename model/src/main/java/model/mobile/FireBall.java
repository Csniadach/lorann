package model.mobile;

import contract.IFireball;
import contract.MobileOrder;

import java.awt.*;

/**
 * Created by SNIADACH Cyril
 */
public class FireBall extends Mobile implements IFireball {

    private int step = 1;

    public FireBall(Point pos) {
        super("fireball_1.png", true, pos);
    }

    public int getStep() {
        return step;
    }

    @Override
    public void setDirection(MobileOrder direction) {
        this.direction = direction;
    }

    public void animate() {
        this.step++;
        if(this.step > 0 && this.step < 6) {
            this.loadSprite(String.format("sprite\\fireball_%d.png", this.step));
        }

        System.out.println(this.step);
    }
}
