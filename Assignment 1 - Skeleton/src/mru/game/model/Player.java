package mru.game.model;

public class Player {
	
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
	
	private double ballance;
	private int wins;
	private String fullName;
	
	Player(String name, double bal,int wincount)
	{
		fullName = name;
		ballance = bal;
		wins = wincount;
		
	}
	
	public void setBallance(double bal)
	{
		ballance = bal;
	}
	public void setWin(int win)
	{
		wins = win;
	}
	public void setName( String myName)
	{
		fullName = myName;
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
		System.out.format( "| %2s              |%2.2f             |", fullName, ballance);
		
		
	}
	public void topPlayer()
	{
		System.out.format( "| %2s              |%2d               |", fullName, wins);
		
	}
	
}
