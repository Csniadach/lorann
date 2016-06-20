package contract;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum MobileOrder
{
    /**
     * the directions available to the mobiles components
     *
     */
    Right,
    Up,
    Left,
    Down;

    /**
     * the list of the possible moves
     *
     * @return VALUES
     */
    public static List<MobileOrder> getValues()
{
    return VALUES;
}

    /**
     * initialize the value that will be determined by random
     *
     */
    private static final java.util.List<MobileOrder> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    /**
     * allow the value to be between 1 and 4
     *
     */
    private static final int SIZE = VALUES.size();

    /**
     * get a random number
     *
     */
    private static final Random RANDOM = new Random();

    /**
     * Get a random value between 1 and 4
     *
     * @return VALUES.get(RANDOM.nextInt(SIZE)
     */
    public static MobileOrder random()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
