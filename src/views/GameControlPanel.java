package views;

import helpers.Artist_Swing;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import models.Tower_Fire;
import models.Tower_IceBeam;
import models.Tower_Laser;
import models.Tower_SpreadShot;

/**
 *	This is the control panel of playing the game.
 *  It contains two control panels, <code>towerControlPanel</code>
 *  and <code>generalControlPanel</code>
 * 	
 *  @author Xingjian Zhang
 *  @version 1.0.0
 */
public class GameControlPanel extends JPanel  {
	private final int buttonSize = 90;

    /**
     *
     */
	private static final String SPREADTEXT = "A Spread-beam tower. Shoot multiple enemies with a slightly less powerful beam.";
	private static final String LASERTEXT = "A Laser-beam tower. Normal attack.";
	private static final String ICETEXT = "An Ice-beam tower. Slow enemies who are shot by it.";
	private static final String FIRETEXT = "A Fire-beam tower. Light critters on fire and damages them over time.";
    public static final int CONTROLPANELHEIGHT = 150;
	//we have our two control panels.
	JPanel towerControlPanel = new JPanel();
	JPanel generalControlPanel = new JPanel();
	//our tower control panel will have all info pertaining to our tower
	//this includes tower buttons, upgrading, selling, etc
	JButton bSellTower = new JButton("Sell");
	JButton bUpgradeTower = new JButton("Upgrade");
	JTextArea lblTowerInfo = new JTextArea("No tower selected");
	JLabel lblBuildTowerPrompt = new JLabel("Tower:");
	ButtonGroup towerGroup = new ButtonGroup();
	JToggleButton bSpread = new JToggleButton("Spread (" + Tower_SpreadShot.getBuyPrice() + ")");
	JToggleButton bFire = new JToggleButton("Fire (" + Tower_Fire.getBuyPrice() + ")");
	JToggleButton bIceBeam = new JToggleButton("Ice (" + Tower_IceBeam.getBuyPrice() + ")");
	JToggleButton bLaser = new JToggleButton("Laser (" + Tower_Laser.getBuyPrice() + ")");
	JToggleButton bNone = new JToggleButton("Check");
	
	
	//our general control panel will have general info (lives, money)
	//this also includes main menu button, pausing, speeding up game, etc.
	JButton bStartWave = new JButton("Game Start!");
	JLabel lblInfo = new JLabel("| Lives = " + ", Money = " + ", Wavenumber =  |");
	JButton bPause = new JButton("Pause");
	JButton bReturn = new JButton("Main Menu");
	
	

    /**
     *	Constructor of GameControlPanel
     */
    public GameControlPanel(){
		//add our buttons to a group so only one can be selected at once.
		towerGroup.add(bSpread);
		towerGroup.add(bFire);
		towerGroup.add(bIceBeam);
		towerGroup.add(bLaser);
		towerGroup.add(bNone);
		
		bUpgradeTower.setPreferredSize(new Dimension(buttonSize+30,20));
		bSellTower.setPreferredSize(new Dimension(buttonSize, 20));
		bSpread.setPreferredSize(new Dimension(buttonSize+30, 20));
		bFire.setPreferredSize(new Dimension(buttonSize, 20));
		bIceBeam.setPreferredSize(new Dimension(buttonSize, 20));
		bLaser.setPreferredSize(new Dimension(buttonSize+10, 20));
		bNone.setPreferredSize(new Dimension(buttonSize-10, 20));
		bSpread.setName("Spread");
		bFire.setName("Fire");
		bIceBeam.setName("IceBeam");
		bLaser.setName("Laser");
		bNone.setName("None");
		bSpread.setToolTipText(SPREADTEXT);
		bLaser.setToolTipText(LASERTEXT);
		bIceBeam.setToolTipText(ICETEXT);
		bFire.setToolTipText(FIRETEXT);
		
		
		Font oldFont = lblInfo.getFont();
		lblInfo.setFont(new Font(oldFont.getFontName(), Font.BOLD, oldFont.getSize()));
		//format the slider
		
		towerControlPanel.add(lblTowerInfo);
		
		towerControlPanel.add(bUpgradeTower);
		towerControlPanel.add(bSellTower);
		towerControlPanel.add(lblBuildTowerPrompt);
		towerControlPanel.add(bSpread);
		towerControlPanel.add(bFire);
		towerControlPanel.add(bIceBeam);
		towerControlPanel.add(bLaser);
		towerControlPanel.add(bSpread);
		towerControlPanel.add(bNone);
        //add everything to this panel.
		
		generalControlPanel.add(bStartWave);
		generalControlPanel.add(lblInfo);
		
		generalControlPanel.add(bPause);
		generalControlPanel.add(bReturn);
        
		//add our two panels to the main panel
		this.add(towerControlPanel);
		this.add(generalControlPanel);
		this.setSize(Artist_Swing.PIXELWIDTH, CONTROLPANELHEIGHT);
		this.validate();
	}

    /**
     *	Getter of tower sell button
     *	@return bSellTower
     */
    public JButton getSellButton(){
		return this.bSellTower;
	}
	
    /**
     *	Getter of tower upgrade button
     * 	@return bUpgradeTower
     */
    public JButton getUpgradeButton(){
		return this.bUpgradeTower;
	}
    
    /**
     *	Getter of control panel height
     *  @return CONTROLPANELHEIGHT
     */
    public static int getControlPanelHeight(){
		return CONTROLPANELHEIGHT;
	}
    
    /**
     *	Getter of information label
     *  @return lblInfo
     */
    public JLabel getInfoLabel(){
		return lblInfo;
	}

    /**
     *	Setter of tower information label
     *  @param text
     */
    public void setTowerInfoLabelText(String text){
		lblTowerInfo.setText(text);
	}

    /**
     *	Setter of information label
     *  @param text
     */
    public void setInfoLabelText(String text){
		lblInfo.setText(text);
	}
	
    /**
     *	Getter of pause game button
     * 	@return bPause
     */
    public JButton getPauseButton(){
		return bPause;
	}

    /**
     *	Getter of return game button
     *  @return bReturn
     */
    public JButton getReturnButton(){
		return bReturn;
	}

    /**
     *	Getter of start wave button
     *  Interface for future build, to be continue
     *  @return null
     */
    public JButton getStartWaveButton(){
		return null;
	}

    /**
     *	Getter of spread tower button
     *  @return bSpread
     */
    public JToggleButton getSpreadButton(){
		return bSpread;
	}

    /**
     *	Getter of fire tower button
     *  @return bFire 
     */
    public JToggleButton getFireButton(){
		return bFire;
	}

    /**
     *	Getter of ice tower button
     *  @return bIceBeam
     */
    public JToggleButton getIceButton(){
		return bIceBeam;
	}

    /**
     *	Getter of laser tower button
     *  @return bLaser
     */
    public JToggleButton getLaserButton(){
		return bLaser;
	}

    /**
     *	Getter of check button
     *  @return bNone
     */
    public JToggleButton getNoneButton(){
		return bNone;
	}

}
