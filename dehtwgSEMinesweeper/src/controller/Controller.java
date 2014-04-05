package controller;

import java.util.Date;
import java.util.Observable;
import java.util.Random;

import models.Cell;
import models.Cell.cellState;
import models.Field;

public class Controller extends Observable{
	
	/*CLASS VARIABLES -----*/
	public static enum GAMESTATE {lost, won, running}
	public static boolean gameRunning = false; /*definitely will be useful*/
	/*---------------------*/
	
	
	/*INSTANCE VARIABLES-------------*/
	public Field field;
	public int freeFieldsLeft;
	/*-------------------------------*/
	
	
	/*CONSTRUCTOR------------------------------*/
	public Controller(Field f)
	{
		field = f;
		
	}
	/*-----------------------------------------*/
	
	
	/*PUBLIC METHODS----------------------------------------*/
	
	
	public boolean segregateBombs(int bombPercentage, String out)
	{
		int absoluteSize = field.getCols()*field.getRows();
		int absoluteBombs;
		Random rand = new Random();
		rand.setSeed(new Date().getTime());
		
		/*check if the user has chosen a wrong bombPercentage*/
		if((bombPercentage > 100) || (bombPercentage < 0)){
			out = "The percentage - how many Cells will inherit a bomb needs to be a value between 100 and 0!! not " + bombPercentage;
			return false;
		}
		
		/*calculate percentual part of bombs*/
		absoluteBombs = absoluteSize * bombPercentage/100;
		
		/*if by percentage, there should be less than 1 bomb, place at least 1 bomb*/
		if(absoluteBombs < 1)
		{
			absoluteBombs = 1;
		}
		freeFieldsLeft = absoluteSize - absoluteBombs;		
		
		int b = 0; /*stores the bamount of bombs that have already been placed*/
		Cell[][] cells = field.getCells();
		while(b < absoluteBombs)
		{
			for(int i = 0; i < field.getRows(); i++){
				for(int o = 0; o < field.getCols(); o++){
					if(!cells[i][o].hasBomb()){
						if((rand.nextInt(2) == 0) && (b < absoluteBombs)){
							/*give the cell a bomb*/
							cells[i][o].setBomb(true);
							
							/*tell the fields arround, that they´re touching a bomb*/
							for(int a = i-1; a < i+1; a++){
								for(int x = o-1; x < o+1; x++){
									if(cellIsInField(a, x)){
										cells[a][x].incrementTouch();
									}
								}
							}
							
							System.out.println("cell[" + i + "][" + o + "] inherits a bomb  -  only for testing  - comes from Field - segregateBombs");
							if(++b >= absoluteBombs){
								i = field.getRows();
								o = field.getCols();
								break;
							}
						}
					}
				}
			}
			
		}
		out = "DONE!";
		return true;
	}
	
	/*clicks a cell ad returns false if a bomb was clicked or true if the game goes on*/
	public GAMESTATE clickCell(int ROW, int COL){

		field.getCells()[ROW][COL].setState(cellState.open);
		
		/*first check if the selected cell inherits a bomb*/
		if(field.getCells()[ROW][COL].hasBomb()){			
			/*the player has lost and now we will open all bombs*/
			for(int i = 0; i < field.getRows(); i++){
				for(int o = 0; o < field.getCols(); o++){
					if(field.getCells()[i][o].hasBomb()){
						field.getCells()[i][o].setState(cellState.open);
					}
				}
			}
			return GAMESTATE.lost;
		}
		
		System.out.println("freefields left : " + freeFieldsLeft);
		if(--freeFieldsLeft == 0){return GAMESTATE.won;}
		return GAMESTATE.running;
	}
	
	
	/*checks if a cell lays between 0 and the row- and col size*/
	private boolean cellIsInField(int row, int col)
	{
		if(row < field.getRows() && row >= 0){
			if(col < field.getCols() && col >= 0){
				return true;
			}
		}
		return false;
	}
	/*------------------------------------------------------*/

}
   