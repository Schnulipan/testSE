package view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
import javax.swing.SwingConstants;


import controller.Controller;
import controller.Controller.GAMESTATE;

import models.Cell;
import models.Cell.cellState;
import models.JuleButton;

public class GUI extends JFrame implements I_View, ActionListener {

	/* CLASS VARIABLES -------- */

	/* holds all the possible images a cell can have */
	public static BufferedImage Icons;
	{
		try {
			Icons = ImageIO.read(new File("Icons.gif"));
		} catch (IOException e) {
			tellPlayer("Internal Error - couldn´t find Icons.gif");
			e.printStackTrace();
		}
	}
	public static BufferedImage[][] IconsMatrix;

	{
		IconsMatrix = new BufferedImage[6][2];
		IconsMatrix[0][0] = Icons.getSubimage(0, 0, 20, 20);/* hidden */
		IconsMatrix[0][1] = Icons.getSubimage(20, 0, 20, 20);/* open */
		IconsMatrix[1][0] = Icons.getSubimage(0, 20, 20, 20);/* checked */
		IconsMatrix[1][1] = Icons.getSubimage(20, 20, 20, 20);/* bomb */

		IconsMatrix[2][0] = Icons.getSubimage(0, 40, 20, 20);/* 1 */
		IconsMatrix[2][1] = Icons.getSubimage(20, 40, 20, 20);/* 2 */
		IconsMatrix[3][0] = Icons.getSubimage(0, 60, 20, 20);/* 3 */
		IconsMatrix[3][1] = Icons.getSubimage(20, 60, 20, 20);/* 4 */
		IconsMatrix[4][0] = Icons.getSubimage(0, 80, 20, 20);/* 5 */
		IconsMatrix[4][1] = Icons.getSubimage(20, 80, 20, 20);/* 6 */
		IconsMatrix[5][0] = Icons.getSubimage(0, 100, 20, 20);/* 7 */
		IconsMatrix[5][1] = Icons.getSubimage(20, 100, 20, 20);/* 8 */

	}
	/*------------------------*/

	/* INSTANCE VARIABLES--------------- */
	/* Controller */
	private Controller c;
	/* JPANELS */
	private JPanel gamePanel;
	private JPanel statPanel; /* will show the actual state like free fields... */
	private JPanel cellPanel; /* will hold the cells */

	/* JLabels */
	private JLabel LfreeFields;

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

		for (int i = 0; i < c.field.getRows(); i++) {
			for (int o = 0; o < c.field.getCols(); o++) {
				if (c.field.getCells()[i][o].getState() == cellState.open) {
					if (c.field.getCells()[i][o].hasBomb()) {
						buttonCells[i][o].setIcon(new ImageIcon(
								IconsMatrix[1][1]));
					} else {
						int touch = c.field.getCells()[i][o].getInTouchWith();
						if (touch > 0) {
							switch (touch) {
							case 1:
								buttonCells[i][o].setIcon(new ImageIcon(
										IconsMatrix[2][0]));
								break;
							case 2:
								buttonCells[i][o].setIcon(new ImageIcon(
										IconsMatrix[2][1]));
								break;
							case 3:
								buttonCells[i][o].setIcon(new ImageIcon(
										IconsMatrix[3][0]));
								break;
							case 4:
								buttonCells[i][o].setIcon(new ImageIcon(
										IconsMatrix[3][1]));
								break;
							case 5:
								buttonCells[i][o].setIcon(new ImageIcon(
										IconsMatrix[4][0]));
								break;
							case 6:
								buttonCells[i][o].setIcon(new ImageIcon(
										IconsMatrix[4][1]));
								break;
							case 7:
								buttonCells[i][o].setIcon(new ImageIcon(
										IconsMatrix[5][0]));
								break;
							case 8:
								buttonCells[i][o].setIcon(new ImageIcon(
										IconsMatrix[5][1]));
								break;

							}
						} else {
							buttonCells[i][o].setIcon(new ImageIcon(
									IconsMatrix[0][1]));
						}
					}

				}/*else -> cell is not open*/ 
				else if (c.field.getCells()[i][o].getState() == cellState.checked) {
					buttonCells[i][o].setIcon(new ImageIcon(IconsMatrix[1][0]));
				}
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

		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		menuPanel menu;
		this.getContentPane().add(menu = new menuPanel(c, this));
		validate();
		synchronized (menu) {
			try {
				menu.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		remove(menu);
		validate();
		this.setSize(new Dimension(c.field.getRows() * 20,
				c.field.getCols() * 25));
		// setExtendedState(MAXIMIZED_BOTH);

		/* initialize the visual gamefield */
		buttonCells = new JuleButton[c.field.getRows()][c.field.getCols()];
		for (int i = 0; i < c.field.getRows(); i++) {
			for (int o = 0; o < c.field.getCols(); o++) {
				buttonCells[i][o] = new JuleButton(i, o);
				buttonCells[i][o].setIcon(new ImageIcon(IconsMatrix[0][0]));
				buttonCells[i][o].addActionListener(this);
				buttonCells[i][o].setSize(30, 30);
				buttonCells[i][o].setFont(new Font("Arial",
						Font.HANGING_BASELINE, 10));
			}
		}

		gamePanel = new JPanel(new BorderLayout());
		statPanel = new JPanel();
		try {
			smiley = new JButton(new ImageIcon(ImageIO.read(new File(
					"smiley.png"))));
		} catch (IOException e) {
			e.printStackTrace();
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

		statPanel.add(LfreeFields = new JLabel("Free Fields left: "
				+ c.freeFieldsLeft));
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
				e.printStackTrace();
			}
		}

		return gamestate;
	}

	@Override
	public boolean demandTryAgain() {
		return false;
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
						}
					}
				}
			}
		}
	}
}
