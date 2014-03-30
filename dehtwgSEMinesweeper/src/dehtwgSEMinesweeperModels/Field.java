package dehtwgSEMinesweeperModels;

import java.io.IOException;

import dehtwgSEMinesweeperModels.Cell.cellState;

public class Field {
	
	/*INSTANCEVARIABLES--------------------------*/
	/*holds all the cells of the game - will be filled in the constructor*/
	private Cell[][] cells;
	
	/*hold the row/col numbers*/
	private int rows;
	private int cols;
	/*-------------------------------------------*/
	
	
	
	
	/*CONSTRUCTOR-----------*/
	public Field(int ROW, int COL) throws IOException{
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
						cells[i][o].setPresentIcon(cells[i][o].getIcons().getSubimage(20, 20, 20, 20));
					}
				}
			}
			return false;
		}
		
		/*open only the selected cell*/
		cells[ROW][COL].setPresentIcon(cells[ROW][COL].getIcons().getSubimage(20, 0, 20, 20));
		return true;
	}
	/*--------------------------------------*/
	
	
	
	
	

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
