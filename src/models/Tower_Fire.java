package models;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Tower_Fire extends Tower{
	
	//properties for the fire tower
	static int buyCost = 200;
	
	/**
    *
    * @param n
    * @param p
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
    *
    * @return
    */
   public static int getBuyPrice(){	
		return buyCost;
	}
   
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
