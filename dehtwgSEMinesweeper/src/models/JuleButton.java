package models;



public class JuleButton extends javax.swing.JButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/*Instance Variables-----------*/
	private int xcoordinate, ycoordinate;
	/*-----------------------------*/
	
	/*CONSTRUCTOR-------------*/
	public JuleButton(int a, int b){
		super();
		xcoordinate = a;
		ycoordinate = b;
	}
	/*------------------------*/
	

	public int getXcoordinate() {
		return xcoordinate;
	}

	public void setXcoordinate(int x) {
		this.xcoordinate = x;
	}

	public int getYcoordinate() {
		return ycoordinate;
	}

	public void setYcoordinate(int y) {
		this.ycoordinate = y;
	}
	

}
