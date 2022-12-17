package cinema_jetbrains;

import java.util.Locale;
import java.util.Scanner;

public class Cinema {

	private final int rows;
	private final int cols;
	private final int seats;

	// user preferences:
	private int seat;
	private int selectedRow = -1;

	// statics:
	private int countTickets = 0;
	private int currentIncome = 0;

	// Array of seats:
	private String[][] array;

	public Cinema(int rows, int cols) {

		this.rows = rows;
		this.cols = cols;
		this.seats = this.cols * this.rows;
		array = new String[this.rows][this.cols];
		initArray();
	}

	public static Scanner scanner() {

		Scanner scanner = new Scanner(System.in);
		return scanner;
	}

	public static Cinema readCinema() {

		System.out.println("Enter the number of rows:");
		int rows = scanner().nextInt();

		System.out.println("Enter the number of seats in each row:");
		int cols = scanner().nextInt();

		return new Cinema(rows, cols);
	}

	public String makePrintHeader() {

		String[] header = new String[this.cols + 1];
		header[0] = " ";

		for (int i = 1; i <= cols; i++) {
			header[i] = String.valueOf(i);
		}

		return String.join(" ", header);
	}

	public int calculatePriceTicket(int rowSelected) {

		return this.seats < 60 ? 10 : rowSelected <= Math.round(rows / 2) ? 10 : 8;
	}

	public int selectRow() {

		boolean flag;

		
		do {

			System.out.println("Enter a row number:");
			this.selectedRow = scanner().nextInt();

			System.out.println("Enter a seat number in that row:");
			this.seat = scanner().nextInt();

			flag = searchSeatsAvaliable(selectedRow);

			if (flag == true) {

				System.out.println("That ticket has already been purchased!");
			} else {

				array();
				this.countTickets++;
			}
			
		} while (flag == true);

		return selectedRow;
	}

	public int validateInput() {
		
		boolean flag;
		
		
		do{
			
			try {
				
				selectedRow=selectRow();
				flag=false;
			} catch (ArrayIndexOutOfBoundsException e) {
				
				flag = true;
				System.out.printf("Wrong input!%n");
						
			}
			
		}while(flag==true);
		
		return selectedRow;
	}
	public void initArray() {

		for (int i = 0; i < this.array.length; i++) {
			
			for (int j = 0; j < this.array[i].length; j++) {
				
				this.array[i][j] = "S";
			}
		}
	}

	public void printSeats() {

		System.out.println("Cinema: ");
		System.out.println(makePrintHeader());

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array[i].length; j++) {

				if (j == 0) {

					System.out.print(i + 1);
				}

				System.out.print(" " + array[i][j]);
			}

			System.out.println();
		}
	}

	public boolean searchSeatsAvaliable(int rowSelected) {

		boolean flag = false;
		
		for (int i = 0; i < this.array.length; i++) {
			
			for (int j = 0; j < this.array[i].length; j++) {
				
				if (array[rowSelected - 1][this.seat - 1].equals("B")) {
					flag = true;
					break;
				}
			}
		}

		return flag;
	}

	public void array() {

		this.array[selectedRow - 1][this.seat - 1] = "B";
	}

	public int incomefrontAndBackSpace() {

		int front = Math.round(rows / 2);
		int back = rows - front;

		return ((front * cols) * 10) + ((back * cols) * 8);
	}

	public int totalIncome() {

		return seats < 60 ? (seats * 10) : incomefrontAndBackSpace();
	}

	public void statics() {

		System.out.printf("%nNumber of purchased tickets: %d%n", this.countTickets);
		System.out.printf(Locale.US,"Percentage: %.2f%%%n", ((this.countTickets * 100.0)/seats));
		System.out.printf("Current income: $%d%n", this.currentIncome);
		System.out.printf("Total income: $%d%n%n", totalIncome());
	}

	public int selecMenu() {

		System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");

		int option = scanner().nextInt();

		switch (option) {
		case 1:
			printSeats();
			break;
		case 2:
			int price = calculatePriceTicket(validateInput());
			currentIncome += price;
			System.out.printf("%nTicket price: $%d%n%n", price);
			break;
		case 3:
			statics();
			break;
		case 0:
			break;
		}

		return option;
	}

	public static void main(String[] args) {

		Cinema cinema = readCinema();

		int option = -1;

		while (option != 0) {

			option = cinema.selecMenu();
		}
	}

}
