package models.models;

import models.Cell;
import controller.Controller;
import controller.Controller.GAMESTATE;

public class CellStateChecked implements I_CellState{
	
	
	private Cell c;
	private Controller con;
	
	
	public CellStateChecked(Cell cell, Controller controller){
		this.c = cell;
		this.con = controller;
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

}
