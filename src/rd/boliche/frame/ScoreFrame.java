package rd.boliche.frame;
import java.util.ArrayList;

import rd.boliche.BowlingScoreFile;

public class ScoreFrame
{
	Score [] score1 = new Score[10];
	Score [] score2 = new Score[10];
	ArrayList<Integer> player1LineScore;
	ArrayList<Integer> player2LineScore;
	
	public ScoreFrame(BowlingScoreFile bf)
	{
		player1LineScore = bf.getPlayerOneScore();
		player2LineScore = bf.getPlayerTwoScore();
		this.setScoreOne();
		this.setScoreTwo();
		this.completePlayerOneScore();
		this.completePlayerTwoScore();
	}
	
	private void setScoreOne()
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
	
	
	private void completePlayerOneScore()
	{
		int limit = this.player1LineScore.size()/2;
		for(int i = 0 ; i<limit && i<9 && this.score1[i] != null; i++)
		{			
			if(score1[i].isStrike())
				if(score1[i+1].isStrike() && score1[i+1] != null)
				{
					score1[i].addToTotal(10 + score1[i+2].getFirstScore());
					if(i>0)
						score1[i].addToTotal(score1[i-1].getTotal());
					continue;
				}
				else
				{
					if(score1[i+1] != null)
						score1[i].addToTotal(score1[i+1].getFirstScore() + score1[i+1].getSecondScore());
					if(i>0)
						score1[i].addToTotal(score1[i-1].getTotal());
					continue;
				}
			if(score1[i].isSpare() && score1[i+1] != null)
			{
				score1[i].addToTotal(score1[i+1].getFirstScore());
				if(i>0)
					score1[i].addToTotal(score1[i-1].getTotal());
				continue;
			}
			if(i>0)
				score1[i].addToTotal(score1[i-1].getTotal());
		}
		
		if(this.score1[8]!= null && this.score1[9]!=null)
			score1[9].addToTotal(score1[8].getTotal());
	}
	
	private void completePlayerTwoScore()
	{
		int limit = this.player2LineScore.size()/2;
		for(int i = 0 ; i<limit && i<9 && this.score2[i] != null; i++)
		{			
			if(score2[i].isStrike())
				if(score2[i+1].isStrike() && score2[i+1] != null)
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
		{
			if(score2[9].isPerfect())
				score2[9].addToTotal(10);
			else if(score2[9].isFirstStrike())
				score2[9].addToTotal(score2[9].getSecondScore() + score2[9].getThirdScore());
			else if(score2[9].isFirstSetSpare())
				score2[9].addToTotal(score2[9].getThirdScore());
			score2[9].addToTotal(score2[8].getTotal());
		}
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