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
	public void clickCellTest() throws IOException {
		a = new Field(1, 3);
		a.getCells()[0][1].setBomb(true);
		a.getCells()[0][2].setBomb(true);
		assertTrue(a.clickCell(0, 0));
		assertEquals(a.getCells()[0][0].getState(), Cell.cellState.open);
		assertEquals(a.getCells()[0][1].getState(), Cell.cellState.hidden);
		assertEquals(a.getCells()[0][2].getState(), Cell.cellState.hidden);
		
		assertFalse(a.clickCell(0, 1));
		assertEquals(a.getCells()[0][0].getState(), Cell.cellState.open);
		assertEquals(a.getCells()[0][1].getState(), Cell.cellState.open);
		assertEquals(a.getCells()[0][2].getState(), Cell.cellState.open);
		}
	
	
	@Test
	public void initializeTest()
	{
		a = new Field();
		a.initialize(1,1);
		
		assertNotNull(a.getCells());
		assertNotNull(a.getCells()[0][0]);
	}
	
	
	@Test
	public void segregateBombsTest()
	{
		a = new Field(2,2);
		String out = null;
		assertFalse(a.segregateBombs(200, out));
		assertFalse(a.segregateBombs(-1, out));
		
		assertTrue(a.segregateBombs(1, out));
		
		
		a = new Field(2,2);
		assertTrue(a.segregateBombs(50, out));
				
		assertTrue(a.getCells()[0][0].hasBomb());
		assertTrue(a.getCells()[0][1].hasBomb());
		assertFalse(a.getCells()[1][0].hasBomb());
		assertFalse(a.getCells()[1][1].hasBomb());
		
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
