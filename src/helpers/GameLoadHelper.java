package helpers;

import models.Critter;
import models.Point;
import models.TDMap;
import models.Tower;
import models.Tower_Fire;
import models.Tower_IceBeam;
import models.Tower_Laser;
import models.Tower_SpreadShot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Help load the info of a game from a .GInfo file.
 * @author Hao Zhang
 * 
 * @version 3.0.0
 */
public class GameLoadHelper {
	public static final int TOP_NUMBER = 5;
	private int waveNumber = 0;
	private int lives = 0;
	private int money = 0;
	private int credit = 0;
	private String mapName = "";
	private ArrayList<Tower> towers;
	private ArrayList<Point> pArray;
	private File file;
	private TDMap map;
	private ArrayList<Critter> crittersInWave;
	private ArrayList<Integer> prices;
	private ArrayList<String> times;
	private ArrayList<String> topUser;
	private ArrayList<Integer> topScore;
	
	/**
	 * Constructor
	 */
	public GameLoadHelper(){
		towers = new ArrayList<Tower>();
		crittersInWave = new ArrayList<Critter>();
	}
	
	/**
	 * Constructor with file name
	 * @param fileName
	 */
	public GameLoadHelper(String fileName, TDMap map){
		towers = new ArrayList<Tower>();
		pArray = new ArrayList<Point>();
		prices = new ArrayList<Integer>();
		file = new File(fileName);
		times = new ArrayList<String>();
		topUser = new ArrayList<String>(TOP_NUMBER);
		topScore = new ArrayList<Integer>(TOP_NUMBER);
		this.map = map;
	}
	
	/**
	 * Getter of wave number.
	 * @return waveNumber
	 */
	public int getWaveNumber(){
		return waveNumber;
	}
	
	/**
	 * Getter of remaining lives.
	 * @return lives
	 */
	public int getLives(){
		return lives;
	}
	
	/**
	 * Getter of money.
	 * @return money
	 */
	public int getMoney(){
		return money;
	}
	
	/**
	 * Getter of credit.
	 * @return credit
	 */
	public int getCredit(){
		return credit;
	}
	
	/**
	 * Getter of map name.
	 * @return mapName
	 */
	public String getMapName(){
		return mapName;
	}
	
	/** 
	 * Getter of an array list of towers
	 * @return towers
	 */
	public ArrayList<Tower> getTowers(){
		return towers;
	}
	
	/**
	 * Getter of position.
	 * @return pArray
	 */
	public ArrayList<Point> getPos(){
		return pArray;
	}
	
	/**
	 * Getter of prices.
	 * @return prices
	 */
	public ArrayList<Integer> getPrices(){
		return prices;
	}
	
	/**
	 * Getter of update times.
	 * @return times
	 */
	public ArrayList<String> getTimes(){
		return times;
	}
	
	/**
	 * Getter of top users.
	 * @return topUser
	 */
	public ArrayList<String> getTopUser(){
		return topUser;
	}
	
	/**
	 * Getter of top scores.
	 * @return topScore
	 */
	public ArrayList<Integer> getTopScore(){
		return topScore;
	}
	
	/**
	 * Save game info like wave number, money, lives and towers to file.
	 */
	public void loadGame(){
 		String newline = "";
 		int xPos, yPos, level;
 		String towerName = "";
 		String pos = "";
 		String tlevel = "";
 		String upTimes = "";
 		File topFile;
		try{
 			Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
 			
 			waveNumber = Integer.parseInt(sc.nextLine());
 			money = Integer.parseInt(sc.nextLine());
 			lives = Integer.parseInt(sc.nextLine());
 			credit = Integer.parseInt(sc.nextLine());
 			mapName = sc.nextLine();
 			
 			while(sc.hasNextLine() && (newline = sc.nextLine()) != null){
 				String[] tInfo = newline.split(",");
 	 			pos = tInfo[0];
 	 			towerName = tInfo[1];
 	 			tlevel = tInfo[2];
 	 			upTimes = tInfo[3];
 				xPos = Integer.parseInt(pos.split(":")[0]);
 				yPos = Integer.parseInt(pos.split(":")[1]);
 				pArray.add(new Point(xPos, yPos));
 				level = Integer.parseInt(tlevel);
 				times.add(upTimes);
 				getTowerInfo(xPos, yPos, towerName, level);
 			}
 			sc.close();
 			topFile = new File(mapName + ".topf");
 			Scanner top5 = new Scanner(new BufferedReader(new FileReader(topFile)));
 			while(top5.hasNextLine() && (newline = top5.nextLine()) != null){
 				String[] record = newline.split(":");
 				topUser.add(record[0]);
 				topScore.add(Integer.parseInt(record[1]));
 			}
 			top5.close();
 		}
 		catch(IOException e){
 			//System.out.print("load helper error.");
 		}
	}
	
	/**
	 * This method is to get information of tower
	 * @param xPos
	 * @param yPos
	 * @param tName
	 * @param towerLevel
	 */
 	public void getTowerInfo(int xPos, int yPos, String tName, int towerLevel){
 		Point adjustedTowerPoint = map.getPosOfBlock_pixel(xPos, yPos);
		Tower towToBuild = null;
		
		if(tName.equalsIgnoreCase("Spread")){
			towToBuild =new Tower_SpreadShot("Spread", adjustedTowerPoint, crittersInWave);	
			prices.add(Tower_SpreadShot.getBuyPrice());
		}else if(tName.equalsIgnoreCase("Fire")){
			towToBuild = new Tower_Fire("Fire", adjustedTowerPoint, crittersInWave);	
			prices.add(Tower_Fire.getBuyPrice());
		}else if(tName.equalsIgnoreCase("Ice")){
			towToBuild = new Tower_IceBeam("IceBeam", adjustedTowerPoint, crittersInWave);	
			prices.add(Tower_IceBeam.getBuyPrice());
		}else if(tName.equalsIgnoreCase("Laser")){
			towToBuild = new Tower_Laser("Laser", adjustedTowerPoint, crittersInWave);
			prices.add(Tower_Laser.getBuyPrice());
		}else if(tName.equalsIgnoreCase("None")){
			//no tower = don't do anything.
		}else{
			System.out.println("Error: No appropriate tower type (coding error)");
		}
		//if we have a tower to build (that isn't null), build it
		if(towToBuild!= null){
			// build the tower, and put it on the tile
			for(int i = 0; i < towerLevel-1; i++)
				towToBuild.upgradeTower();
			towers.add(towToBuild);
			//tile.setTowerOnTile(towToBuild);
		}
	}
}
