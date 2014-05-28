package models;

import static org.junit.Assert.*;

import java.io.IOException;

import models.Cell;
import models.Cell.cellState;
import models.models.CellStateChecked;

import org.junit.Before;
import org.junit.Test;

public class CellTest {
	
	public Cell a;

	@Before
	public void initialize() throws IOException{
		a = new Cell(0, 0);
		assertNotNull(a);
	}
	
	
	/*getters and setters*/
	@Test
	public void getStateTest() {
		a.setCellState(new CellStateChecked(a));
		assertTrue(a.getCellState().isChecked());
	}
	
	@Test
	public void setStateTest() {
		a.setCellState(new CellStateChecked(a));
		assertTrue(a.getCellState().isChecked());
	}
	
	@Test
	public void hasBombTest(){
		a.setBomb(false);
		assertFalse(a.hasBomb());
		a.setBomb(true);
		assertTrue(a.hasBomb());
	}
	
	@Test
	public void setBombTest(){
		a.setBomb(false);
		assertFalse(a.hasBomb());
		a.setBomb(true);
		assertTrue(a.hasBomb());
	}	

}
