package models;

/** 
 *  Create one player including the value of life, money etc.
 *  Applying singleton pattern to ensure there is only one player at any time.
 *  
 *  @author HaoZhang
 *  @version v1.0.0
 */
public class Player {
	//Final constants (changed for balancing game)
	private static final int STARTINGLIVES = 10;
	private static final int STARTINGMONEY = 5000;
	private static final int STARTINGCREDIT = 0;
	//default the lives and money to the constants above
	private int lives = STARTINGLIVES;
	private int money = STARTINGMONEY;
	private int credit = STARTINGCREDIT;
	private String userName = "";
	//and we apply singleton pattern to ensure only one player
	private static Player playerInstance = new Player();
	
	/**
	 * The private constructor (singleton)
	 */
	private Player(){
		
	}
	
    /**
     * The method to get the player instance created.
     * 
     * @return playerInstance
     */
    public static Player getInstance(){
		return playerInstance;
	}
    
    /**
     * Get the user name.
     * @return userName
     */
    public String getName(){
    	return userName;
    }
    
    /**
     * The method to get the life value of this player.
     * 
     * @return lives
     */
    public int getLives(){
		return this.lives;
	}

    /**
     * The method to get the money value of this player.
     * 
     * @return money
     */
    public int getMoney(){
		return this.money;
	}
    
    /**
     * The method to get the point value of this player.
     * 
     * @return point
     */
    public int getCredit(){
		return this.credit;
	}

    /**
     * The method to set the life value of this player.
     * 
     * @param l  An integer as the life value of this player.
     */
    public void setLives(int l){
		lives = l;
	}

    /**
     * The method to set the money value of this player.
     * 
     * @param m  An integer as the money value of this player.
     */
    public void setMoney(int m){
		money = m;
	}
    
    /**
     * The method to set the point value of this player.
     * 
     * @param m  An integer as the point value of this player.
     */
    public void setCredit(int c){
		credit = c;
	}
    
    /**
     * Set the user name.
     * @param name
     */
    public void setUserName(String name){
    	userName = name;
    }

    /**
     * The method to add some money to the money of this player
     * 
     * @param moneyToAdd An integer as the amount of money to add.
     */
    public void addToMoney(int moneyToAdd){
		this.money += moneyToAdd;
	}
    
    /**
     * The method to add point to the point of this player
     * 
     * @param PointToAdd An integer as the amount of money to add.
     */
    public void addToCredit(int creditToAdd){
		this.credit += creditToAdd;
	}

    /**
     * The method to decrease the life value of this player.
     * It subtracts 1 from the life value.
     * 
     */
    public void takeAwayALife(){
		this.lives -=1; 
	}

    /** 
     * Get the start value of life of this player.
     *
     * @return STARTINGLIVES
     */
    public static int getStartingLives(){
		return STARTINGLIVES;
	}

    /** 
     * Get the start value of money of this player.
     *
     * @return STARTINGMONEY
     */
    public static int getStartingMoney(){
		return STARTINGMONEY;
	}
    
    /** 
     * Get the start value of Point of this player.
     *
     * @return STARTINGMONEY
     */
    public static int getStartingCredit(){
		return STARTINGCREDIT;
	}

    /** 
     * Reset the value of life and money to start value.
     * The value of life is set to STARTINGLIVES.
     * The value of money is set to STARTINGMONEY.
     */
    public void resetStats(){
    	//reset the stats of the player
		lives = STARTINGLIVES;
		money = STARTINGMONEY;
		credit = STARTINGCREDIT;
	}
}
