package model;

import contract.IModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoadMapTest {

    private IModel model;

    /**
     * Sets the up.
     *
     * @throws Exception
     *           the exception
     */
    @Before
    public void setUp() throws Exception {
    this.model = new Model();
    }

    /**
     * Tear down.
     *
     * @throws Exception
     *           the exception
     */
    @After
    public void tearDown() throws Exception {

    }

    /**
     * test method for getMap
     *
     * @throws Exception
     */
    @Test
    public void testGetMap() throws Exception {
        this.model.loadMap("MAP1");
        Assert.assertEquals("BHHHHHHHHHHHHHHHHHHB\n" +
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
                "BHHHHHHHHHHHHHHHHHHB", this.model.getMap());
    }
}