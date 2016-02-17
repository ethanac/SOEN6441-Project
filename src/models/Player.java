package models;

/** Create the player including the value of life, money etc.
 *  Applying singleton pattern to ensure there is only one player at any time.
 * 
 * 
 */
public class Player {
	//Final constants (changed for balancing game)
	private static final int STARTINGLIVES = 10;
	private static final int STARTINGMONEY = 5000;
	//default the lives and money to the constants above
	private int lives = STARTINGLIVES;
	private int money = STARTINGMONEY;
	//and we apply singleton pattern to ensure only one player
	private static Player playerInstance = new Player();
	
	//private constructor (singleton)
	private Player(){
		
	}
	
    /**
     *
     * @return playerInstance
     */
    public static Player getInstance(){
		return playerInstance;
	}

    /**
     *
     * @return lives
     */
    public int getLives(){
		return this.lives;
	}

    /**
     *
     * @return money
     */
    public int getMoney(){
		return this.money;
	}

    /**
     *
     * @param l
     */
    public void setLives(int l){
		lives = l;
	}

    /**
     *
     * @param m
     */
    public void setMoney(int m){
		money = m;
	}

    /**
     *
     * @param moneyToAdd
     */
    public void addToMoney(int moneyToAdd){
		this.money += moneyToAdd;
	}

    /**
     *
     */
    public void takeAwayALife(){
		this.lives -=1; 
	}

    /** Get the value of life at the beginning
     *
     * @return STARTINGLIVES
     */
    public static int getStartingLives(){
		return STARTINGLIVES;
	}

    /** Get the value of money at the beginning
     *
     * @return STARTINGMONEY
     */
    public static int getStartingMoney(){
		return STARTINGMONEY;
	}

    /** Reset the start value of life and money
     *
     */
    public void resetStats(){
    	//reset the stats of the player
		lives = STARTINGLIVES;
		money = STARTINGMONEY;
	}
}
