package test.view;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import views.GameControlPanel;

/**
 *  The test for GameControlPanel class in the view package.
 * 
 *	@author HaoZhang
 *	@version 1.0.0
 */
public class ViewTestGameControlPanel {
	private ArrayList<GameControlPanel> Agcp = new ArrayList<>();

	/**
	 *  Initializing an ArrayList of TDMap.
	 */
	@Before
	public void setUp() {
		for (int i=0; i<100; i++){
			Agcp.add(new GameControlPanel());
		}
	}

	/**
	 *  test getSellButton.
	 */
	@Test
	public void testgetSellButton() {
		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getSellButton());
		}
	}

	/**
	 * test GetUpgradeButton.
	 */
	@Test
	public void testGetUpgradeButton() {
		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getUpgradeButton());
		}
	}

	/**
	 * test GetInfoLabel.
	 */
	@Test
	public void testGetInfoLabel() {
		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getInfoLabel());
		}
	}

	/**
	 * test SetTowerInfoLabelText
	 */
	@Test
	public void testSetTowerInfoLabelText() {
		for(int i=0; i<100; i++){
			Agcp.get(i).setTowerInfoLabelText("I am the TowerInfo.");
		}
	}
	
	/**
	 * test SetInfoLabelText
	 */
	@Test
	public void testSetInfoLabelText() {
		for(int i=0; i<100; i++){
			Agcp.get(i).setInfoLabelText("I am the Info.");
		}
		for(int i=0; i<100; i++){
			assertEquals(Agcp.get(i).getInfoLabel().getText(), "I am the Info.");
		}
	}
	
	/**
	 * test GetPauseButton
	 */
	@Test
	public void testGetPauseButton(){
		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getPauseButton());
		}
	}

	/**
	 * test GetReturnButton
	 */
    @Test
    public void testGetReturnButton(){
    	for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getReturnButton());
		}
	}

    @Test
    public void testGetStartWaveButton(){
    		for(int i=0; i<100; i++){
			assertNull(Agcp.get(i).getStartWaveButton());
		}
	}

    /**
     * test GetSpreadButton.
     */
    @Test
    public void testGetSpreadButton(){
    		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getSpreadButton());
		}
	}

    /** 
     * test GetFireButton.
     */
    @Test
    public void testGetFireButton(){
    		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getFireButton());
		}
	}

    /** 
     * test GetIceButton.
     */
    @Test
    public void testGetIceButton(){
    		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getIceButton());
		}
	}

    /**
     * test GetLaserButton.
     */
    @Test
    public void testGetLaserButton(){
    		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getLaserButton());
		}
	}

    /**
     * test GetNoneButton.
     */
    @Test
    public void testGetNoneButton(){
    		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getNoneButton());
		}
	}
}
