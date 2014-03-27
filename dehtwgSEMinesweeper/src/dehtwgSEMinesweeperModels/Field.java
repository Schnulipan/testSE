package dehtwgSEMinesweeperModels;


public class Field {
	
	
	/*INSTANCEVARIABLES--------------------*/
	/*may only be an even number - will be calculated in constructor*/
	private int numberCells;
	
	/*will be given in the constructor - amount cells in a row/column*/
	private int rows;
	private int cols;
	
	/*stores all the cells for the game*/
	private Cell[][] cells;
	/*-------------------------------------*/
	
	
	
	
	
	
	/*CONSTRUCTOR-----------------------------------------*/
	public Field(int ROWS, int COLS){
		this.rows = ROWS;
		this.cols = COLS;
		this.numberCells = rows*cols;
		
		this.cells = new Cell[rows][cols];		
	}
	/*----------------------------------------------------*/
	

}
