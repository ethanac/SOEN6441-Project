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
		
		//towerTest.setColor(red);

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
		
		assertEquals(fireTower.getSellPrice(), 100);
		assertEquals(iceTower.getSellPrice(), 75);
		assertEquals(laserTower.getSellPrice(), 80);
		assertEquals(spreadTower.getSellPrice(), 400);
		
	}

	/**
	 * Test for getting tower color
	 */
	@Test
	public void testGetColor(){
		
		assertEquals(fireTower.getColor(), red);
		assertEquals(iceTower.getColor(), white);
		assertEquals(laserTower.getColor(), black);
		assertEquals(spreadTower.getColor(), yellow);
	
	}

	/**
	 * Test for getting tower damage
	 */
	@Test
	public void testGetDamage(){
		
		assertEquals(fireTower.getDamage(), 0.2, 0);
		assertEquals(iceTower.getDamage(), 0.25, 0);
		assertEquals(laserTower.getDamage(), 0.5, 0);
		assertEquals(spreadTower.getDamage(), 0.8, 0);
		
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
		
		assertEquals(fireTower.getLevel(), 1);
		assertEquals(iceTower.getLevel(), 1);
		assertEquals(laserTower.getLevel(), 1);
		assertEquals(spreadTower.getLevel(), 1);
	
	}

	/**
	 * Test for getting tower name
	 */
	@Test
	public void testGetName(){

		assertEquals(fireTower.getName(), "Fire");
		assertEquals(iceTower.getName(), "Ice");
		assertEquals(laserTower.getName(), "Laser");
		assertEquals(spreadTower.getName(), "Spread");
	
	}

	/**
	 * Test for getting tower position
	 */
	@Test
	public void testGetPosition(){
		
		assertEquals(fireTower.getPosX(), 1);
		assertEquals(fireTower.getPosY(), 0);
		assertEquals(iceTower.getPosX(), 1);
		assertEquals(iceTower.getPosY(), 1);
		assertEquals(laserTower.getPosX(), 1);
		assertEquals(laserTower.getPosY(), 2);
		assertEquals(spreadTower.getPosX(), 1);
		assertEquals(spreadTower.getPosY(), 3);	
		
	}

	/**
	 * Test for getting tower attack range
	 */
	@Test
	public void testGetRange(){

		assertEquals(fireTower.getRange(), 100);
		assertEquals(iceTower.getRange(), 100);
		assertEquals(laserTower.getRange(), 250);
		assertEquals(spreadTower.getRange(), 200);
	
	}

	/**
	 * Test for getting tower shoot color
	 */
	@Test
	public void testGetShotColor(){

		assertEquals(fireTower.getShotColor(), red);
		assertEquals(iceTower.getShotColor(), white);
		assertEquals(laserTower.getShotColor(), black);
		assertEquals(spreadTower.getShotColor(), yellow);
	
	}

	/**
	 * Test for getting tower shoot strategy
	 */
	@Test
	public void testGetStrategy(){

		assertNotNull(fireTower.getStrategy());
		assertNotNull(iceTower.getStrategy());
		assertNotNull(laserTower.getStrategy());
		assertNotNull(spreadTower.getStrategy());
	
	}

	/**
	 * Test for getting tower upgrade cost
	 */
	@Test
	public void testGetUpPrice(){

		assertEquals(fireTower.getUpPrice(), 400);
		assertEquals(iceTower.getUpPrice(), 350);
		assertEquals(laserTower.getUpPrice(), 600);
		assertEquals(spreadTower.getUpPrice(), 2000);
	
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
		assertEquals(fireTower.getColor(),black);	
		
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
		
		fireTower.setStrategy(towerFarthestStrategy);
		assertEquals(fireTower.getStrategy(), towerFarthestStrategy);
		
	}

	/**
	 * Test for upgrading tower method
	 */
	@Test
	public void testUpgradeTower(){
		
		fireTower.upgradeTower();
		assertEquals(fireTower.getLevel(), 2);
		
	}

	/**
	 * Test for getting tower purchasing price
	 */
	@Test
	public void testGetBuyPrice(){
		 
		assertEquals(fireTower.getBuyPrice(), 200);
		assertEquals(iceTower.getBuyPrice(), 150);
		assertEquals(laserTower.getBuyPrice(), 200);
		assertEquals(spreadTower.getBuyPrice(), 900);
	}

	/**
	 * Test for getting default tower shoot strategy
	 */
	@Test
	public void testGetDefaultStrategy(){
		
		assertEquals(fireTower.getDefaultStrategy(),"Closest");
		assertEquals(iceTower.getDefaultStrategy(), "Closest");
		assertEquals(laserTower.getDefaultStrategy(), "Closest");
		assertEquals(spreadTower.getDefaultStrategy(), "Closest");
		
	}

	/**
	 * Test for getting tower max level
	 */
	@Test
	public void testGetMaxTowerLevel(){
		
		assertEquals(fireTower.getMaxTowerLevel(),4);
		assertEquals(iceTower.getMaxTowerLevel(),4);
		assertEquals(laserTower.getMaxTowerLevel(),4);
		assertEquals(spreadTower.getMaxTowerLevel(),4);
		
	}
	
}
