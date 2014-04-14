package view;

import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;

public class menuPanel extends JPanel implements ActionListener{
	
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
	public menuPanel(JFrame p, Controller c) {
		parent = p;
		
		textRow = new JTextField();
		textCol = new JTextField();
		textBombs = new JTextField();
		
		labelRow = new JLabel("Rows:");
		labelCol = new JLabel("Cols:");
		labelBombs = new JLabel("Bombs:");
		
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
				this.textRow.setText("0");
			}
			try{
				col = Integer.parseInt(textCol.getText());
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(this, "All Fields need to be filled with integers!");
				this.textCol.setText("");
			}
			try{
				bombP = Integer.parseInt(textBombs.getText());
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(this, "All Fields need to be filled with integers!");
				this.textBombs.setText("");
			}
			
			
			
			
			String errMessage = null;
			
			if(row > 0 && col > 0 && bombP > 0){
				con.field.initialize(row, col);
				con.segregateBombs(bombP, errMessage);
				parent.remove(this);
			}
			
		}
		
	}
	
	
	
	
	
	
}
