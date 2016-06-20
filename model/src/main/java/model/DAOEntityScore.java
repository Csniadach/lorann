package model;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * The Class DAOEntity.
 *
 * @author Jean-Aymeric Diet
 *
 * @param <E>
 *          the element type
 */
abstract class DAOEntityScore<E extends EntityScore> {

    /** The connection. */
    private final Connection connection;

    /**
     * Instantiates a new DAO entity.
     *
     * @param connection
     *          the connection
     * @throws SQLException
     *           the SQL exception
     */
    public DAOEntityScore(final Connection connection) throws SQLException {
        this.connection = connection;
    }

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    protected Connection getConnection() {
        return this.connection;
    }

    /**
     * Creates the.
     *
     * @param entityScore
     *          the entityScore
     * @return true, if successful
     */
    public abstract boolean create(E entityScore);

    /**
     * Delete.
     *
     * @param entityScore
     *          the entityScore
     * @return true, if successful
     */
    public abstract boolean delete(E entityScore);

    /**
     * Update.
     *
     * @param entityScore
     *          the entityScore
     * @return true, if successful
     */
    public abstract boolean update(E entityScore);

    /**
     * get the highscore
     *
     * @return highscore[][]
     */
    public abstract String[][] getHighScore();

    /**
     * update the name and score
     *
     * @param score
     * @param nickname
     */
    public abstract void upNameAndScore(final int score, final String nickname);
}
