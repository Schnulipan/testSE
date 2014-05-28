package models.models;

import java.awt.image.BufferedImage;

import models.Cell;
import controller.Controller.GAMESTATE;

public class CellStateChecked implements I_CellState{
	
	
	private Cell c;
	
	
	public CellStateChecked(Cell cell){
		this.c = cell;
	}
	
	

	@Override
	public GAMESTATE click() {
		return GAMESTATE.running;
	}

	@Override
	public boolean isOpen() {
		return false;
	}

	@Override
	public boolean isChecked() {
		return true;
	}

	@Override
	public boolean isHidden() {
		return false;
	}



	@Override
	public BufferedImage getCellImage() {
		return Cell.IconsMatrix[1][0];
	}



	@Override
	public void check() {
		c.setCellState(new CellStateHidden(c));
	}

}
