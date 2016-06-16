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

	private IFireball fireBall;

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
		while (true) {
			if(this.fireBall != null) {
				this.moveFireBall();
			}

			this.view.repaint();

			try {
				Thread.sleep(250);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
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


	private void fire() {
		this.destroyFireBall();
		MobileOrder direction = this.hero.getDirection();
		Point currentPos = this.hero.getPos().getLocation();
		Point nextPos = this.computeNextPos(direction, currentPos);
		if(!currentPos.equals(nextPos)) {
			this.fireBall = (IFireball) this.model.element('F', nextPos);
			this.fireBall.setDirection(direction);
			this.swapFireBall(nextPos);
			this.view.repaint();
		}
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

	private void moveFireBall() {
		Point currentPos = this.fireBall.getPos().getLocation();
		this.fireBall.animate();
		System.out.printf("DICK '%s'%n", currentPos);
		Point nextPos = this.computeNextPos(this.fireBall.getDirection(), currentPos);
		System.out.printf("BUTT '%s'%n", currentPos);

		this.swapFireBall(nextPos);

		this.tileMap[currentPos.x][currentPos.y] = model.element(' ', currentPos.getLocation());

		if(this.fireBall != null && this.fireBall.getStep() > 5) {
			this.destroyFireBall();
		}
	}

	private void swapFireBall(Point nextPos) {
		String nextElement = this.tileMap[nextPos.x][nextPos.y].getClass().getCanonicalName();
		if(nextElement.contains("Monster")) {
			this.fireBall.setLocation(nextPos);
			this.tileMap[nextPos.x][nextPos.y] = this.fireBall;
			this.destroyFireBall();
		} else if(nextElement.contains("Door") ||
				nextElement.contains("Purse") ||
				nextElement.contains("Crystal")) {
			this.fireBall = null;
		}
		else {
			this.fireBall.setLocation(nextPos);
			this.tileMap[nextPos.x][nextPos.y] = this.fireBall;
		}
	}

	private Point computeNextPos(MobileOrder direction, Point currentPos) {
		Point nextPos = currentPos.getLocation();
		switch (direction) {
			case Left:
				if(currentPos.y > 0 &&
						tileMap[currentPos.x][currentPos.y - 1].getPermeability())
				{
					nextPos = new Point(
							currentPos.x,
							currentPos.y - 1);
				}
				break;
			case Right:
				if(currentPos.y < (view.getWidth() / 32) - 1 &&
						tileMap[currentPos.x][currentPos.y + 1].getPermeability())
				{
					nextPos = new Point(
							currentPos.x,
							currentPos.y + 1);
				}
				break;
			case Up:
				if(currentPos.x > 0 &&
						tileMap[currentPos.x - 1][currentPos.y].getPermeability()) {
					nextPos = new Point(
							currentPos.x - 1,
							currentPos.y);
				}
				break;
			case Down:
				if(currentPos.x < (view.getHeight() / 32) - 1 &&
						tileMap[currentPos.x + 1][currentPos.y].getPermeability()) {
					nextPos = new Point(
							currentPos.x + 1,
							currentPos.y);
				}
				break;
		}
		return nextPos;
	}

	private void destroyFireBall() {
		if(this.fireBall != null) {
			Point pos = this.fireBall.getPos().getLocation();
			this.tileMap[pos.x][pos.y] = this.model.element(' ', pos);
			this.fireBall = null;
		}
	}

	public void update(Observable o, Object arg) {
		this.tileMap = parser(model.getMap());
		this.view.repaint();
	}
}
