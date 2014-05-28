package models.models;

import java.awt.image.BufferedImage;

import controller.Controller.GAMESTATE;

public interface I_CellState {

	/*Methods for Controller*/
	GAMESTATE click();
	
	/*Methods for View*/
	BufferedImage getCellImage();
	
	/*Methods evera class could need*/
	boolean isOpen();
	boolean isChecked();
	boolean isHidden();
}
