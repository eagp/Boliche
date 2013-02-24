package rd.boliche.frame;

abstract public class Score 
{
	protected int score1;
	protected int score2;
	protected int score3;
	protected int scoreTotal;
	
	Score(int s1, int s2)
	{
		this.score1 = (s1>=0) ? s1 : 0; //si son negativos se convierten en 0
		this.score2 = (s2>=0) ? s2 : 0;

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
	
	public abstract boolean isStrike();
	
	public abstract boolean isSpare();
	
	public abstract void setThirdScore(int score);
	
	public abstract int getThirdScore();

	public abstract int getTriplet();
	
	public abstract boolean isFirstStrike();;
	
	public abstract boolean isFirstSetSpare();
	
	public abstract boolean isPerfect();
}