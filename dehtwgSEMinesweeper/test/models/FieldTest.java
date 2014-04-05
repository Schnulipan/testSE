package models;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import models.Cell;
import models.Field;
import models.Cell.cellState;

import org.junit.Before;
import org.junit.Test;

public class FieldTest {

	Field a;
	
	@Before
	public void initialize() throws IOException{
		
		a = new Field(1, 1);
		assertNotNull(a);
		
		for(int i = 0; i < 1; i++){
			for(int o = 0; o < 1; o++){
				assertNotNull(a.getCells()[i][o]);
			}
			
		}
	}
	
	
	@Test
	public void initializeTest()
	{
		a = new Field();
		a.initialize(1,1);
		
		assertNotNull(a.getCells());
		assertNotNull(a.getCells()[0][0]);
	}
	
	
	
	
	
	/*Getters and Setters*/
	@Test
	public void getCellsTest() {
		assertNotNull(a.getCells());
	}
	
	@Test
	public void setCellsTest() {
		Cell[][] testcells= a.getCells();
		Cell[][] newtestcells = new Cell[1][1];
		a.setCells(newtestcells);
		assertNotSame(a.getCells(),testcells);
	}
	
	@Test
	public void getRowsTest() {
		assertNotNull(a.getRows());
	}
	
	@Test
	public void setRowsTest() {
		int testrows = a.getRows();
		int newtestrows = 10;
		a.setRows(newtestrows);
		assertNotSame(a.getRows(), testrows);
		a.setRows(1);
	}
	
	@Test
	public void setColsTest() {
		int testcols = a.getCols();
		int newtestcols = 10;
		a.setCols(newtestcols);
		assertNotSame(a.getCols(),testcols);
		a.setCols(1);
	}
	
	@Test
	public void getColsTest() {
		assertNotNull(a.getCols());
	}
	
	
	
	

}
