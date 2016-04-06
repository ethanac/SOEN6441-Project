package models;

import java.io.File;
import java.io.IOException;  
import java.io.RandomAccessFile;  
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date;

import controllers.GameController;
import views.GameApplicationFrame;  
  
/** 
 * This method is to set different kinds of logs
 * 
 * @author Zhoujian Lan
 * @version 3.0.0
 * 
 */  
  
public class Log { 
	
	Date date = new Date();   //get the current time  
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //define the time format  
	String formatDate = sdf.format(date);   //formatting current time
    String name = "D:/"+GameApplicationFrame.APP_NAME+".txt";   //get the text name
    public void createFile() throws ParseException, IOException{  
       try{
    	   File f = new File(name);
    	   f.delete();
    	   RandomAccessFile out_rand = new RandomAccessFile(name,"rw"); 
    	   out_rand.writeBytes(formatDate + " Game Started! \n");  
    	   out_rand.close();  
       }catch (IOException e) {   
           e.printStackTrace();   
       }    
    }
    
    /**
     * set log of startWave
     * @throws ParseException
     * @throws IOException
     */
    public void startWave() throws ParseException, IOException{  
    	try {   
    		 // Open a random access file streams
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            // get file length  
            long fileLength = randomFile.length();   
            // move the pointer to the end of the file   
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " Wave " + GameController.getWaveNumber() + " start! \n");   
            randomFile.close();    
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }
    
    /**
     * Set log of endWave
     * @throws ParseException
     * @throws IOException
     */
    public void endWave() throws ParseException, IOException{  
    	try {   
            
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
          
            long fileLength = randomFile.length();   
           
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " Wave " + GameController.getWaveNumber() + " end! \n");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    } 
    
    /**
     * set log of buildTower
     * @throws ParseException
     * @throws IOException
     */
    public void buildTower() throws ParseException, IOException{  
    	try {   
            
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            
            long fileLength = randomFile.length();   
           
            randomFile.seek(fileLength);  
            randomFile.writeBytes(formatDate + " The " + GameController.selectedTowerToBuild() + " Tower has been build. " +"\n");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }  
    	
    }  
    
    /**
     * set log of updateTower
     * @throws ParseException
     * @throws IOException
     */
    public void updateTower() throws ParseException, IOException{  
    	try {   
           
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   

            long fileLength = randomFile.length();   
          
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " The " + GameController.getUpdateTowerName() + " Tower at " + GameController.getUpdateTowerPosition() + " has been updated to level " + (GameController.getUpdateTowerLevel()+1) + "\n ");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }

    /**
     * set log of sellTower
     * @throws ParseException
     * @throws IOException
     */
    public void sellTower() throws ParseException, IOException{  
    	try {   
           
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
           
            long fileLength = randomFile.length();   
           
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " The " + GameController.getSellTowerName() + " Tower at " + GameController.getSellTowerPosition() + " has been sold.\n ");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }
    
    /**
     * set log of pause
     * @throws ParseException
     * @throws IOException
     */
    public void pause() throws ParseException, IOException{  
    	try {   
           
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
          
            long fileLength = randomFile.length();   
           
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " Game paused.\n ");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }
    
    /**
     * set log of replay
     * @throws ParseException
     * @throws IOException
     */
    public void replay() throws ParseException, IOException{  
    	try {   
           
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            
            long fileLength = randomFile.length();   
            
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " Game restart.\n ");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }
    
    /**
     * set log of endGame
     * @throws ParseException
     * @throws IOException
     */
    public void endGame() throws ParseException, IOException{  
    	try {   
           
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
           
            long fileLength = randomFile.length();   
            
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " Game Over.\n ");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }
} 
