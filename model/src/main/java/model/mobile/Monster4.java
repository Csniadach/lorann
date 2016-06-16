package model.mobile;

import contract.IElement;
import contract.IMonster;
import contract.MobileOrder;

import java.awt.*;

/**
 * Created by SNIADACH Cyril
 */
public class Monster4 extends Mobile implements IMonster {
    public Monster4(Point pos)
    {
        super("monster_4.png", true, pos);
    }


    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {
        return null;
    }
}
