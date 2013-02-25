package rd.boliche.frame;
import java.util.ArrayList;

import rd.boliche.BowlingScoreFile;

public class ScoreFrame
{
	Score [] score1 = new Score[10]; // Arreglo del score Jugador 1 
	Score [] score2 = new Score[10];
	ArrayList<Integer> player1LineScore; // Arreglo LINEAL del jugador 1
	ArrayList<Integer> player2LineScore;
	
	public ScoreFrame(BowlingScoreFile bf) // Para sacar los valores del txt
	{ 
		player1LineScore = bf.getPlayerOneScore();
		player2LineScore = bf.getPlayerTwoScore();
		// Metodos que se llaman
		this.setScoreOne();
		this.setScoreTwo();
		this.completePlayerOneScore();
		this.completePlayerTwoScore();
	}
	
	private void setScoreOne()  // Llena el score del Jugador 1 
	{
		if(this.player1LineScore.isEmpty())
			return;
		int limit = this.player1LineScore.size()/2;
		int it = 0; //para iterar en los array list
		for(int i = 0; i<limit && this.player1LineScore.get(it)!=null; i++,it+=2)
			if(i<9)
				this.score1[i] = new NormalScore(this.player1LineScore.get(it), this.player1LineScore.get(it+1));
			else
				this.score1[i] = new FinalScore(this.player1LineScore.get(it), this.player1LineScore.get(it+1),this.player1LineScore.get(it+2));
	}
	
	
	private void setScoreTwo() 
	{
		if(this.player2LineScore.isEmpty())
			return;
		int limit = this.player2LineScore.size()/2;
		int it = 0; //para iterar en los array list
		for(int i = 0; i<limit && this.player1LineScore.get(it)!=null; i++,it+=2)
			if(i<9)
				this.score2[i] = new NormalScore(this.player2LineScore.get(it), this.player2LineScore.get(it+1));
			else
				this.score2[i] = new FinalScore(this.player2LineScore.get(it), this.player2LineScore.get(it+1),this.player2LineScore.get(it+2));
	}
	
	
	private void completePlayerOneScore() // Completa los puntos finales del jugador 1
	{
		int limit = this.player1LineScore.size()/2; // se Determina el limite para ese jugador, se divide entre dos para tener el tamaño del score
		for(int i = 0 ; i<limit && i<9 && this.score1[i] != null; i++)   
		{			// Si el primero es strike y el score que viene no es NULL se aplica
			if(score1[i].isStrike() && score1[i+1] != null) 
				// Si el segundo score despues del primer strike es NULL no sigue.
				if(score1[i+1].isStrike() && score1[i+2] != null)
				{ // Si es un strike se le suman 10.
					score1[i].addToTotal(10 + score1[i+2].getFirstScore());
					if(i>0) // Se suman los anterioes 
						score1[i].addToTotal(score1[i-1].getTotal());
					continue;
				}
				else
				{
					if(score1[i+1] != null) // Si es strike pero el otro no es strike se le suman los valores del 1 y 2 
						score1[i].addToTotal(score1[i+1].getFirstScore() + score1[i+1].getSecondScore());
					if(i>0) // si no es el primer score se suma el score anterior 
						score1[i].addToTotal(score1[i-1].getTotal());
					continue;
				}
			if(score1[i].isSpare() && score1[i+1] != null) //Si es un Spare se suma el primer punto al siguiente Tiro
			{
				score1[i].addToTotal(score1[i+1].getFirstScore());
				if(i>0)
					score1[i].addToTotal(score1[i-1].getTotal());
				continue;
			}
			if(i>0) 
				score1[i].addToTotal(score1[i-1].getTotal());
		}
		// se suman los ultimos puntos
		if(this.score1[8]!= null && this.score1[9]!=null)
			score1[9].addToTotal(score1[8].getTotal());
	}
	
	private void completePlayerTwoScore() // Funcion Simetrica al Jugador Anterior 
	{
		int limit = this.player2LineScore.size()/2;
		for(int i = 0 ; i<limit && i<9 && this.score2[i] != null; i++)
		{			
			if(score2[i].isStrike() && score2[i+1] != null)
				if(score2[i+1].isStrike() && score2[i+2] != null)
				{
					score2[i].addToTotal(10 + score2[i+2].getSecondScore());
					if(i>0)
						score2[i].addToTotal(score2[i-1].getTotal());
					continue;
				}
				else
				{
					if(score2[i+1] != null)
						score2[i].addToTotal(score2[i+1].getFirstScore() + score2[i+1].getSecondScore());
					if(i>0)
						score2[i].addToTotal(score2[i-1].getTotal());
					continue;
				}
			if(score2[i].isSpare() && score2[i+1] != null)
			{
				score2[i].addToTotal(score2[i+1].getFirstScore());
				if(i>0)
					score2[i].addToTotal(score2[i-1].getTotal());
				continue;
			}
			if(i>0)
				score2[i].addToTotal(score2[i-1].getTotal());
		}
		
		if(this.score2[8]!= null && this.score2[9]!=null)
			if(this.score2[8]!= null && this.score2[9]!=null)
				score2[9].addToTotal(score2[8].getTotal());
	}
	
	public Score [] getScoreOne()
	{
		return this.score1;
	}
	
	public Score [] getScoreTwo()
	{
		return this.score2;
	}
}