package controller;

import contract.*;

import java.awt.*;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

/**
 * The Class Controller.
 */
public class Controller implements IController, Observer {

	/** The view. */
	private IView view;

	private IElement[][] tileMap;

	/** The model. */
	private IModel model;

	private IHero hero;

	public IElement[][] getTileMap() {
		return tileMap;
	}

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
		this.tileMap = this.parser(this.model.getMap());
		this.hero = (IHero) model.element('L', new Point());
		model.getObservable().addObserver(this);
	}

	/**
	 * Entry point of Controller
	 *loading of the starting map
	 * @see IController#control()
	 */
	public void control() {
		this.orderPerform(ControllerOrder.MENU);

		//Game Loop
		while(true) {
			this.view.repaint();
		}
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


	/**
	 * Parse tileMap to associate a Letter to a sprite
	 *
	 * @param tilemap TileMap in text format (with letter)
	 * @see contract.IController#parser(String)
	 */
	public IElement[][] parser(String tilemap) {
		String[] lines = tilemap.split("\n");
		int x = lines.length;
		int y = lines[0].length();
		IElement[][] map = new IElement[x][y];

		for(IElement[] row: map)
			Arrays.fill(row, this.model.element(' ', null));


		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < y; j++)
			{
				char c = lines[i].charAt(j);
				Point pos = new Point(i, j);

				IElement ele = this.model.element(c, pos);
				if(c == 'L') {
					this.hero = (IHero) ele;
				}
				if (ele != null) {
					map[i][j] = ele;
				}
			}
		}

		return map;
	}

	/**
	 * @param controllerOrder Load map from model
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
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
			case MAP6:
				this.model.loadMap("MAP6");
				break;
			case MAP7:
				this.model.loadMap("MAP7");
				break;
			case MAP8:
				this.model.loadMap("MAP8");
				break;
			case MAP9:
				this.model.loadMap("MAP9");
				break;
			case MENU:
				this.model.loadMap("MENU");
				break;
			case WORKSHOP:
				this.model.loadMap("WORKSHOP");
				break;
			case MOVEDOWN:
				this.movehero(MobileOrder.Down);
				break;
			case MOVEUP:
				this.movehero(MobileOrder.Up);
				break;
			case MOVERIGHT:
				this.movehero(MobileOrder.Right);
				break;
			case MOVELEFT:
				this.movehero(MobileOrder.Left);
				break;
			case FIRE:
				this.fire();
				break;
			default:
				this.model.loadMap("test");
				break;
		}
	}


	public void fire()
	{

	}

	/** checking the permability and if the hero gets out of the map */

	public void movehero(MobileOrder order) {
		Point pos = this.hero.getPos();

		this.hero.move(order, tileMap, this.view);

		this.tileMap[pos.x][pos.y] = model.element(' ', pos.getLocation());

		pos = this.hero.getPos();

		this.tileMap[pos.x][pos.y] = this.hero;

		this.view.repaint();
	}

	public void update(Observable o, Object arg) {
		this.tileMap = parser(model.getMap());
		this.view.repaint();
	}
}
