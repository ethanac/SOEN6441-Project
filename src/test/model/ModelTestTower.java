package test.model;

import org.junit.Test;

import models.Critter;
import models.Point;
import models.Tower;
import models.Tower_Fire;
import models.Tower_IceBeam;
import models.Tower_Laser;
import models.Tower_SpreadShot;
import strategies.Closest;
import strategies.Farthest;
import strategies.Strongest;
import strategies.Weakest;

import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
/**
 * The test for Tower class and other classes that extend it in models
 *
 * @author Xingjian Zhang
 * @version 3.0.0
 */
public class ModelTestTower {

	private Tower_Fire fireTower;
	private Tower_IceBeam iceTower;
	private Tower_Laser laserTower;
	private Tower_SpreadShot spreadTower;
	private Point[] p = new Point[4];
	private Color red, white, black, yellow;  
	private ArrayList<Critter> testCritters;
	private Closest towerClosestStrategy;
	private Farthest towerFarthestStrategy;
	private Strongest towerStrongestStrategy;
	private Weakest towerWeakestStrategy;
	
	/**
	 * Initializing 4 points of tower positions, 4 colors and 4 kinds of towers
	 */
	@Before
	public void setUp(){
		
		for(int i = 0; i < p.length; i++){
			p[i] = new Point(1, i);
		}
		red = new Color (255, 0, 0);
		white = new Color(255, 255, 255);
		black = new Color(0, 0, 0);
		yellow = new Color(255, 255, 0);
		fireTower = new Tower_Fire("Fire", p[0], testCritters);
		iceTower = new Tower_IceBeam("Ice", p[1], testCritters);
		laserTower = new Tower_Laser("Laser", p[2], testCritters);
		spreadTower = new Tower_SpreadShot("Spread", p[3], testCritters);
		towerClosestStrategy = new Closest();
		towerFarthestStrategy = new Farthest();
		towerStrongestStrategy = new Strongest();
		towerWeakestStrategy = new Weakest();
		

	}
	
	/**
	 * Tear down the Towers after every test execution
	 */
	@After
	public void tearDown(){
		
		fireTower = null;
		iceTower = null;
		laserTower = null;
		spreadTower = null;
		
	}
	
	/**
	 * Test for getting sell price
	 */
	@Test
	public void testGetSellPrice(){
		
		assertEquals(100, fireTower.getSellPrice());
		assertEquals(75, iceTower.getSellPrice());
		assertEquals(80, laserTower.getSellPrice());
		assertEquals(400, spreadTower.getSellPrice());
		
	}

	/**
	 * Test for getting tower color
	 */
	@Test
	public void testGetColor(){
		
		assertEquals(red, fireTower.getColor());
		assertEquals(white, iceTower.getColor());
		assertEquals(black, laserTower.getColor());
		assertEquals(yellow, spreadTower.getColor());
	
	}

	/**
	 * Test for getting tower damage
	 */
	@Test
	public void testGetDamage(){
		
		assertEquals(0.2, fireTower.getDamage(), 0);
		assertEquals(0.25, iceTower.getDamage(), 0);
		assertEquals(0.5, laserTower.getDamage(), 0);
		assertEquals(0.8, spreadTower.getDamage(), 0);
		
	}

	/**
	 * Test for getting tower status
	 */
	@Test
	public void testGetEnabled(){
		
		assertTrue(fireTower.getEnabled());
		assertTrue(iceTower.getEnabled());
		assertTrue(laserTower.getEnabled());
		assertTrue(spreadTower.getEnabled());
		
	}

	/**
	 * Test for getting tower level
	 */
	@Test
	public void testGetLevel(){
		
		assertEquals(1, fireTower.getLevel());
		assertEquals(1, iceTower.getLevel());
		assertEquals(1, laserTower.getLevel());
		assertEquals(1, spreadTower.getLevel());
	
	}

	/**
	 * Test for getting tower name
	 */
	@Test
	public void testGetName(){

		assertEquals("Fire", fireTower.getName());
		assertEquals("Ice", iceTower.getName());
		assertEquals("Laser", laserTower.getName());
		assertEquals("Spread", spreadTower.getName());
	
	}

	/**
	 * Test for getting tower position
	 */
	@Test
	public void testGetPosition(){
		
		assertEquals(1, fireTower.getPosX());
		assertEquals(0, fireTower.getPosY());
		assertEquals(1, iceTower.getPosX());
		assertEquals(1, iceTower.getPosY());
		assertEquals(1, laserTower.getPosX());
		assertEquals(2, laserTower.getPosY());
		assertEquals(1, spreadTower.getPosX());
		assertEquals(3, spreadTower.getPosY());	
		
	}

	/**
	 * Test for getting tower attack range
	 */
	@Test
	public void testGetRange(){

		assertEquals(100, fireTower.getRange());
		assertEquals(100, iceTower.getRange());
		assertEquals(250, laserTower.getRange());
		assertEquals(200, spreadTower.getRange());
	
	}

	/**
	 * Test for getting tower shoot color
	 */
	@Test
	public void testGetShotColor(){

		assertEquals(red, fireTower.getShotColor());
		assertEquals(white, iceTower.getShotColor());
		assertEquals(black, laserTower.getShotColor());
		assertEquals(yellow, spreadTower.getShotColor());
	
	}

	/**
	 * Test for getting tower shoot strategy
	 */
	@Test
	public void testGetStrategy(){

		assertEquals("Closest", fireTower.getStrategy().toString());
		assertEquals("Closest", iceTower.getStrategy().toString());
		assertEquals("Closest", laserTower.getStrategy().toString());
		assertEquals("Closest", spreadTower.getStrategy().toString());
	}

	/**
	 * Test for getting tower upgrade cost
	 */
	@Test
	public void testGetUpPrice(){

		assertEquals(400, fireTower.getUpPrice());
		assertEquals(350, iceTower.getUpPrice());
		assertEquals(600, laserTower.getUpPrice());
		assertEquals(2000, spreadTower.getUpPrice());
	}

	/**
	 * Test for checking whether tower is selected
	 */
	@Test
	public void testIsSelected(){

		assertFalse(fireTower.isSelected());
		assertFalse(iceTower.isSelected());
		assertFalse(laserTower.isSelected());
		assertFalse(spreadTower.isSelected());
	
	}

	/**
	 * Test for setting tower color
	 */
	@Test
	public void testSetColor(){
		
		fireTower.setColor(black);
		assertEquals(black, fireTower.getColor());	
		
	}

	/**
	 * Test for setting tower state
	 */
	@Test
	public void testSetEnabled(){
		
		fireTower.setEnabled(false);
		assertFalse(fireTower.getEnabled());	
	}

	/**
	 * Test for setting tower shoot strategy
	 */
	@Test
	public void testSetStrategy(){

		fireTower.setStrategy(towerClosestStrategy);
		assertEquals("Closest", fireTower.getStrategy().toString());
		fireTower.setStrategy(towerFarthestStrategy);
		assertEquals("Farthest", fireTower.getStrategy().toString());
		fireTower.setStrategy(towerStrongestStrategy);
		assertEquals("Strongest", fireTower.getStrategy().toString());
		fireTower.setStrategy(towerWeakestStrategy);
		assertEquals("Weakest", fireTower.getStrategy().toString());
		
	}

	/**
	 * Test for upgrading tower method
	 */
	@Test
	public void testUpgradeTower(){
		
		fireTower.upgradeTower();
		assertEquals(2, fireTower.getLevel());
	}

	/**
	 * Test for getting tower purchasing price
	 */
	@Test
	public void testGetBuyPrice(){
		 
		assertEquals(200, fireTower.getBuyPrice());
		assertEquals(150, iceTower.getBuyPrice());
		assertEquals(200, laserTower.getBuyPrice());
		assertEquals(900, spreadTower.getBuyPrice());
	}

	/**
	 * Test for getting default tower shoot strategy
	 */
	@Test
	public void testGetDefaultStrategy(){
		
		assertEquals("Closest", fireTower.getDefaultStrategy());
		assertEquals("Closest", iceTower.getDefaultStrategy());
		assertEquals("Closest", laserTower.getDefaultStrategy());
		assertEquals("Closest", spreadTower.getDefaultStrategy());
		
	}

	/**
	 * Test for getting tower max level
	 */
	@Test
	public void testGetMaxTowerLevel(){
		
		assertEquals(4, fireTower.getMaxTowerLevel());
		assertEquals(4, iceTower.getMaxTowerLevel());
		assertEquals(4, laserTower.getMaxTowerLevel());
		assertEquals(4, spreadTower.getMaxTowerLevel());	
	}
	
}
