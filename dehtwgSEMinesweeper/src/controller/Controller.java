package controller;

import java.util.Observable;

import models.Field;

public class Controller extends Observable{
	
	/*CLASS VARIABLES -----*/
	public static boolean gameStart = false; /*maybe will be useful*/
	public static boolean gameRunning = false; /*definitely will be useful*/
	/*---------------------*/
	
	
	/*INSTANCE VARIABLES-------------*/
	private Field field;
	/*-------------------------------*/
	
	
	/*CONSTRUCTOR------------------------------*/
	public Controller(Field f)
	{
		field = f;
		
	}
	/*-----------------------------------------*/
	
	
	/*PUBLIC METHODS----------------------------------------*/
	public void runGameLoop()
	{
		while(!gameStart){}//while the user has not 
	}
	/*------------------------------------------------------*/

}
   