package helpers;

import models.Tower;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * Help save the info of a game to a .GInfo file.
 * @author Hao Zhang
 *
 */
public class GameSaveHelper {
	private String name = "";
	private int waveNumber = 0;
	private int lives = 10;
	private int money = 0;
	private int credit = 0;
	private ArrayList<Tower> towers;
	private File file;
	private String mapName = "";
	
	/**
	 * Constructor
	 */
	public GameSaveHelper(){
		towers = new ArrayList<Tower>();
	}
	
	public GameSaveHelper(String fileName, String name, int waveNumber, int lives, int money, int credit, String mapname, ArrayList<Tower> t){
		file = new File(fileName);
		this.name = name;
		this.waveNumber = waveNumber;
		this.lives = lives;
		this.money = money;
		this.credit = credit;
		this.mapName = mapname;
		towers = t;
	}
	
	/**
	 * Getter of name.
	 * @return name
	 */
	public String getName(){
		return name;
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
	 * Getter of an array list of towers
	 * @return towers
	 */
	public ArrayList<Tower> getTowers(){
		return towers;
	}
	
	/**
	 * Save game info like wave number, money, lives and towers to file.
	 */
	public void saveGame(){
		String newInfo = "";
 		
 		try{
 			PrintWriter out = new PrintWriter( file );
 			out.println(waveNumber);
 			out.println(this.money);
 			out.println(this.lives);
 			out.println(this.credit);
 			out.println(this.mapName);
 			for(Tower t : towers){
 				newInfo = t.infoToSave();
 				out.println(newInfo);
 			}
 			out.flush();
 			out.close();
 		}
 		catch(IOException e){
 			System.out.print("save helper error.");
 		}
	}
}
