package mru.game.controller;
import mru.game.model.*;
import mru.game.view.AppMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
	
	/* In this class toy'll need these methods:
	 * A constructor
	 * A method to load the txt file into an arraylist (if it exists, so you check if the txt file exists first)
	 * A save method to store the arraylist into the the txt file 
	 * A method to search for a player based their name
	 * A method to find the top players
	 * Depending on your designing technique you may need and you can add more methods here 
	 */

public class GameManager {
	
	private final String FILE_PATH = "res/CasinoInfo.txt";
	ArrayList<Player> players = new ArrayList<Player>();
	AppMenu appMenu;
	
	public GameManager() throws FileNotFoundException {
		appMenu = new AppMenu();
		
	
		launchGame();
	}
	private void launchGame() { 
		
		char choice = appMenu.mainMenu();
		
		switch (choice) {
		case 'p':
			
			break;
		case 's':
			search();
			break;
		case 'e':
			saveFile();
			break;
		}	
	}
	private void loadFile() throws FileNotFoundException {
		File ci = new File(FILE_PATH);
		
	}
	public void topPlayer() {
		
	}
	public void findPlayer() {
		
	}
	private void saveFile() {
		
	}
	private void search() {
		char choice = appMenu.subMenu();
		
		switch (choice) {
		case 't':
			topPlayer();
			break;
		case 'n':
			findPlayer();
			break;
		case 'b':
			launchGame();
			break;
		}
		
		
		
	}
	
	
	
	

}
