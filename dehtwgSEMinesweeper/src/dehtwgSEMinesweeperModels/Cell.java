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
	private static BufferedImage[] icons;
	/*holds all the possible states a cell can have during play*/
	private static enum cellState {unseen, bomb, free, checked};
	/*------------------------------------------------------------------------------------*/
	
	
	
	
	
	/*INSTANCEVARIABLES-----------------------------------*/
	/*for GUI later*/
	private int height;
	private int width;
	
	/*stores the actual icon for GUI*/
	private BufferedImage presentIcon;
	
	/*this decides whether the ell inherits a bomb*/
	private boolean hasBomb = false;
	/*----------------------------------------------------*/
	
	
	
	
	
	/*CONSTRUCTOR--------*/
	public Cell(int HEIGHT, int WIDTH, boolean bomb){
		this.height = HEIGHT;
		this.width = WIDTH;
		this.hasBomb = bomb;
		
		
	}
	/*-------------------*/
	
	
}
