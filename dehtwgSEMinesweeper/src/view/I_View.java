package view;

import java.util.Observer;

import controller.Controller.GAMESTATE;

import models.Cell;

public interface I_View extends Observer{
	
	void welcomePlayer();
	void tellPlayer(String s);
	void demandPlayerInstructions();
	GAMESTATE demandClick();
	boolean demandTryAgain();
	
	void showCell(Cell c);
	void showAllCells();

}
