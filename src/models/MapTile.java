package models;

/**
 *
 * This class refers to the Tiles that are associated to the TDMap class.
 * 
 * @author Hao Zhang
 * @version v1.0.0
 */
public class MapTile {
	private int tileValue;
	private Tower towerOnTile;
	
    /**Constructor
     *
     */
    public MapTile(){
		tileValue = 0;
		
	}

    /**
     *
     * @return tileValue
     */
    public int getTileValue(){
		return tileValue;
	}

    /**
     *
     * @param tv
     */
    public void setTileValue(int tv){
		tileValue = tv;
	}

    /**
     *
     * @return
     */
    public Tower getTowerOnTile(){
		return towerOnTile;
	}

    /**
     *
     * @param tow
     */
    public void setTowerOnTile(Tower tow){
		towerOnTile = tow;
	}
}
