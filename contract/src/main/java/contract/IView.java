package contract;

import java.util.Hashtable;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

	/**
	 * Set the controller
	 *
	 * @param controller
     */
	void setController(IController controller);


	/**
	 * refresh the view
	 *
	 *
	 */
	void repaint();

	/**
	 * Get the height
	 *
	 * @return height
     */
	int getHeight();

	/**
	 * Get the width
	 *
	 * @return width
     */
	int getWidth();


	/**
	 * Get the pseudo
	 *
	 * @return pseudo
     */
	String getPseudo();

	/**
	 * print a mesage in the view
	 *
	 * @param message
     */
	void printMessage(final String message);
}
