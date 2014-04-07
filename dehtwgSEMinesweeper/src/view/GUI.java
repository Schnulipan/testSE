package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.imageio.ImageIO;

import controller.Controller.GAMESTATE;

import models.Cell;
import models.Field;

public class GUI implements I_View{
	
	
	/*CLASS VARIABLES --------*/
	
	/*holds all the possible images a cell can have*/
	public static BufferedImage Icons;
	{
		try {
			Icons = ImageIO.read(new File("Icons.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static BufferedImage[][] IconsMatrix;

	{
		IconsMatrix = new BufferedImage[2][2];
		IconsMatrix[0][0] = Icons.getSubimage(0, 0, 20, 20);
		IconsMatrix[0][1] = Icons.getSubimage(20, 0, 20, 20);
		IconsMatrix[1][0] = Icons.getSubimage(0, 20, 20, 20);
		IconsMatrix[1][1] = Icons.getSubimage(20, 20, 20, 20);
	}
	/*------------------------*/
	
	/*INHERITED METHODS ------------------------------------------*/
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAllCells() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void showCell(Cell c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void demandPlayerInstructions() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void tellPlayer(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void welcomePlayer() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public GAMESTATE demandClick() {
		return GAMESTATE.lost;
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public boolean demandTryAgain() {
		// TODO Auto-generated method stub
		return false;
	}
	/*------------------------------------------------------------*/

	

	

	

}
