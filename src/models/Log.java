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
 * 
 * 
 */  
  
public class Log { 
	
	Date date = new Date();   //获取当前时间  
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //定义文件内容时间格式  
	String formatDate = sdf.format(date);   //把当前时间以定义的格式 格式化  
    String name = "D:/"+GameApplicationFrame.APP_NAME+".txt";   //获得文件名  
	
	
    
    public void createFile() throws ParseException, IOException{  
       try{
    	   File f = new File(name);
    	   f.delete();
    	   RandomAccessFile out_rand = new RandomAccessFile(name,"rw"); 
    	   out_rand.writeBytes(formatDate + " Game Started! \n");  //写入时间  
    	   out_rand.close();  
       }catch (IOException e) {   
           e.printStackTrace();   
       }   
        
    }
    
    public void startWave() throws ParseException, IOException{  
    	try {   
            // 打开一个随机访问文件流，按读写方式   
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            // 文件长度，字节数   
            long fileLength = randomFile.length();   
            // 将写文件指针移到文件尾。   
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " Wave " + GameController.getWaveNumber() + " start! \n");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }   
    public void endWave() throws ParseException, IOException{  
    	try {   
            // 打开一个随机访问文件流，按读写方式   
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            // 文件长度，字节数   
            long fileLength = randomFile.length();   
            // 将写文件指针移到文件尾。   
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " Wave " + GameController.getWaveNumber() + " end! \n");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    } 
    
    public void buildTower() throws ParseException, IOException{  
    	try {   
            // 打开一个随机访问文件流，按读写方式   
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            // 文件长度，字节数   
            long fileLength = randomFile.length();   
            // 将写文件指针移到文件尾。   
            randomFile.seek(fileLength);  
            randomFile.writeBytes(formatDate + " The " + GameController.selectedTowerToBuild() + " Tower has been build. " +"\n");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }  
    	
    }  
    
    public void updateTower() throws ParseException, IOException{  
    	try {   
            // 打开一个随机访问文件流，按读写方式   
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            // 文件长度，字节数   
            long fileLength = randomFile.length();   
            // 将写文件指针移到文件尾。   
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " The " + GameController.getUpdateTowerName() + " Tower at " + GameController.getUpdateTowerPosition() + " has been updated to level " + (GameController.getUpdateTowerLevel()+1) + "\n ");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }

    public void sellTower() throws ParseException, IOException{  
    	try {   
            // 打开一个随机访问文件流，按读写方式   
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            // 文件长度，字节数   
            long fileLength = randomFile.length();   
            // 将写文件指针移到文件尾。   
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " The " + GameController.getSellTowerName() + " Tower at " + GameController.getSellTowerPosition() + " has been sold.\n ");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }
    public void pause() throws ParseException, IOException{  
    	try {   
            // 打开一个随机访问文件流，按读写方式   
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            // 文件长度，字节数   
            long fileLength = randomFile.length();   
            // 将写文件指针移到文件尾。   
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " Game paused.\n ");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }
    
    public void replay() throws ParseException, IOException{  
    	try {   
            // 打开一个随机访问文件流，按读写方式   
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            // 文件长度，字节数   
            long fileLength = randomFile.length();   
            // 将写文件指针移到文件尾。   
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " Game restart.\n ");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }
    
    public void endGame() throws ParseException, IOException{  
    	try {   
            // 打开一个随机访问文件流，按读写方式   
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            // 文件长度，字节数   
            long fileLength = randomFile.length();   
            // 将写文件指针移到文件尾。   
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " Game Over.\n ");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }
 
} 
