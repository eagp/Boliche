package rd.window;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class BowlingErrorWindow extends JOptionPane
{
	public BowlingErrorWindow(String s) 
	{
		this.showMessageDialog(null,s,"Advertencia", JOptionPane.WARNING_MESSAGE,new ImageIcon("src/pony.png"));
	}
}
