package models;

import java.awt.Color;
import java.awt.Graphics;

public class Tower_IceBeam extends Tower{
	
	static int buyCost = 150;
	
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

	public static int getBuyPrice() {
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
