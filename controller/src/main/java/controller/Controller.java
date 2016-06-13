package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		//this.view.printMap("Appuyer sur les touches '1', '2', '3' '4' ou '5', pour charger le niveau de votre choix.");
		this.model.loadMap("MAP1");
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */

	/**parser function*/
	public String[][] parser(String tilemap)
	{
		String[] lines = tilemap.split("\n");
		int x = lines.length;
		int y = lines[0].length();
		String[][] map = new String[y][x];
		Hashtable<Character, String> assocSprite = this.view.getAssocSprite();
		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < y; j++)
			{
				map[j][i] = assocSprite.get(lines[i].charAt(j));
			}
		}
		return map;
	}

	/** the loading the map in function of the map_name on the database*/
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case MAP1:
				this.model.loadMap("MAP1");
				break;
			case MAP2:
				this.model.loadMap("MAP2");
				break;
			case MAP3:
				this.model.loadMap("MAP3");
				break;
			case MAP4:
				this.model.loadMap("MAP4");
				break;
			case MAP5:
				this.model.loadMap("MAP5");
				break;
			case test:
				this.model.loadMap("MAP6");
				break;

			default:
				break;
		}
	}

}
