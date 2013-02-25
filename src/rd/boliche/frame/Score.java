package rd.boliche.frame;

public interface Score 
{
	
	public int getTotal();
	
	public int getFirstScore();
	
	public int getSecondScore();
	
	public boolean isStrike();
	
	public boolean isSpare();
	
	public void setThirdScore(int score);
	
	public int getThirdScore();

	public boolean isFirstStrike();;
	
	public boolean isFirstSetSpare();
	
	public boolean isPerfect();
	
	public void addToTotal(int num);
	
	public String toString();
}