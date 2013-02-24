package rd.boliche.frame;

public abstract class DualScore extends Score 
{

	DualScore(int s1, int s2) throws IllegalStateException 
	{
		super(s1, s2);
		if(s1+s2>10)
			throw new IllegalStateException("Numero de puntuacion pasada");
		this.scoreTotal = s1+s2; 
	}

	public  boolean isStrike()
	{
		return (this.score1==10) ? true:false;
	}
	
	public  boolean isSpare()
	{
		if(this.score1 != 10 && (this.score1 + this.score2 == 10))
			return true;
		return false;
	}

	@Override
	public final void setThirdScore(int score) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final int getThirdScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public final int getTriplet() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public final boolean isFirstStrike() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final boolean isFirstSetSpare() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final boolean isPerfect() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public abstract String toString();
}
