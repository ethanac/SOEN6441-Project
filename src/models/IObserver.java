package models;

/**
 * This class is designed for future functions like critters' move and towers' attack.
 * 
 * 
 */
public interface IObserver {

    /**
     * update the observer by getting the state from model.
     */
    public void observerUpdate();
}