package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.Controller;

public class menuPanel extends JPanel implements ActionListener, DocumentListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*ParentFrame*/
	JFrame parent;
	
	/*JTextFields*/
	JTextField textRow;
	JTextField textCol;
	JTextField textBombs;
	
	
	/*JButtons*/
	JButton confirm;
	
	/*JLabels*/
	JLabel labelRow;
	JLabel labelCol;
	JLabel labelBombs;
	
	
	/*Controller*/
	Controller con;
	
	/*CONSTRUCTOR*/
	public menuPanel(Controller c, JFrame p) {
		parent = p;
		
		textRow = new JTextField("10");
		textCol = new JTextField("10");
		textBombs = new JTextField("10");
		textRow.getDocument().addDocumentListener(this);
		textCol.getDocument().addDocumentListener(this);
		textBombs.getDocument().addDocumentListener(this);
		
		labelRow = new JLabel("Rows");
		labelCol = new JLabel("Cols");
		labelBombs = new JLabel("Bomb Percentage");
		
		confirm = new JButton("Confirm");
		confirm.addActionListener(this);
		
		
		this.setLayout(new GridLayout(4,2));
		
		this.add(labelRow);
		this.add(textRow);
		this.add(labelCol);
		this.add(textCol);
		this.add(labelBombs);
		this.add(textBombs);
		this.add(confirm);
		
		this.setVisible(true);
		
		con = c;
	}
	
	
	
	/*INHERITED METHODS*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		
		int row = 0;
		int col = 0;
		int bombP = 0;
		
		if(event == confirm){
			try{
				row = Integer.parseInt(textRow.getText());
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(this, "All Fields need to be filled with integers!");
				this.textRow.setText("10");
			}
			try{
				col = Integer.parseInt(textCol.getText());
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(this, "All Fields need to be filled with integers!");
				this.textCol.setText("10");
			}
			try{
				bombP = Integer.parseInt(textBombs.getText());
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(this, "All Fields need to be filled with integers!");
				this.textBombs.setText("10");
			}
			
			
			
			
			String errMessage = null;
			
			if(row > 0 && col > 0 && bombP > 0 && bombP < 101){
				con.field.initialize(row, col);
				con.segregateBombs(bombP, errMessage);
				synchronized (this){
					this.notify();
				}
			}			
		}	
	}



	@Override
	public void changedUpdate(DocumentEvent arg0) {
		
		
		try{
			if(Integer.parseInt(textRow.getText()) < 1){
				JOptionPane.showMessageDialog(this, "Rows need to be higher than 0!");
				textRow.setText("10");
			}
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "All Fields need to be filled with integers!");
			this.textRow.setText("10");
		}
		try{
			if(Integer.parseInt(textCol.getText()) < 1){
				JOptionPane.showMessageDialog(this, "Cols need to be higher than 0!");
				textCol.setText("10");
			}
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "All Fields need to be filled with integers!");
			this.textCol.setText("10");
		}
		try{
			if(Integer.parseInt(textBombs.getText()) < 1){
				JOptionPane.showMessageDialog(this, "Bomb Percentage need to be higher than 0!");
				textBombs.setText("10");
			}
			if(Integer.parseInt(textBombs.getText()) > 100){
				JOptionPane.showMessageDialog(this, "Bombs Percentage need to be lower than 100!");
				textBombs.setText("10");
			}
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "All Fields need to be filled with integers!");
			this.textBombs.setText("10");
		}

	}



	@Override
	public void insertUpdate(DocumentEvent arg0) {

		
		try{
			if(Integer.parseInt(textRow.getText()) < 1){
				JOptionPane.showMessageDialog(this, "Rows need to be higher than 0!");
				textRow.setText("10");
			}
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "All Fields need to be filled with integers!");
			this.textRow.setText("10");
		}
		try{
			if(Integer.parseInt(textCol.getText()) < 1){
				JOptionPane.showMessageDialog(this, "Cols need to be higher than 0!");
				textCol.setText("10");
			}
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "All Fields need to be filled with integers!");
			this.textCol.setText("10");
		}
		try{
			if(Integer.parseInt(textBombs.getText()) < 1){
				JOptionPane.showMessageDialog(this, "Bomb Percentage need to be higher than 0!");
				textBombs.setText("10");
			}
			if(Integer.parseInt(textBombs.getText()) > 100){
				JOptionPane.showMessageDialog(this, "Bombs Percentage need to be lower than 100!");
				textBombs.setText("10");
			}
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "All Fields need to be filled with integers!");
			this.textBombs.setText("10");
		}
	}



	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
