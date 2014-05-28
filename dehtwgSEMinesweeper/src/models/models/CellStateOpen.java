package models.models;

import java.awt.image.BufferedImage;

import models.Cell;
import controller.Controller.GAMESTATE;

public class CellStateOpen implements I_CellState{
	
	private Cell c;
	

	public CellStateOpen(Cell c) {
		this.c = c;
	}
	
	
	

	@Override
	public GAMESTATE click() {
		return GAMESTATE.running;
	}

	@Override
	public boolean isOpen() {
		return true;
	}

	@Override
	public boolean isChecked() {
		return false;
	}

	@Override
	public boolean isHidden() {
		return false;
	}



	/*for VIEW*/
	@Override
	public BufferedImage getCellImage() {
		if(c.hasBomb()){
			return Cell.IconsMatrix[1][1];
		}
		
		else{
			switch(c.getInTouchWith()){
			case 0:
				return Cell.IconsMatrix[0][1];
			case 1:
				return Cell.IconsMatrix[2][0];
			case 2:
				return Cell.IconsMatrix[2][1];
			case 3:
				return Cell.IconsMatrix[3][0];
			case 4:
				return Cell.IconsMatrix[3][1];
			case 5:
				return Cell.IconsMatrix[4][0];
			case 6:
				return Cell.IconsMatrix[4][1];
			case 7:
				return Cell.IconsMatrix[5][0];
			case 8:
				return Cell.IconsMatrix[5][1];
			}
		}
		return null;
	}




	@Override
	public void check() {
		/*nothing happens - cant check an open cell*/		
	}

}
