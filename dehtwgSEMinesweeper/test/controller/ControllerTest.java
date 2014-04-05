package controller;

import static org.junit.Assert.*;

import models.Field;

import org.junit.Before;
import org.junit.Test;

public class ControllerTest {

	@Before
	public void initialize() {
		Field f = new Field();
		Controller c = new Controller(f);
		
		assertNotNull(c.field);
		assertNotNull(c);
	}

}
