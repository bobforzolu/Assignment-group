package mru.game.model;

public class Player {
	
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
	
	private double ballance;
	private int wins;
	private String playerName;
	
	public Player(String name, double bal,int winCount)
	{
		playerName = name;
		ballance = bal;
		wins = winCount;
		
	}
	
	public void setBallance(double bal)
	{
		ballance = bal;
	}
	public void setWin(int winCount)
	{
		wins = winCount;
	}
	public void setName(String name)
	{
		playerName = name;
	}
	public double getBallance()
	{
		return ballance;
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
		String info = "|name: "+playerName+"| |ballance: $"+ ballance+ "|| wins:" +wins+"|";
		
		return info;
		
	}
	public void topPlayer()
	{
		
		System.out.format( "|%2s              |%2d               %n", playerName, wins);
		
	}
	
}
