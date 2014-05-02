package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JuleButtonTest {

	public JuleButton jb;
	@Before
	public void initializeTest() {

		jb = new JuleButton(1, 1);
	}
	
	@Test
	public void getXcoordinateTest(){
		int x;
		jb.setXcoordinate(2);
		assertEquals(2, x = jb.getXcoordinate());
		assertNotNull(x);
	}
	
	@Test
	public void getYcoordinateTest(){
		int x;
		jb.setYcoordinate(2);
		assertEquals(2, x = jb.getYcoordinate());
		assertNotNull(x);
	}
	
	@Test
	public void setXcoordinate(){
		jb.setYcoordinate(3);
		assertEquals(3, jb.getYcoordinate());  
		
		assertEquals(2, jb.getXcoordinate());
		assertEquals(2, jb.getYcoordinate());
	}

}
