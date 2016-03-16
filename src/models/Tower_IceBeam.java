package models;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * This class defines the IceBeam tower. 
 * It extends the Tower class.
 * 
 * @author HaoZhang
 * @version 2.0.0
 */
public class Tower_IceBeam extends Tower {
	//properties for the ice beam tower
	static int buyCost = 150;
	double slowFactor;
	int slowTime;
    /**
     * Constructor of IceBeam tower defines attributes of this tower type
     *
     * @param n
     * @param p
     * @param crittersOnMap
     */
    public Tower_IceBeam(String n, Point p, ArrayList<Critter> crittersOnMap) {
		super(n, p, crittersOnMap);
		//these variables are all explicitly written as all laser towers will have the same starting stats
		damage = 0.25;
		rateOfFire = 3;
		range = 100;
		sellPrice = 75;
		upCost = 350;
		slowFactor = 0.5;
		tColor = Color.WHITE;
		shotColor = Color.WHITE;
		buyCost = 150;
		slowTime = 50;
	}
	
	/**
	 * Shoots the critter and slowing down the move speed of critters
	 * 
	 * @see models.Tower#shootTarget(models.Critter, java.awt.Graphics)
	 * 
	 */
    protected void shootTarget(Critter target, Graphics g){
		super.shootTarget(target, g);
		target.slowCritter(this.slowFactor, this.slowTime);
	}
	
    /**
     * Getter of IceBeam tower tower purchasing price
     *
     * @return buyCost
     */
    public static int getBuyPrice(){	
		return buyCost;
	}
    /**
     * This upgrades the tower and the slow down capability
     * 
     * @see models.Tower#upgradeTower()
     */
    public void upgradeTower(){
    	if(level < MAXTOWERLEVEL){
	    	super.upgradeTower();
			this.slowTime = (this.slowTime + 20);
			this.slowFactor = this.slowFactor + 0.1;
    	}
    }

}
