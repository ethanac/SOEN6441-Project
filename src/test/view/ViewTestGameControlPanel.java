package test.view;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import views.GameControlPanel;

public class ViewTestGameControlPanel {
	private ArrayList<GameControlPanel> Agcp = new ArrayList<>();

	@Before
	public void setUp() {
		for (int i=0; i<100; i++){
			Agcp.add(new GameControlPanel());
		}
	}

	@Test
	public void testgetSellButton() {
		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getSellButton());
		}
	}

	@Test
	public void testGetUpgradeButton() {
		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getUpgradeButton());
		}
	}

	@Test
	public void testGetInfoLabel() {
		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getInfoLabel());
		}
	}

	@Test
	public void testSetTowerInfoLabelText() {
		for(int i=0; i<100; i++){
			Agcp.get(i).setTowerInfoLabelText("I am the TowerInfo.");
		}
	}
	
	@Test
	public void testSetInfoLabelText() {
		for(int i=0; i<100; i++){
			Agcp.get(i).setInfoLabelText("I am the Info.");
		}
		for(int i=0; i<100; i++){
			assertEquals(Agcp.get(i).getInfoLabel().getText(), "I am the Info.");
		}
	}
	
	@Test
	public void testGetPauseButton(){
		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getPauseButton());
		}
	}

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

    @Test
    public void testGetSpreadButton(){
    		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getSpreadButton());
		}
	}

    @Test
    public void testGetFireButton(){
    		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getFireButton());
		}
	}

    @Test
    public void testGetIceButton(){
    		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getIceButton());
		}
	}

    @Test
    public void testGetLaserButton(){
    		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getLaserButton());
		}
	}

    @Test
    public void testGetNoneButton(){
    		for(int i=0; i<100; i++){
			assertNotNull(Agcp.get(i).getNoneButton());
		}
	}
}
