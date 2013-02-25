package rd.boliche.frame;

public class FinalScore extends TripleScore 
{
	/* Se heredan los score 1, 2, 3 y total */
	
	FinalScore(int s1, int s2, int s3) throws IllegalStateException 
	{
		super(s1, s2, s3); // se utiliza super para llamar al constructor de la clase TripleScore
	}

	public String toString()  // Se define finalmente como se representa un punto final.
	{
		if(this.isPerfect())
			return "X | X | X";
		else if(this.isFirstStrike() && this.score2 == 10)
			return "X | X | " + this.score3;
		else if(this.isFirstStrike() && this.score3 == 10)
			return "X | " + this.score2+ " | X";
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
