package model.mobile;

import contract.IFireball;
import contract.MobileOrder;

import java.awt.*;

/**
 * Created by SNIADACH Cyril
 */
public class FireBall extends Mobile implements IFireball {

    /**
     * step
     */
    private int step = 1;

    /**
     * initialize the fireball
     *
     * @param pos
     */
    public FireBall(Point pos) {
        super("fireball_1.png", true, pos);
    }

    /**
     * get the step
     *
     * @return step
     */
    public int getStep() {
        return step;
    }

    /**
     * sets the direction where the fireball is heading
     *
     * @param direction
     */
    public void setDirection(MobileOrder direction) {
        this.direction = direction;
    }

    /**
     * animate the fireball:
     * increments the step and change it's sprite each step
     *
     */
    public void animate() {
        this.step++;
        if(this.step > 0 && this.step < 6) {
            this.loadSprite(String.format("fireball_%d.png", this.step));
        }

        //System.out.println(this.step); //this is a test for the position of the fireball
    }
}
