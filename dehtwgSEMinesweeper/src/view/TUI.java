package view;

import java.util.Observable;
import java.util.Scanner;

import models.Cell;
import models.models.I_CellState;
import controller.Controller;
import controller.Controller.GAMESTATE;

public class TUI implements I_View {

	/* CLASS VARIABLES-------- */
	private static char[] icons;
	{
		icons = new char[4];
		icons[0] = 'O';
		icons[1] = ' ';
		icons[2] = 'P';
		icons[3] = 'X';
	}
	/*-----------------------*/

	/* INSTANCE VARIABLES---------- */
	private Controller controller;
	private Scanner scanner;
	private TUI lock = this;
	private String scannerReturn = null;
	private GAMESTATE returnableGamestate = GAMESTATE.running;
	private Thread keyListener;

	/*----------------------------*/

	/* CONSTRUCTOR-------------------------- */
	public TUI(Controller c) {
		this.controller = c;
		c.addObserver(this);
		scanner = new Scanner(System.in);

		controller.addObserver(this);
	}

	/*-------------------------------------*/

	/* INHERITED METHODS ------------------------------------------ */
	@Override
	public void update(Observable arg0, Object arg1) {
		showAllCells();

	}

	@Override
	public void showCell(Cell c) {
		I_CellState state = c.getCellState();

		/* decide what will be printed - dependent on the cell�s state */
		if (state.isOpen()) {
			if (c.hasBomb()) {
				System.out.print("X");
			} else {
				if (c.getInTouchWith() > 0) {
					System.out.print(c.getInTouchWith());
				} else {
					System.out.print(" ");
				}
			}
		}

		if (state.isHidden()) {
			System.out.print("O");
		}
		if (state.isChecked()) {
			System.out.print("P");
		}
	}

	@Override
	public void showAllCells() {
		int row = controller.field.getRows();
		int col = controller.field.getCols();
		Cell[][] c = controller.field.getCells();

		/* print out all the cells */
		System.out.println();
		System.out.print("    ");
		for (int x = 0; x < row; x++) {
			System.out.print(x);
		}
		System.out.println();
		for (int x = 0; x < row + 4; x++) {
			System.out.print("_");
		}
		System.out.println();
		for (int i = 0; i < row; i++) {
			System.out.printf("%3d", i);
			System.out.print("|");
			for (int o = 0; o < col; o++) {
				showCell(c[i][o]);
			}
			System.out.print("|");
			System.out.println();/* this will begin a new line */
		}
		for (int x = 0; x < row + 4; x++) {
			System.out.print("_");
		}

	}

	@Override
	public void demandPlayerInstructions() {
		int row = 0, col = 0, bombpercentage = 0;
		System.out.println("Please insert the field size!");
		while (row <= 0) {
			System.out.println("Rows: ");
			if ((row = scanner.nextInt()) <= 0) {
				System.out.println("Value needs to be higher than 0!");
			}

		}
		while (col <= 0) {
			System.out.println("Cols: ");
			if ((col = scanner.nextInt()) <= 0) {
				System.out.println("Value needs to be higher than 0!");
			}

		}
		controller.field.initialize(row, col);
		String errorMessage = null;
		System.out.println("Bomb-Percentage: ");

		do {

			if ((bombpercentage = scanner.nextInt()) <= 0) {
				System.out.println(errorMessage);
				System.out.println("Bomb-Percentage: ");
			}

		} while (!controller.segregateBombs(bombpercentage, errorMessage));

		showAllCells();
		System.out.println("Thank you!\nHave Fun playing!");

	}

	@Override
	public void tellPlayer(String s) {
		System.out.println();
		System.out.println("|---------------------------------|");
		System.out.println(s);
		System.out.println("|---------------------------------|");
		System.out.println();
	}

	@Override
	public void welcomePlayer() {
		System.out.println("Welcome to Minesweeper!");

	}

	@Override
	public GAMESTATE demandClick() {
		Scanner s = new Scanner(System.in);

		System.out.println("");
		System.out
				.println("what would you like to do?\nclick a cell(c)\nmark a cell(m)\nquit(q)");
		scannerReturn = s.nextLine();

		int row = -1, col = -1;

		switch (scannerReturn.charAt(0)) {
		case 'c':
			System.out.println("Please enter which cell you�d like to click");
			while (row < 0 || row > controller.field.getRows()) {
				System.out.println("Roww: ");
				if ((row = scanner.nextInt()) < 0) {
					System.out
							.println("Value needs to be higher than 0 and lower than "
									+ controller.field.getRows());
				}
			}
			while (col < 0 || col > controller.field.getCols()) {
				System.out.println("Col: ");
				if ((col = scanner.nextInt()) < 0) {
					System.out
							.println("Value needs to be higher than 0 and lower than "
									+ controller.field.getCols());
				}
			}

			returnableGamestate = controller.clickCell(row, col);
			break;

		case 'm':
			System.out.println("Please enter which cell you�d like to mark");
			while (row < 0 || row > controller.field.getRows()) {
				System.out.println("Row: ");
				if ((row = scanner.nextInt()) < 0) {
					System.out
							.println("Value needs to be higher than 0 and lower than "
									+ controller.field.getRows());
				}
			}
			while (col < 0 || col > controller.field.getCols()) {
				System.out.println("Col: ");
				if ((col = scanner.nextInt()) < 0) {
					System.out
							.println("Value needs to be higher than 0 and lower than "
									+ controller.field.getCols());
				}
			}
			controller.markCell(row, col);
			returnableGamestate = GAMESTATE.running;
			break;

		case 'q':
			returnableGamestate = GAMESTATE.quit;
			break;
		default:
			returnableGamestate = GAMESTATE.running;
			break;
		}
		return returnableGamestate;
	}

	@Override
	public boolean demandTryAgain() {
		tellPlayer("Do you want to try again? (y/n)");
		if (scanner.next().equals("y")) {
			return true;
		}
		return false;
	}

	/*------------------------------------------------------------*/

	class keyListener extends Thread {
		public keyListener() {
			this.start();
		}

		@Override
		public void run() {
			Scanner s = new Scanner(System.in);

			System.out.println("");
			System.out
					.println("what would you like to do?\nclick a cell(c)\nmark a cell(m)\nquit(q)");
			scannerReturn = s.nextLine();

			int row = -1, col = -1;

			switch (scannerReturn.charAt(0)) {
			case 'c':
				System.out
						.println("Please enter which cell you�d like to click");
				while (row < 0 || row > controller.field.getRows()) {
					System.out.println("Roww: ");
					if ((row = scanner.nextInt()) < 0) {
						System.out
								.println("Value needs to be higher than 0 and lower than "
										+ controller.field.getRows());
					}
				}
				while (col < 0 || col > controller.field.getCols()) {
					System.out.println("Col: ");
					if ((col = scanner.nextInt()) < 0) {
						System.out
								.println("Value needs to be higher than 0 and lower than "
										+ controller.field.getCols());
					}
				}

				returnableGamestate = controller.clickCell(row, col);

			case 'm':
				System.out
						.println("Please enter which cell you�d like to mark");
				while (row < 0 || row > controller.field.getRows()) {
					System.out.println("Row: ");
					if ((row = scanner.nextInt()) < 0) {
						System.out
								.println("Value needs to be higher than 0 and lower than "
										+ controller.field.getRows());
					}
				}
				while (col < 0 || col > controller.field.getCols()) {
					System.out.println("Col: ");
					if ((col = scanner.nextInt()) < 0) {
						System.out
								.println("Value needs to be higher than 0 and lower than "
										+ controller.field.getCols());
					}
				}
				controller.markCell(row, col);
				returnableGamestate = GAMESTATE.running;

			case 'q':
				returnableGamestate = GAMESTATE.quit;
			default:
				returnableGamestate = GAMESTATE.running;
			}
		}

	}
}
