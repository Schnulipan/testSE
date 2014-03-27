package dehtwgSEMinesweeperModels;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Cell {
	
	

	/*CLASSVARIABLES----------------------------------------------------------------------*/
	/*stores all the possible images a cell can hold - unseen, bomb, free, checked*/
	private static BufferedImage allIcons;
	/*holds all the possible states a cell can have during play*/
	private static enum cellState {unseen, bomb, free, checked};
	/*------------------------------------------------------------------------------------*/
	
	
	
	
	
	/*INSTANCEVARIABLES-----------------------------------*/
	/*for GUI*/
	private int height;
	private int width;
	
	/*stores the actual icon for GUI*/
	private BufferedImage presentIcon;
	
	private cellState state;
	
	/*this decides whether the cell inherits a bomb*/
	private boolean hasBomb = false;
	/*----------------------------------------------------*/
	
	
	
	
	
	/*CONSTRUCTOR--------*/
	public Cell(int HEIGHT, int WIDTH, boolean bomb) throws IOException{
		this.height = HEIGHT;
		this.width = WIDTH;
		this.hasBomb = bomb;
		this.state = cellState.unseen;
		
		allIcons = ImageIO.read(new File("Icons.gif"));
		presentIcon = allIcons.getSubimage(0,0,20,20);
	}
	/*-------------------*/


	
	
	

	/*GETTERS AND SETTERS-----------------------------------------------------------*/

	public static BufferedImage getAllIcons() {
		return allIcons;
	}

	public static void setAllIcons(BufferedImage allIcons) {
		Cell.allIcons = allIcons;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public BufferedImage getPresentIcon() {
		return presentIcon;
	}

	public void setPresentIcon(BufferedImage presentIcon) {
		this.presentIcon = presentIcon;
	}

	public cellState getState() {
		return state;
	}

	public void setState(cellState state) {
		this.state = state;
	}

	public boolean isHasBomb() {
		return hasBomb;
	}

	public void setHasBomb(boolean hasBomb) {
		this.hasBomb = hasBomb;
	}
	/*--------------------------------------------------------------------------------*/
	
}
