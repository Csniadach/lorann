package model.mobile;

import contract.IMobile;
import contract.IModel;
import contract.MobileOrder;
import model.Element;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by SNIADACH Cyril
 */
public abstract class Mobile extends Element implements IMobile {
    public Point getPos() {
        return pos.getLocation();
    }

    protected Point pos = new Point();

    protected MobileOrder direction;

    public Mobile(String imagePath, boolean permeability, Point pos) {
        super(imagePath, permeability);
        this.pos.setLocation(pos);
    }

    public void move(MobileOrder order)
    {
        System.out.println("Position : " + pos);
        switch (order) {
            case Left:
                if(this.direction == MobileOrder.Left) {
                    this.pos.setLocation(
                            this.pos.getX(),
                            this.pos.getY() - 1);
                } else {
                    this.loadSprite("sprite\\lorann_l.png");
                }
                break;
            case Right:
                if(this.direction == MobileOrder.Right) {
                    this.pos.setLocation(
                            this.pos.getX(),
                            this.pos.getY() + 1);
                } else {
                    this.loadSprite("sprite\\lorann_r.png");
                }
                break;
            case Up:
                if(this.direction == MobileOrder.Up) {
                    this.pos.setLocation(
                            this.pos.getX() - 1,
                            this.pos.getY());
                } else {
                    this.loadSprite("sprite\\lorann_u.png");
                }
                break;
            case Down:
                if(this.direction == MobileOrder.Down) {
                    this.pos.setLocation(
                            this.pos.getX() + 1,
                            this.pos.getY());
                } else {
                    this.loadSprite("sprite\\lorann_b.png");
                }
                break;
        }
        this.direction = order;
        System.out.println("position : " + pos);
    }
}
