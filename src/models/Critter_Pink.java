package models;

import java.awt.Color;


/**
 * The pink critter.
 * Pink critter is Strong but slow
 * 
 * @author Zhoujian Lan
 * @version 3.0.0
 */

public class Critter_Pink extends Critter{

    /**
     * The constructor of pink critter.
     * @param level  The initial level.
     * @param m  The map of the game.
     */
    public Critter_Pink(int level, TDMap m) {
		super(level, m);
		double levelMultiplier = calculateLevelMultiplier();
		//average reward
		reward = (int) (10*levelMultiplier);
		//high hitpoints
		currHitPoints = (300*levelMultiplier);
		maxHitPoints = currHitPoints;
		//medium regen
		regen = 2*levelMultiplier;
		//low speed
		speed = Math.min(2*levelMultiplier, MAXSPEED);
		//med resistance
		resistance = 0.3*levelMultiplier;
		//set name
		name = "Shuriken Critter";
		cColor = Color.PINK;
	}
}
