package view;

import java.awt.event.KeyEvent;
import java.util.Hashtable;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * CrystalBall code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_NUMPAD1:
				return ControllerOrder.MAP1;
			case KeyEvent.VK_NUMPAD2:
				return ControllerOrder.MAP2;
			case KeyEvent.VK_NUMPAD3:
				return ControllerOrder.MAP3;
			case KeyEvent.VK_NUMPAD4:
				return ControllerOrder.MAP4;
			case KeyEvent.VK_NUMPAD5:
				return ControllerOrder.MAP5;
			case KeyEvent.VK_NUMPAD6:
				return ControllerOrder.MAP6;
			case KeyEvent.VK_NUMPAD7:
				return ControllerOrder.MAP7;
			case KeyEvent.VK_NUMPAD8:
				return ControllerOrder.MAP8;
			case KeyEvent.VK_NUMPAD9:
				return ControllerOrder.MAP9;
			case KeyEvent.VK_NUMPAD0:
				return ControllerOrder.test;
			case KeyEvent.VK_LEFT:
				return ControllerOrder.MOVELEFT;
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.MOVERIGHT;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.MOVEDOWN;
			case KeyEvent.VK_UP:
				return ControllerOrder.MOVEUP;
			default:
				return null;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	public void repaint(){
		this.viewFrame.update();
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}


	public int getHeight()
	{
		return this.viewFrame.getHeight();
	}
	public int getWidth()
	{
		return this.viewFrame.getWidth();
	}
}
