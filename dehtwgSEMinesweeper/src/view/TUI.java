package view;

import java.util.Observable;

import controller.Controller;

public class TUI implements I_View{
	
	/*INSTANCE VARIABLES----------*/
	private Controller controller;
	
	/*----------------------------*/
	
	
	
	/*CONSTRUCTOR--------------------------*/
	public TUI(Controller c)
	{
		this.controller = c;
		c.addObserver(this);
	}
	/*-------------------------------------*/
	
	
	
	/*INHERITED METHODS ------------------------------------------*/
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showCell() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAllCells() {
		// TODO Auto-generated method stub
		
	}
	/*------------------------------------------------------------*/
}
