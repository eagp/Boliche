package rd.boliche;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public final class BowlingScoreFile
{
	
	private BufferedReader file;
	// se crean arreglos para guardar los puntos  LINEALMENTE. 
	
	private ArrayList<Integer> extracted = new ArrayList<Integer>();
	private ArrayList<Integer> player1 = new ArrayList<Integer>();
	private ArrayList<Integer> player2 = new ArrayList<Integer>();
	
	
	public BowlingScoreFile(File f) throws IllegalStateException
	{
		// Se utiliza un try para poder tirar una excepcion
		try
		{
			this.file = new BufferedReader(new FileReader(f)); // se Lee un Archivo f
			String s = null; 
			while((s = this.file.readLine()) != null && this.extracted.size()<42) //va llenando la lista extracted del archivo, 42 siendo el maximo posible de tiros
			{
				// Si hay una linea vacia en el archivo tira una Excepcion 
				if(s.length() == 0)
					throw new IllegalStateException("Archivo Invalido: Linea Vacia\nPor favor edite bien el archivo");
				// Si no existe linea vacia se agrega el numero 
				this.extracted.add(new Integer(	s));
			}
			
			if(this.extracted.size() == 0)
				throw new IllegalStateException("no se puede usar un archivo vacio");  //no se le da soporte a un archivo vacio
			
			if(this.extracted.size() % 2 != 0 && this.extracted.size()<36) //si falta el segundo tiro de cualquier jugador se asume como archivo invalido
				throw new IllegalStateException("Archivo Invalido: Jugadas Incompletas");
			
			if(this.extracted.size() > 36 && this.extracted.size() <= 39) //no hay soporte si las jugadas finales estan incompletas
				throw new IllegalStateException("Archivo Invalido: Jugadas Finales Incompletas para jugador 1");
			else if(this.extracted.size() > 39 && this.extracted.size() < 42) 
				throw new IllegalStateException("Archivo Invalido: Jugadas Finales Incompletas para jugador 2");
			
			if(this.extracted.size()>0)
				this.setPlayerOneScore();				
			if(this.extracted.size()>2) //si el segundo jugador todavia no a jugado por primera vez no pone su score, situaciones para manejar scores incompletos.
				this.setPlayerTwoScore();
		}
		catch(IllegalStateException e1) 
		{
			throw new IllegalStateException(e1.getLocalizedMessage());
		}
		catch(Exception e2)
		{
			throw new IllegalStateException("Archivo Invalido! " + e2.getLocalizedMessage());
		}
	}
	
	private void setPlayerOneScore()
	{
		// Se pone el score al jugador 1 linealmente.
		
		for(int i = 0; i<this.extracted.size();i+=3)
		{
			if(this.extracted.size() == 42 && this.player1.size() == 18)		
			{
				// se ponen los ultimos puntos.
				this.player1.add(this.extracted.get(36));
				this.player1.add(this.extracted.get(37));
				this.player1.add(this.extracted.get(38));
				return;
			} 
			// se ponen los valores que no son Finales.
			this.player1.add(this.extracted.get(i));
			i++;
			this.player1.add(this.extracted.get(i));
		}
	}
	
	public ArrayList<Integer> getPlayerOneScore()
	{ // Se devuelve el arreglo 1
		return this.player1;
	}
	
	private void setPlayerTwoScore() // Se pone linealmente igual que el player 1
	{
		for(int i = 2; i<this.extracted.size();i+=3)
		{
			if(this.extracted.size() == 42 && this.player2.size()==18)
			{
				this.player2.add(this.extracted.get(39));
				this.player2.add(this.extracted.get(40));
				this.player2.add(this.extracted.get(41));
				break;
			}
			this.player2.add(this.extracted.get(i));
			i++;
			this.player2.add(this.extracted.get(i));
		}
	}
	
	public ArrayList<Integer> getPlayerTwoScore()
	{ 
		return this.player2;
	}
	
	public boolean isGameComplete() // Se pone un booleano para saber si el juego esta completo o no 
	{
		return this.extracted.size() == 42 ? true : false;
	}
}