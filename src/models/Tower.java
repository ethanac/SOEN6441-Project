package models;

import helpers.*;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;



/**
 * The Tower Class.
 * It defines the basic attributes and draws the tower.
 * Fire, icebeam and laser tower extends this class.
 * Set the basic info for Towers
 * 
 * @author HaoZhang
 * @author Meng Yao
 * 
 * @version 1.0.0
 * 
 */
public abstract class Tower implements DrawableEntity{
	//final variables
	final static int MAXTOWERLEVEL = 4;
	
	
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
	
	private boolean enabled;
	private boolean selected;
	
    /**
     * This is the constructor.
     * 
     * @param n A string as the name of the tower.
     * @param p A Point object as the coordinate of the tower.
     * 
     */
    public Tower(String n, Point p){
		position = p;
		name = n;
		level = 1;
		
		enabled = true;
		selected = false;
	}
    
  //upgrade the towers values and level

    /**
     * The method to upgrade the tower.
     * The characteristics is changed. 
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
     * Updates and draws the Tower.
     *  
     * @param g  The graphics object to draw.
     */
    public void updateAndDraw(Graphics g){	
		
		this.drawTower(g);
	}
	
    /**
     * The method to draw a tower.
     * 
     * @param g A Graphics object to draw.
     */
    public void drawTower(Graphics g) {
		//Draws the tower with the Artist
		Artist_Swing.drawTower(this,g);
    }
    
    /**
     * The method to get the sellPrice.
     * 
     * @return The price of a tower to be sold.
     */
    public int getSellPrice(){	
		return sellPrice;
	}
    
    /**
     * The method to get the damage of a tower.
     * 
     * @return damage  The attack damage of a tower.
     */
    public double getDamage(){	
		return damage;
	}
    
    /**
     * The method to get the cost to update a tower.
     * 
     * @return The cost to update a tower.
     */
    public int getUpPrice(){
		return upCost;
	}

    /**
     * The method to get the x axis value of the position of a tower.
     * 
     * @return position.getX() The x value.
     */
    public int getPosX(){	
		return position.getX();
	}
	
    /**
     * The method to get the y axis value of the position of a tower.
     * 
     * @return position.getY() The y value.
     */
    public int getPosY(){	
		return position.getY();
	}
	
    /**
     * The method to get the attack range of a tower.
     * 
     * @return range The range of a tower.
     */
    public int getRange(){	
		return range;
	}
	
    /**
     * The method to get the name of a tower.
     * 
     * @return name The name of the tower.
     */
    public String getName(){	
		return name;
	}
	
    /**
     * The method to get the state of a tower.
     * 
     * @return enabled The state of a tower.
     */
    public boolean getEnabled(){	
		return enabled;
	}

    /**
     * The method to set the state of a tower.
     * 
     * @param state A boolean value as the state of a tower.
     */
    public void setEnabled(boolean state){
		enabled = state;
	}

    /**
     * The method to get the Color of a tower.
     * 
     * @return tColor The color of a tower.
     */
    public Color getColor(){
		return tColor;
	}

    /**
     * The method to get the selected state of a tower.
     * 
     * @return selected The state of a tower whether be selected or not.
     */
    public boolean isSelected(){
		return selected;
	}


    /**
     * The method to set the selected state of a tower.
     * 
     * @param s A boolean value as the selected state of a tower.
     */
    public void setSelected(boolean s){
		selected = s;
	}


    /**
     * The method to set the color of a tower.
     * 
     * @param newColor A Color value as the color of a tower.
     */
    public void setColor(Color newColor){
		
		tColor = newColor;
	}

    /**
     * The method to get the shot color of a tower.
     * 
     * @return shotColor The color of a tower's bullet.
     */
    public Color getShotColor(){
		return shotColor;
	}

    /**
     * The method to get the max level of a tower.
     * 
     * @return MAXTOWERLEVEL The maximum level of a tower.
     */
    public static int getMaxTowerLevel(){
		return MAXTOWERLEVEL;
	}


    /**
     * The method to get the level of a tower.
     * 
     * @return level The level of a tower.
     */
    public int getLevel(){
		return level;
	}
	
    /**
     * The method to convert the characteristics of a tower to a string.
     * Its format of output is 
     * $towerName$ Tower, Level: $level$ /$MAXTOWERLEVEL$
     * Attack range: $attackRange$, Damage: $Damage$.
     * 
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
	

}
