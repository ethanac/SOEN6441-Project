package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TopListFrame extends JFrame implements ActionListener{
	private final int NUMBEROFSPACE = 10;
	private final int TOP_NUMBER = 5;
	JFrame mainFrame = new JFrame();
	JPanel mainPanel = new JPanel();
	JPanel controlPanel = new JPanel();
	JTextArea topList = new JTextArea();
	JButton bClose = new JButton("close");
	ArrayList<String> topUser;
	ArrayList<Integer> topScore;
	private String title = "Top 5";
	
	public TopListFrame(ArrayList<String> users, ArrayList<Integer> scores){
		topUser = users;
		topScore = scores;
		init();
		bClose.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == bClose)
			this.dispose();
	}
	
	private void init(){
	
		getTopList();
		mainPanel.setDoubleBuffered(true);
		mainPanel.add(topList);
		mainPanel.setVisible(true);
		controlPanel.setDoubleBuffered(true);
		controlPanel.add(bClose);
		controlPanel.setVisible(true);
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		add(mainPanel);
		add(controlPanel);
		this.setResizable(false);
		setSize(200, 300);
		setTitle(title);       														
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/** 
	 * Get the top 5 list.
	 */
	private void getTopList(){
		String list = "Name" + String.format("%" + NUMBEROFSPACE + "s", " ") + "Score\n";
		if(topUser.size() > 0){
			for(int i=0; i< TOP_NUMBER; i++){
				if(i < topUser.size() && topUser.get(i) != null)
					list += topUser.get(i) + String.format("%" + (NUMBEROFSPACE-topUser.get(i).length()+"name".length()) + "s", " ") + topScore.get(i) +"\n"; 
				else
					break;
			}
		}
		else{
			list = "No record found!";
		}
		topList.setText(list);
		topList.setEditable(false);
	}
}
