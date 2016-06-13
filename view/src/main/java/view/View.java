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

	public Hashtable<Character, String> getAssocSprite()
	{
		return assocSprite;
	}

	private Hashtable<Character, String> assocSprite = new Hashtable<Character, String>();

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		this.fillAssoc();
		SwingUtilities.invokeLater(this);
	}

	private void fillAssoc()
	{
		this.assocSprite.put('B', "bone.png");
		this.assocSprite.put('K', "crystal_ball.png");
		this.assocSprite.put('H', "horizontal_bone.png");
		this.assocSprite.put('V', "vertical_bone.png");
		this.assocSprite.put('C', "gate_closed.png");
		this.assocSprite.put('O', "gate_open.png");
		this.assocSprite.put('P', "purse.png");
		this.assocSprite.put('L', "lorann_b.png");
		this.assocSprite.put('1', "monster_1.png");
		this.assocSprite.put('2', "monster_2.png");
		this.assocSprite.put('3', "monster_3.png");
		this.assocSprite.put('4', "monster_4.png");
		this.assocSprite.put(' ', "");
	}


	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_1:
				return ControllerOrder.MAP1;
			case KeyEvent.VK_2:
				return ControllerOrder.MAP2;
			case KeyEvent.VK_3:
				return ControllerOrder.MAP3;
			case KeyEvent.VK_4:
				return ControllerOrder.MAP4;
			case KeyEvent.VK_5:
				return ControllerOrder.MAP5;
			case KeyEvent.VK_T:
				return ControllerOrder.test;
			default:
				return ControllerOrder.MAP1;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */

	/** allow the display of the map */
	public void printMap(final String map) {
		this.viewFrame.printMap(map);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
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
}
