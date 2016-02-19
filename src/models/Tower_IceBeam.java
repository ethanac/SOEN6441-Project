package models;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class defines the IceBeam tower. 
 * It extends the Tower class.
 * 
 * @author HaoZhang
 * @version v1.0.0
 */
public class Tower_IceBeam extends Tower{
	
	static int buyCost = 150;
	
	/**
	 * This is the constructor.
	 * 
	 * @param n A string as the name of the tower.
	 * @param p A Point object as the position of the tower.
	 * 
	 */
	public Tower_IceBeam(String n, Point p) {
		super(n, p);
		
		//these variables are all explicitly written as all laser towers will have the same starting stats
				damage = 0.25;
				rateOfFire = 10;
				range = 100;
				sellPrice = 75;
				upCost = 350;
				tColor = Color.WHITE;
				shotColor = Color.WHITE;
				buyCost = 150;
				
	}
	
	/**
	 * The method to get the price of a tower you want to buy.
	 * 
	 * @return The cost to buy a IceBeam tower.
	 */
	public static int getBuyPrice() {
		return buyCost;
	}
	
	/**
	 * Upgrade the tower if its current level is under the maximum level.
	 */
	public void upgradeTower(){
    	if(level < MAXTOWERLEVEL){
	    	super.upgradeTower();
    	}
    }
	
	@Override
	public void updateAndDraw(Graphics g) {
		this.drawTower(g);
		
	}

}
