package models;

/**
 * This class defines the position of a grid using a pair of x and y.
 * 
 * @author HaoZhang
 * @version 3.0.0
 */
public class Point {
	private int x;
	private int y;
	//constructors

    /** 
     * This is the Constructor.
     *
     * @param x An integer as the value of x axis.
     * @param y An integer as the value of y axis.
     */
    	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	//getters and setters

    /**
     * The method to get the x value.
     * 
     * @return x Get the value of x axis.
     */
    	public int getX() {
		return x;
	}

    /**
     * The method to set the x value.
     *
     * @param x An integer as the value of y axis.
     */
    public void setX(int x) {
		this.x = x;
	}

    /**
     * The method to get the y value.
     *
     * @return y Get the value of y axis.
     */
    public int getY() {
		return y;
	}

    /**
     * The method to set the y value.
     *
     * @param y An integer as the value of y axis.
     */
    public void setY(int y) {
		this.y = y;
	}


    /**
     * The method to set both of the x value and y value.
     *
     * @param x 	An integer as the value of x axis.
     * @param y 	An integer as the value of y axis.
     */
    	public void setPoint(int x, int y){
		this.x = x;
		this.y = y;
	}

    /**
     * The method to check if one point equals to another.
     * If the two points are equal, return true,
     * otherwise return false.
     *
     * @param P A Point object as the point to compare with.
     * @return result   The result of comparing, 
     * 					true if the two points are equal, otherwise false.
     */
	public boolean equals(Point P){
		boolean result = false;
		//two points are equal IFF x1 = x2 and y1 = y2
		if(this.x == P.x && this.y == P.y){
			result = true;
		}
		return result;
	}
	
	/**
	 * The method to change the value of x and y to String.
	 * Its format of output is "Position: ( $x value$, $y value$)".
	 */
	public String toString(){
		String result = "Position: (" + this.x + ", " + this.y + ")";
		
		return result;
	}
}

