package mru.game.model;

	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
public class Player {
	
	
	
	/**
	 * total ballance
	 */
	private double balance;
	/**
	 * total win
	 */
	private int wins;
	/**
	 * name of the player
	 */
	private String playerName;
	
	/**
	 * the constructer sets up the player name, ballance and wins
	 * @param name the name of the player
	 * @param bal the players ballance
	 * @param winCount total wins of the player
	 */
	public Player(String name, double bal,int winCount)
	{
		playerName = name;
		balance = bal;
		wins = winCount;
		
	}
	/**
	 * player constructer
	 */
	public Player()
	{
		
		
	}
	/**
	 * Assigns a ballence to the player
	 * @param bal the players ballance 
	 */
	public void setBalance(double bal)
	{
		balance = bal;
	}
	/**
	 * Assigns a name to the player
	 * @param winCount player win amount
	 */
	public void setWin(int winCount)
	{
		wins = winCount;
	}
	/**
	 * Assigns a name to the player
	 * @param name 
	 */
	public void setName(String name)
	{
		playerName = name;
	}
	/**
	 * returns players balance
	 * @return balance
	 */
	public double getBalance()
	{
		return balance;
	}
	/**
	 * returns players win
	 * @return wins
	 */
	public int getWin()
	{
		return wins;
	}
	/**
	 * returns player name
	 * @return playerName
	 */
	public String getName()
	{
		return playerName;
	}
	
	
	/**
	 *@decription saves the player data
	 */
	public String toString() {
		
		String info = "\n              -PLAYER INFO-           "
				+ "\n+==============+==========+==============+"
				+ "\n|NAME          |# WINS    |BALANCE       |" 
				+ "\n+==============+==========+==============+"
				+ "\n|"+playerName+"|"+wins+"  |$"+balance+"  |"
				+ "\n+--------------+----------+--------------+";

		return info;
		
		/*
		System.out.printf("\n              --PLAYER INFO--             "
						+ "\n+==============+==========+==============+"
						+ "\n|NAME          |# WINS    |BALANCE       |" 
						+ "\n+==============+==========+==============+"
						+ "\n|%-14s|%-10d|$%-13.2f|"
						+ "\n+--------------+----------+--------------+", playerName, wins, balance);
		*/
	}

	/**
	 *@decription prints the information of the top players
	 *@param none
	 * @return none
	 */
	public void topPlayer()
	{
		
		System.out.printf(
				 "%n|%-17s|%-17d|                         "
			   + "%n+-----------------+-----------------+", playerName, wins);
		
	}
	/**
	 *@decription a string used to save player data
	 *@param none
	 * @return none
	 */
	public String format() {
		return playerName + "," + balance + "," + wins;
	}
	
	public void newPlayer() {
		System.out.printf("Welcome" + playerName + "Your initial balance is: " + balance + "$");
	}
}

