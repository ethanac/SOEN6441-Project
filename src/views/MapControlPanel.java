package views;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Point;
import models.TDMap;

/**
 *	This is the map control panel of map editor
 *	It creates map control panel by setting its combo boxes and buttons
 * 
 *	@author Meng Yao
 *	@author Xingjian Zhang
 *	@version 1.0.0 
 */
public class MapControlPanel extends JPanel{

	JLabel lblWidthLabel = new JLabel("Width = ");
	JLabel lblHeightLabel = new JLabel("Height = ");
	JLabel lblStartLabel = new JLabel("Start = (,)");
	JLabel lblEndLabel = new JLabel("End = (,)");
	JLabel lblStatus = new JLabel("Status:");
	JLabel lblFormatLabel = new JLabel(" | ");
	JComboBox widthList;
	JComboBox heightList;
	JButton bInitialize = new JButton("Re-Initialize the Map");

	JButton bReturn = new JButton("Main Menu");
	JButton bSave = new JButton("Save Map");
	TDMap tdMap;
	JButton bSelectStart = new JButton("Select start");
	JButton bSelectEnd = new JButton("Select end");
	
    /**
     *	Constructor of MapControlPanel
     *  @param map
     */
    public MapControlPanel(TDMap map){
        //add the info label to this panel
		this.tdMap= map;
        this.add(lblWidthLabel);
        this.setWidthIndexes();
        this.add(widthList);
        this.add(lblHeightLabel);
        this.setHeightIndexes();
        this.add(heightList);
        this.add(bInitialize);
        this.add(lblStartLabel);
        this.add(bSelectStart);
        this.add(lblEndLabel);
        this.add(bSelectEnd);
        this.add(lblFormatLabel);

        this.add(bSave);
        this.add(bReturn);
        this.add(lblStatus);

	}
    
    /**
     *	Setter of status
     * 	@param text
     */
    public void setStatusText(String text){
    		lblStatus.setText(text);
    }
    
    /**
     *	Getter of initialize button
     *  @return bInitialize
     */
    public JButton getInitializeButton(){
		return bInitialize;
	}

    /**
     *	Getter of return button
     *  @return bReturn
     */
    public JButton getReturnButton(){
		return bReturn;
	}

   /* public JButton getSetStartAndEndButton() {
		return bSetStartAndEnd;
	}*/

    /**
     * 	Getter of save button
     *  @return bSave
     */
    public JButton getSaveButton()
	{
		return bSave;
	}
    
    /**
     *  Getter of select start point button
     *  @return bSelectStart
     */
    public JButton getSelectStartButton(){
    	return bSelectStart;
    }
    
    /**
     *  Getter of select end point button
     *  @return
     */
    public JButton getSelectEndButton(){
    	return bSelectEnd;
    }
    
    /**
     *  Setter of start point text on label
     *  @param p
     */
    public void setStartPointLabel(Point p){
    	lblStartLabel.setText("Start (" + p.getX() + ", " + p.getY() + ")");
    }
    
    /**
     *  Setter of end point text on label
     *  @param p
     */
    public void setEndPointLabel(Point p){
    	lblEndLabel.setText("End (" + p.getX() + ", " + p.getY() + ")");
    }

    /**
     *	Getter of width indexes
     *  @return widthList
     */
    public JComboBox getWidthIndexes()
	{
		return widthList;
	}

    /**
     *	Sets all of the indices for the widths and puts them into an existing JCOmbobox
     */
    public void setWidthIndexes()
	{
		String[] widths = new String[TDMap.MAXWIDTH-TDMap.MINWIDTH+1];
		for(int i=TDMap.MINWIDTH, j=0; i<=TDMap.MAXWIDTH; i++, j++)
		{
			widths[j]= Integer.toString(i);
		}
		widthList = new JComboBox(widths);
	}

    /**
     *	Getter of height indexes
     *  @return heightList
     */
    public JComboBox getHeightIndexes()
	{
		return heightList;
	}

    /**
     *	Sets all of the indices for the heights and puts them into an existing JCombobox
     */
    public void setHeightIndexes()
	{

		String[] heights = new String[TDMap.MAXHEIGHT-TDMap.MINHEIGHT+1];
		for(int i=TDMap.MINHEIGHT, j=0; i<=TDMap.MAXHEIGHT; i++, j++)
		{
			heights[j]= Integer.toString(i);
		}
		heightList = new JComboBox(heights);
	}
	
	
}