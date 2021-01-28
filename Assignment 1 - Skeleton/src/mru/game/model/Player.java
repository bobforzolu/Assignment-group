package mru.game.model;

public class Player {
	
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
	
	private double ballance;
	private int wins;
	private String fullName;
	
	public Player(String name, double bal,int winCount)
	{
		fullName = name;
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
		fullName = name;
	}
	public double getBallance()
	{
		return ballance;
	}
	public int getWin()
	{
		return wins;
	}
	public String setName()
	{
		return fullName;
	}
	
	
	public void playerinfo()
	{
		System.out.format( "| %2s            |%2.2f        |%2.2d        |", fullName, ballance, wins);
		
		
	}
	public void topPlayer()
	{
		System.out.format( "| %2s              |%2d               |", fullName, wins);
		
	}
	
}
