package model.mobile;

import contract.IElement;
import contract.IMonster;
import contract.MobileOrder;

import java.awt.*;

/**
 * Created by SNIADACH Cyril
 */
public class Monster4 extends Mobile implements IMonster {

    /**
     * init of monster 4
     *
     * @param pos
     */
    public Monster4(Point pos)
    {
        super("monster_4.png", true, pos);
    }


    /**
     * movement of the monster2, here, the monster is idle
     *
     * @param heroPos
     * @param tileMap
     * @return
     */
    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {
        return null;
    }
}
