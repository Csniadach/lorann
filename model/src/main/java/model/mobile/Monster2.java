package model.mobile;

import contract.IElement;
import contract.IMonster;
import contract.MobileOrder;

import java.awt.*;

/**
 * Created by SNIADACH Cyril
 */
public class Monster2 extends Mobile implements IMonster {
    public Monster2(Point pos)
    {
        super("monster_2.png", true, pos);
    }


    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {
        return MobileOrder.random();
    }
}
