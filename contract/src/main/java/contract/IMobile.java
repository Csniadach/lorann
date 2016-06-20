package contract;

import java.awt.*;

public interface IMobile extends IElement
{
    /**
     * set the location
     *
     * @param loc
     */
    void setLocation(Point loc);

    /**
     * Get the position
     *
     * @return pos
     */
    Point getPos();

    /**
     * allow to move
     *
     * @param order
     */
    void move(MobileOrder order);

    /**
     * Get the directions
     *
     * @return direction
     */
    MobileOrder getDirection();
}
