package models.models;

import models.Cell;
import controller.Controller;
import controller.Controller.GAMESTATE;

public class CellStateOpen implements I_CellState{
	
	private Cell c;
	private Controller con;
	

	public CellStateOpen(Cell c, Controller controller) {
		this.c = c;
		con = controller;
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

}
