package rd.boliche;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public final class BowlingScoreFile
{
	private BufferedReader file;
	private ArrayList<Integer> extracted = new ArrayList<Integer>();
	private ArrayList<Integer> player1 = new ArrayList<Integer>();
	private ArrayList<Integer> player2 = new ArrayList<Integer>();
	
	
	public BowlingScoreFile(File f) throws IllegalStateException
	{
		try
		{
			this.file = new BufferedReader(new FileReader(f));
			String s = null;
			while((s = this.file.readLine()) != null && this.extracted.size()<42) //va llenando la lista extracted del archivo
			{
				if(s.length() == 0)
					throw new IllegalStateException("Archivo Invalido: Linea Vacia");
				this.extracted.add(new Integer(	s));
			}
			
			if(this.extracted.size() == 0)
				throw new IllegalStateException("no se puede usar un archivo vacio");  //no se le da soporte a 
			
			if(this.extracted.size() % 2 != 0) //si falta el segundo tiro de cualquier jugador se asume como archivo invalido
				throw new IllegalStateException("Archivo Invalido: Jugadas Incompletas");
			
			if(this.extracted.size()>0)
				this.setPlayerOneScore();				
			if(this.extracted.size()>2) //si el segundo jugador todavia no a jugado por primera vez no pone su score
				this.setPlayerTwoScore();
		}
		catch(IllegalStateException e1)
		{
			throw new IllegalStateException(e1.getLocalizedMessage());
		}
		catch(Exception e2)
		{
			throw new IllegalStateException("Archivo Invalido!");
		}
	}
	
	private void setPlayerOneScore()
	{
		for(int i = 0; i<this.extracted.size();i+=3)
		{
			if(this.extracted.size() == 42 && this.player1.size() == 18)
			{
				this.player1.add(this.extracted.get(36));
				this.player1.add(this.extracted.get(37));
				this.player1.add(this.extracted.get(38));
				return;
			}
			this.player1.add(this.extracted.get(i));
			i++;
			this.player1.add(this.extracted.get(i));
		}
	}
	
	public ArrayList<Integer> getPlayerOneScore()
	{
		return this.player1;
	}
	
	private void setPlayerTwoScore()
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
	
	public boolean isGameComplete()
	{
		return this.extracted.size() == 42 ? true : false;
	}
}