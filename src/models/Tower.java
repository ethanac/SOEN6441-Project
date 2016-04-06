package models;

import helpers.*;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import strategies.*;

/**
 * Set the basic info for Towers
 * 
 * @author Hao Zhang
 * @version 3.0.0
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
	Timestamp createTime;
	Timestamp updateTime;
	private Timestamp updateTime1;
	private Timestamp updateTime2;
	private Timestamp updateTime3;
	private long ct;
	private long t1 = -1;
	private long t2 = -1;
	private long t3 = -1;
	 
	
    /**
     *
     * @param n
     * @param p
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
		ct = System.currentTimeMillis();
		createTime = new Timestamp(ct);
		
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
     * @param strategy
     */
    public void setStrategy(IStrategy strategy) {
		this.strategy = strategy;
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
     * @return
     */
    public IStrategy getStrategy(){
		return this.strategy;
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
     * @return
     */
    public static String getDefaultStrategy(){
		return DEFAULTSTRATEGY;
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
     * @param crittersOnMap
     */
    public void setCrittersOnMap(ArrayList<Critter> crittersOnMap){
		this.potentialCrittersInRange = crittersOnMap;
	}

    /**
     *
     * @return
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
     *Draws the tower with the Artist
     * 
     * @param g
     */
    public void drawTower(Graphics g) {
    	Artist_Swing.drawTower(this,g);
    }
	

	/**
     *selects the tower based on strategy
     *
     * @param tf1
     * @param crittersInR
     * @return
     */
    protected Critter selectTarget(Tower tf1, ArrayList<Critter> crittersInR){
    	
		Critter target = strategy.findTarget(tf1, crittersInR);
		return target;
	}

    /**
     *finds the distance between a creep and a tower.
     *
     * @param a
     * @return
     */
    public double distanceToCritter(Critter a){
    	//get delta x and deltay
	    double deltaX = a.getPixelPosition().getX()-this.getPosX();
	    double deltaY = a.getPixelPosition().getY()-this.getPosY();
		double critterDistance = Math.sqrt((deltaX)*(deltaX) + (deltaY)*(deltaY));
		
		return critterDistance;
	}
	
	/**
	 * checking if a critter is in range of a tower
	 * @param a
	 * @return
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
	
    /**
     *returns the critters that are in range of a tower
     *
     * @param a
     * @return
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
	

    /**
     *deals damage based on amount of damage of the tower
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
	

    /**
     * upgrade the towers values and level
     */
    public void upgradeTower(){
    	long time = System.currentTimeMillis();
    	//upgrades the tower based on properties
		if(level == 1){
			level = level + 1;
			upCost = upCost*3;
			damage = damage*2; 
			rateOfFire = rateOfFire + level;
			sellPrice = sellPrice*2;
			range = (int)(1.5*range);
			t1 = time;
			updateTime1 =  new Timestamp(time);
		}else if(level == 2){
			level = level + 1;
			upCost = upCost*3;
			damage = damage*2; 
			rateOfFire = rateOfFire + level;
			sellPrice = sellPrice*2;
			range = (int)(1.5*range);
			t2 = time;
			updateTime2 =  new Timestamp(time);
		}else if(level == 3){
			level = level + 1;
			upCost = upCost*3;
			damage = damage*2; 
			rateOfFire = rateOfFire + level;
			sellPrice = sellPrice*2;
			range = (int)(1.5*range);
			t3 = time;
			updateTime3 =  new Timestamp(time);
		}
	}
    
    /**
     * Set update times using time info read from a file.
     * @param order
     * @param time
     */
    public void setUpgradTimes(int order, long time){
    	if(order == 0)
    		createTime = new Timestamp(time);
    	else if(order == 1)
    		updateTime1 = new Timestamp(time);
    	else if(order == 2)
    		updateTime2 = new Timestamp(time);
    	else
    		updateTime3 = new Timestamp(time);
    }
    
    /**
     * Show the tower info at the game control panel
     * 
     * @param level
     * @param name
     * @param range
     * @param damage
     * 
     * @return result
     */
    public String toString1(){
		String result = "";
		String level = "";
		String name = "";
		String range = "";
		String damage = "";
		name = this.getName() + " Tower: ";
		level = " Level:  " + this.getLevel() + " / " + MAXTOWERLEVEL + ", \n";
		range = "Attack range: " + this.getRange() + ", ";
		damage = "Damage: " + this.getDamage();
		result = name + level + range + damage;
		
		return result;
	}
    
    /**
     * Get the log text of the tower.
     * @return result
     */
    public String toString2(){
		String result = "";
		String createTime = "";
		String updateTime1 = "";
		String updateTime2 = "";
		String updateTime3 = "";
		
		createTime = "Created at " + this.getCreateTime() ;
		updateTime1 = "\n" + "Updated at " + this.getUpdateTime1();
		updateTime2 = "\n" + "Updated at " + this.getUpdateTime2();
		updateTime3 = "\n" + "Updated at " + this.getUpdateTime3();
		
		if(this.getLevel()==1){
			result = createTime;
		}else if (this.getLevel() == 2){
			result = createTime + updateTime1;
		}else if(this.getLevel() == 3){
			result = createTime + updateTime1+ updateTime2;
		}else if(this.getLevel() == 4){
			result = createTime + updateTime1+ updateTime2 + updateTime3;
		}
		
		
		return result;
	}
    
    /**
     * Prepare the info of the tower for saving game.
     * @return result
     */
    public String infoToSave(){
    	String result = "";
    	String towerP = position.getX() + ":" + position.getY();
    	String name = this.getName();
    	String level = this.getLevel()+"";
    	result = towerP+","+name+","+level + "," + ct + ":" + t1 + ":" + t2 + ":" + t3;
    	
    	return result;
    }

    private Timestamp getUpdateTime3() {
		return updateTime3;
	}

	private Timestamp getUpdateTime2() {
		
		return updateTime2;
	}

	private Timestamp getUpdateTime1() {
		
		return updateTime1;
	}

	private Timestamp getCreateTime() {
		return createTime;
	}

	public double getDamage(){	
		return damage;
	}
}
