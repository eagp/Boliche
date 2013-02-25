package rd.boliche.frame;

public abstract class TripleScore implements Score 
{
	protected int score1;
	protected int score2;
	protected int score3;
	protected int scoreTotal;
	
	TripleScore(int s1, int s2, int s3) throws IllegalStateException
	{
		this.score1 = (s1>=0) ? s1 : 0; //si son negativos se convierten en 0
		this.score2 = (s2>=0) ? s2 : 0;
		
		if(this.score1 + this.score2 > 10 && !this.isFirstStrike())
				throw new IllegalStateException("Puntuacion pasada");
		this.score3 = (s3>=0 ? s3 : 0);
		if(!this.isFirstStrike() && !this.isPerfect() && !this.isFirstSetSpare())
			this.scoreTotal = score1 + score2;
		else
			this.scoreTotal = this.score1 + this.score2 + this.score3;
	}
	
	public int getFirstScore()
	{
		return this.score1;
	}
	
	public int getSecondScore()
	{
		return this.score2;
	}
	
	public void addToTotal(int num)
	{
		this.scoreTotal += num;
	}
	
	public void setThirdScore(int score)
	{
		this.score3 = score;	
	}
	
	public int getThirdScore()
	{
		return this.score3;
	}
	
	public boolean isFirstStrike()
	{
		return (this.score1 == 10 ? true:false);
	}
	
	public boolean isFirstSetSpare()
	{
		return (this.isFirstStrike() ? false : this.score1 + this.score2== 10 ? true : false);
	}
	
	public boolean isPerfect()
	{
		return (this.score1 == 10 && this.score2 == 10 && this.score3 == 10 ? true:false);
	}
	
	public int getTotal()
	{
		return this.scoreTotal;
	}
	
	public abstract String toString();
	
	/*
	 * metodos que no deben ser heredados
	 * */
	
	@Override
	public final boolean isStrike() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final boolean isSpare() {
		// TODO Auto-generated method stub
		return false;
	}	
}
