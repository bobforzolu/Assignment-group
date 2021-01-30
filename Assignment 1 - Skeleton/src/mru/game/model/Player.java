package mru.game.model;

public class Player {
	
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
	
	private double balance;
	private int wins;
	private String playerName;
	
	public Player(String name, double bal,int winCount)
	{
		playerName = name;
		balance = bal;
		wins = winCount;
		
	}
	
	public void setBalance(double bal)
	{
		balance = bal;
	}
	public void setWin(int winCount)
	{
		wins = winCount;
	}
	public void setName(String name)
	{
		playerName = name;
	}
	public double getBalance()
	{
		return balance;
	}
	public int getWin()
	{
		return wins;
	}
	public String getName()
	{
		return playerName;
	}
	
	
	public String toString()
	{
		
		
		String info = "\n              -PLAYER INFO-           "
				+ "\n+==============+==========+==============+"
				+ "\n|NAME          |# WINS    |BALANCE       |" 
				+ "\n+==============+==========+==============+"
				+ "\n|"+playerName+"|"+wins+"  |$"+balance+"  |"
				+ "\n+--------------+----------+--------------+";
		
		return info;
		
	}
	public void topPlayer()
	{
		
		System.out.printf("%n      -PLAYER INFO-          "
				+ "%n+=================+=================+"
				+ "%n|NAME             |# WINS           |"
				+ "%n+=================+=================+"
				+ "%n|%s               |%d               |"
				+ "%n+-----------------+-----------------+"
				+ "%n|%s               |%d               |"
				+ "%n+-----------------+-----------------+", playerName, wins, playerName, wins);
		
	}
	public String format() {
		return playerName + "," + balance + "," + wins;
	}
}

