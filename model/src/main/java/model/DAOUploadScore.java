package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class DAOUploadScore.
 *
 * @author Cyril SNIADACH
 */
class DAOUploadScore extends DAOEntityScore<UploadScore> {

    /**
     * Instantiates a new DAO Upload Score.
     *
     * @param connection
     *          the connection
     * @throws SQLException
     *           the SQL exception
     */
    public DAOUploadScore(final Connection connection) throws SQLException {
        super(connection);
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#create(model.Entity)
     */
    @Override
    public boolean create(final UploadScore entity) {
        // Not implemented
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#delete(model.Entity)
     */
    @Override
    public boolean delete(final UploadScore entity) {
        // Not implemented
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#update(model.Entity)
     */
    @Override
    public boolean update(final UploadScore entity) {
        // Not implemented
        return false;
    }

    public String[][] getHighScore()
    {
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#find()
     */
    public void upNameAndScore(final int score, final String nickname) {
        //UploadScore uploadScore = new UploadScore(nickname, score);

        try {
            final String sql = "{call AddShowScore(?, ?)}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.setInt(1, score);
            call.setString(2, nickname);
            //call.execute();
            final int row = call.executeUpdate();
            if (row > 0)
                System.out.println("The score was uploaded to the db");
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }
}