package test.view;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import models.Point;
import models.TDMap;
import views.MapControlPanel;

public class ViewTestMapControlPanel {
	
	private TDMap map = new TDMap();
	private ArrayList<MapControlPanel> Amcp = new ArrayList<MapControlPanel>();
	private Point point = new Point(20,10);
	
	@Before
	public void setUp() {
		map = new TDMap();
		point = new Point(20,10);
		Amcp = new ArrayList<MapControlPanel>();
		for(int i=0; i<100; i++){
			Amcp.add(new MapControlPanel(map));
		}
	}

	@Test
	public void testSetStatusText(){
    		for(int i=0; i<100; i++){
    			Amcp.get(i).setStatusText("I am status text.");
    		}
    }
    
	@Test
    public void testGetInitializeButton(){
    		for(int i=0; i<100; i++){
			assertNotNull(Amcp.get(i).getInitializeButton());
		}
	}

    @Test
    public void testGetReturnButton(){
		for(int i=0; i<100; i++){
			assertNotNull(Amcp.get(i).getReturnButton());
		}
    }	

    @Test
    public void testGetSaveButton(){
		for(int i=0; i<100; i++){
			assertNotNull(Amcp.get(i).getSaveButton());
		}
    }	
    
    @Test
    public void testGetSelectStartButton(){
		for(int i=0; i<100; i++){
			assertNotNull(Amcp.get(i).getSelectStartButton());
		}
    }
    
    @Test
    public void testGetSelectEndButton(){
		for(int i=0; i<100; i++){
			assertNotNull(Amcp.get(i).getSelectEndButton());
		}
    }
    
    @Test
    public void testSetStartPointLabel(){
    		for(int i=0; i<100; i++){
    			Amcp.get(i).setStartPointLabel(point);
    		}
    }

    @Test
    public void testSetWidthIndexes()
	{
    		for(int i=0; i<100; i++){
			Amcp.get(i).setWidthIndexes();
		}
    		for(int i=1; i<100; i++){
			assertNotNull(Amcp.get(i).getWidthIndexes());
		}
	}

    @Test
    public void testSetHeightIndexes()
	{
    		for(int i=0; i<100; i++){
			Amcp.get(i).setHeightIndexes();
		}
    		for(int i=1; i<100; i++){
			assertNotNull(Amcp.get(i).getHeightIndexes());
		}
	}
}
