package models;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class defines the Laser tower. 
 * It extends the Tower class.
 * 
 * @author HaoZhang
 * @version v1.0.0
 */
public class Tower_Laser extends Tower{
	
	static int buyCost = 200;
	
	public Tower_Laser(String n, Point p) {
		super(n, p);
		
		//these variables are all explicitly written as all laser towers will have the same starting stats
				damage = 0.5;
				rateOfFire = 10;
				range = 250;
				sellPrice = 80;
				upCost = 600;
				tColor = Color.black;
				shotColor = Color.black;
				buyCost = 200;
	}

	/**
	 * The method to get the price of a tower you want to buy.
	 * 
	 * @return The cost to buy a Laser tower.
	 */
   public static int getBuyPrice(){	
		return buyCost;
	}

	@Override
	public void updateAndDraw(Graphics g) {
		this.drawTower(g);
		
	}

}
