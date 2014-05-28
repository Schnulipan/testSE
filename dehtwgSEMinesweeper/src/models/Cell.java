package models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import models.models.CellStateHidden;
import models.models.I_CellState;

public class Cell {

	/*CLASS VARIABLES -------------------------------*/
	/*holds the states a cell can have*/
	public static enum cellState {hidden, open, checked}

	

	/* holds all the possible images a cell can have */
	public static BufferedImage Icons;
	{
		try {
			Icons = ImageIO.read(new File("Icons.gif"));
		} catch (IOException e) {
			System.out.println("Internal Error - couldn´t find Icons.gif");
		}
	}
	public static BufferedImage[][] IconsMatrix;
 
	{
		IconsMatrix = new BufferedImage[6][2];
		IconsMatrix[0][0] = Icons.getSubimage(0, 0, 20, 20);/* hidden */
		IconsMatrix[0][1] = Icons.getSubimage(20, 0, 20, 20);/* open */
		IconsMatrix[1][0] = Icons.getSubimage(0, 20, 20, 20);/* checked */
		IconsMatrix[1][1] = Icons.getSubimage(20, 20, 20, 20);/* bomb */

		IconsMatrix[2][0] = Icons.getSubimage(0, 40, 20, 20);/* 1 */
		IconsMatrix[2][1] = Icons.getSubimage(20, 40, 20, 20);/* 2 */
		IconsMatrix[3][0] = Icons.getSubimage(0, 60, 20, 20);/* 3 */
		IconsMatrix[3][1] = Icons.getSubimage(20, 60, 20, 20);/* 4 */
		IconsMatrix[4][0] = Icons.getSubimage(0, 80, 20, 20);/* 5 */
		IconsMatrix[4][1] = Icons.getSubimage(20, 80, 20, 20);/* 6 */
		IconsMatrix[5][0] = Icons.getSubimage(0, 100, 20, 20);/* 7 */
		IconsMatrix[5][1] = Icons.getSubimage(20, 100, 20, 20);/* 8 */

	}
	/*------------------------*/
	
	
	
	
	/*INSTACE VARIABLES--------------------------------------------------*/	
	private int row, col;
	
	/*holds the cell´s state*/	
	private I_CellState cState;
	

	/*tells if the Cell inherits a bomb*/
	private boolean hasBomb;
	
	/*how many bombs is this cell touching?*/
	private int inTouchWith;
	/*-------------------------------------------------------------------*/
	





	/*CONSTRUCTOR-------*/
	public Cell(int ROW, int COL){
		/*make sure the cell doesn't inherit a bomb*/
		hasBomb = false;
		
		/*set the present state to hidden*/
		cState = new CellStateHidden(this);
		
		inTouchWith = 0;
		
		row = ROW;
		col = COL;
	}
	/*------------------*/



	/*GETTERS AND SETTERS------------------------------------------------------------*/
	public void setCellState(I_CellState state){
		cState = state;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	
	public boolean hasBomb() {
		return hasBomb;
	}

	public void setBomb(boolean hasBomb) {
		this.hasBomb = hasBomb;
	}
	
	public int getInTouchWith() {
		return inTouchWith;
	}

	public void incrementTouch() {
		this.inTouchWith++;
	}
	/*-------------------------------------------------------------------------------*/



	public I_CellState getCellState() {
		return cState;
	}
}
