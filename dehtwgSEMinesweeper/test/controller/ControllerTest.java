package controller;

import static org.junit.Assert.*;

import java.io.IOException;

import models.Cell;
import models.Field;
import models.Cell.cellState;
import models.models.CellStateHidden;

import org.junit.Before;
import org.junit.Test;

import controller.Controller.GAMESTATE;

public class ControllerTest {

	Field a;
	Controller c;
	
	@Before
	public void initialize() {
		a = new Field();
		c = new Controller(a);
		
		assertNotNull(c.field);
		assertNotNull(c);
		
		c.field.initialize(1, 1);
	}
	
	@Test
	public void clickCellTest() throws IOException {
		c.field = new Field(3, 3);
		c.field.getCells()[0][1].setBomb(true);
		c.field.getCells()[0][2].setBomb(true);
		assertEquals(GAMESTATE.running, c.clickCellR(0, 0));
		assertEquals(GAMESTATE.running, c.clickCellR(0, 0));
		c.markCell(0, 1);
		assertEquals(GAMESTATE.running, c.clickCellR(0, 1));
		c.markCell(0, 1);
		assertTrue(c.field.getCells()[0][0].getCellState().isOpen());
		
		assertFalse(c.clickCellR(0, 1) == GAMESTATE.running);
		assertTrue(c.field.getCells()[0][0].getCellState().isOpen());
		assertTrue(c.field.getCells()[0][1].getCellState().isOpen());
		assertTrue(c.field.getCells()[0][2].getCellState().isOpen());
		
		
		c.field = new Field(1,2);
		c.segregateBombs(1, new String());
		c.field.getCells()[0][0].setBomb(true);
		c.field.getCells()[0][1].setBomb(false);
		assertEquals(GAMESTATE.won, c.clickCellR(0, 1));
		
		c = new Controller(new Field(2, 2));
		c.segregateBombs(1, new String());
		if(c.field.getCells()[0][0].hasBomb()){
			assertEquals(GAMESTATE.won, c.clickCellR(1, 1));
		}
		if(c.field.getCells()[0][1].hasBomb()){
			assertEquals(GAMESTATE.won, c.clickCellR(1, 0));
		}
		if(c.field.getCells()[1][0].hasBomb()){
			assertEquals(GAMESTATE.won, c.clickCellR(0, 1));
		}
		if(c.field.getCells()[1][1].hasBomb()){
			assertEquals(GAMESTATE.won, c.clickCellR(0, 0));
		}
	}
	
	
	@Test
	public void markCellTest(){
		a = new Field(2, 2);
		c = new Controller(a);
		
		c.segregateBombs(1, new String());
		if(c.field.getCells()[0][0].hasBomb()){
			c.markCell(0, 0);
			assertTrue(c.field.getCells()[0][0].getCellState().isChecked());
			c.markCell(0, 0);
			assertEquals(cellState.hidden, c.field.getCells()[0][0].getCellState());
			
			if(!c.field.getCells()[0][0].hasBomb()){
				c.clickCellR(0, 0);
				assertEquals(cellState.open, c.field.getCells()[0][0].getCellState().isOpen());
			}else{
				c.field.getCells()[0][1].setCellState(new CellStateHidden(c.field.getCells()[0][1]));
				c.clickCellR(0, 1);
				assertTrue(c.field.getCells()[0][1].getCellState().isOpen());
			}
		}
	}
	
	
	@Test
	public void segregateBombsTest()
	{
		c.field = new Field(2,2);
		String out = null;
		assertFalse(c.segregateBombs(200, out));
		assertFalse(c.segregateBombs(-1, out));
		
		assertTrue(c.segregateBombs(1, out));
		
		
		c.field = new Field(2,2);
		assertTrue(c.segregateBombs(50, out));
		
		int check =0;
		while(check < 2){
			for(int i = 0; i < c.field.getRows(); i++)
			{
				for(int o = 0; o<c.field.getCols(); o++)
				{
					if(c.field.getCells()[i][o].hasBomb())
					{
						assertTrue(c.field.getCells()[i][o].hasBomb());
						check++;
					}
					else
					{
						assertFalse(c.field.getCells()[i][o].hasBomb());
					}
				}
			}
		}
		assertEquals(2, check);
		
	}
	
	
	@Test
	public void cellIsInFieldTest()
	{
		c.field = new Field(1,1);
		assertFalse(c.cellIsInField(-1, -1));
		assertFalse(c.cellIsInField(0, -1));
		assertTrue(c.cellIsInField(0, 0));
	}

}
