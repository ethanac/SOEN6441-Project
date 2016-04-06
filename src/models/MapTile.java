package models;

/**
 *
 * This class refers to the Tiles that are associated to the TDMap class.
 * 
 * @author HaoZhang
 * @version 3.0.0
 */
public class MapTile {
	private int tileValue;
	private Tower towerOnTile;
	
    /**
     * This is the Constructor.
     * It sets the tileValue to 0.
     */
    public MapTile(){
		tileValue = 0;
		
	}

    /**
     * The method to get the tileValue.
     * 
     * @return tileValue
     */
    public int getTileValue(){
		return tileValue;
	}

    /**
     * The method to set the tileValue.
     * 
     * @param tv  An integer as the tileValue.
     */
    public void setTileValue(int tv){
		tileValue = tv;
	}

    /**
     * The method to get the TowerOnTile.
     * 
     * @return towerOnTile
     */
    public Tower getTowerOnTile(){
		return towerOnTile;
	}

    /**
     * The method to set the towerOnTile.
     * 
     * @param tow  A Tower object as the towerOnTile.
     */
    public void setTowerOnTile(Tower tow){
		towerOnTile = tow;
	}
}
