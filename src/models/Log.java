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
	
	Date date = new Date();   //��ȡ��ǰʱ��  
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //�����ļ�����ʱ���ʽ  
	String formatDate = sdf.format(date);   //�ѵ�ǰʱ���Զ���ĸ�ʽ ��ʽ��  
    //String name = "D:/"+GameApplicationFrame.APP_NAME+".txt";   //����ļ���  
	String name = "/Users/Ethan/Desktop/"+ GameApplicationFrame.APP_NAME + ".txt";
	
    
    public void createFile() throws ParseException, IOException{  
       try{
    	   File f = new File(name);
    	   f.delete();
    	   RandomAccessFile out_rand = new RandomAccessFile(name,"rw"); 
    	   out_rand.writeBytes(formatDate + " Game Started! \n");  //д��ʱ��  
    	   out_rand.close();  
       }catch (IOException e) {   
           e.printStackTrace();   
       }   
        
    }
    
    public void startWave() throws ParseException, IOException{  
    	try {   
            // ��һ����������ļ���������д��ʽ   
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            // �ļ����ȣ��ֽ���   
            long fileLength = randomFile.length();   
            // ��д�ļ�ָ���Ƶ��ļ�β��   
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " Wave " + GameController.getWaveNumber() + " start! \n");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }   
    public void endWave() throws ParseException, IOException{  
    	try {   
            // ��һ����������ļ���������д��ʽ   
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            // �ļ����ȣ��ֽ���   
            long fileLength = randomFile.length();   
            // ��д�ļ�ָ���Ƶ��ļ�β��   
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " Wave " + GameController.getWaveNumber() + " end! \n");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    } 
    
    public void buildTower() throws ParseException, IOException{  
    	try {   
            // ��һ����������ļ���������д��ʽ   
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            // �ļ����ȣ��ֽ���   
            long fileLength = randomFile.length();   
            // ��д�ļ�ָ���Ƶ��ļ�β��   
            randomFile.seek(fileLength);  
            randomFile.writeBytes(formatDate + " The " + GameController.selectedTowerToBuild() + " Tower has been build. " +"\n");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }  
    	
    }  
    
    public void updateTower() throws ParseException, IOException{  
    	try {   
            // ��һ����������ļ���������д��ʽ   
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            // �ļ����ȣ��ֽ���   
            long fileLength = randomFile.length();   
            // ��д�ļ�ָ���Ƶ��ļ�β��   
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " The " + GameController.getUpdateTowerName() + " Tower at " + GameController.getUpdateTowerPosition() + " has been updated to level " + (GameController.getUpdateTowerLevel()+1) + "\n ");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }

    public void sellTower() throws ParseException, IOException{  
    	try {   
            // ��һ����������ļ���������д��ʽ   
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            // �ļ����ȣ��ֽ���   
            long fileLength = randomFile.length();   
            // ��д�ļ�ָ���Ƶ��ļ�β��   
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " The " + GameController.getSellTowerName() + " Tower at " + GameController.getSellTowerPosition() + " has been sold.\n ");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }
    public void pause() throws ParseException, IOException{  
    	try {   
            // ��һ����������ļ���������д��ʽ   
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            // �ļ����ȣ��ֽ���   
            long fileLength = randomFile.length();   
            // ��д�ļ�ָ���Ƶ��ļ�β��   
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " Game paused.\n ");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }
    
    public void replay() throws ParseException, IOException{  
    	try {   
            // ��һ����������ļ���������д��ʽ   
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            // �ļ����ȣ��ֽ���   
            long fileLength = randomFile.length();   
            // ��д�ļ�ָ���Ƶ��ļ�β��   
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " Game restart.\n ");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }
    
    public void endGame() throws ParseException, IOException{  
    	try {   
            // ��һ����������ļ���������д��ʽ   
            RandomAccessFile randomFile = new RandomAccessFile(name, "rw");   
            // �ļ����ȣ��ֽ���   
            long fileLength = randomFile.length();   
            // ��д�ļ�ָ���Ƶ��ļ�β��   
            randomFile.seek(fileLength);   
            randomFile.writeBytes(formatDate + " Game Over.\n ");   
            randomFile.close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }
 
} 
