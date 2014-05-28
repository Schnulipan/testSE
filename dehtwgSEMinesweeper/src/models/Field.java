package models;

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
				cells[i][o] = new Cell(i, o);
		}
	}
	
	
	/*----------------------*/
	
	
	
	/*PUBLIC METHODS------------------------*/
	
	
	
	/*defines the fields size (how many cells are played with)*/
	public void initialize(int ROW, int COL)
	{
		this.rows = ROW;
		this.cols = COL;
		this.cells = new Cell[ROW][COL];
		
		for(int i = 0; i < rows; i++){
			for(int o = 0; o < cols; o++){
				cells[i][o] = new Cell(i, o);
			}
		}
	}	
	
	
	/*--------------------------------------juhu*/
	
	
	
	
	/*PRIVATE METHODS----------------------------------------*/
	
	/*-------------------------------------------------------*/
	
	
	
	

	/*GETTERS AND SETTERS-------------------------------------------*/
	public Cell[][] getCells() {
		return cells;
	}
	
	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	/*--------------------------------------------------------------*/

}
