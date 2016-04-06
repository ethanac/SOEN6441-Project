package models;

import java.util.ArrayList;

/**
 * This class is designed for future function related to Observer.
 * 
 * @author HaoZhang
 * @version 3.0.0
 */
public abstract class Subject {
	ArrayList<IObserver> observers = new ArrayList<IObserver>();

    /**
     * The method to add an IObserver
     * 
     * @param obsToAdd 	An IObserver object as the observer to be added.
     */
    public void addObs(IObserver obsToAdd){
		observers.add(obsToAdd);
	}

    /**
     * The method to remove an IObserver.
     *
     * @param obsToRemove An IObserver object as the observer to be removed.
     * @return observers.remove(obsToRemove)
     */
    public boolean removeObs(IObserver obsToRemove){
		return observers.remove(obsToRemove);
	}

    /**
     * The method to notify the observers to update.
     * 
     */
    protected void notifyObs(){
		for(IObserver o : observers){
			o.observerUpdate();
		}
	}
}
