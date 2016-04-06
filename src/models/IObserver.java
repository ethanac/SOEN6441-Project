package models;

/**
 * This class is designed for future functions like critters' move and towers' attack.
 * 
 * @author Zhoujian Lan 
 * @version 3.0.0
 * 
 */
public interface IObserver {

    /**
     * update the observer by getting the state from model.
     */
    public void observerUpdate();
}