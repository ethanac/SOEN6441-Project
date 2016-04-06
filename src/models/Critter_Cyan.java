package models;

import java.awt.Color;


/**
 * The Cyan critter.
 * Circle critter is average, run of the mill critter
 * 
 * @author Zhoujian Lan
 * @version 3.0.0
 */

public class Critter_Cyan extends Critter{
	
    /**
     * The constructor of cyan critter.
     * @param level The initial level.
     * @param m  The map of the game.
     */
    public Critter_Cyan(int level, TDMap m) {
		super(level, m);
		double levelMultiplier = calculateLevelMultiplier();
		//average reward
		reward = (int) (10*levelMultiplier);
		//average hitpoints
		currHitPoints = (140*levelMultiplier);
		maxHitPoints = currHitPoints;
		//low regen
		regen = (0.5*levelMultiplier);
		//average speed
		speed = Math.min(4*levelMultiplier, MAXSPEED);
		//no resistance
		resistance = 0;
		//set name
		name = "Circle Critter";
		cColor = Color.CYAN;
	}
}
