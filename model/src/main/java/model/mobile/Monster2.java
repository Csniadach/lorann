package model.mobile;

import contract.IElement;
import contract.IMonster;
import contract.MobileOrder;

import java.awt.*;

/**
 * Created by SNIADACH Cyril
 */
public class Monster2 extends Mobile implements IMonster {

    /**
     * init of monster2
     *
     * @param pos
     */
    public Monster2(Point pos)
    {
        super("monster_2.png", true, pos);
    }


    /**
     * movement of the monster2, here, a random one
     *
     * @param heroPos
     * @param tileMap
     * @return
     */
    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {
        return MobileOrder.random();
    }
}
