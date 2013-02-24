package rd.boliche.frame;
import java.util.ArrayList;
import java.util.Iterator;

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
		//this.setScoreTwo();
		this.completePlayerOneScore();
		//this.completePlayerTwoScore();
	}
	
	private void setScoreOne()
	{
		if(this.player1LineScore.isEmpty())
			return;
		int limit = this.player1LineScore.size()/2;
		int it = 0;
		int i;
		for(i = 0; i<limit-1; i++)
		{	
			if(i<9)
				this.score1[i] = new NormalScore(this.player1LineScore.get(it), this.player1LineScore.get(it+1));
			else
				this.score1[i] = new TripleScore(this.player1LineScore.get(it), this.player1LineScore.get(it+1),this.player1LineScore.get(it+2));
			it+=2;
		}
	}
	
	private void setScoreTwo()
	{
		if (this.player2LineScore.isEmpty())
			return;
		int limit = this.player2LineScore.size()/2;
		int it = 0;
		int i;
		for(i = 0; i<limit; i++)
		{
			if(i<9)
				this.score2[i] = new NormalScore(this.player2LineScore.get(it), this.player2LineScore.get(it+1));
			else
				this.score2[i] = new TripleScore(this.player2LineScore.get(it), this.player2LineScore.get(it+1),this.player2LineScore.get(it+2));
			it+=2;
		}
	}
	
	
	private void completePlayerOneScore()
	{
		int limit = this.player1LineScore.size()/2;
		for(int i = 0 ; i<limit && i<9 ; i++)
		{			
			if(score1[i].isStrike())
				score1[i].addToTotal(score1[i+1].getTotal() + score1[i+2].getTotal());
			if(score1[i].isSpare())
				score1[i].addToTotal(score1[i+1].getTotal() + score1[i+1].getFirstScore());
			if(i>0)
				score1[i].addToTotal(score1[i-1].getTotal());
		}
	}
	
	private void completePlayerTwoScore()
	{
		int limit = this.player2LineScore.size()/2;
		for(int i = 0 ; i<limit && i<9 ; i++)
		{			
			if(score2[i].isStrike())
				score2[i].addToTotal(score2[i+1].getTotal() + score2[i+2].getTotal());
			if(score2[i].isSpare())
				score2[i].addToTotal(score2[i+1].getTotal() + score2[i+1].getFirstScore());
			if(i>0)
				score2[i].addToTotal(score2[i-1].getTotal());
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