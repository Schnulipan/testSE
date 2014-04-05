package models;


import java.util.Date;
import java.util.Random;

import models.Cell.cellState;

public class Field {
	
	/*INSTANCEVARIABLES--------------------------*/
	/*holds all the cells of the game - will be filled in the constructor*/
	private Cell[][] cells;
	
	/*hold the row/col numbers*/
	private int rows;
	private int cols;
	/*-------------------------------------------*/
	
	
	
	
	/*CONSTRUCTOR-----------*/ /*PROBABLY WONT EVER BE USED*/
	/*standard constructor*/
	public Field(){}
	
	public Field(int ROW, int COL){
		this.rows = ROW;
		this.cols = COL;
		
		cells = new Cell[rows][cols];
		for(int i = 0; i < rows; i++)
			for(int o = 0; o < cols; o++){
				cells[i][o] = new Cell();
		}
	}
	
	
	/*----------------------*/
	
	
	
	/*PUBLIC METHODS------------------------*/
	/*clicks a cell ad returns false if a bomb was clicked or true if the game goes on*/
	public boolean clickCell(int ROW, int COL){

		cells[ROW][COL].setState(cellState.open);
		
		/*first check if the selected cell inherits a bomb*/
		if(cells[ROW][COL].hasBomb()){			
			/*the player has lost and now we will open all bombs*/
			for(int i = 0; i < rows; i++){
				for(int o = 0; o < cols; o++){
					if(cells[i][o].hasBomb()){
						cells[i][o].setState(Cell.cellState.open);
					}
				}
			}
			return false;
		}
		
		return true;
	}
	
	
	/*defines the fields size (how many cells are played with)*/
	public void initialize(int ROW, int COL)
	{
		this.rows = ROW;
		this.cols = COL;
		this.cells = new Cell[ROW][COL];
		
		for(int i = 0; i < rows; i++){
			for(int o = 0; o < cols; o++){
				cells[i][o] = new Cell();
			}
		}
	}	
	/*--------------------------------------juhu*/
	
	
	
	
	/*PRIVATE METHODS----------------------------------------*/
	public boolean segregateBombs(int bombPercentage, String out)
	{
		int absoluteSize = rows*cols;
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
		
		System.out.println(absoluteBombs + " -> amount of Bombs - message comes from Field-class - segregateBombs");/*TODO this is only for testing! delete this line!!!!!!!!!*/
		
		int b = 0; /*stores the bamount of bombs that have already been placed*/
		while(b < absoluteBombs)
		{
			for(int i = 0; i < this.rows; i++){
				for(int o = 0; o < this.cols; o++){
					if(!cells[i][o].hasBomb()){
						if((rand.nextInt(2) == 0) && (b < absoluteBombs)){
							cells[i][o].setBomb(true);
							System.out.println("cell[" + i + "][" + o + "] inherits a bomb  -  only for testing  - comes from Field - segregateBombs");
							b++;
						}
					}
				}
			}
			
		}
		out = "DONE!";
		return true;
		
				
		
	}
	/*-------------------------------------------------------*/
	
	
	
	

	/*GETTERS AND SETTERS-------------------------------------------*/
	public Cell[][] getCells() {
		return cells;
	}
	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	/*--------------------------------------------------------------*/

}
