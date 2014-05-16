package models.models;

import models.Cell;

public class CellStateHidden implements CellState{

	private Cell c;
	
	public CellStateHidden(Cell cell)  {
		c = cell;
	}
	
	@Override
	public void click() {
		if(c.hasBomb()){
			
		}
		else{
			
		}
		
	}

}
