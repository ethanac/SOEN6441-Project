package models;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * This class defines the fire tower. 
 * It extends the Tower class.
 * 
 * @author HaoZhang
 * @version 2.0.0
 */
public class Tower_Fire extends Tower {
	//properties for the fire tower
	double DOT;
	int damageOverTimeLength = 30;
	static int buyCost = 200;
	double slowFactor;
	int slowTime;
    /**
     * Constructor of Fire Tower defines attributes of this tower type
     *
     * @param n
     * @param p
     * @param crittersOnMap
     */
    public Tower_Fire(String n, Point p, ArrayList<Critter> crittersOnMap) {
		super(n, p, crittersOnMap);
		//these variables are all explicitly written as all laser towers will have the same starting stats
		damage = 0.2;
		rateOfFire = 1;
		range = 100;
		sellPrice = 100;
		upCost = 400;
		slowFactor = 0.1;
		tColor = Color.red;
		shotColor = Color.red;
		buyCost = 200;
		slowTime = 25;
		DOT = 2;
	}
	
	/**
	 * Shoots the critter and applies damage over time
	 * 
	 * @see models.Tower#shootTarget(models.Critter, java.awt.Graphics)
	 */
    protected void shootTarget(Critter target, Graphics g){
		super.shootTarget(target, g);
		target.damageOverTimeCritter(this.DOT, this.damageOverTimeLength);
		target.slowCritter(this.slowFactor, this.slowTime);
	}
	
    /**
     * Getter of fire tower purchasing price
     * 
     * @return
     */
    public static int getBuyPrice(){	
		return buyCost;
	}
    
    /**
     * This upgrades the tower and the DOT and slow
     * 
     * @see models.Tower#upgradeTower()
     */
    public void upgradeTower(){
    	if(level < MAXTOWERLEVEL){
	    	super.upgradeTower();
			this.slowTime = (this.slowTime + 20);
			this.slowFactor = this.slowFactor + 0.1;
			this.DOT = this.DOT*2;
			this.damageOverTimeLength = (int) (this.damageOverTimeLength*1.5);
    	}
    }

}
