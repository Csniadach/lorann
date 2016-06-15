package model;

import contract.IElement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by SNIADACH Cyril
 */
public abstract class Element implements IElement {
    protected BufferedImage image = null;
    protected boolean     permeability;

    public Element(String path, boolean permeability)
    {
        if(!path.equals("")) {
            this.loadSprite(String.format("sprite\\%s", path));
        }
        this.permeability = permeability;
    }

    public void loadSprite(String path) {
        try {
        this.image = ImageIO.read(new File(path));
            } catch (IOException e) {
            e.printStackTrace();

            }
        }

    public BufferedImage getImage()
    {
        return this.image;
    }

    public boolean getPermeability()
    {
        return permeability;
    }


}
