package rd.boliche.frame;

public final class FinalScore extends Score 
{

	private int score3;
	
	FinalScore(int s1, int s2) 
	{
		super(s1, s2);
	}
	
	FinalScore(int s1, int s2, int s3)
	{
		super(s1,s2);
		this.score3 = s3;
	}
	
	public void setThirdScore(int score)
	{
		this.score3 = (score>=0 ? score : 0);
	}

	public int getTriplet()
	{
		return this.score1 + this.score2 + this.score3;
	}
	
	public boolean isFirstStrike()
	{
		return (this.score1 == 10 ? true:false);
	}
	
	public boolean isFirstSetSpare()
	{
		return (this.isFirstStrike() ? false : this.getTotal() == 10 ? true : false);
	}
	
}
