package models.models;

import java.awt.image.BufferedImage;

import controller.Controller;
import controller.Controller.GAMESTATE;
import models.Cell;
import models.Cell.cellState;
import models.Field;

public class CellStateHidden implements I_CellState{

	private Cell c;
	private Controller con;
	
	public CellStateHidden(Cell cell, Controller controller)  {
		c = cell;
		con = controller;
	}
	
	@Override
	public GAMESTATE click() {			
			Field f = con.field;
			int ROW, COL;
			ROW = c.getRow();
			COL = c.getCol();
			
			
			/*check if the selected cell inherits a bomb*/
			if(f.getCells()[ROW][COL].hasBomb()){
				/*the player has lost and now we will open all bombs*/
				for(int i = 0; i < f.getRows(); i++){
					for(int o = 0; o < f.getCols(); o++){
						if(f.getCells()[i][o].hasBomb()){
							f.getCells()[i][o].setCellState(new CellStateOpen(c, con));
						}
					}
				}
				return GAMESTATE.lost;
			}else
			{
				/*otherwise*/
				/*decrement the amount of freefields-variable - if 0 -> the player has won*/
				if(--con.freeFieldsLeft == 0){
					return GAMESTATE.won;
				}
				
				/*open all cells, that have no bomb contact and touch the recently clicked cell*/
				for(int a = ROW-1; a < ROW+2; a++){
					for(int b = COL-1;b < COL+2; b++){
						if( ((a!=ROW) && (b == COL)) || ((a == ROW && (b != COL)))) {
							if(con.cellIsInField(a, b)){
								if(!f.getCells()[a][b].hasBomb()){
									
									if(f.getCells()[a][b].getCellState().isHidden()){
										if(f.getCells()[a][b].getInTouchWith() == 0){
											con.clickCellR(a, b);
										}
										else{
											f.getCells()[a][b].setCellState(new CellStateOpen(c, con));
											if(--con.freeFieldsLeft == 0){
												return GAMESTATE.won;
											}
										}
									}
								}
							}
						}
					}
				}
			}
			return GAMESTATE.running;		
	}

	@Override
	public boolean isOpen() {
		return false;
	}

	@Override
	public boolean isChecked() {
		return false;
	}

	@Override
	public boolean isHidden() {
		return true;
	}

	@Override
	public BufferedImage getCellImage() {
		return Cell.IconsMatrix[0][0];
	}

}
