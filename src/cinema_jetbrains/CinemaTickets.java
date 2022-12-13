package cinema_jetbrains;

import java.util.Scanner;

public class CinemaTickets {
	private final int rows;
	private final int cols;
	private final int seats;
	private int seat;

	public CinemaTickets(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.seats = this.cols * this.rows;
	}

	public static Scanner scanner() {
		Scanner scanner = new Scanner(System.in);
		return scanner;
	}

	public static CinemaTickets readCinema() {

		System.out.println("Enter the number of rows:");
		int rows = scanner().nextInt();
		System.out.println("Enter the number of seats in each row:");
		int cols = scanner().nextInt();

		return new CinemaTickets(rows, cols);
	}

	public String makePrintHeader() {
		String[] header = new String[this.cols + 1];
		header[0] = " ";
		for (int i = 1; i <= cols; i++) {
			header[i] = String.valueOf(i);
		}

		return String.join(" ", header);
	}

	public void makeAllSeats() {
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				if (j == 0) {
					System.out.print(i + 1);
				}
				System.out.print(" S");
			}
			System.out.println();
		}

	}

	public void printSeats() {

		String header = makePrintHeader();
		System.out.println("Cinema:");
		System.out.println(header);
		makeAllSeats();
	}

	public int frontSits() {
		int frontSite = Math.round(rows / 2);
		return frontSite;
	}

	public int calculatePriceTicket(int row) {
		int priceTicket;
		if (this.seats < 60) {
			priceTicket = 10;
		} else {

			int frontSite = frontSits();
			if (row <= frontSite) {
				priceTicket = 10;
			} else {
				priceTicket = 8;
			}
		}
		return priceTicket;
	}

	public int selectRow() {
		System.out.println("Enter a row number:");
		int rowSelected = scanner().nextInt();
		System.out.println("Enter a seat number in that row:");
		this.seat = scanner().nextInt();

		return rowSelected;
	}

	public void array( int selectRow) {

		String[][] array = new String[this.rows][this.cols];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = "S";
			}
		}

		array[selectRow - 1][this.seat - 1] = "B";

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
	public int selecMenu() {
		System.out.println("1. Show the seats:\n"
				+ "2. Buy a ticket\n"
				+ "0. Exit");
		int option = scanner().nextInt();
		
		switch (option) {
		case 1 : printSeats();break;
		case 2 :System.out.println("Ticket price: $"+calculatePriceTicket(selectRow()));break;
		case 0 ://TODO:EXIT:;
		}
		return option;
	}

	public static void main(String[] args) {

		CinemaTickets cinema = readCinema();
		
		/*
		cinema.printSeats();
		int selectRow = cinema.selectRow();
		int priceTicket = cinema.calculatePriceTicket(selectRow);
		System.out.println("Ticket price: $" + priceTicket);

		cinema.array(selectRow);
		*/
		int option=-1;
		while(option!=0) {
			
		option=cinema.selecMenu();
		}
		
		
	}

}
