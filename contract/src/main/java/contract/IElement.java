package contract;

import java.awt.image.BufferedImage;

public interface IElement {

    /**
     * Get permability
     *
     * @return permability
     */
    boolean getPermeability();

    /**
     *
     * get image
     *
     * @return image
     */
    BufferedImage getImage();
}
