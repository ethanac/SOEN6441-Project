package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.GameController;
import models.TDMap;

/**
 * This class is used for getting user name from the user.
 * The user name is passed to GameController.
 * @author Hao Zhang
 *
 */
public class UserFrame extends JFrame implements ActionListener{
	/**
	 * Constants
	 */
	private final int UFHEIGHT = 200;
	private final int UFWIDTH = 400;
	/*
	 * Panels, buttons and labels used in this frame.
	 */
	JPanel userPanel = new JPanel();
	JPanel notePanel = new JPanel();
	JPanel controlPanel = new JPanel();
	JButton bBack = new JButton("Back to Main Menu");
	JButton bForward = new JButton("Forward to Game");
	JLabel namelabel= new JLabel("User Name: ", JLabel.RIGHT);
	JLabel note = new JLabel("Please enter your user name.");
	JTextField tField = new JTextField("YourName",30);
	
	private String title = "User name";
	private String fPath = "";
	private TDMap mapToLoad;
	
	/**
	 * Constructor.
	 * @param gc  set user name of this game controller.
	 */
	public UserFrame(TDMap map, String fPath){
		init();
		bBack.addActionListener(this);
		bForward.addActionListener(this);
		this.fPath = fPath;
		mapToLoad = map;
	}
	
	/**
	 * Get and respond to an action.
	 * @param e  Mouse action
	 */
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == bBack){
			this.dispose();
			new MenuApplicationFrame();
		}else if(e.getSource() == bForward){
			if(tField.getText().equals(""))
				note.setText("User name cannot be empty!");
			else{
				if(fPath.equals(""))
					new GameApplicationFrame(mapToLoad, tField.getText());
				else
					new GameApplicationFrame(mapToLoad, fPath, tField.getText());
				this.dispose();
			}
		}
	}
	
	/**
	 * Initialize the frame.
	 */
	private void init(){
		this.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
		            System.exit(0);
	         } 
		});
		userPanel.setDoubleBuffered(true);
		userPanel.setVisible(true);
		userPanel.add(namelabel);
		userPanel.add(tField);
		notePanel.add(note);
		notePanel.setVisible(true);
		controlPanel.setVisible(true);
		controlPanel.add(bBack);
		controlPanel.add(bForward);
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		add(userPanel);
		add(notePanel);
		add(controlPanel);
		this.setResizable(false);
		setSize(UFWIDTH, UFHEIGHT);
		setTitle(title);       														
		setLocationRelativeTo(null);
		setVisible(true);
	}	
}
