package models.models;

import controller.Controller.GAMESTATE;
import models.Cell;

public interface I_CellState {

	
	GAMESTATE click();
	boolean isOpen();
	boolean isChecked();
	boolean isHidden();
}
