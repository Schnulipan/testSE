package dehtwgSEMinesweeperModels;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import dehtwgSEMinesweeperModels.Cell.cellState;

public class FieldTest {

	Field a;
	BufferedImage  TestIcons;
	
	@Before
	public void initialize() throws IOException{
		TestIcons =ImageIO.read(new File("Icons.gif"));
		
		a = new Field(1, 1);
		assertNotNull(a);
		
		for(int i = 0; i < 1; i++){
			for(int o = 0; o < 1; o++){
				assertNotNull(a.getCells()[i][o]);
			}
			
		}
	}
	
	
	public void clickCellTest() throws IOException {
		//a.getCells()[1][1].setBomb(false);
		
		assertTrue(a.clickCell(1, 1));
		assertTrue(a.getCells()[1][1].getState() == cellState.open);
		for(int i = 0; i < 1; i++){
			for(int o = 0; o < 1; o ++){
				if(a.getCells()[i][o].hasBomb()){
					assertTrue(a.getCells()[i][o].getPresentIcon() == TestIcons.getSubimage(20, 20, 20, 20));
				}
				
			}
		}
		//a.getCells()[1][1].setBomb(true);
		//assertTrue(!a.clickCell(1, 1));
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
		assertTrue(a.getCells()!=testcells);
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
		assertTrue(a.getRows()!=testrows);
		a.setRows(1);
	}
	
	@Test
	public void setColsTest() {
		int testcols = a.getCols();
		int newtestcols = 10;
		a.setCols(newtestcols);
		assertTrue(a.getCols()!=testcols);
		a.setCols(1);
	}
	
	@Test
	public void getColsTest() {
		assertNotNull(a.getCols());
	}
	
	
	
	

}
