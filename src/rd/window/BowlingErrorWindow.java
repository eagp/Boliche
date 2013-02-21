package rd.window;

import javax.swing.JOptionPane;

public class BowlingErrorWindow extends JOptionPane
{
	public BowlingErrorWindow(String s) 
	{
		this.showMessageDialog(null,s,"Warning", JOptionPane.WARNING_MESSAGE);
	}
}
