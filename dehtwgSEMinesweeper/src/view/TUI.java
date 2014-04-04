package view;

import java.util.Observable;

import models.Cell;
import models.Field;
import controller.Controller;

public class TUI implements I_View{
	
	/*CLASS VARIABLES--------*/
	private static char[] icons;
	{
		icons = new char[4];
		icons[0] = 'O';
		icons[1] = ' ';
		icons[2] = 'P';
		icons[3] = 'X';		
	}
	/*-----------------------*/
	
	/*INSTANCE VARIABLES----------*/
	private Controller controller;
	
	/*----------------------------*/
	
	
	
	/*CONSTRUCTOR--------------------------*/
	public TUI(Controller c)
	{
		this.controller = c;
		c.addObserver(this);
	}
	/*-------------------------------------*/
	
	
	
	/*INHERITED METHODS ------------------------------------------*/
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showCell(Cell c) {
		Cell.cellState state = c.getState();
		
		/*decide what will be printed - dependent on the cell´s state*/
		switch(state)
		{
		case open:
			if(c.hasBomb()){
				System.out.println("X");
				break;
			}
			System.out.print(" ");
			break;
		case hidden:
			System.out.print("O");
			break;
		case checked:
			System.out.print("P");
			break;
		}
	}

	@Override
	public void showAllCells(Field f) {
		int row = f.getRows();
		int col = f.getCols();
		Cell[][] c = f.getCells();
		
		/*print out all the cells*/
		for(int i = 0; i < row; i++){
			for(int o = 0; o < col; o++){
				showCell(c[i][o]);
			}
			System.out.println();/*this will begin a new line*/
		}
		
	}
	/*------------------------------------------------------------*/
}
