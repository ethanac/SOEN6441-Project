package models;

import helpers.*;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;



/**
 * The Tower Class.
 * It defines the basic attributes and draws the tower.
 * Fire, icebeam and laser tower extends this class.
 * 
 * @author HaoZhang
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
	
	private boolean enabled;
	private boolean selected;
	
    /**
     *
     * @param n
     * @param p
     * @param crittersOnMap
     */
    public Tower(String n, Point p){
		position = p;
		name = n;
		level = 1;
		
		enabled = true;
		selected = false;
	}
	
    /**
     *
     * @return
     */
    public int getSellPrice(){	
		return sellPrice;
	}

    /**
     *
     * @return
     */
    public int getUpPrice(){
		return upCost;
	}

    
	
    /**
     *
     * @return
     */
    public int getPosX(){	
		return position.getX();
	}
	
    /**
     *
     * @return
     */
    public int getPosY(){	
		return position.getY();
	}
	
    /**
     *
     * @return
     */
    public int getRange(){	
		return range;
	}
	
    /**
     *
     * @return
     */
    public String getName(){	
		return name;
	}
	
    /**
     *
     * @return
     */
    public boolean getEnabled(){	
		return enabled;
	}

    /**
     *
     * @param state
     */
    public void setEnabled(boolean state){
		enabled = state;
	}

    /**
     *
     * @return
     */
    public Color getColor(){
		return tColor;
	}

    /**
     *
     * @return
     */
    public boolean isSelected(){
		return selected;
	}


    /**
     *
     * @param s
     */
    public void setSelected(boolean s){
		selected = s;
	}


    /**
     *
     * @param newColor
     */
    public void setColor(Color newColor){
		
		tColor = newColor;
	}

    /**
     *
     * @return
     */
    public Color getShotColor(){
		return shotColor;
	}

    /**
     *
     * @return
     */
    public static int getMaxTowerLevel(){
		return MAXTOWERLEVEL;
	}


    /**
     *
     * @return
     */
    public int getLevel(){
		return level;
	}
	
    /**
     * Updates and draws the Tower 
     * @param g
     */
    public void updateAndDraw(Graphics g){	
		
		this.drawTower(g);
	}
	
    /**
     *
     * @param g
     */
    public void drawTower(Graphics g) {
		//Draws the tower with the Artist
		Artist_Swing.drawTower(this,g);
    }
	
	//upgrade the towers values and level

    /**
     *
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

	public String toString(){
		String result = "";
		result += this.getName() + ", ";
		result += "Level " + this.getLevel() + "/" + MAXTOWERLEVEL;
		
		return result;
	}
	

}
