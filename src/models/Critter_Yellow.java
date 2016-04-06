package models;

import java.awt.Color;


/**
 * The boss critter.
 * infinity critter is BOSS critter. Hard to kill, but high rewards.
 * 
 * @author Zhoujian Lan
 * @version 3.0.0
 */

public class Critter_Yellow extends Critter{

    /**
     * The constructor of yellow critter.
     * @param level  The initial level.
     * @param m  The map of the game.
     */
    public Critter_Yellow(int level, TDMap m) {
		super(level, m);
		double levelMultiplier = calculateLevelMultiplier();
		//high reward
		reward = (int) (20*levelMultiplier);
		//high hitpoints
		currHitPoints = (150*levelMultiplier);
		maxHitPoints = currHitPoints;
		//high regen
		regen = (2*levelMultiplier);
		//medium-high speed
		speed = Math.min(8*levelMultiplier, MAXSPEED);
		//high resistance
		resistance = 0.5*levelMultiplier;
		//set name
		name = "Infinity Critter";
		cColor = Color.YELLOW;
	}
}
