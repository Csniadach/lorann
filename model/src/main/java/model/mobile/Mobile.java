package model.mobile;

import contract.IMobile;
import contract.IModel;
import contract.MobileOrder;
import model.Element;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by SNIADACH Cyril
 */
public abstract class Mobile extends Element implements IMobile {
    public Point getPos() {
        return pos.getLocation();
    }

    private Point pos = new Point();
    private int dx = 0;
    private int dy = 0;

    public Mobile(String imagePath, boolean permeability, Point pos) {
        super(imagePath, permeability);
        this.pos.setLocation(pos);
    }

    public void move(MobileOrder order)
    {
        System.out.println("Position : " + pos);
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
        System.out.println("position : " + pos);
    }
}
