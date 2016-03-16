package models;

import helpers.*;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import strategies.*;

/**
 * The Tower Class.
 * It defines the basic attributes and draws the tower.
 * Fire, icebeam and laser tower extends this class.
 * Set the basic info for Towers
 * 
 * @author Hao Zhang
 * @author Meng Yao
 * @author Xingjian Zhang
 * 
 * @version 2.0.0
 * 
 */
public abstract class Tower implements DrawableEntity{
	//final variables
	final static int MAXTOWERLEVEL = 4;
	final static String DEFAULTSTRATEGY = "Closest";
	
	//Tower properties
	Point position;
	double damage;
	int rateOfFire;
	int range;
	int sellPrice;	
	int upCost;
	String name;
	int level;
	Color tColor;
	Color shotColor;
	private IStrategy strategy; 
	ArrayList<Critter> potentialCrittersInRange;
	private boolean enabled;
	private boolean selected;
	
    /**
     * Constructor of Tower with its basic info
     * 
     * @param n name of tower
     * @param p coordinates of tower
     * @param crittersOnMap
     */
    public Tower(String n, Point p, ArrayList<Critter> crittersOnMap){
		position = p;
		name = n;
		level = 1;
		this.potentialCrittersInRange = crittersOnMap;
		strategy = new Closest();
		enabled = true;
		selected = false;
	}
	
    /**
     * Getter of tower selling refund
     * 
     * @return sellPrice tower refund
     */
    public int getSellPrice(){	
		return sellPrice;
	}

    /**
     * Getter of upgrade price
     * 
     * @return upCost
     */
    public int getUpPrice(){
		return upCost;
	}

    /**
     * Setter of shotting strategy
     * 
     * @param strategy
     */
    public void setStrategy(IStrategy strategy) {
		this.strategy = strategy;
	}
	
    /**
     * Getter of tower position in x axis
     *
     * @return position.getX()
     */
    public int getPosX(){	
		return position.getX();
	}
	
    /**
     * Getter of tower position in y axis
     * 
     * @return position.getY()
     */
    public int getPosY(){	
		return position.getY();
	}
	
    /**
     * Getter of tower range
     *
     * @return range
     */
    public int getRange(){	
		return range;
	}
	
    /**
     * Getter of tower name
     *
     * @return name
     */
    public String getName(){	
		return name;
	}
	
    /**
     * Tower state getter, return the enabling state of tower
     *
     * @return
     */
    public boolean getEnabled(){	
		return enabled;
	}

    /**
     * Setter of tower state
     *
     * @param state
     */
    public void setEnabled(boolean state){
		enabled = state;
	}

    /**
     * Getter of tower color
     *
     * @return tColor
     */
    public Color getColor(){
		return tColor;
	}

    /**
     * Method to judge whether the tower is selected
     *
     * @return selected
     */
    public boolean isSelected(){
		return selected;
	}

    /**
     * Getter of tower shooting strategy
     *
     * @return this.strategy
     */
    public IStrategy getStrategy(){
		return this.strategy;
	}

    /**
     * Method to set the tower state to being seleted
     *
     * @param s
     */
    public void setSelected(boolean s){
		selected = s;
	}

    /**
     * Method to acquire the default strategy
     *
     * @return DEFAULTSTRATEGY
     */
    public static String getDefaultStrategy(){
		return DEFAULTSTRATEGY;
	}

    /**
     * Setter of the tower color
     * 
     * @param newColor
     */
    public void setColor(Color newColor){
		
		tColor = newColor;
	}

    /**
     * Getter of tower shooting color
     *
     * @return shotColor
     */
    public Color getShotColor(){
		return shotColor;
	}

    /**
     * Getter of max tower level
     *
     * @return MAXTOWERLEVEL
     */
    public static int getMaxTowerLevel(){
		return MAXTOWERLEVEL;
	}

    /**
     * Setter of critters' position that inside the tower range
     *
     * @param crittersOnMap
     */
    public void setCrittersOnMap(ArrayList<Critter> crittersOnMap){
		this.potentialCrittersInRange = crittersOnMap;
	}

    /**
     * Getter of tower current level
     *
     * @return level
     */
    public int getLevel(){
		return level;
	}
	
    /**
     * Updates and draws the Tower (and the shot to critter if any)
     * @param g
     */
    public void updateAndDraw(Graphics g){	
    	//get in range critters
		ArrayList<Critter> inRangeC = new ArrayList<Critter>();
		//get in range
		inRangeC = this.findCrittersInRange(potentialCrittersInRange);
		//select target
		Critter targetedCritter = this.selectTarget(this, inRangeC);
		if(targetedCritter != null){
			if(enabled){
				//shoot target
				this.shootTarget(targetedCritter, g);
			}
		}
		//draw the tower
		this.drawTower(g);
	}
	
    /**
     * Method to draw the tower
     *
     * @param g
     */
    public void drawTower(Graphics g) {
		//Draws the tower with the Artist
		Artist_Swing.drawTower(this,g);
    }
	
    /**
     * Method to make the critter select a target according to its strategy
     *
     * @param tf1
     * @param crittersInR
     * @return target
     */
    protected Critter selectTarget(Tower tf1, ArrayList<Critter> crittersInR){
    	//selects the tower based on strategy
		Critter target = strategy.findTarget(tf1, crittersInR);
		return target;
	}

    /**
     * Method to calculate the distance between a creep and a tower
     * 
     * @param a
     * @return critterDistance
     */
    public double distanceToCritter(Critter a){
    	//get delta x and deltay
	    double deltaX = a.getPixelPosition().getX()-this.getPosX();
	    double deltaY = a.getPixelPosition().getY()-this.getPosY();
		//finds the distance between a creep and a tower.
		double critterDistance = Math.sqrt((deltaX)*(deltaX) + (deltaY)*(deltaY));
		
		return critterDistance;
	}
    
	//checking if a critter is in range of a tower
    
    /**
     * Method to check the whether a critter is in a tower range 
     * 
     * @param a
     * @return true if the critter is inside a tower range
     * @return false if the critter is outside any tower range
     */
	private boolean inRange(Critter a){
		boolean result = true;
		//finds the distance between a creep and a tower.
		int critterDistance = (int) distanceToCritter(a);
		
		if(a.getSize()+this.getRange()<critterDistance){
			result = false;
		}
		
		return result;
	}
	
	//returns the critters that are in range of a tower

    /**
     * Method to find all critter list that in a tower range
     *
     * @param a
     * @return crittersInRange
     */
    	public ArrayList<Critter> findCrittersInRange(ArrayList<Critter> a){
		//initialize arrayList
		ArrayList<Critter> crittersInRange = new ArrayList<Critter>();
		if(a != null){
			//go through and get any that are in range
			for(int i = 0; i<a.size();i++){
				if(a.get(i).isActive()){
					if(inRange(a.get(i))){
						crittersInRange.add(a.get(i));
					}
				}
			}
		}
		return crittersInRange;
		
	}
	
	//deals damage based on amount of damage of the tower

    /**
     * Tower shots and deals damage to critters
     *
     * @param target
     * @param g
     */
    protected void shootTarget(Critter target, Graphics g){
		for(int i = 0; i < this.rateOfFire * GameClock.getInstance().deltaTime(); i++){
			target.damage(damage);
			Artist_Swing.drawShot(this, target, g);
		}
	} 
    
	//upgrade the towers values and level

    /**
     * Method to upgrade the tower level and tower attributes
     */
    public void upgradeTower(){
    	//upgrades the tower based on properties
		if(level < MAXTOWERLEVEL){
			level = level + 1;
			upCost = upCost*3;
			damage = damage*2; 
			rateOfFire = rateOfFire + level;
			sellPrice = sellPrice*2;
			range = (int)(1.5*range);
		}
	}

    /**
     * Method to transfer tower attributes to string
     * 
     * @return result
     */
    public String toString(){
		String result = "";
		String level = "";
		String name = "";
		String range = "";
		String damage = "";
		name = this.getName() + " Tower, ";
		level = "Level: " + this.getLevel() + "/" + MAXTOWERLEVEL + "\n";
		range = "Attack range: " + this.getRange() + ", ";
		damage = "Damage: " + this.getDamage();
		
		result = name + level + range + damage;
		
		return result;
	}

    /**
     * Getter of tower current damage
     * 
     * @return
     */
    public double getDamage(){	
		return damage;
	}
	

}