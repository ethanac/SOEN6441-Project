package test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import models.Critter;
import models.Critter_Cyan;
import models.Critter_Orange;
import models.Critter_Pink;
import models.Critter_Red;
import models.Critter_White;
import models.Critter_Yellow;
import models.Point;
import models.TDMap;

/**
 *  The test for Critter class and other classes that extend it in models
 * 
 *	@author Xingjian Zhang
 *	@version 2.0.0
 */
public class ModelTestCritter {

	Critter_Cyan testCyanCritter;
	Critter_Orange testOrangeCritter;
	Critter_Pink testPinkCritter;
	Critter_Red testRedCritter;
	Critter_White testWhiteCritter;
	Critter_Yellow testYellowCritter;
	TDMap testMap = new TDMap("src/res/Try1.TDMap");
	Color[] colors = {Color.CYAN, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	
	/**
	 * Initializing 6 critters with 6 different types
	 */
	@Before
	public void setUp(){
		
		testCyanCritter = new Critter_Cyan(1, testMap);
		testOrangeCritter = new Critter_Orange(1, testMap);
		testPinkCritter = new Critter_Pink(1, testMap);
		testRedCritter = new Critter_Red(1, testMap);
		testWhiteCritter = new Critter_White(1, testMap);
		testYellowCritter = new Critter_Yellow(1, testMap);
		
	}
	
	/**
	 * Tear down the Critters after every test execution
	 */
	@After
	public void tearDown(){
		
		testCyanCritter = null;
		testOrangeCritter = null;
		testPinkCritter = null;
		testRedCritter = null;
		testWhiteCritter = null;
		testYellowCritter = null;
	}
	
	/**
	 * Test for getting critter color
	 */
	@Test
	public void testGetColor(){
		
		assertEquals(testCyanCritter.getColor(), Color.CYAN);
		assertEquals(testOrangeCritter.getColor(), Color.ORANGE);
		assertEquals(testPinkCritter.getColor(), Color.PINK);
		assertEquals(testRedCritter.getColor(), Color.RED);
		assertEquals(testWhiteCritter.getColor(), Color.WHITE);
		assertEquals(testYellowCritter.getColor(), Color.YELLOW);
		
	}
	
	/**
	 * Test for getting critter hit points
	 */
	@Test
	public void testGetHitPoint(){
		
		assertEquals(140, testCyanCritter.getHitPoints(), 0);
		assertEquals(175, testOrangeCritter.getHitPoints(), 0);
		assertEquals(300, testPinkCritter.getHitPoints(), 0);
		assertEquals(180, testRedCritter.getHitPoints(), 0);
		assertEquals(140, testWhiteCritter.getHitPoints(), 0);
		assertEquals(150, testYellowCritter.getHitPoints(), 0);
		
	}
	
	/**
	 * Test for getting critter pixel path index
	 */
	@Test
	public void testGetIndexInPixelPath(){
		
		assertEquals(0, testCyanCritter.getIndexInPixelPath(), 0);
		assertEquals(0, testOrangeCritter.getIndexInPixelPath(), 0);
		assertEquals(0, testPinkCritter.getIndexInPixelPath(), 0);
		assertEquals(0, testRedCritter.getIndexInPixelPath(), 0);
		assertEquals(0, testWhiteCritter.getIndexInPixelPath(), 0);
		assertEquals(0, testYellowCritter.getIndexInPixelPath(), 0);
		
	}
	
	/**
	 * Test for getting critter level
	 */
	@Test
	public void testGetLevel(){
		
		assertEquals(1, testCyanCritter.getLevel());
		assertEquals(1, testOrangeCritter.getLevel());
		assertEquals(1, testPinkCritter.getLevel());
		assertEquals(1, testRedCritter.getLevel());
		assertEquals(1, testWhiteCritter.getLevel());
		assertEquals(1, testYellowCritter.getLevel());
		
	}
	
	/**
	 * Test for getting list of pixel path of critter
	 */
	@Test
	public void testGetListPixelPath(){
		
		ArrayList<Point> testActualPath= testCyanCritter.getListPixelPath();
		ArrayList<Point> testExpectedPath= testMap.getPath_ListOfPixels();
		for(int i = 0; i < testActualPath.size(); i++){
			assertEquals(testExpectedPath.get(i).toString(),
			testActualPath.get(i).toString());
		}
		
	}
	
	/**
	 * Test for getting critter loot
	 */
	@Test
	public void testGetLoot(){
		
		assertEquals(10, testCyanCritter.getLoot());
		assertEquals(12, testOrangeCritter.getLoot());
		assertEquals(10, testPinkCritter.getLoot());
		assertEquals(12, testRedCritter.getLoot());
		assertEquals(7, testWhiteCritter.getLoot());
		assertEquals(20, testYellowCritter.getLoot());
		
	}
	
	/**
	 * Test for getting critter max hit points
	 */
	@Test
	public void testGetMaxHitPoints(){
		
		assertEquals(140, testCyanCritter.getMaxHitPoints(), 0);
		assertEquals(175, testOrangeCritter.getMaxHitPoints(), 0);
		assertEquals(300, testPinkCritter.getMaxHitPoints(), 0);
		assertEquals(180, testRedCritter.getMaxHitPoints(), 0);
		assertEquals(140, testWhiteCritter.getMaxHitPoints(), 0);
		assertEquals(150, testYellowCritter.getMaxHitPoints(), 0);
		
	}
	
	/**
	 * Test for getting critter default position
	 */
	@Test
	public void testGetPixelPosition(){
		
		Point testPoint = new Point(-1, -1);
		assertEquals(testPoint.toString(), testCyanCritter.getPixelPosition().toString());
		assertEquals(testPoint.toString(), testOrangeCritter.getPixelPosition().toString());
		assertEquals(testPoint.toString(), testPinkCritter.getPixelPosition().toString());
		assertEquals(testPoint.toString(), testRedCritter.getPixelPosition().toString());
		assertEquals(testPoint.toString(), testWhiteCritter.getPixelPosition().toString());
		assertEquals(testPoint.toString(), testYellowCritter.getPixelPosition().toString());
		
	}
	
	/**
	 * Test for getting critter raw move speed
	 */
	@Test
	public void testGetRawSpeed(){
		
		assertEquals(4, testCyanCritter.getRawSpeed(), 0);
		assertEquals(4, testOrangeCritter.getRawSpeed(), 0);
		assertEquals(2, testPinkCritter.getRawSpeed(), 0);
		assertEquals(4, testRedCritter.getRawSpeed(), 0);
		assertEquals(10, testWhiteCritter.getRawSpeed(), 0);
		assertEquals(8, testYellowCritter.getRawSpeed(), 0);
		
	}
	
	/**
	 * Test for getting critter regeneration
	 */
	@Test
	public void testGetRegen(){
		
		assertEquals(0.5, testCyanCritter.getRegen(), 0);
		assertEquals(1, testOrangeCritter.getRegen(), 0);
		assertEquals(2, testPinkCritter.getRegen(), 0);
		assertEquals(0, testRedCritter.getRegen(), 0);
		assertEquals(0, testWhiteCritter.getRegen(), 0);
		assertEquals(2, testYellowCritter.getRegen(), 0);
		
	}
	
	/**
	 * Test for getting critter regeneration
	 */
	@Test
	public void testGetSize(){
		
		assertEquals(5, testCyanCritter.getSize(), 0);
		assertEquals(5, testOrangeCritter.getSize(), 0);
		assertEquals(5, testPinkCritter.getSize(), 0);
		assertEquals(5, testRedCritter.getSize(), 0);
		assertEquals(5, testWhiteCritter.getSize(), 0);
		assertEquals(5, testYellowCritter.getSize(), 0);
		
	}
	
	/**
	 * Test for getting critter current move speed
	 */
	@Test
	public void testGetSpeed(){
		
		assertEquals(4, testCyanCritter.getSpeed(), 0);
		assertEquals(4, testOrangeCritter.getSpeed(), 0);
		assertEquals(2, testPinkCritter.getSpeed(), 0);
		assertEquals(4, testRedCritter.getSpeed(), 0);
		assertEquals(10, testWhiteCritter.getSpeed(), 0);
		assertEquals(8, testYellowCritter.getSpeed(), 0);
		
	}
	
	/**
	 * Test for method which checks the critter reaches end or not
	 */
	@Test
	public void testHasReachedEnd(){

		assertFalse(testCyanCritter.hasReachedEnd());
		assertFalse(testOrangeCritter.hasReachedEnd());
		assertFalse(testPinkCritter.hasReachedEnd());
		assertFalse(testRedCritter.hasReachedEnd());
		assertFalse(testWhiteCritter.hasReachedEnd());
		assertFalse(testYellowCritter.hasReachedEnd());
		
	}
	
	/**
	 * Test for checking the critters' active state
	 */
	@Test
	public void testIsActive(){

		assertFalse(testCyanCritter.isActive());
		assertFalse(testOrangeCritter.isActive());
		assertFalse(testPinkCritter.isActive());
		assertFalse(testRedCritter.isActive());
		assertFalse(testWhiteCritter.isActive());
		assertFalse(testYellowCritter.isActive());
		
	}
	
	/**
	 * Test for method checking the critter is alive
	 */
	@Test
	public void testIsAlive(){

		assertTrue(testCyanCritter.isAlive());
		assertTrue(testOrangeCritter.isAlive());
		assertTrue(testPinkCritter.isAlive());
		assertTrue(testRedCritter.isAlive());
		assertTrue(testWhiteCritter.isAlive());
		assertTrue(testYellowCritter.isAlive());
		
	}

	/**
	 * Test for checking critter being burning
	 */
	@Test
	public void testIsBurning(){

		assertFalse(testCyanCritter.isBurning());
		assertFalse(testOrangeCritter.isBurning());
		assertFalse(testPinkCritter.isBurning());
		assertFalse(testRedCritter.isBurning());
		assertFalse(testWhiteCritter.isBurning());
		assertFalse(testYellowCritter.isBurning());
		
	}

	/**
	 * Test for method that makes critter info into string
	 */
	@Test
	public void test(){

		assertEquals("\nHP: 140.0/140.0\nRegen = 0.5\n", testCyanCritter.toString());
		assertEquals("\nHP: 175.0/175.0\nRegen = 1.0\n", testOrangeCritter.toString());
		assertEquals("\nHP: 300.0/300.0\nRegen = 2.0\n", testPinkCritter.toString());
		assertEquals("\nHP: 180.0/180.0\nRegen = 0.0\n", testRedCritter.toString());
		assertEquals("\nHP: 140.0/140.0\nRegen = 0.0\n", testWhiteCritter.toString());
		assertEquals("\nHP: 150.0/150.0\nRegen = 2.0\n", testYellowCritter.toString());
	}

	
}
