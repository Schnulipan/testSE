package view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


import controller.Controller;
import controller.Controller.GAMESTATE;

import models.Cell;
import models.JuleButton;

public class GUI extends JFrame implements I_View, ActionListener {

	/* CLASS VARIABLES -------- */
	private static final long serialVersionUID = 1L;

	/* INSTANCE VARIABLES--------------- */
	/* Controller */
	private Controller c;
	/* JPANELS */
	private JPanel gamePanel;
	private JPanel statPanel; /* will show the actual state like free fields... */
	private JPanel cellPanel; /* will hold the cells */

	/* JLabels */
	private JLabel LfreeFields = new JLabel("Free Fields Left: ");

	/* JTextFields */

	/* JButtons */
	private JuleButton[][] buttonCells;
	private JButton smiley;

	/**/
	private boolean nextClickpermitted = false;
	private boolean tryagain = false;
	private GAMESTATE gamestate = GAMESTATE.running;

	/*---------------------------------*/

	/* CONSTRUCTOR------------------------- */
	public GUI(Controller CON) {
		c = CON;
		c.addObserver(this);

		this.setTitle("Minesweeper by Julian");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);

	}
	/*------------------------------------*/

	/* INHERITED METHODS ------------------------------------------ */
	@Override
	public void update(Observable arg0, Object arg1) {
		showAllCells();

	}

	@Override
	public void showAllCells() {
		/*iterate through all the cells*/
		for (int i = 0; i < c.field.getRows(); i++) {
			for (int o = 0; o < c.field.getCols(); o++) {
				buttonCells[i][o].setIcon(new ImageIcon(c.field.getCells()[i][o].getCellState().getCellImage()));
			}
		}
		LfreeFields.setText("Free Fields Left: " + c.freeFieldsLeft);
		// validate();//quasi repaint();...ist nicht mal nötig...
		setVisible(true);
	}

	@Override
	public void showCell(Cell c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void demandPlayerInstructions() {

		this.setSize(200, 200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		menuPanel menu;
		this.getContentPane().add(menu = new menuPanel(c, this));
		validate();
		synchronized (menu) {
			try {
				menu.wait();
			} catch (InterruptedException e) {
			}
		}
		remove(menu);
		validate();
		this.setSize(new Dimension(c.field.getRows() * 20,
				c.field.getCols() * 20+100));
		// setExtendedState(MAXIMIZED_BOTH);

		/* initialize the visual gamefield */
		buttonCells = new JuleButton[c.field.getRows()][c.field.getCols()];
		for (int i = 0; i < c.field.getRows(); i++) {
			for (int o = 0; o < c.field.getCols(); o++) {
				buttonCells[i][o] = new JuleButton(i, o);
				buttonCells[i][o].setIcon(new ImageIcon(Cell.IconsMatrix[0][0]));
				buttonCells[i][o].addActionListener(this);
				final int ii = new Integer(i);
				final int oo = new Integer(o);
				buttonCells[i][o].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent me){
						if(SwingUtilities.isRightMouseButton(me)){
							c.markCell(ii, oo);
						}
					}
				});
			}
		}

		gamePanel = new JPanel(new BorderLayout());
		statPanel = new JPanel();
		try {
			smiley = new JButton(new ImageIcon(ImageIO.read(new File(
					"smiley.png"))));
		} catch (IOException e) {
		}

		int row, col;
		row = c.field.getRows();
		col = c.field.getCols();
		cellPanel = new JPanel(new GridLayout(row, col));
		for (int i = 0; i < c.field.getRows(); i++) {
			for (int o = 0; o < c.field.getCols(); o++) {
				cellPanel.add(buttonCells[i][o]);
			}
		}
		smiley.addActionListener(this);

		statPanel.add(LfreeFields = new JLabel("Free Fields left: "	+ c.freeFieldsLeft));
		
		statPanel.add(smiley);
		gamePanel.add(statPanel, BorderLayout.NORTH);
		gamePanel.add(cellPanel, BorderLayout.CENTER);
		this.add(gamePanel);
		setVisible(true);
		showAllCells();
		validate();

		tryagain = false;

	}

	@Override
	public void tellPlayer(String s) {
		JOptionPane.showMessageDialog(this, s);

	}

	@Override
	public void welcomePlayer() {
		tellPlayer("Welcome to Minesweeper by Julian Müller!");

	}

	@Override
	public GAMESTATE demandClick() {
		nextClickpermitted = true;

		/* wait until the user has performed an action - clicked a cell */
		synchronized (this) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}

		return gamestate;
	}

	@Override
	public boolean demandTryAgain() {
		
		synchronized (smiley){
			try {
				smiley.wait();
			} catch (InterruptedException e) {
			}
		}
		return tryagain;
	}

	/*------------------------------------------------------------*/

	@Override
	public void actionPerformed(ActionEvent e) {

		Object event = e.getSource();
		int row, col;
		row = c.field.getRows();
		col = c.field.getCols();

		if (event == smiley) {
			tryagain = true;
			synchronized(smiley){
				smiley.notify();
			}
		} else {
			if (nextClickpermitted) {
				for (int i = 0; i < row; i++) {
					for (int o = 0; o < col; o++) {
						if (event == buttonCells[i][o]) {
							gamestate = c.clickCell(
									buttonCells[i][o].getXcoordinate(),
									buttonCells[i][o].getYcoordinate());
							/* wake up the game - the user has clicked a cell */
							synchronized (this) {
								this.notify();
							}
							break;
						}
					}
				}
			}
		}
	}
}
