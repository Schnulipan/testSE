package dehtwgSEMinesweeperModels;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cell {

	/*CLASS VARIABLES -------------------------------*/
	/*holds the states a cell can have*/
	public static enum cellState {hidden, open, checked}
	
	/*holds all the possible images a cell can have*/
	public static BufferedImage Icons;
	{
		Icons = ImageIO.read(new File("Icons.gif"));
	}
	public static BufferedImage[][] IconsMatrix;

	{
		IconsMatrix = new BufferedImage[2][2];
		IconsMatrix[0][0] = Icons.getSubimage(0, 0, 20, 20);
		IconsMatrix[0][1] = Icons.getSubimage(20, 0, 20, 20);
		IconsMatrix[1][0] = Icons.getSubimage(0, 20, 20, 20);
		IconsMatrix[1][1] = Icons.getSubimage(20, 20, 20, 20);
	}
	/*-----------------------------------------------*/
	
	
	
	
	/*INSTACE VARIABLES--------------------------------------------------*/	
	/*holds the cell´s state*/
	private cellState state;
	
	/*tells if the Cell inherits a bomb*/
	private boolean hasBomb;
	/*-------------------------------------------------------------------*/
	





	/*CONSTRUCTOR-------*/
	public Cell() throws IOException{
		/*make sure the cell doesnt inherit a bomb*/
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

	public BufferedImage getIcons() {
		return Icons;
	}
	
	public boolean hasBomb() {
		return hasBomb;
	}

	public void setBomb(boolean hasBomb) {
		this.hasBomb = hasBomb;
	}
	
	public static BufferedImage[][] getIconsMatrix() {
		return IconsMatrix;
	}
	/*-------------------------------------------------------------------------------*/
}
