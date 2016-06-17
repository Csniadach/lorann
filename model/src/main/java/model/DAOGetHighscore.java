package model;

import java.sql.*;
import java.util.ArrayList;

/**
 * The Class DAOLoadMap.
 *
 * @author Cyril SNIADACH
 */
class DAOGetHighscore extends DAOEntityScore<GetHighscore> {

    /**
     * Instantiates a new DAO Load Map.
     *
     * @param connection
     *          the connection
     * @throws SQLException
     *           the SQL exception
     */
    public DAOGetHighscore(final Connection connection) throws SQLException {
        super(connection);
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#create(model.Entity)
     */
    @Override
    public boolean create(final GetHighscore entity) {
        // Not implemented
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#delete(model.Entity)
     */
    @Override
    public boolean delete(final GetHighscore entity) {
        // Not implemented
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#update(model.Entity)
     */
    @Override
    public boolean update(final GetHighscore entity) {
        // Not implemented
        return false;
    }

    public void upNameAndScore(final int score, final String nickname)
    {

    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#find()
     */
    public String[][] getHighScore() {
        String[][] stringHighScore = {{},{}};

        try {
            ArrayList<String> aScores = new ArrayList<String>();
            ArrayList<String> aNicknames = new ArrayList<String>();
            String sql = "{call ShowNicknamesScores()}";
            CallableStatement call = this.getConnection().prepareCall(sql);
            ResultSet rs = call.executeQuery(sql);
            while (rs.next()) {
                aScores.add(rs.getString("score"));
                aNicknames.add(rs.getString("nickname"));
            }
            //System.out.println("NICKNAME SIZE !!!!! DEBUG DEBUG DEBUG DEBUG DEBUG " + aNicknames.size() + " DEBUG DEBUG DEBUG DEBUG DEBUG ");
            //System.out.println("SCORE SIZE !!!!! DEBUG DEBUG DEBUG DEBUG DEBUG " + aScores.size() + " DEBUG DEBUG DEBUG DEBUG DEBUG ");
            stringHighScore[0] = new String[aNicknames.size()];
            stringHighScore[1] = new String[aScores.size()];
            stringHighScore[0] = aNicknames.toArray(stringHighScore[0]);
            stringHighScore[1] = aScores.toArray(stringHighScore[1]);
            return stringHighScore;
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}