package contract;

public interface IFireball extends IMobile
{
    /**
     * Set the direction
     *
     * @param direction
     */
    void setDirection(MobileOrder direction);

    /**
     * Get step
     *
     * @return step
     */
    int getStep();

    /**
     * animate the fireball
     *
     *
     */
    void animate();
}
