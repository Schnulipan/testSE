package view;

import java.util.Observer;

import controller.Controller.GAMESTATE;

import models.Cell;
import models.Field;

public interface I_View extends Observer{
	
	void tellPlayer(String s);
	void welcomePlayer();
	void demandPlayerInstructions();
	GAMESTATE demandClick();
	
	void showCell(Cell c);
	void showAllCells();

}
