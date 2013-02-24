package rd.boliche.frame;

public final class NormalScore extends Score 
{

	NormalScore(int s1, int s2) throws IllegalStateException 
	{
		super(s1, s2);
		if(s1+s2>10)
			throw new IllegalStateException("Numero de puntuacion pasada");
		this.scoreTotal = s1+s2; 
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
