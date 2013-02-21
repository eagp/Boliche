package rd.boliche.frame;

public class Score 
{
	protected int score1;
	protected int score2;
	protected int scoreTotal;
	
	Score(int s1, int s2) throws IllegalStateException
	{
		this.score1 = (s1>=0) ? s1 : 0; //si son negativos se convierten en 0
		this.score2 = (s2>=0) ? s2 : 0;
		if(s1+s2>10)
			throw new IllegalStateException("Numero de puntuacion pasada");
		this.scoreTotal = s1+s2; 
	}

	public void addToTotal(int num)
	{
		this.scoreTotal += num;
	}
	
	public int getTotal()
	{
		return this.scoreTotal;
	}
	
	public int getFirstScore()
	{
		return this.score1;
	}
	
	public int getSecondScore()
	{
		return this.score2;
	}
	
	public final boolean isStrike()
	{
		return (this.score1==10) ? true:false;
	}
	
	public final boolean isSpare()
	{
		if(this.score1 != 10 && (this.score1 + this.score2 == 10))
			return true;
		return false;
	}
}