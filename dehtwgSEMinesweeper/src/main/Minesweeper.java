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
	public static boolean contin = true;
	
	public static String errMessage = null;
	
	
	public static void main(final String[] args)
	{
		
		
		
		while(contin){
			contin = false;
			controller = new Controller(new Field());
			view = new TUI(controller);
			
			view.welcomePlayer();
			view.demandPlayerInstructions();
			
			do{
				view.showAllCells();/*TODO das sollte durch das observerpattern im controller geregelt werden...*/
			}while((gamestate = view.demandClick()) == GAMESTATE.running);
			
			view.showAllCells();
			if(gamestate == GAMESTATE.lost)
			{
				view.tellPlayer("Sorry! You just lost the game!");
				contin = view.demandTryAgain();
			}
			else if(gamestate == GAMESTATE.quit){
				view.tellPlayer("okay then... bye");
			}
			else{
				view.tellPlayer("CONGRATULATIONS YOU WON!!!!");
				contin = view.demandTryAgain();
			}
			
			

		}
		
	}

}
