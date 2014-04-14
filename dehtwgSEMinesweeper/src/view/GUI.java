package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import controller.Controller.GAMESTATE;
import models.Cell;
import models.Field;

public class GUI extends JFrame implements I_View {
	
	
	/*CLASS VARIABLES --------*/
	
	/*holds all the possible images a cell can have*/
	public static BufferedImage Icons;
	{
		try {
			Icons = ImageIO.read(new File("Icons.gif"));
		} catch (IOException e) {
			tellPlayer("Internal Error - couldn´t find Icons.gif");
			e.printStackTrace();
		}
	}
	public static BufferedImage[][] IconsMatrix;

	{
		IconsMatrix = new BufferedImage[2][2];
		IconsMatrix[0][0] = Icons.getSubimage(0, 0, 20, 20);/*hidden*/
		IconsMatrix[0][1] = Icons.getSubimage(20, 0, 20, 20);/*open*/
		IconsMatrix[1][0] = Icons.getSubimage(0, 20, 20, 20);/*checked*/
		IconsMatrix[1][1] = Icons.getSubimage(20, 20, 20, 20);/*bomb*/
	}
	/*------------------------*/
	
	
	
	
	/*INSTANCE VARIABLES---------------*/
	/*Controller*/
	private Controller c;
	/*JPANELS*/
	private JPanel gamePanel;
	/*---------------------------------*/
	
	
	
	
	
	
	
	
	
	/*CONSTRUCTOR-------------------------*/
	public GUI(Controller CON){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(new Dimension(600, 600));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		c = CON;
	}
	/*------------------------------------*/
	
	
	
	
	
	
	
	
	
	/*INHERITED METHODS ------------------------------------------*/	
	@Override
	public void update(Observable arg0, Object arg1) {
		showAllCells();
		
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
		this.getContentPane().add(new menuPanel(this, c));
		
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
