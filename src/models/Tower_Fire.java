package models;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * This class defines the fire tower. 
 * It extends the Tower class.
 * 
 * @author HaoZhang
 * @version v1.0.0
 */
public class Tower_Fire extends Tower{
	
	//properties for the fire tower
	static int buyCost = 200;
	
	/**
    * This is the constructor.
    * 
    * @param n A string as the name of the tower.
    * @param p A Point object as the position of the tower.
    * 
    */
	public Tower_Fire(String n, Point p) {
		
		super(n, p);

		//these variables are all explicitly written as all laser towers will have the same starting stats
				damage = 0.25;
				rateOfFire = 10;
				range = 100;
				sellPrice = 100;
				upCost = 400;
				tColor = Color.red;
				shotColor = Color.red;
				buyCost = 200;
				
	}

	/**
    * The method to get the price of a tower you want to buy.
    * 
    * @return The cost to buy a fire tower.
    */
   public static int getBuyPrice(){	
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
