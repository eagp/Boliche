package rd.boliche.frame;

public interface Score 
{
	/* Se declara interface por que se necesita estos metodos, pero van a funcionar diferentes para las demas clases. 
	 * se pone de esta manera porque es un arreglo de tipo Score.
	  */
	 
	public int getTotal(); // Se declara un metodo para determinar el total de un score
	
	public int getFirstScore(); // se declara un metodo para determinar el Primer Punto
	
	public int getSecondScore();// se declara un metodo para determinar el Segundo Punto
	
	public boolean isStrike();// se declara un metodo para determinar si es un Strike
	
	public boolean isSpare();// se declara un metodo para determinar si es un Spare 
	
	public void setThirdScore(int score);// se declara un metodo para dar el valor del tercer punto.
	
	public int getThirdScore();// se declara un metodo para determinar el tercer punto.

	public boolean isFirstStrike();;// se declara un metodo para determinar si el primero es strike de un score
	
	public boolean isFirstSetSpare();// se declara un metodo para determinar si el primero es un spare en un score
	
	public boolean isPerfect();// se declara un metodo para determinar si el juego es perfecto.
	
	public void addToTotal(int num);// se declara un metodo para acumular los puntos de cada jugada.
	
	public String toString();// se declara un metodo para representar como string lo que se va a imprimir.
}