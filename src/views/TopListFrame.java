package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

public class TopListFrame extends JFrame implements ActionListener{

	private final int TOP_NUMBER = 5;
	JFrame mainFrame = new JFrame();
	JPanel mainPanel = new JPanel();
	JPanel controlPanel = new JPanel();
	JTextArea topList = new JTextArea();
	JTextPane listPane = new JTextPane();
	StyledDocument doc = listPane.getStyledDocument();
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
		topList.append(String.format("%-20s %10s\n\n", "Name", "Score"));
		if(topUser.size() > 0){
			for(int i=0; i< TOP_NUMBER; i++){
				if(i < topUser.size() && topUser.get(i) != null)
					topList.append( String.format("%-20s %10s\n", topUser.get(i), topScore.get(i))); 
				else
					break;
			}
		}
		else{
			topList.append( "No record found!");
		}
		//topList.setText(list);
		topList.setVisible(true);
		topList.setEditable(false);

	}
}
