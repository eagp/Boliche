package rd.boliche.frame;

public class FinalScore extends TripleScore 
{

	FinalScore(int s1, int s2, int s3) throws IllegalStateException 
	{
		super(s1, s2, s3);
		this.scoreTotal = s1+s1;
	}

	public String toString()
	{
		if(this.isPerfect())
			return "X | X | X";
		else if(this.isFirstStrike() && this.score2 == 10)
			return "X | X | " + this.score3;
		else if(this.isFirstStrike())
			return "X | " + this.score2 + " | " + this.score3;
		else if(this.isFirstSetSpare() && this.score3 == 10)
			return this.getFirstScore() + " | / | X";
		else if(this.isFirstSetSpare())
			return this.getFirstScore() + " | / | " + this.getThirdScore();
		else
			return this.getFirstScore() + " | " + this.getSecondScore();  
	}
}
