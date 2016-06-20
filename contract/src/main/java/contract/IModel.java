package contract;

import java.awt.*;
import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {



	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	/**
	 * Gets the map content.
	 *
	 * @return the content
	 */
	String getMap();

	/**
	 * Load the map.
	 *
	 * @param key
	 *          the key
	 */
	void loadMap(String key);

	/**
	 * Get the scores
	 *
	 * @return score
     */
	String[][] getHighScore();

	/**
	 * update the nickname and score
	 *
	 * @param score
	 * @param nickname
     */
	void upNameAndScore(final int score, final String nickname);

	/**
	 * associate an element to the map
	 *
	 * @param c
	 * @param pos
     * @return
     */
	IElement element(char c, Point pos);
}
