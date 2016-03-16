package test.view;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

import org.junit.Before;
import org.junit.Test;

import models.Point;
import models.TDMap;
import views.MapControlPanel;

/**
 *  The test for MapControlPanel class in the view package.
 * 
 *	@author HaoZhang
 *	@version 1.1.0
 */
public class ViewTestMapControlPanel {
	
	private TDMap map = new TDMap();
	private ArrayList<MapControlPanel> Amcp = new ArrayList<MapControlPanel>();
	private Point point = new Point(64,41);
	/**
	 * An array of string for any test case which needs a string as a parameter.
	 */
	private String[] s = {"I am string 1",
						"I am string 2",
						"I am string 3",
						"I am string 4",
						"I am string 5"
	};
	
	/**
	 *  Initializing an ArrayList of TDMap.
	 */
	@Before
	public void setUp() {
		map = new TDMap();
		point = new Point(20,10);
		Amcp = new ArrayList<MapControlPanel>();
		for(int i=0; i<100; i++){
			Amcp.add(new MapControlPanel(map));
		}
	}

	/**
	 *  test SetStatusText
	 */
	@Test
	public void testSetStatusText(){
		for(int i=0; i<100; i++){
    			Amcp.get(i).setStatusText(s[i%5]);
    			assertEquals(s[i%5], Amcp.get(i).getStatusText());
    		}
    }
    
	/**
	 *  test GetInitializeButton
	 */
	@Test
    public void testGetInitializeButton(){
		JButton bInitialize = new JButton("Re-Initialize the Map");
		for(int i=0; i<100; i++){
			JButton b = Amcp.get(i).getInitializeButton();
			assertEquals(b.getText(), bInitialize.getText());
		}
	}

	/**
	 *  test GetReturnButton
	 */
    @Test
    public void testGetReturnButton(){
    		JButton bReturn = new JButton("Main Menu");
    		for(int i=0; i<100; i++){
			JButton b = Amcp.get(i).getReturnButton();
    			assertEquals(b.getText(), bReturn.getText());
		}
    }	

    /**
	 *  test GetSaveButton
	 */
    @Test
    public void testGetSaveButton(){
    		JButton bSave = new JButton("Save Map");
    		for(int i=0; i<100; i++){
			JButton b = Amcp.get(i).getSaveButton();
    			assertEquals(b.getText(), bSave.getText());
		}
    }	
    
    /**
     * test GetSelectStartButton
     */
    @Test
    public void testGetSelectStartButton(){
    		JButton bSelectStart = new JButton("Select start");
    		for(int i=0; i<100; i++){
			JButton b = Amcp.get(i).getSelectStartButton();
    			assertEquals(b.getText(), bSelectStart.getText());
		}
    }
    
    /**
     * test GetSelectEndButton
     */
    @Test
    public void testGetSelectEndButton(){
    		JButton bSelectEnd = new JButton("Select end");
    		for(int i=0; i<100; i++){
			JButton b = Amcp.get(i).getSelectEndButton();
    			assertEquals(b.getText(), bSelectEnd.getText());
		}
    }
    
    /**
     * test SetStartPointLabel
     */
    @Test
    public void testSetStartPointLabel(){
    		String info = "Start (" + point.getX() + ", " + point.getY() + ")";
    		for(int i=0; i<100; i++){
    			Amcp.get(i).setStartPointLabel(point);
    			assertEquals(info, Amcp.get(i).getStartPointLabel());
    		}
    }
    
    /**
     * test SetEndPointLabel
     */
    @Test
    public void testSetEndPointLabel(){
    		String info = "End (" + point.getX() + ", " + point.getY() + ")";
    		for(int i=0; i<100; i++){
    			Amcp.get(i).setEndPointLabel(point);
    			assertEquals(info, Amcp.get(i).getEndPointLabel());
    		}
    }

    /**
     * test SetWidthIndexes
     */
    @Test
    public void testSetWidthIndexes()
	{
    		for(int i=0; i<100; i++){
			Amcp.get(i).setWidthIndexes();
		}
    		for(int i=1; i<100; i++){
    			JComboBox<?> w = Amcp.get(i).getWidthIndexes();
    			for(int k=TDMap.MINWIDTH, j=0; k<=TDMap.MAXWIDTH; k++, j++)
    			{
    				assertEquals(w.getItemAt(j),Integer.toString(k));
    			}
		}
	}

    /**
     * test SetHeightIndexes.
     */
    @Test
    public void testSetHeightIndexes()
	{
    		for(int i=0; i<100; i++){
			Amcp.get(i).setHeightIndexes();
		}
    		for(int i=1; i<100; i++){
    			JComboBox<?> w = Amcp.get(i).getWidthIndexes();
    			for(int k=TDMap.MINWIDTH, j=0; k<=TDMap.MAXWIDTH; k++, j++)
    			{
    				assertEquals(w.getItemAt(j),Integer.toString(k));
    			}
		}
	}
}
