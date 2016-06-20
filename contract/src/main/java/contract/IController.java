package contract;

import java.awt.*;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {

	/**
	 * Control.
	 */
	public void control();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void orderPerform(ControllerOrder controllerOrder);

	/**
	 * Get score
	 *
	 *@return score
     */
	int getScore();

	/**
	 * Get level
	 *
	 * @return level
     */
	int getLevel();

	/**
	 * Get tilemap
	 *
	 * @return tilemap[][]
     */
	IElement[][] getTileMap();

	/**
	 * Parse the map text
	 *
	 *
	 * @param tilemap
	 * @return IElement[][]
     */
	IElement[][] parser(String tilemap);

	/**the next position
	 *
	 * @param direction
	 * @param currentPos
     * @return
     */
	Point computeNextPos(MobileOrder direction, Point currentPos);

}
