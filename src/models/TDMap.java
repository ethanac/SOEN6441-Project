package models;


import helpers.Artist_Swing;

import java.awt.Graphics;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * 
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * @author Hao Zhang
 * @author Meng Yao
 * 
 * @version 1.0.0
 */
public class TDMap implements DrawableEntity{
	//final variables
	public static final int MINWIDTH = 5, 

    
    MAXWIDTH = 80, 

    MINHEIGHT = 5, 

    MAXHEIGHT = 80;

    public static final int DEFAULTGRIDWIDTH = 40;

    public static final int DEFAULTGRIDHEIGHT = 24;

    public static final int TOWER = 4;
    
    public static final int PATH = 2;
    private final int PIXELWIDTH = Artist_Swing.PIXELWIDTH;
    private final int PIXELHEIGHT = Artist_Swing.GAMEPIXELHEIGHT;
    
    //private int grid[][];
    private MapTile gridTile[][];
    
    // The grid will be ALWAYS initialized and used as a width by height, that
    // will be implemented with graphics as horizontal by vertical blocks, that
    // go from top-left to bottom right. ALSO, it is ROWxCOLUMN!!
    private int gridWidth, gridHeight;

    // width will range from 13 to 50 and height will range from 20 to 80
    private String backdrop;
    private int start1, start2, end1, end2;
    private boolean isMapValid;

    private LinkedList<Integer> shortestPath;

    public int tileWidth_Pixel;

    public int tileHeight_Pixel;
    
    /**
     * 
     */
    //used to test address of TDMap,deletable after testing
	public boolean existedMapPath;
	

    /**
     * This is the constructor without parameter.
     * It initializes the variables to default values.
     */
    public TDMap()
    {
    	//set the grid width and height as default
        gridWidth= DEFAULTGRIDWIDTH;
        gridHeight= DEFAULTGRIDHEIGHT;
        initializeGrid();
       
        //generic backdrop
        backdrop= "Generic";
        //set the tile width and height of the tiles
        tileWidth_Pixel = (int) (((double)PIXELWIDTH)/((double)gridWidth));
        tileHeight_Pixel = (int) (((double)PIXELHEIGHT)/((double)gridHeight));
    }
    
   
    
    /**
     * This the constructor with a parameter.
     * 
     * @param add  A string as the path of the map file to be opened.
     */
    public TDMap(String add)
    {
    	//set the grid width and height
    	gridWidth = DEFAULTGRIDWIDTH;
    	gridHeight = DEFAULTGRIDHEIGHT;
    	//read the map from the file and see if it is good
    	boolean goodMap = readMapFromFile(add);
    	existedMapPath = true;
    	//set the tile width and height (after reading)
    	tileWidth_Pixel = (int) (((double)PIXELWIDTH)/((double)gridWidth));
        tileHeight_Pixel = (int) (((double)PIXELHEIGHT)/((double)gridHeight));
         //if the map is bad, we want to set a default path.
    	if(!goodMap){
    		existedMapPath = false;
    		//still try to recalculate the tilewidth and height
            tileWidth_Pixel = (int) (((double)PIXELWIDTH)/((double)gridWidth));
            tileHeight_Pixel = (int) (((double)PIXELHEIGHT)/((double)gridHeight));
        	//halfway is halfway through the grid's width
            int halfWay = gridWidth/2;
            //initialize the grid
        	initializeGrid();
        	//go to halfway and add a path 3 blocks down.
            for(int i = 0; i < halfWay; i++){
            	gridTile[i][3].setTileValue(PATH);
            }
            //go from 3 to 6 downwards
            for(int i = 3; i < 7; i++){
            	gridTile[halfWay][i].setTileValue(PATH);
            }
            //go to the end of the path
            for(int i = halfWay; i < gridWidth; i++){
            	gridTile[i][6].setTileValue(PATH);
            }
            //set our start and end points
            backdrop= "Generic";
            start1 = 0;
            start2 = 3;
            end1 = gridWidth-1;
            end2 = 6;
        }

    }
    
    /**
     * The method to initialize the grid.
     */
    private void initializeGrid() {
		//initializes the gridTile array to be all new MapTile objects
         gridTile = new MapTile[gridWidth][gridHeight];
         for(int i = 0; i < gridWidth; i++){
        	 for(int j = 0; j < gridHeight; j++){
        		 gridTile[i][j] = new MapTile();
        	 }
         }
	}
    
    /**
     * The method to initialize a new TDMap from a file.
     * 
     * @param add A string as the path of the map file.
     * @return result A boolean value. If the map file does not exist, return false;
     * 				  If the the map file is OK to use, return true;
     * 				  Otherwise, return false.			
     */
    private boolean readMapFromFile(String add)
    {
    	boolean result;
        File f= new File(add);
        //make sure it exists
        if(!f.exists())
            return false;
        else
        {
        	//File and data streams are how we read
            FileInputStream fis;
            DataInputStream dis;
            try
            {
            	//initialize
                fis = new FileInputStream(f);
                dis = new DataInputStream(fis);
                //read the backdrop, the width, the height
                backdrop= dis.readUTF();
                gridWidth= dis.readInt();
                gridHeight= dis.readInt();
                initializeGrid(); //initialize the grid
                //go through and get the values of the grid
                for(int i=0; i< gridWidth; i++){
                    for(int j=0; j< gridHeight; j++){
                    	int nextReadInt = dis.readInt();
                        //grid[i][j]= nextReadInt;
                        gridTile[i][j].setTileValue(nextReadInt);
                    }
                }
                //then read the start and end points
                start1= dis.readInt();
                start2= dis.readInt();
                end1= dis.readInt();
                end2= dis.readInt();
                //close our readers
                dis.close();
                fis.close();
                //verify our map
                result = verifyMap();
                
            }
            catch(IOException e) //if we get an issue, return false
            {
            	System.out.println("Error with reading map");
                return false;
            }
            return result;
        }
    }

    /**
     * The method to save the current TDMap to a file.
     * 
     * @param add 	A string as the path where you want to save the map.
     * @return booleanvalue If the map is saved successfully, return true.
     * 						Otherwise, return false.
     */
    public boolean writeMaptoFile(String add)
    {
        //File and data output streams are how we write	
        File f= new File(add);
        FileOutputStream fos;
        DataOutputStream dos;
        try
        {
        	//initialize
            fos = new FileOutputStream(f);
            dos = new DataOutputStream(fos);
            //write our backdrop, width, height
            dos.writeUTF(backdrop);
            dos.writeInt(gridWidth);
            dos.writeInt(gridHeight);
            //go through and write our tiles
            for(int i=0; i< gridWidth; i++){
                for(int j=0; j< gridHeight; j++){
                    dos.writeInt(gridTile[i][j].getTileValue()); 
                }
            }
            //write our start and ends
            dos.writeInt(start1);
            dos.writeInt(start2);
            dos.writeInt(end1);
            dos.writeInt(end2);
            //close our outputs
            dos.close();
            fos.close();
        }
        catch(IOException e)
        {
            return false;
        }
        return true;
    }

    /**
     * The method to set one grid on the map to path or tower.
     * Path cells are denoted to be 2.
     * 
     * @param i An integer as the x value.
     * @param j An integer as the y value.
     */
    public void toggleGrid(int i, int j)
    {
    	//if we are on the start path or the end path, do nothing
    	if((((i==start1) && (j==start2))) || (((i==end1) && (j==end2)))){
  
        }else{ //otherwise, toggle the path
        	//make sure we are in bounds
    		if((i<gridWidth)&&(j<gridHeight))
    			//if we are path, go to tower
    			if(gridTile[i][j].getTileValue()==PATH)
    			{
    				gridTile[i][j].setTileValue(TOWER);
    			}
    			else //if we are tower, go to path
    			{
    				gridTile[i][j].setTileValue(PATH);
    			}
        }

    }
    
    /**
     * The method to reinitialize the grid.
     * Background and Tower cells are denoted to be 4.
     * 
     * @param gridWidth An integer as the width of the grid.
     * @param gridHeight An integer as the height of the grid.
     * @param backdrop A String as the backdrop
     */
    public void reinitialize(int gridWidth, int gridHeight, String backdrop) {
			this.gridWidth= gridWidth;
			this.gridHeight= gridHeight;
			this.backdrop= backdrop;
			refresh();
	}
   
    /** 
     * The method to set a grid to path.
     * Path cells is denoted to be 2.
     *
     * @param i An integer as the x axis value.
     * @param j An integer as the y axis value.
     */
    public void setAsPath(int i, int j)
    {	//make sure in bounds
        if((i<gridWidth)&&(j<gridHeight)){
        	//set as path
        	gridTile[i][j].setTileValue(PATH);
        }
    }
    
    
    /**
     * The method to refresh the grids.
     * Set the value of width, height, start point and end point to default value.
     */
        public void refresh()
    {
        //we reinitialize the grid
        gridTile = new MapTile[gridWidth][gridHeight];
    	for(int i=0; i< gridWidth; i++){
            for(int j=0; j< gridHeight; j++)
            {
            	//grid[i][j]= TOWER;
            	gridTile[i][j]= new MapTile();
            	gridTile[i][j].setTileValue(TOWER);
            }
        }
    	//and we set our starts and ends to default
        end1= -1;
    	end2= -1;
    	start1= -1;
    	start2= -1;
    	//and recalculate the width and height
        tileWidth_Pixel = PIXELWIDTH/gridWidth;
        tileHeight_Pixel = PIXELHEIGHT/gridHeight;
    }
    
    /** 
     * The method to set the start point.
     *
     * @param i An integer as the x axis value.
     * @param j An integer as the y axis value.
     */
    public void setStart(int i, int j)
    {
    	//set the start point
        start1= i;
        start2= j;
        setAsPath(i,j);
    }
    //return the start point
    public Point getStart(){
    	return new Point(start1, start2);
    }
    public Point getEnd(){
    	return new Point(end1, end2);
    }
    
    /**
     * The method to set the end point.
     * 
     * @param i An integer as the x axis value.
     * @param j An integer as the y axis value.
     */
    public void setEnd(int i, int j)
    {
        end1= i;
        end2= j;
        setAsPath(i,j);
    }


/**
*
* This method will return true if the Map is connected, and false
* otherwise.
* The way it is implemented is by applying a BREADTH-FIRST search algorithm
* from the starting cell and then checking if the ending cell has been
* explored or not. If the ending cell has been explored, then the PATH is
* valid. This BFS also explores the shortest path from the End Cell to the
* Start Cell to get rid of Loops.
* This method also initializes the boolean isMapValid to a T/F value.
* 
* @return isMapValid If the path on the map connects the start point and the end point, return true;
* 					 Otherwise, return false.
*/
    public boolean verifyMap(){
        LinkedList<Integer> explored= new LinkedList<>();
        LinkedList<Integer> frontier= new LinkedList<>();
        int parent[]= new int [(gridWidth*gridHeight)];
        frontier.addFirst(key(start1,start2));
        int t;
        //we go through the path and try to find one from the start path to the end path
        //if we can find one, then we are good, and the map is valid (we don't care
        //about anything else)
        while(!frontier.isEmpty())
        {
            t= frontier.removeFirst();
            explored.add(t);
            int i= arckeyi(t);
            int j= arckeyj(t);
            //our conditions to see which one to visit next
            if((i-1)>=0) 
                if(gridTile[i-1][j].getTileValue()==PATH)
                    if(!explored.contains(key(i-1,j)))
                    {
                        frontier.addLast(key(i-1,j));
                        parent[key(i-1,j)]=t;
                    }
            if((i+1)<gridWidth)
                if(gridTile[i+1][j].getTileValue()==PATH)
                    if(!explored.contains(key(i+1,j)))
                    {
                        frontier.addLast(key(i+1,j));
                        parent[key(i+1,j)]=t;
                    }
            if((j-1)>=0)
                if(gridTile[i][j-1].getTileValue()==PATH)
                    if(!explored.contains(key(i,j-1)))
                    {
                        frontier.addLast(key(i,j-1));
                        parent[key(i,j-1)]=t;
                    }
            if((j+1)<gridHeight)
                if(gridTile[i][j+1].getTileValue()==PATH)
                    if(!explored.contains(key(i,j+1)))
                    {
                        frontier.add(key(i,j+1));
                        parent[key(i,j+1)]=t;
                    }
        }
        t= key(end1,end2);
        //now we want to make sure that our valid map contains our end path position
        isMapValid= explored.contains(t);
        //if so, we are good, and we can generate the shortest path
        if(isMapValid){
	        shortestPath= new LinkedList<>();
	        while(t!=key(start1,start2))
	        {
	            shortestPath.addFirst(t);
	            t= parent[t];
	        }
	        shortestPath.addFirst(t);
        }
        return isMapValid;
    }
    
    // These are miscellaneous methods that assign a unique key value to each
    // individual cell in the grid and allow conversions between them.

    /**
     * To get the key for the verifyMap method.
     * 
     * @param i An integer as the x axis value.
     * @param j An integer as the y axis value.
     * @return gridWidth*j+i+1 get the key value.
     */
        public int key(int i, int j)
    {
        return (gridWidth*j+i+1);
    }

    /**
     * The method to get the next x axis value to find a path.
     * 
     * @param k An integer as the key value.
     * @return ((k-1)%gridWidth  The next x value.
     */
    public int arckeyi(int k)
    {
        return ((k-1)%gridWidth);
    }

    /**
     * The method to get the next y axis value to find a path.
     * 
     * @param k An integer as the key value.
     * @return ((k-1)%gridWidth  The next y value.
     */
    public int arckeyj(int k)
    {
        return ((k-1)/gridWidth);
    }
    
    
    /**
     * The method to get the width of a tile
     * 
     * @return tileWidth_Pixel the width of the tile.
     */
    public int getTileWidth_pixel(){
    	return this.tileWidth_Pixel;
    }

    /**
     * The method to get the height of a tile
     * 
     * @return tileHeight_Pixel the height of the tile.
     */
    public int getTileHeight_pixel(){
    	return this.tileHeight_Pixel;
    }

    /**
     * The method to get the pixelWidth.
     * 
     * @return PIXELWIDTH  the pixelWidth.
     */
    public int getPixelWidth(){
    	return PIXELWIDTH;
    }

    /**
     * The method to get the pixelHeight.
     * 
     * @return PIXELHEIGHT  the pixelHeight.
     */
    public int getPixelHeight(){
    	return PIXELHEIGHT;
    }

    /**
     * The method to get the gridWidth.
     * 
     * @return gridWidth  the gridWidth.
     */
    public int getGridWidth()
    {
    	return gridWidth;
    }

    /**
     * The method to get the gridHeight.
     * 
     * @return gridHeight  the gridHeight.
     */
    public int getGridHeight()
    {
    	return gridHeight;
    }

    /**
     * The method to get the type of a tile.
     * It could be 0, 1, 2, 4.
     * 
     * @param x An integer as the x axis value of a tile.
     * @param y An integer as the y axis value of a tile.
     * @return The type of this tile.
     */
    public int getType(int x, int y)
    {
    	int type= gridTile[x][y].getTileValue();
    	return type;
    }

    /**
     * The method to get a tile.
     * 
     * @param x An integer as the x axis value of a tile.
     * @param y An integer as the y axis value of a tile.
     * @return The tile in the given position.
     */
    public MapTile getTile(int x, int y){
    	MapTile tile = gridTile[x][y];
    	return tile;
    }

    /**
     * The method to get the backdrop.
     * 
     * @return backdrop The backdrop returned
     */
    public String getBackdrop()
    {
    	return backdrop;
    }

    /**
     * The method to get the Points of shortest path.
     * 
     * @return pointsShortestPath An arraylist of Points as the shortest path.
     */
    public ArrayList<Point> getPointsOfShortestPath(){
    	//initialize the arraylist
		ArrayList<Point> pointsShortestPath = new ArrayList<Point>();
		//if the shortestPath is null, then just create a default path.
		if(shortestPath == null){
			//this is the same default path as above (to be consistent with graphics)
			int halfWay = this.gridWidth/2;
            for(int i = 0; i < halfWay; i++){
            	pointsShortestPath.add(new Point(i,3));
            }
            for(int i = 3; i < 7; i++){
            	pointsShortestPath.add(new Point(halfWay,i));
            }
            for(int i = halfWay + 1; i < gridWidth; i++){
            	pointsShortestPath.add(new Point(i,6));
            }
		}else{ //otherwise, convert the shortest path into points.
			for(int i = 0; i < this.shortestPath.size(); i++){
				pointsShortestPath.add(new Point(arckeyi(shortestPath.get(i)), arckeyj(shortestPath.get(i))));
			}
		}
		return pointsShortestPath;
	}

    /**
     * The method to get the position of a block.
     * 
     * @param x An integer as the x axis value of a tile.
     * @param y An integer as the y axis value of a tile.
     * @return result The Point object.
     */
    public Point getPosOfBlock_pixel(int x, int y){
		//we return the pixel position of a block, based on the tile width and height
    	Point result = new Point((int) Math.ceil((x*tileWidth_Pixel)),(int) Math.ceil(y*tileHeight_Pixel));
		return result;
	}
	
	
    /**
     * The method to update and draw the map.
     * 
     * @param g The graphics object need to draw.
     */
    public void updateAndDraw(Graphics g){
    	//uses the artist to draw the map
		Artist_Swing.drawMap(this, g);
	}

    /**
     * The method to provide an easy way to print out the grid to display the map. 
     */
    public void print()
    {
        System.out.println("Grid Size is "+gridWidth+" in horizontal width by "+gridHeight+" in vertical height:");
        for(int j=-2; j<gridWidth; j++)
            System.out.print("-");
        for(int i=0; i<gridHeight; i++)
        {
            System.out.print("\n|");
            for(int j=0; j<gridWidth; j++)
                if(gridTile[j][i].getTileValue()==TOWER)
                    System.out.print(" ");
                else if(gridTile[j][i].getTileValue()==PATH)
                    System.out.print("O");
            System.out.print("|");
        }
        System.out.println();
        for(int j=-2; j<gridWidth; j++)
            System.out.print("-");
        if(isMapValid)
            System.out.print("\nShortest path from Start to End is: ");
        for(Integer shortestPath1 : shortestPath) {
            System.out.print("(" + arckeyi(shortestPath1) + "," + arckeyj(shortestPath1) + ")\t");
        }
        System.out.println();
    }

}

