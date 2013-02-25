package rd.boliche.frame;

public abstract class TripleScore implements Score 
{
	/*  Clase que implementa la interface Score para el puntaje Final de manera Abstracta*/
	
	protected int score1;  // Se declara la variable para score 1, 2, 3, total   
	protected int score2;
	protected int score3;
	protected int scoreTotal;
	
	TripleScore(int s1, int s2, int s3) throws IllegalStateException
	{
		this.score1 = (s1>=0) ? s1 : 0; //si son negativos se convierten en 0
		this.score2 = (s2>=0) ? s2 : 0;
		
		if(this.score1 + this.score2 > 10 && !this.isFirstStrike())
				throw new IllegalStateException("Puntuacion pasada");
		 // Si el primero no es strike la suma de los score 1 y 2 no puede dar mas de 10
		this.score3 = (s3>=0 ? s3 : 0);
		if(this.score3>10)
			throw new IllegalStateException("Puntuacion pasada");
		if(!this.isFirstStrike() && !this.isPerfect() && !this.isFirstSetSpare())
			this.scoreTotal = score1 + score2;
		// Si no se cumplen niguno de los metodos anteriores se suma los score 1 y 2
		else
			// Se suman los 3 si no se cumple lo anterior
			this.scoreTotal = this.score1 + this.score2 + this.score3;
	}
	
	/* Se impletaron los metodos que se necesitan para un score de Tres */
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
	
	public abstract String toString(); // es abstrato por que no se aclara que es un score de Tres.
	
	/*
	 * metodos que no deben ser heredados porque no son propios de un score de Tres 
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
