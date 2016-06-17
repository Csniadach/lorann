package model;

import java.awt.*;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Observable;

import contract.IElement;
import contract.IModel;
import model.mobile.*;
import model.motionless.*;

/**
 * The Class Model.
 */
public class Model extends Observable implements IModel {

	/** The map */
	private String map = "";

	/** The score */
	private int score = 0;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
	}

	/**
	 * Associate all sprite with a letter representing hin in tileMap
	 */
	public IElement element(char c, Point pos) {
		switch (c){
			case 'B':
				return new Bone();
			case 'K':
				return new CrystalBall();
			case 'H':
				return new HorizontalBone();
			case 'V':
				return new VerticalBone();
			case 'C':
				return new ClosedDoor();
			case 'O':
				return new OpenDoor();
			case 'P':
				return new Purse();
			case 'L':
				return new Hero(pos);
			case 'F':
				return new FireBall(pos);
			case '1':
				return new Monster1(pos);
			case '2':
				return new Monster2(pos);
			case '3':
				return new Monster3(pos);
			case '4':
				return new Monster4(pos);
			case 'T':
				return new Title();
			case 'S':
				return new Score();
			default:
				return new Empty();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}


	/** i added the map functions in general here*/

	public String getMap() {
		return this.map;
	}


	private void setMap(final String map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}


	public void loadMap(String key) {
		try {
			final DAOLoadMap daoLoadMap = new DAOLoadMap(DBConnection.getInstance().getConnection());
			this.setMap(daoLoadMap.find(key).getMap());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	public void upNameAndScore(final int score, final String nickname)
	{
		try
		{
			final DAOUploadScore daoUploadScore = new DAOUploadScore(DBConnection.getInstance().getConnection());
			daoUploadScore.upNameAndScore(score, nickname);
		}
		catch (final SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void setGetHighScore(final int score)
	{
		this.score = score;
	}

	public int getGetHighScore()
	{
		return this.score;
	}

	public String[][] getHighScore()
	{
		try {
			final DAOGetHighscore daoGetHighscore = new DAOGetHighscore(DBConnection.getInstance().getConnection());
			return (daoGetHighscore.getHighScore());
		}
		catch (final SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
