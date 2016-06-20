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

    /**
     * the image
     */
    protected BufferedImage image = null;

    /**
     * the permability
     */
    protected boolean     permeability;

    /**
     * the Element
     *
     * @param path
     * @param permeability
     */
    public Element(String path, boolean permeability)
    {
        if(!path.equals("")) {
            this.loadSprite(path);
        }
        this.permeability = permeability;
    }

    /**
     * load the sprite from the good path
     *
     * @param path
     */
    protected void loadSprite(String path) {
        String.format("Working Directory = /sprite/%s", path);
        if(path == null)
            return;
        try {
            this.image = ImageIO.read(getClass().getResource(String.format("/sprite/%s", path)));
            } catch (IOException e) {
            e.printStackTrace();

            }
        }

    /**
     * get the image
     *
     * @return image
     */
    public BufferedImage getImage()
    {
        return this.image;
    }

    /**
     * get the permability
     *
     * @return permability
     */
    public boolean getPermeability()
    {
        return permeability;
    }


}
