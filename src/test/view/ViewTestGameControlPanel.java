package test.view;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import models.Tower_Fire;
import models.Tower_IceBeam;
import models.Tower_Laser;
import models.Tower_SpreadShot;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import views.GameControlPanel;

/**
 *  The test for GameControlPanel class in the view package.
 * 
 *	@author HaoZhang
 *	@version 3.0.0
 */
public class ViewTestGameControlPanel {
	private ArrayList<GameControlPanel> Agcp = new ArrayList<>();
	private String[] info = {"I am the Tower Info 1.",
			"I am the Tower Info 2",
			"I am the Tower Info 3",
			"I am the Tower Info 4",
			"I am the Tower Info 5"
			};

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
	 * test Constructor.
	 */
	@Test
	public void testConstructor() {
		for (int i=0; i<100; i++) {
			for(int j=0; j<4; j++){
				//Agcp.get(i).cbStrategy.get(j);
			}
		}
	}
	
	/**
	 *  test getSellButton.
	 */
	@Test
	public void testgetSellButton() {
		JButton bSellTower = new JButton("Sell");
		for(int i=0; i<100; i++){
			JButton b = (Agcp.get(i).getSellButton());
			assertEquals(b.getText(), bSellTower.getText());
		}
	}

	/**
	 * test GetUpgradeButton.
	 */
	@Test
	public void testGetUpgradeButton() {
		JButton bUpgradeTower = new JButton("Upgrade");
		for(int i=0; i<100; i++){
			JButton b = (Agcp.get(i).getUpgradeButton());
			assertEquals(b.getText(), bUpgradeTower.getText());
		}
	}
	
	/**
	 * test GetControlPanelHeight.
	 * This method is static.
	 */
	@Test
	public void testGetControlPanelHeight(){
		int CONTROLPANELHEIGHT = 150;
		for(int i=0; i<100; i++){
			assertEquals(CONTROLPANELHEIGHT, GameControlPanel.getControlPanelHeight());
		}
	}

	/**
	 * test GetInfoLabel.
	 */
	@Test
	public void testGetInfoLabel() {
		JLabel lblInfo = new JLabel("| Lives = " + ", Money = " + ", Wavenumber =  |");
		for(int i=0; i<100; i++){
			JLabel b = (Agcp.get(i).getInfoLabel());
			assertEquals(b.getText(), lblInfo.getText());
		}
	}

//	/**
//	 * test SetTowerInfoLabelText
//	 */
//	@Test
//	public void testSetTowerInfoLabelText() {
//		for(int i=0; i<100; i++){
//			Agcp.get(i).setTowerInfoLabelText(info[i%5]);
//			assertEquals(info[i%5], Agcp.get(i).getTowerInfo());
//		}
//	}
	
	/**
	 * test SetInfoLabelText
	 */
	@Test
	public void testSetInfoLabelText() {
		for(int i=0; i<100; i++){
			Agcp.get(i).setInfoLabelText(info[i%5]);
		}
		for(int i=0; i<100; i++){
			assertEquals(Agcp.get(i).getInfoLabel().getText(), info[i%5]);
		}
	}
	
	/**
	 * test GetPauseButton
	 */
	@Test
	public void testGetPauseButton(){
		JButton bPause = new JButton("Pause");
		for(int i=0; i<100; i++){
			JButton b = (Agcp.get(i).getPauseButton());
			assertEquals(b.getText(), bPause.getText());
		}
	}

	/**
	 * test GetReturnButton
	 */
    @Test
    public void testGetReturnButton(){
    		JButton bReturn = new JButton("Main Menu");
		for(int i=0; i<100; i++){
		JButton b = (Agcp.get(i).getReturnButton());
		assertEquals(b.getText(), bReturn.getText());
		}
	}

    @Test
    public void testGetStartWaveButton(){
    		JButton bStartWave = new JButton("Start Wave!");
    		for(int i=0; i<100; i++){
			JButton b = (Agcp.get(i).getStartWaveButton());
			assertEquals(b.getText(), bStartWave.getText());
		}
	}

    /**
     * test GetSpreadButton.
     */
    @Test
    public void testGetSpreadButton(){
    		JToggleButton bSpread = new JToggleButton("Spread (" + Tower_SpreadShot.getBuyPrice() + ")");
    		for(int i=0; i<100; i++){
    			JToggleButton b = (Agcp.get(i).getSpreadButton());
    			assertEquals(b.getText(), bSpread.getText());
		}
	}

    /** 
     * test GetFireButton.
     */
    @Test
    public void testGetFireButton(){
    		JToggleButton bFire = new JToggleButton("Fire (" + Tower_Fire.getBuyPrice() + ")");
    		for(int i=0; i<100; i++){
			JToggleButton b = (Agcp.get(i).getFireButton());
			assertEquals(b.getText(), bFire.getText());
		}
	}

    /** 
     * test GetIceButton.
     */
    @Test
    public void testGetIceButton(){
    		JToggleButton bIceBeam = new JToggleButton("Ice (" + Tower_IceBeam.getBuyPrice() + ")");
    		for(int i=0; i<100; i++){
			JToggleButton b = (Agcp.get(i).getIceButton());
			assertEquals(b.getText(), bIceBeam.getText());
		}
	}

    /**
     * test GetLaserButton.
     */
    @Test
    public void testGetLaserButton(){
    		JToggleButton bLaser = new JToggleButton("Laser (" + Tower_Laser.getBuyPrice() + ")");
    		for(int i=0; i<100; i++){
			JToggleButton b = Agcp.get(i).getLaserButton();
			assertEquals(b.getText(), bLaser.getText());
		}
	}

    /**
     * test GetNoneButton.
     */
    @Test
    public void testGetNoneButton(){
    		JToggleButton noneButton = new JToggleButton("Check");
    		for(int i=0; i<100; i++){
			JToggleButton b = Agcp.get(i).getNoneButton();
    			assertEquals(b.getText(), noneButton.getText());
		}
	}
    
    /**
     * test GetCBStrategy.
     */
    @Test
    public void testGetCBStrategy(){
    		String[] strategies = {"Closest","Farthest","Weakest","Strongest"};
    		for(int i=0; i<100; i++){
    			JComboBox<String> jcb = Agcp.get(i).getCBStrategy();
    			for(int j=0; j<4; j++)
    				assertEquals(jcb.getItemAt(j), strategies[j]);
    		}
    }
    
    /**
     * test getCritterInfoButton.
     */
    public void testGetCritterInfoButton() {
    		JButton infoButton = new JButton("Critter Info");
    		for(int i=0; i<100; i++){
			JButton b = Agcp.get(i).getCritterInfoButton();
			assertEquals(b.getText(), infoButton.getText());
		}
    }
    
//    /**
//     * test getSpeedSlider.
//     * For build 2 speedSlider is null.
//     */
//    public void testGetSpeedSlider() {
//    		for(int i=0; i<100; i++){
//			assertNull(Agcp.get(i).getSpeedSlider());
//		}
//    }
}
