package controller;

import contract.*;
import model.Model;
import view.View;
import org.junit.Before;
import org.junit.Test;

import java.awt.Point;

import static org.junit.Assert.*;


public class ControllerTest {
    private IModel model;
    private IView view;
    private IController controller;
    private IElement[][] expectedMap;

    /**
     * Sets the up.
     *
     * @throws Exception
     *           the exception
     */
    @Before
    public void setUp() throws Exception {
        this.model = new Model();
        this.view = new View(this.model);
        this.controller = new Controller(this.view, this.model);
        this.view.setController(controller);

        this.expectedMap = new IElement[][]{
                {model.element('B', new Point()), model.element('V', new Point()), model.element('H', new Point()), model.element('P', new Point()), model.element('L', new Point())},
                {model.element('1', new Point()), model.element('2', new Point()), model.element('3', new Point()), model.element('4', new Point()), model.element(' ', new Point())},
                {model.element('C', new Point()), model.element('O', new Point()), model.element(' ', new Point()), model.element(' ', new Point()), model.element(' ', new Point())}
        };
    }

    /**
     * test of the loading of a map
     *
     * @throws Exception
     */
    @Test
    public void TestOrderPerformMAP1() throws Exception {
        this.controller.orderPerform(ControllerOrder.MAP1);
        assertEquals(1, this.controller.getLevel());
        assertEquals("BHHHHHHHHHHHHHHHHHHB\n" +
                        "V    V             V\n" +
                        "V    V             V\n" +
                        "V    V     P       V\n" +
                        "V  P BHHHHHB       V\n" +
                        "V P P1     K  L   CV\n" +
                        "V  P BHHHHHB       V\n" +
                        "V    V     P       V\n" +
                        "V    V             V\n" +
                        "V    V             V\n" +
                        "V    V             V\n" +
                        "BHHHHHHHHHHHHHHHHHHB",
                this.model.getMap());
    }

    /**
     * test of the parser
     *
     * @throws Exception
     */
    @Test
    public void TestParser() throws Exception {
        IElement[][] map = this.controller.parser("BVHPL\n" +
                "1234 \n" +
                "CO   ");

        assertEquals(this.expectedMap.length, map.length);
        for (int i = 0; i < map.length; i++){
            assertEquals(this.expectedMap[i].length, map[i].length);
            for (int j = 0; j < map[i].length; j++){
                assertEquals(this.expectedMap[i][j].getClass().getCanonicalName(),
                        map[i][j].getClass().getCanonicalName());
            }
        }
    }

    /**
     * test that the parser do get the map
     *
     * @throws Exception
     */
    @Test
    public void TestParserLoadMap() throws Exception {
        this.model.loadMap("TEST");
        IElement[][] map = this.controller.parser(
                this.model.getMap()
        );

        assertEquals(this.expectedMap.length, map.length);
        for (int i = 0; i < map.length; i++){
            assertEquals(this.expectedMap[i].length, map[i].length);
            for (int j = 0; j < map[i].length; j++){
                assertEquals(this.expectedMap[i][j].getClass().getCanonicalName(),
                        map[i][j].getClass().getCanonicalName());
            }
        }
    }

    /**
     * test of the next position
     *
     * @throws Exception
     */
    @Test
    public void TestComputeNextPosUp() throws Exception {
        this.controller.orderPerform(ControllerOrder.WORKSHOP);
        Point nextPos = this.controller.computeNextPos(
                MobileOrder.Up,
                new Point(5, 5)
        );
        assertEquals(
                new Point(4, 5),
                nextPos
        );
    }

    /**
     * test of the next position to the left
     *
     * @throws Exception
     */
    @Test
    public void TestComputeNextPosLeft() throws Exception {
        this.controller.orderPerform(ControllerOrder.WORKSHOP);
        Point nextPos = this.controller.computeNextPos(
                MobileOrder.Left,
                new Point(5, 5)
        );
        assertEquals(
                new Point(5, 4),
                nextPos
        );
    }

    /**
     * test of the next position down
     *
     * @throws Exception
     */
    @Test
    public void TestComputeNextPosDown() throws Exception {
        this.controller.orderPerform(ControllerOrder.WORKSHOP);
        Point nextPos = this.controller.computeNextPos(
                MobileOrder.Down,
                new Point(5, 5)
        );
        assertEquals(
                new Point(6, 5),
                nextPos
        );
    }

    /**
     * test of the next position to the right
     *
     * @throws Exception
     */
    @Test
    public void TestComputeNextPosRight() throws Exception {
        this.controller.orderPerform(ControllerOrder.WORKSHOP);
        Point nextPos = this.controller.computeNextPos(
                MobileOrder.Right,
                new Point(5, 5)
        );
        assertEquals(
                new Point(5, 6),
                nextPos
        );
    }
}