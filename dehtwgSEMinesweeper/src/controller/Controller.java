package controller;

import java.util.Observable;

import models.Field;

public class Controller extends Observable{
	
	/*CLASS VARIABLES -----*/
	public static boolean gameRunning = false; /*definitely will be useful*/
	/*---------------------*/
	
	
	/*INSTANCE VARIABLES-------------*/
	public Field field;
	/*-------------------------------*/
	
	
	/*CONSTRUCTOR------------------------------*/
	public Controller(Field f)
	{
		field = f;
		
	}
	/*-----------------------------------------*/
	
	
	/*PUBLIC METHODS----------------------------------------*/
	public void calculateClick(int ROW, int COL)
	{
		
		field.clickCell(ROW, COL);
		
		
	}
	/*------------------------------------------------------*/

}
   