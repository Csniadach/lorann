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
    private int         x;
    private int         y;
    private BufferedImage image = null;
    private boolean     permeability;

    public Element(String path, boolean permeability)
    {
        if (path == null) {
            System.out.println("/!\\ERROR/!\\SPRITE PATH FOR " + x + y + " IMAGE IS NULL/!\\ERROR/!\\");
        }
        if(!path.equals("")) {
            try {
                this.image = ImageIO.read(new File(
                        String.format("sprite\\%s", path)));
            } catch (IOException e) {
                System.out.println(String.format("sprite\\%s", path));
                e.printStackTrace();
            }
        }
        this.permeability = permeability;
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
