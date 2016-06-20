package model.motionless;

import model.Element;

/**
 * Created by SNIADACH Cyril
 */
public abstract class Motionless extends Element {

    /**
     * init of motionless
     *
     * @param imagePath
     * @param permeability
     */
    public Motionless(String imagePath, final boolean permeability) {
        super(imagePath, permeability);
    }
}
