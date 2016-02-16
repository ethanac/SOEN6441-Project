package models;

import java.awt.Color;
import java.awt.Graphics;

public class Tower_SpreadShot extends Tower{

	private int amountOfTargets = 3;
	static int buyCost = 900;
	
	public Tower_SpreadShot(String n, Point p) {
		super(n, p);
		
		//these variables are all explicitly written as all laser towers will have the same starting stats
				damage = 0.8;
				rateOfFire = 10;
				range = 200;
				sellPrice = 400;
				upCost = 2000;
				tColor = Color.YELLOW;
				shotColor = Color.YELLOW;
				buyCost = 900;
	}

	public static int getBuyPrice(){	
		return buyCost;
	}

	@Override
	public void updateAndDraw(Graphics g) {
		this.drawTower(g);
		
	}

}
