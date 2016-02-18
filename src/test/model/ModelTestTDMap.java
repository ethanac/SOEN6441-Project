package test.model;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

import models.TDMap;;

/**
 * 
 * 
 *
 */
public class ModelTestTDMap {

	private String mapAddress1, mapAddress2;
	private TDMap testTDMap1, testTDMap2;
	
	@Before
	public void setUp(){
		mapAddress1 = "src/res/Try1.TDMap";
		mapAddress2 = "src/res/wrong.TDMap";
		testTDMap1 = new TDMap(mapAddress1);
		testTDMap2 = new TDMap(mapAddress2);
	}
	
	@After
	public void tearDown(){
		
		mapAddress1 = null;
		mapAddress2 = null;
		testTDMap1 = null;
		testTDMap2 = null;
	}
	
	@Test
	public void testValidMapPath(){
		
		assertTrue(testTDMap1.existedMapPath);
		
	}
	
	@Test
	public void testInvalidMapPath(){
		
		assertFalse(testTDMap2.existedMapPath);
		
	}
	
	@Test
	public void testWriteMapTofile(){
		
		assertTrue(testTDMap1.writeMaptoFile("src/res/TestMap.TDMap"));
		
	}
	
	@Test
	public void testVerifyMap_valid(){

		assertTrue(testTDMap1.verifyMap()&&testTDMap2.verifyMap());

		
	}
	
	@Test
	public void testVerifyMap_invalid(){
		
		testTDMap1.refresh();
		testTDMap1.setStart(0, 0);
		testTDMap1.setEnd(10, 10);
		assertFalse(testTDMap1.verifyMap());
	
	}
	
	@Test
	public void testGetPointsOfShortestPath(){

		assertEquals(78,testTDMap1.getPointsOfShortestPath().size());
		assertEquals(43,testTDMap2.getPointsOfShortestPath().size());
		
	}
	
}
