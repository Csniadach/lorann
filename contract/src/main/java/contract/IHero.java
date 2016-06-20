package contract;

public interface IHero extends IMobile
{

    /**
     * Allow the Hero to move
     *
     * @param order
     * @param tileMap
     * @param view
     */
    void move(MobileOrder order, IElement[][] tileMap, IView view);
}
