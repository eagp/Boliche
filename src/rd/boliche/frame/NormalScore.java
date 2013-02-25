package rd.boliche.frame;

public class NormalScore extends DualScore
{
	/* Se heredan los score 1 y 2 y total */

	NormalScore(int s1, int s2) throws IllegalStateException /* Se declara constructor para darle los valores a los score 1 y 2 */
	{
		super(s1, s2); // se utiliza super para llamar al constructor de la clase DualScore 
	}
	
	public String toString() // Se define finalmente como se representa un punto de dos
	{
		if(this.isStrike())
			return " | X";
		else if(this.isSpare())
			return this.getFirstScore() + " | /";
		else 
			return this.getFirstScore() + " | " + this.getSecondScore();  
	}
}
