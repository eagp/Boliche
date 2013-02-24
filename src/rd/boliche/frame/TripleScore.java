package rd.boliche.frame;

public final class TripleScore extends Score 
{

	private int score3;
	
	TripleScore(int s1, int s2, int s3)
	{
		super(s1,s2);
		this.score3 = (s3>=0 ? s3 : 0);
	}
	
	public int getThirdScore()
	{
		return this.score3;
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
	
	public boolean isPerfect()
	{
		return (this.score1 == 10 && this.score2 == 10 && this.score3 == 10 ? true:false);
	}
	
}
