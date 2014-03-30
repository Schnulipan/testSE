package dehtwgSEMinesweeperModels;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class FieldTest {

	Field a;
	
	@Before
	public void initialize() throws IOException{
		a = new Field(1, 1);
		assertNotNull(a);
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
