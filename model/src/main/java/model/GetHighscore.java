package model;

/**
 * The Class GetHighscore.
 *
 * @author cyril SNIADACH
 */
class GetHighscore extends EntityScore {

    private int	score;
    /**
     * Instantiates a new Get Highscore.
     */
    public GetHighscore() {

    }

    public void setGetHighScore(final int score)
    {
        this.score = score;
    }

    public int getGetHighScore()
    {
        return this.score;
    }
}

