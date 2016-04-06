package models;

import java.awt.Color;


/**
 * The white critter.
 * White critter is fast but weak compared to other critters
 * 
 * @author Zhoujian Lan
 * @version 3.0.0
 */

public class Critter_White extends Critter{

    /**
     * The white critter.
     * @param level  The initial level.
     * @param m  The map of the game.
     */
    public Critter_White(int level, TDMap m) {
		super(level, m);
		double levelMultiplier = calculateLevelMultiplier();
		//average reward
		reward = (int) (7*levelMultiplier);
		//low hitpoints
		currHitPoints = (140*levelMultiplier);
		maxHitPoints = currHitPoints;
		//does not regenerate health
		regen = 0;
		//fast
		speed = Math.min(10*levelMultiplier, MAXSPEED);
		//does not resist effects
		resistance = 0;
		//set name
		name = "Arrow Critter";
		cColor = Color.WHITE;
	}
}
