package model.mobile;

import contract.IElement;
import contract.IMonster;
import contract.MobileOrder;

import java.awt.*;

/**
 * Created by SNIADACH Cyril
 */
public class Monster3 extends Mobile implements IMonster {

    /**
     * init of monster3
     *
     * @param pos
     */
    public Monster3(Point pos)
    {
        super("monster_3.png", true, pos);
    }


    /**
     * movement of the monster3, here, a random one
     *
     * @param heroPos
     * @param tileMap
     * @return
     */
    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {
        return MobileOrder.random();
    }
}