package controller;

import static org.junit.Assert.*;

import java.io.IOException;

import models.Cell;
import models.Field;

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
		c.field = new Field(1, 3);
		c.field.getCells()[0][1].setBomb(true);
		c.field.getCells()[0][2].setBomb(true);
		assertTrue(c.clickCell(0, 0) == GAMESTATE.running);
		assertEquals(c.field.getCells()[0][0].getState(), Cell.cellState.open);
		assertEquals(c.field.getCells()[0][1].getState(), Cell.cellState.hidden);
		assertEquals(c.field.getCells()[0][2].getState(), Cell.cellState.hidden);
		
		assertFalse(c.clickCell(0, 1) == GAMESTATE.running);
		assertEquals(c.field.getCells()[0][0].getState(), Cell.cellState.open);
		assertEquals(c.field.getCells()[0][1].getState(), Cell.cellState.open);
		assertEquals(c.field.getCells()[0][2].getState(), Cell.cellState.open);
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
					System.out.println("bearbeite cell["+i+"]["+o+"] - only for testing -- comes from ControllerTest - segregateBombs");
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

}
