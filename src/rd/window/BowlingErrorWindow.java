package rd.window;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class BowlingErrorWindow extends JOptionPane
{

	private static final long serialVersionUID = 1L;

	public BowlingErrorWindow(String s) 
	{
		JOptionPane.showMessageDialog(null,s,"Advertencia", JOptionPane.WARNING_MESSAGE,new ImageIcon("src/pony.png"));
	}
}
