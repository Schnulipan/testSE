package view;

import java.util.Observer;

import models.Cell;
import models.Field;

public interface I_View extends Observer{
	
	void showCell(Cell c);
	void showAllCells(Field f);

}
