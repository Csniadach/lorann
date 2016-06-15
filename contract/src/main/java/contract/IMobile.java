package contract;

import java.awt.*;

public interface IMobile extends IElement
{
    Point getPos();

    void move(MobileOrder order);
}
