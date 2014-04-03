package dehtwgSEMinesweeperModels;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import dehtwgSEMinesweeperModels.Cell.cellState;

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
		assertEquals(cellState.hidden, a.getState());
	}
	
	@Test
	public void setStateTest() {
		a.setState(cellState.checked);
		assertEquals(cellState.checked, a.getState());
	}
	
	@Test
	public void getPresentIconTest() {
		assertNotNull(a.getPresentIcon());
	}
	
	@Test
	public void setPresentIconTest() throws IOException {
		a.setPresentIcon(ImageIO.read(new File("Icons.gif")));
		assertNotNull(a.getPresentIcon());
	}
	
	@Test
	public void getIconsTest(){
		assertNotNull(a.getIcons());
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
