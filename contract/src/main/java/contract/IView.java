package contract;

import java.util.Hashtable;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {


	void setController(IController controller);

	void repaint();

	int getHeight();
	int getWidth();

	String getPseudo();
	void printMessage(final String message);
}
