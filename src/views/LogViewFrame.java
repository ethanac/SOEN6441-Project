package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This method is to create a frame of viewing log
 * @author Zhoujian Lan
 * @version 3.0.0
 *
 */
public class LogViewFrame extends JFrame implements ActionListener{
	JFrame mainFrame = new JFrame();
	JPanel mainPanel = new JPanel();
	JPanel controlPanel = new JPanel();
	JTextArea log = new JTextArea("Log is displayed here.", 10, 40);
	JScrollPane sp = new JScrollPane(log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JButton bViewAll = new JButton("View All log");
	JButton bViewAllTower = new JButton("View all towers log");
	JButton bViewByWave = new JButton("View log in a wave");
	JTextField waveNumber = new JTextField("Enter wave number here.");
	String fName = "/Users/Ethan/Desktop/Team 8 -- Tower Defense.txt";
	int number = 0;
	boolean ifMatch = false;
	String title = "View Log";
	
	public LogViewFrame(){
		init();
		bViewAll.addActionListener(this);
		bViewAllTower.addActionListener(this);
		bViewByWave.addActionListener(this);
	}
	
	/**
	 * Get and respond to an action
	 * @param e
	 */
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == bViewAll){
			getLog("all");
		}
		else if(e.getSource() == bViewAllTower){
			getLog("tower");
		}
		else if(e.getSource() == bViewByWave){
			String wn = waveNumber.getText();
			try{
				number = Integer.parseInt(wn);
			}
			catch(NumberFormatException nfe){
				log.setText("Please enter the wave number first!");
			}
			getLog("wave");
		}
	}
	
	/**
	 * initialization
	 */
	public void init(){
		sp.setBounds(20,30, 100, 40);
		sp.setVisible(true);
		mainPanel.setDoubleBuffered(true);
		//mainPanel.add(log);
		mainPanel.add(sp);
		mainPanel.setVisible(true);
		controlPanel.setDoubleBuffered(true);
		controlPanel.add(bViewAll);
		controlPanel.add(bViewAllTower);
		controlPanel.add(bViewByWave);
		controlPanel.add(waveNumber);
		controlPanel.setVisible(true);
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		add(mainPanel);
		add(controlPanel);
		this.setResizable(false);
		setSize(500,300);
		setTitle(title);       														
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * This method is to get log
	 * @param option
	 */
	public void getLog(String option){
		try{
			log.setText("");
			File logFile = new File(fName);
			String newline = "";
			Scanner sc = new Scanner(new BufferedReader(new FileReader(logFile)));
			while(sc.hasNextLine() && (newline = sc.nextLine()) != null){
 				if(option.equals("all"))
 					log.append(newline+"\n");
 				else if(option.equals("tower")){
 					if(newline.contains("Tower"))
 						log.append(newline+"\n");
 				}
 				else if(option.equals("wave")){
 					if(!ifMatch){
 						if(newline.contains("Wave "+number+" start!")){
 							log.append(newline+"\n");
 							ifMatch = true;
 						}
 					}
 					else{
 						log.append(newline+"\n");
 						if(newline.contains("Wave "+number+" end!")){
 							ifMatch = false;
 							break;
 						}
 					}
 				}
 			}
 			sc.close();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}
