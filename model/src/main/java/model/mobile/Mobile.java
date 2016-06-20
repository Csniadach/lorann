package model.mobile;

import contract.IMobile;
import contract.IModel;
import contract.MobileOrder;
import model.Element;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

/**
 * Created by SNIADACH Cyril
 */
public abstract class Mobile extends Element implements IMobile {

    /**
     * get the position
     *
     * @return pos
     */
    public Point getPos() {
        return pos.getLocation();
    }

    /**
     * init of the position
     *
     */
    protected Point pos = new Point();

    /**
     * init of the direction
     */
    protected MobileOrder direction = MobileOrder.Down;

    /**
     * inti of Mobile
     *
     * @param imagePath
     * @param permeability
     * @param pos
     */
    public Mobile(String imagePath, boolean permeability, Point pos) {
        super(imagePath, permeability);
        this.pos.setLocation(pos);
    }

    /**
     * set the location
     *
     * @param loc
     */
    public void setLocation(Point loc) {
        this.pos.setLocation(loc);
    }

    /**
     * get the direction
     *
     * @return direction
     */
    public MobileOrder getDirection() {
        return direction;
    }

    /**
     * the movement of a mobile elements
     *
     * @param order
     */
    public void move(MobileOrder order)
    {
        switch (order) {
            case Left:
                this.pos.setLocation(
                        this.pos.getX(),
                        this.pos.getY() - 1);
                break;
            case Right:
                this.pos.setLocation(
                        this.pos.getX(),
                        this.pos.getY() + 1);
                break;
            case Up:
                this.pos.setLocation(
                        this.pos.getX() - 1,
                        this.pos.getY());
                break;
            case Down:
                this.pos.setLocation(
                        this.pos.getX() + 1,
                        this.pos.getY());
                break;
        }
        this.direction = order;
        System.out.println("POS : " + pos);
    }
}
