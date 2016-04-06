package strategies;


import java.util.ArrayList;

import models.Critter;
import models.Tower;

/**
 *
 * finds the Critter that is farthest along the path
 * @author Zhoujian Lan
 * @version 3.0.0
 */
public class Farthest implements IStrategy {

    /**
     * This method is to find farthest critter target
     * @param tower
     * @param g1
     * @return
     */
    @Override
	public Critter findTarget(Tower tower, ArrayList<Critter> g1) {
		Critter farthest_enemy= null;   
        double max_dist = 0;
       
        for (int i = 0; i < g1.size(); i++) {
            Critter enemy = g1.get(i); 			
            double dist = (g1.get(i).getIndexInPixelPath()); // The distance of this enemy along the path
            if (dist > max_dist)
            {
            max_dist = dist;
            farthest_enemy=enemy;
            }
        }
       return(farthest_enemy);
	}
    
    /**
     * @return "Farthest"
     */
	public String toString(){
		return "Farthest";
	}

}
