package rd.window;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class BowlingErrorWindow extends JOptionPane
{
	/* Determinar los errores a nivel grafico */
	private static final long serialVersionUID = 1L;

	public BowlingErrorWindow(String s) 
	{
		JOptionPane.showMessageDialog(null,s,"Advertencia", JOptionPane.WARNING_MESSAGE,new ImageIcon(getClass().getResource("/images/pony.png")));
	}
}
