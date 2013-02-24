package rd.boliche.frame;

public abstract class TripleScore extends Score 
{

	protected int score3;
	
	TripleScore(int s1, int s2, int s3) throws IllegalStateException
	{
		super(s1,s2);
		if(this.score1 + this.score2 > 10 && !this.isFirstStrike())
				throw new IllegalStateException("Puntuacion pasada");
		this.score3 = (s3>=0 ? s3 : 0);
		if(!this.isFirstStrike() && !this.isPerfect() && !this.isFirstSetSpare())
			this.scoreTotal = score1 + score2;
		else
			this.scoreTotal = this.getTriplet();
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
		return (this.isFirstStrike() ? false : this.score1 + this.score2== 10 ? true : false);
	}
	
	public boolean isPerfect()
	{
		return (this.score1 == 10 && this.score2 == 10 && this.score3 == 10 ? true:false);
	}

	public void setThirdScore(int score) 
	{
		this.score3 = score;
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
