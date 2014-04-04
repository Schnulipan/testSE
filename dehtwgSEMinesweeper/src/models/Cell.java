package models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cell {

	/*CLASS VARIABLES -------------------------------*/
	/*holds the states a cell can have*/
	public static enum cellState {hidden, open, checked}

	/*-----------------------------------------------*/
	
	
	
	
	/*INSTACE VARIABLES--------------------------------------------------*/	
	/*holds the cell´s state*/
	private cellState state;
	
	/*tells if the Cell inherits a bomb*/
	private boolean hasBomb;
	/*-------------------------------------------------------------------*/
	





	/*CONSTRUCTOR-------*/
	public Cell() throws IOException{
		/*make sure the cell doesn't inherit a bomb*/
		hasBomb = false;
		
		/*set the present state to hidden*/
		state = cellState.hidden;
	}
	/*------------------*/





	/*GETTERS AND SETTERS------------------------------------------------------------*/
	public cellState getState() {
		return state;
	}

	public void setState(cellState state) {
		this.state = state;
	}
	
	public boolean hasBomb() {
		return hasBomb;
	}

	public void setBomb(boolean hasBomb) {
		this.hasBomb = hasBomb;
	}
	/*-------------------------------------------------------------------------------*/
}
