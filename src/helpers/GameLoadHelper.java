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
 */
public class GameLoadHelper {
	private int waveNumber = 0;
	private int lives = 10;
	private int money = 0;
	private int credit = 0;
	private ArrayList<Tower> towers;
	private ArrayList<Point> pArray;
	private File file;
	private TDMap map;
	private ArrayList<Critter> crittersInWave;
	private ArrayList<Integer> prices;
	private ArrayList<String> times;
	
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
	 * Save game info like wave number, money, lives and towers to file.
	 */
	public void loadGame(){
 		String newline = "";
 		int xPos, yPos, level;
 		String towerName = "";
 		String pos = "";
 		String tlevel = "";
 		String upTimes = "";
		try{
 			Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
 			waveNumber = Integer.parseInt(sc.nextLine());
 			lives = Integer.parseInt(sc.nextLine());
 			money = Integer.parseInt(sc.nextLine());
 			credit = Integer.parseInt(sc.nextLine());
 			
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
 		}
 		catch(IOException e){
 			System.out.print("hehe");
 		}
	}
 		
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
