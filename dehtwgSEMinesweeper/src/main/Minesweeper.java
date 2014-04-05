package main;

import models.Field;
import view.I_View;
import view.TUI;
import controller.Controller;

public class Minesweeper {


	private static Controller controller;
	private static I_View view;
	
	
	public static void main(final String[] args)
	{
		controller = new Controller(new Field());
		view = new TUI(controller);
		
		view.welcomePlayer();
		view.demandPlayerInstructions();

		/*TODO SAUBERE ABBRUCHBEDINGUNG EINFÜGEN!!!!*/
		while(true)
		{
			view.showAllCells();
			view.demandClick();
			
		}
	}

}
