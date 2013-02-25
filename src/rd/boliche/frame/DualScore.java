package rd.boliche.frame;

public abstract class DualScore implements Score 
{
	protected int score1;
	protected int score2;
	protected int scoreTotal;
	
	DualScore(int s1, int s2) throws IllegalStateException 
	{
		this.score1 = (s1>=0) ? s1 : 0; //si son negativos se convierten en 0
		this.score2 = (s2>=0) ? s2 : 0;
		if(s1+s2>10)
			throw new IllegalStateException("Numero de puntuacion pasada");
		this.scoreTotal = s1+s2; 
	}
	
	public int getFirstScore()
	{
		return this.score1;
	}
	
	public int getSecondScore()
	{
		return this.score2;
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

	public void addToTotal(int score)
	{
		this.scoreTotal += score;
	}
	
	public int getTotal()
	{
		return this.scoreTotal;
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
