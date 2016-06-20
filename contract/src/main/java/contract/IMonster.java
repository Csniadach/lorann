package contract;

import java.awt.*;

public interface IMonster extends IMobile {

    /**
     * get the direction in which the monster will move (it's where the hero is)
     *
     * @param heroPos
     * @param tileMap
     * @return direction
     */
    MobileOrder getDirection(Point heroPos, IElement[][] tileMap);
}
