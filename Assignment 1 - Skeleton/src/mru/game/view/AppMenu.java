package mru.game.view;

import java.util.Scanner;

public class AppMenu {
	
	public void menu() {
		
		char choice;

		Scanner keyboard =  new Scanner(System.in);
		
		mainMenu();
		
		choice = keyboard.next().charAt(0);
		
		if (choice == 'P' || choice == 'p') {
			
			
			
			
		} else if (choice == 'S' || choice == 's') {
			System.out.print("\nSelect one of these options;\n"
					+ "\n        (T) Top player (Most number of wins)"
					+ "\n        (N) Looking for a name"
					+ "\n        (B) Back to Main menu"
					+ "\n\nEnter a choice: ");
		
			choice = keyboard.next().charAt(0);
			
			if (choice == 'T' || choice == 't') {
				
				// list of top players goes here
				System.out.print("\nPress \"Enter\" to continue...");
				
			} else if (choice == 'N' || choice == 'n') {
				System.out.print("\nEnter your name: ");
				
				
				
				
				System.out.print("\nPress \"Enter\" to continue...");
			} else if (choice == 'B' || choice == 'b') {
				menu();
				choice = keyboard.next().charAt(0);
			}
		} else if (choice == 'E' || choice == 'e') {
			System.out.print("\nSaving...\n"
					+ "Done! Please visit us again!");
		}
	}
	
	public static void mainMenu() {
		System.out.print("\nSelect one of these options: \n"
				+ "\n"
				+ "       (P) Play game\n"
				+ "       (S) Search\n"
				+ "       (E) Exit\n"
				+ "\n"
				+ "Enter a choice: ");
	}
	
	/**
	 * This class will be used to show the menus and sub menus to the user
	 * It also prompts the user for the inputs and validates them 
	 */
	
	
}
