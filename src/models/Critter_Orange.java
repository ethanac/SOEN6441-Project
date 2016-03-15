package models;

import java.awt.Color;


/**
 * The orange critter.
 * Critter X is completely resistant to effects from towers. Average apart from that.
 */

public class Critter_Orange extends Critter {

    /**
     * The constructor of orange critter.
     * @param level  The initial level.
     * @param m  The map of the game.
     */
    public Critter_Orange(int level, TDMap m) {
		super(level, m);
		double levelMultiplier = calculateLevelMultiplier();
		//high reward
		reward = (int) (12*levelMultiplier);
		//med hitpoints
		currHitPoints = (175*levelMultiplier);
		maxHitPoints = currHitPoints;
		//low regen
		regen = 1*levelMultiplier;
		//low speed
		speed = Math.min(4*levelMultiplier, MAXSPEED);
		//pure resistancfe
		resistance = 1;
		//set name
		name = "X Critter";
		cColor = Color.ORANGE;
	}
}
