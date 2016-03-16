package models;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * This class defines the Laser tower. 
 * It extends the Tower class.
 * 
 * @author HaoZhang
 * @version 2.0.0
 */
public class Tower_Laser extends Tower{
	static int buyCost = 200;

    /**
     * Constructor of Laser Tower defines attributes of this tower type
     *
     * @param name
     * @param p
     * @param crittersOnMap
     */
    public Tower_Laser(String name, Point p, ArrayList<Critter> crittersOnMap) {
		super(name,p,crittersOnMap);
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
     * Getter of Laser tower purchasing price
     *
     * @return buyCost
     */
    public static int getBuyPrice(){	
		return buyCost;
	}

	
}
