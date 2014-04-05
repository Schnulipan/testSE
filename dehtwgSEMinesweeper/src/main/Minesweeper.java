package main;

import models.Field;
import view.I_View;
import view.TUI;
import controller.Controller;
import controller.Controller.GAMESTATE;

public class Minesweeper {


	private static Controller controller;
	private static I_View view;
	static GAMESTATE gamestate = GAMESTATE.running;
	
	
	public static void main(final String[] args)
	{
		controller = new Controller(new Field());
		view = new TUI(controller);
		
		view.welcomePlayer();
		view.demandPlayerInstructions();
		
		
		do{
			view.showAllCells();/*das sollte durch das observerpattern im controller geregelt werden...TODO*/
		}while((gamestate = view.demandClick()) == GAMESTATE.running);
		
		view.showAllCells();
		if(gamestate == GAMESTATE.lost)
		{
			view.tellPlayer("Sorry! You just lost the game!");
		}
		else{
			view.tellPlayer("CONGRATULATIONS YOU WON!!!!");
		}
		
	}

}
