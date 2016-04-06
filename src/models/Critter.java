package models;
import helpers.Artist_Swing;
import helpers.GameClock;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Critter abstract class from which all critters extend. Has certain attributes and methods including 
 * taking a step, getting damaged, etc.
 * 
 * @author Zhoujian Lan 
 * @version 3.0.0
 */

public abstract class Critter extends Subject implements DrawableEntity {
	//Constants

    /**
     * Constants defines the maximum level, maximum speed of critters and the info of them.
     */
	public static final int MAXCRITTERLEVEL = 50;
	public static final int MAXSPEED = 15;
	public static final String CRITTERMESSAGE = "Below is a description of each of the colored critters.\n\n" + "Yellow:\t\t\tBoss Critter. Very hard to kill\n\n" + "White:\t\t\tFast but weak\n\n" + "Red:\t\t\tSlightly below average\n\n" + "Pink:\t\t\tStrong but slow\n\n" + "Orange:\t\t\tCompletely resistant to fire and slow\n\n" + "Cyan:\t\t\tAverage Critter\n\n";  
	//attributes of the critter
	//tangible properties of critter

    /**
     * The points of current hit.
     */
	protected double currHitPoints;

    /**
     * The maximum hit points.
     */
    protected double maxHitPoints;

    /**
     * The speed of critters.
     */
    protected double speed;

    /**
     * The size.
     */
    protected int size;

    /**
     * The regen.
     */
    protected double regen;

    /**
     * A value from 0.0 to 1.0 that determines how a certain critter type is affected by slows/DOT. Reduces the effect by the factor = Resistance.
     */
    protected double resistance;

    /**
     * The color of the critter.
     */
    protected Color cColor;
	
	//intangible properties

    /**
     * The reward of killing the critter.
     */
    protected int reward;

    /**
     * The level of the critter.
     */
    protected int level;

    /**
     * The name of the critter.
     */
    protected String name;

    /**
     * The factor of slowing effect.
     */
    protected double slowFactor;

    /**
     * The last time of the slowing effect.
     */
    protected int slowTime;

    /**
     * The attributes for computing the lasting effect of damage.
     */
    protected int beenSlowedFor;
	private double damageOverTimeVal;
	private int dotTime;
	private int beenDOTFor;
	private boolean burning;
	
	//state properties

    /**
     * The position of pixel.
     */
    	protected Point _pixelPosition;

    /**
     * The state of critter.
     */
    protected boolean active;

    /**
     * The health of critter
     */
    protected boolean alive;

    /**
     * The state if critter reaches the end.
     */
    protected boolean reachedEnd;

    /**
     * The array of points of the path.
     */
    protected ArrayList<Point> pixelPathToFollow;

    /**
     * The index of pixel path.
     */
    	protected double indexInPixelPath;

    /**
     * The integer index of pixel path.
     */
    protected int intIndexInPixelPath;

    /**
     * The constructor of Critter.
     * @param level The level of critter.
     * @param m  The map of the game.
     */
    public Critter(int level, TDMap m){
    	this.level = level;
    	setInitialValues();
    	//set the level from input
	pixelPathToFollow = m.getPath_ListOfPixels();
	//sets the size to scale with the grid size (bigger blocks = bigger critters)
	size = Math.min(m.getTileWidth_pixel(), m.getTileHeight_pixel())/5; 
    }
    
    /**
     * sets the initial values of the critter attributes.
     */
	public void setInitialValues(){
		reachedEnd = false; //none have reached end to start
		active = false; //none are active to start
		alive = true; //they are all alive to start
		indexInPixelPath = 0; //all start at beginning of path
		this._pixelPosition = new Point(-1,-1);
		slowFactor = 0;
		slowTime = 0;
		beenSlowedFor = 0;
		damageOverTimeVal = 0;
		dotTime = 0;
		beenDOTFor = 0;
		burning =false;
	}
	
	/**
	 * calculates the current level multiplier of the critter
	 * This will be called by extending critters, usually.
	 */
    protected double calculateLevelMultiplier(){
    	double i = 1 + 1*((double)(level-1))/((double)MAXCRITTERLEVEL);
    	
    	if(level > 20){
    		i = 1 + (level+1)*((double)(level-1))/((double)MAXCRITTERLEVEL);
    	}else if(level > 10){
    		i =1 + 2*(level+1)*((double)(level -1))/((double)MAXCRITTERLEVEL);
    	}else if(level > 5){
    		i =1 + (level+1)*((double)(level -1))/((double)MAXCRITTERLEVEL);
    	}
    	return i;
    }
	
    //getters and setters

    /**
     * The getter of index in pixel path.
     * @return indexInPixelPath  Return the index.
     */
    	public double getIndexInPixelPath(){
		return this.indexInPixelPath;
	}

    /**
     * The getter of list pixel path.
     * @return pixelPathToFollow  Return pixel path.
     */
    public ArrayList<Point> getListPixelPath(){
		return this.pixelPathToFollow;
	}

    /**
     * The setter of slow factor.
     * @param slowFactor  The slow factor.
     */
    
	public void setSlowFactor(double slowFactor){
		if(this.slowFactor < slowFactor){
			this.slowFactor = slowFactor;
		}
		beenSlowedFor = 0;
	}
	
	/**
	 * The setter of DOT amount
	 * @param dot  The value of DOT.
	 */
	private void setDOTAmount(double dot) {
		if(this.damageOverTimeVal < dot){
			this.damageOverTimeVal = dot;
		}
		beenDOTFor = 0;
	}
	
    /**
     * The getter of color.
     * @return cColor  The color of critter.
     */
    public Color getColor(){
		return cColor;
	}
	
    /**
     * The getter of pixel position.
     * @return _pixelPosition  Return pixel position
     */
    public Point getPixelPosition(){
		return _pixelPosition;
	}

    /**
     * Check if the critter reaches the end.
     * @return reachedEnd  Return the state.
     */
    public boolean hasReachedEnd(){
		return reachedEnd;
	}

    /**
     * Check if the critter is still alive.
     * @return alive  Return true or false about alive.
     */
    public boolean isAlive(){
		return alive;
	}

    /**
     * Check if the critter is on fire.
     * @return burning  Return the state.
     */
    public boolean isBurning() {
		return burning;
	}

    /**
     * The getter of size.
     * @return size  The size.
     */
    public int getSize(){
		return size;
	}

    /**
     * The getter of loot.
     * @return reward  The value of reward.
     */
    public int getLoot(){
		return reward;
	}

    /**
     * The setter of hit box radius.
     * @param size  The value of size.
     */
    public void setHitboxRadius(int size){
		this.size = size;
	}

    /**
     * The getter of hit points.
     * @return currHitPoints  Return the current hit points.
     */
    public double getHitPoints() {
		return currHitPoints;
	}

    /**
     * The setter of hit points.
     * @param hitPoints  The value of hit points.
     */
    public void setHitPoints(double hitPoints) {
		this.currHitPoints = hitPoints;
	}

    /**
     * The getter of max hit points.
     * @return maxHitPoints  Return the max hit points.
     */
    public double getMaxHitPoints(){
		return maxHitPoints;
	}

    /**
     * The getter of regen
     * @return regen  return the regen.
     */
    public double getRegen() {
		return regen;
	}

    /**
     * The setter of regen.
     * @param regen  The value of regen.
     */
    public void setRegen(double regen) {
		this.regen = regen;
	}

    /**
     * The getter of raw speed.
     * @return speed  Return the raw speed.
     */
    public double getRawSpeed() {
		return speed;
	}

    /**
     * The setter of raw speed.
     * @param speed  The value of speed.
     */
    public void setRawSpeed(int speed) {
		this.speed = speed;
	}

    /**
     * The getter of level
     * @return level  Return the value of level.
     */
    public int getLevel() {
		return level;
	}

    /**
     * The setter of level
     * @param level  The value of level.
     */
    public void setLevel(int level) {
		this.level = level;
	}

    /**
     * The getter of state of active.
     * @return active  Return the state of active.
     */
    public boolean isActive(){
		return active;
	}

    /**
     * The setter of state of active.
     * @param act  The boolean value of state of active.
     */
    public void setActive(boolean act){
		active = act;
	}

    /**
     * The getter of speed.
     * @return speed  Return the value of speed.
     */
    public double getSpeed(){
		return speed;
	}
	//END OF Getters and Setters
    
	/**
	 * @see entities.DrawableEntity#updateAndDraw()
	 * This must have all properties of the critter that change with time
	 * These properties are its position and its health.
	 */

    /**
     * Update and draw.
     * @param g  The graphics g.
     */
	public void updateAndDraw(Graphics g){
		//we only want to do something if the critter is active
		if(this.isActive()){
			//See if we are being slowed, if so, tick the total amount of time we have been slowed for
			if(beenSlowedFor < this.slowTime){
				beenSlowedFor +=1*GameClock.getInstance().deltaTime();
			}else{
				slowFactor = 0;
			}
			//See if we are being damaged over time, if so, tick the time we have been DOT for
			if(beenDOTFor < this.dotTime){
				beenDOTFor +=1*GameClock.getInstance().deltaTime();
				burning = true;
			}else{
				damageOverTimeVal = 0;
				burning = false;
			}
			//update the health of the critter
			updateHealth();
			//update the position of the critter and draw it
			updatePositionAndDraw(g);
		}
	}
	
	/**
	 * updates the health of the critter (called on every "tick" of the clock)
	 */
	private void updateHealth(){
		//a certain amount of time passed (which is deltaTime)
		int timePassed = GameClock.getInstance().deltaTime();
		double dotPerTime = damageOverTimeVal*timePassed;
		double dotTaken = dotPerTime*(1.0-resistance); //this is the amount of DOT we take
		
		//simply update the hitpoints. This should be called every update instance.
		if(this.currHitPoints + this.regen*timePassed - dotTaken <=0){
			this.currHitPoints = 0;
			this.active = false;
			this.alive = false;
			this.notifyObs();
			//if our regen will not push us over our limit, simply regen
		}else if(this.currHitPoints + this.regen*timePassed - dotTaken < this.maxHitPoints){
			this.currHitPoints = this.currHitPoints + this.regen*timePassed - dotTaken;	
		}else{
			//otherwise just set us to the max regen value.
			this.currHitPoints = this.maxHitPoints;
		}
		
	}
	
	/**
	 * updates the position (and draws it), called on every tick of clock
	 */
	private void updatePositionAndDraw(Graphics g){
		//if we haven't yet moved, 
		if(indexInPixelPath == 0){
			//place us on the map at the initial position.
			_pixelPosition = pixelPathToFollow.get(0);
		}
		
		//the next index is our current index + our speed*our clock.
		//note that our speed is equal to 1-(1-resistance)*slowfactor;
		indexInPixelPath += (1.0-(1.0-resistance)*slowFactor)*this.speed*GameClock.getInstance().deltaTime(); //synced with time
		int indexToMoveTo = (int) indexInPixelPath;
		
		//If we aren't going to pass the end, we move our critter.
		if(indexInPixelPath < pixelPathToFollow.size()){
			moveAndDrawCritter(indexToMoveTo, g);
		}else{
			//we have reached the end
			reachedEnd = true; 
			//this critter is no longer active
			active = false;
			//notify our observers.
			this.notifyObs();
		}
	}
	
	/**
	 * Moves the critter to a given position and draws it as it moves.
	 * @param index
	 * @param g
	 */
	private void moveAndDrawCritter(int index, Graphics g){
		//if we have not moved, we just draw the critter (if paused for instance)
		if(intIndexInPixelPath == index){
			this.drawCritter(g);
		//if we have moved, we go through all of the points that we have moved, and draw it
		}else{
			while(intIndexInPixelPath<index){
				intIndexInPixelPath +=1;
				this._pixelPosition.setPoint(this.pixelPathToFollow.get(intIndexInPixelPath).getX(), this.pixelPathToFollow.get(intIndexInPixelPath).getY());
				this.drawCritter(g); //draws the critter
			}
		}
	}
	
	/**
	 * The method to draw.
	 * @param g  The graphics g to draw
	 */
	private void drawCritter(Graphics g) {
		//draws the critter using the artist class
		Artist_Swing.drawCritter(this,g);
    }
	
	//Damages the critter for a certain amount 

    /**
     * Get the damage.
     * @param dam  The value of damage the critter gets
     */
    	public void damage(double dam){
	    	//Check to see if we will not die.
			if(this.currHitPoints - dam > 0){
				this.currHitPoints -= dam; //if we won't die, damage us
			}else{ //if we will die, make us inactive, dead, and notify our observers
				this.currHitPoints = 0;
				this.active = false;
				this.alive = false;
				this.notifyObs();
			}
	}
    	
    	/**
         * Slow the critter.
         * @param sFactor  The slow factor.
         * @param sTime  The lasting time.
         */
        public void slowCritter(double sFactor, int sTime){
        	//set the slow factor and slow time
    		this.setSlowFactor(sFactor);
    		this.slowTime = sTime;
    	}

        /**
         * Set DOT amount and DOT time.
         * @param dot  The value of DOT.
         * @param damageOverTimeLength  The value of DOT time.
         */
        public void damageOverTimeCritter(double dot, int damageOverTimeLength) {
        	//set the damage over time factor and time
    		this.setDOTAmount(dot);
    		this.dotTime = damageOverTimeLength;
    		
    	}
    	
    	/**
    	 * Convert the health points and regen to string.
    	 * @return result  Return the string of hp and regen.
    	 */
    	public String toString(){
    		String result = "";
    		result += "\nHP: " + currHitPoints + "/" + maxHitPoints + "\n";
    		result += "Regen = " + this.regen + "\n";
    		return result;
    	}
}
