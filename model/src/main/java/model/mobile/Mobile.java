package model.mobile;

import model.Element;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by SNIADACH Cyril
 */
public abstract class Mobile extends Element {
    private int x;
    private int y;
    private int dx = 0;
    private int dy = 0;

    public Mobile(String imagePath, final boolean permeability) {
        super(imagePath, permeability);
        this.x = x;
        this.y = y;
    }

    public void moveLeft()
    {
        this.dx = -1;
    }

    public void moveRight()
    {
        this.dx = 1;
    }

    public void moveUp()
    {
        this.dy = -1;
    }

    public void moveDown()
    {
        this.dy = 1;
    }

    public void move()
    {
        this.x += this.dx;
        this.y += this.dy;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }
}
