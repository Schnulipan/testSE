package dehtwgSEMinesweeperModels;

import java.awt.image.BufferedImage;

public class Field {
	
	
	
	/*CLASSVARIABLES----------------------------------------------------------------------*/
	/*stores all the possible images a cell can hold - unseen, bomb, free, checked*/
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
	
	
	
	
	
	

}
