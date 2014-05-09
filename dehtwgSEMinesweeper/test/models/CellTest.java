package models;

import static org.junit.Assert.*;

import java.io.IOException;

import models.Cell;
import models.Cell.cellState;

import org.junit.Before;
import org.junit.Test;

public class CellTest {
	
	public Cell a;

	@Before
	public void initialize() throws IOException{
		a = new Cell();
		assertNotNull(a);
	}
	
	
	/*getters and setters*/
	@Test
	public void getStateTest() {
		a.setState(cellState.checked);
		assertEquals(cellState.checked, a.getState());
	}
	
	@Test
	public void setStateTest() {
		a.setState(cellState.checked);
		assertEquals(cellState.checked, a.getState());
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
