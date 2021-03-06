package controller;

import contract.*;

import java.awt.*;
import java.util.*;

/**
 * The Class Controller.
 */
public class Controller implements IController, Observer {

	/** The view. */
	private IView view;

	/**
	 * The tilemap
	 */
	private IElement[][] tileMap;

	/** The model. */
	private IModel model;

	/**
	 * the hero
	 */
	private IHero hero;

	/**
	 * the pseudo
	 */
	private String pseudo;

	/**
	 * the level
	 */
	private int level = 1;

	/**
	 * the score
	 */
	private int score = 0;

	/**
	 * the door position
	 */
	private Point posDoor = null;

	/**
	 * the list of the alive monsters in real time
	 */
	private HashMap<String, IMonster> monsters = new HashMap<String, IMonster>();

	/**
	 * the fireball
	 */
	private IFireball fireBall;

	/**
	 * dead or not
	 */
	private boolean dead = false;

	/**
	 * parser
	 */
	private boolean parser = false;
	/**
	 * Get the tilemap
	 *
	 * @return tilemap
     */
	public IElement[][] getTileMap() {
		return tileMap;
	}

	/**
	 * Get the level
	 *
	 * @return level
     */
	public int getLevel() {
		return level;
	}

	/**
	 * Get the score
	 *
	 * @return score
     */
	public int getScore() {
		return score;
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
	 *loading of the starting map and game loop that will refresh the view
	 * @see IController#control()
	 */
	public void control() {
		this.pseudo = this.view.getPseudo();
		//System.out.println(this.pseudo); test of the entered pseudo
		this.orderPerform(ControllerOrder.MENU);

		// Game Loop
		while (true) {
			if(this.fireBall != null && !this.parser) {
				this.moveFireBall();
			}

			if(this.dead) {
				this.model.loadMap("MAP1");
				this.view.printMessage(String.format("YOU DIED! You made a score of : %d\nPress OK to restart the game", this.score));
				this.model.upNameAndScore(this.score, this.pseudo);
				this.level = 1;
				this.score = 0;
			}

			if(!this.parser) {
				for (Object o : this.monsters.entrySet()) {
					Map.Entry pair = (Map.Entry) o;
					IMonster monster = (IMonster) pair.getValue();
					this.moveMonster(monster);
				}
			}

			this.view.repaint();

			try {
				Thread.sleep(200);
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
		this.parser = true;
		String[] lines = tilemap.split("\n");
		int x = lines.length;
		int y = lines[0].length();
		IElement[][] map = new IElement[x][y];

		this.monsters.clear();
		this.posDoor = null;

		for(IElement[] row: map)
			Arrays.fill(row, this.model.element(' ', null));


		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < y; j++)
			{
				char c = lines[i].charAt(j);
				Point pos = new Point(i, j);

				IElement element = this.model.element(c, pos);
				if(c == 'L') {
					this.dead = false;
					this.hero = (IHero) element;
				}
				if(c == '1' || c == '2' || c == '3' || c == '4') {
					IMonster monster = (IMonster) element;
					this.monsters.put(monster.getClass().getSimpleName(), monster);
				}
				if(c == 'C') {
					this.posDoor = pos.getLocation();
				}
				if (element != null) {
					map[i][j] = element;
				}
			}
		}

		this.parser = false;
		return map;
	}

	/**
	 * @param controllerOrder Load map from model
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {

		if (controllerOrder == null)
			return;

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


	/**
	 * the action of shooting a fireball
	 */
	private void fire() {
		if(this.fireBall != null)
			return;
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

	/** checking the permability and if the hero gets out of the map and if the hero grabs a key and if the hero dies if he passes an open door, if he gabs a purse, etc...*/

	private void movehero(MobileOrder order) {
		Point pos = this.hero.getPos();
		this.hero.move(order, tileMap, this.view);
		this.tileMap[pos.x][pos.y] = model.element(' ', pos.getLocation());

		pos = this.hero.getPos();
		String elementName = this.tileMap[pos.x][pos.y].getClass().getSimpleName();
		if(elementName.contains("Monster")) {
			this.dead = true;
		} else if (elementName.contains("Crystal") && this.posDoor != null) {
			this.tileMap[this.posDoor.x][this.posDoor.y] = model.element('O', this.posDoor);
			this.score += 100;
		} else if (elementName.contains("OpenDoor")) {
			this.level++;
			if(this.level > 9) {
				this.model.upNameAndScore(this.score, this.pseudo);
				this.view.printMessage(String.format("WELL DONE %s! Your score is : %d\nPress OK to restart the game", this.pseudo, this.score));
				this.score = 0;
				this.level = 1;
			}
			this.model.loadMap(String.format("MAP%d", this.level));
			return;
		} else if (elementName.contains("Purse")) {
			this.score += 250;
		}
		this.tileMap[pos.x][pos.y] = this.hero;
		this.view.repaint();
	}

	/**
	 * the movement of the fireball, and check if it touches a monster
	 */
	private void moveFireBall() {
		Point currentPos = this.fireBall.getPos().getLocation();
		MobileOrder direction = this.fireBall.getDirection();
		for (MobileOrder dir : MobileOrder.getValues()) {
			if(!dir.equals(direction)) {
				Point aroundPos = this.computeNextPos(dir, currentPos);
				IElement element = this.tileMap[aroundPos.x][aroundPos.y];
				String elementName = element.getClass().getSimpleName();
				if(elementName.contains("Monster")) {
					this.tileMap[aroundPos.x][aroundPos.y] = model.element(' ', aroundPos);
					this.monsters.remove(elementName);
					this.destroyFireBall();
					return;
				}
			}
		}
		this.fireBall.animate();
		Point nextPos = this.computeNextPos(this.fireBall.getDirection(), currentPos);

		this.swapFireBall(nextPos);

		this.tileMap[currentPos.x][currentPos.y] = model.element(' ', currentPos.getLocation());

		if(this.fireBall != null && this.fireBall.getStep() > 5) {
			this.destroyFireBall();
		}
	}

	/**
	 * the next step of the fireball
	 *
	 * @param nextPos
     */
	private void swapFireBall(Point nextPos) {
		String nextElement = this.tileMap[nextPos.x][nextPos.y].getClass().getSimpleName();
		if(nextElement.contains("Monster")) {
			this.fireBall.setLocation(nextPos);
			this.tileMap[nextPos.x][nextPos.y] = this.fireBall;
			this.destroyFireBall();
			IMonster monster = this.monsters.get(nextElement);
			Point monsterPos = monster.getPos().getLocation();
			this.tileMap[monsterPos.x][monsterPos.y] = model.element(' ', monsterPos);
			this.monsters.remove(nextElement);
			this.score += 500;
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

	/**
	 * get the next position of the fireball
	 *
	 * @param direction
	 * @param currentPos
     * @return
     */
	public Point computeNextPos(MobileOrder direction, Point currentPos) {
		Point nextPos = currentPos.getLocation();

		if(direction == null)
			return nextPos;

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

	/**
	 * destroy the fireball
	 *
	 */
	private void destroyFireBall() {
		if(this.fireBall != null) {
			Point pos = this.fireBall.getPos().getLocation();
			this.tileMap[pos.x][pos.y] = this.model.element(' ', pos);
			this.fireBall = null;
		}
	}

	/**
	 * update the view
	 *
	 * @param o
	 * @param arg
     */
	public void update(Observable o, Object arg) {
		this.tileMap = parser(model.getMap());
		this.view.repaint();
	}

	/**
	 * the movement of the monster + it's permability
	 *
	 * @param monster
     */
	private void moveMonster(IMonster monster) {
		Point pos = monster.getPos().getLocation();
		Point nextPos = this.computeNextPos(
				monster.getDirection(
						this.hero.getPos().getLocation(),
						this.tileMap),
				pos);
		if(nextPos != pos) {
			String element = tileMap[nextPos.x][nextPos.y].getClass()
					.getSimpleName();
			if(element.contains("Hero")) {
				this.dead = true;
			} else if(!element.contains("Monster") &&
					!element.contains("Purse") &&
					!element.contains("Crystal") &&
					!element.contains("Door")) {
				tileMap[pos.x][pos.y] = model.element(' ', pos.getLocation());
				monster.setLocation(nextPos);
				tileMap[nextPos.x][nextPos.y] = monster;
			}
		}
	}
}
