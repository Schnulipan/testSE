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
	private final BufferedImage Icons = ImageIO.read(new File("Icons.gif"));
	/*-----------------------------------------------*/
	
	
	
	
	/*INSTACE VARIABLES--------------------------------------------------*/
	
	/*holds the cell´s state*/
	private cellState state;
	
	/*hodls the actual icon of the cell*/
	private BufferedImage presentIcon;
	
	/*tells if the Cell inherits a bomb*/
	private boolean hasBomb = false;
	/*-------------------------------------------------------------------*/
	





	/*CONSTRUCTOR-------*/
	public Cell() throws IOException{
		/*sets the present icon to hidden*/
		presentIcon = Icons.getSubimage(0,0,20,20);
		
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

	public BufferedImage getPresentIcon() {
		return presentIcon;
	}

	public void setPresentIcon(BufferedImage presentIcon) {
		this.presentIcon = presentIcon;
	}

	public BufferedImage getIcons() {
		return Icons;
	}
	
	public boolean isHasBomb() {
		return hasBomb;
	}

	public void setHasBomb(boolean hasBomb) {
		this.hasBomb = hasBomb;
	}
	/*-------------------------------------------------------------------------------*/
}
