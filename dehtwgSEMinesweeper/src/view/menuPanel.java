package view;



import java.awt.Dimension;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.Controller;

public class menuPanel extends JPanel implements ActionListener, DocumentListener{
	
	/*INSTANCE VARIABLES ----------------------*/
	/*Controller*/
	Controller con;
	
	/*the boolean, the GUI will wait for*/
	public volatile boolean bombsaresegregated = false;
	public JFrame parent;
	
	/*JTextFields*/
	public JTextField Trow;
	public JTextField Tcol;
	public JTextField Tbombs;
	
	
	/*JButtons*/
	public JButton ok;
	
	
	/*JLabels*/
	public JLabel Lrow;
	public JLabel Lcol;
	public JLabel Lbombs;
	/*-----------------------------------------*/
	
	
	
	/*CONSTRUCTOR!!!*/
	public menuPanel(Controller c, JFrame parent){
		
		this.parent = parent;
		con = c;
		
		
		/*define the panels layout*/
		this.setLayout(new GridLayout(4, 2));
		this.setPreferredSize(new Dimension(400, 400));
		
		/*initialize the textfields*/
		Trow = new JTextField("10");
		Tcol = new JTextField("10");
		Tbombs = new JTextField("10");
		
		/*initialize the Jlabels*/
		Lrow = new JLabel("Rows");
		Lcol = new JLabel("Cols");
		Lbombs = new JLabel("Bomb percentage");
		
		/*initialize the JButton*/
		ok = new JButton("Confirm");
		ok.addActionListener(this);
		
		/*Add the Components*/
		this.add(Lrow);
		this.add(Trow);
		
		this.add(Lcol);
		this.add(Tcol);
		
		this.add(Lbombs);
		this.add(Tbombs);
		
		this.add(ok);
		
		
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object e = arg0.getSource();
		if(e == ok){
			int row, col, bombs;
			row = Integer.parseInt(Trow.getText());
			col = Integer.parseInt(Tcol.getText());
			bombs = Integer.parseInt(Tbombs.getText());
			
			if(row >= 1){
				if(col >= 1){
					if(bombs < 100){
						con.field.initialize(row, col);
						con.segregateBombs(bombs, new String());
						bombsaresegregated = true;
						synchronized(this){
							this.notify();
						}
					}
				}
			}
		}
		
	}



	@Override
	public void changedUpdate(DocumentEvent arg0) {
		Object e = (JTextField)arg0.getDocument();
		if(e == Tbombs){
			if(Integer.parseInt(Tbombs.getText()) > 100){
				JOptionPane.showMessageDialog(this, "the Bomb percentage cant be higher than 100%!");
				Tbombs.setText("10");
			}
		}
		else if(e == Trow){
			if(Integer.parseInt(Trow.getText()) < 1){
				JOptionPane.showMessageDialog(this, "value needs to be higher than 0");
				Trow.setText("10");
			}
		}
		else if(e == Tcol){
			if(Integer.parseInt(Tcol.getText()) < 1){
				JOptionPane.showMessageDialog(this, "value needs to be higher than 0");
				Tcol.setText("10");
			}
		}
		
	}



	@Override
	public void insertUpdate(DocumentEvent arg0) {
		Object e = (JTextField)arg0.getDocument();
		if(e == Tbombs){
			if(Integer.parseInt(Tbombs.getText()) > 100){
				JOptionPane.showMessageDialog(this, "the Bomb percentage cant be higher than 100%!");
				Tbombs.setText("10");
			}
		}
		else if(e == Trow){
			if(Integer.parseInt(Trow.getText()) < 1){
				JOptionPane.showMessageDialog(this, "value needs to be higher than 0");
				Trow.setText("10");
			}
		}
		else if(e == Tcol){
			if(Integer.parseInt(Tcol.getText()) < 1){
				JOptionPane.showMessageDialog(this, "value needs to be higher than 0");
				Tcol.setText("10");
			}
		}
		
	}



	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	JTextField textRow;
	JTextField textCol;
	JTextField textBombs;
	
	
	/*JButtons*/
	JButton confirm;
	
	/*JLabels*/
	JLabel labelRow;
	JLabel labelCol;
	JLabel labelBombs;
}
