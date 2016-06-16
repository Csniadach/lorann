package contract;

public interface IFireball extends IMobile
{
    void setDirection(MobileOrder direction);
    int getStep();
    void animate();
}
