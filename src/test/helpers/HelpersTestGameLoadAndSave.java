package test.helpers;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import helpers.GameLoadHelper;
import helpers.GameSaveHelper;
import models.TDMap;
import models.Tower;

/**
 * Test for saving and loading games
 * 
 * @author Xingjian Zhang
 */
public class HelpersTestGameLoadAndSave {

	GameSaveHelper testGSH;
	GameLoadHelper testGLH;
	TDMap testMap;
	String filePath, testPlayer, testMapname;
	int testWaveNum, testLives, testMoney, testCredit;
	ArrayList<Tower> testTArray, towers;
	
	/**
	 *  Initialize the game to be tested
	 */
	@Before
	public void setUp(){
		
		filePath = "src/res/testSLPath";
		testPlayer = "Player1";
		testWaveNum = 1;
		testLives = 8;
		testMoney = 1300;
		testCredit = 2000;
		testMapname = "testSLMap";
		testTArray = new ArrayList<Tower>();
		testMap = new  TDMap();
		testMap.mapName = "testSLMap";
		towers = new ArrayList<Tower>();
		testGSH = new GameSaveHelper(filePath, testPlayer, testWaveNum, testLives, testMoney, 
				testCredit, testMapname, testTArray);
		testGLH = new GameLoadHelper(filePath, testMap);
	}
	
	/**
	 *  Tear save helper down after tests
	 */
	@After
	public void tearDown(){
		
		testGSH = null;
		
	}
	
	/**
	 *  Test for defining save game helper
	 */
	@Test
	public void testSaveGameHelper(){
		
		assertNotNull(testGSH);
		
	}
	
	/**
	 *  Test for saveGame method
	 */
	@Test
	public void testSaveGame() throws IOException{
		
		testGSH.saveGame();
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		int cache = Integer.parseInt(br.readLine());
		assertEquals (testWaveNum,cache);
		cache = Integer.parseInt(br.readLine());
		assertEquals (testMoney, cache);
		cache = Integer.parseInt(br.readLine());
		assertEquals (testLives, cache);
		cache = Integer.parseInt(br.readLine());
		assertEquals (testCredit, cache);
		assertEquals (testMapname, br.readLine());
			
	}
	
	/**
	 *  Test for loadGame method
	 */
	@Test
	public void testLoadGame(){
		
		testGSH.saveGame();
		testGLH.loadGame();
		assertEquals(testWaveNum, testGLH.getWaveNumber());
		assertEquals(testMoney, testGLH.getMoney());
		assertEquals(testLives, testGLH.getLives());
		assertEquals(testCredit, testGLH.getCredit());
		assertEquals(testMapname, testGLH.getMapName());
		
	}
}
