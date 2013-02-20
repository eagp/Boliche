package rd.window;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class BowlingWindow extends JFrame implements ActionListener
{

	private JFileChooser chooser = new JFileChooser();
	JTextPane textPane;
	private JLabel lblPlayer;
	private JLabel lblPlayer_1;

	public BowlingWindow() 
	{
		super("Bowling Scores");
		initialize();
		this.setVisible(true);
	}

	private void initialize() 
	{
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(this);
		btnBrowse.setActionCommand("Browse");
		btnBrowse.setBounds(306, 27, 117, 25);
		this.getContentPane().add(btnBrowse);
		
		JLabel lblFile = new JLabel("File:");
		lblFile.setBounds(39, 32, 70, 15);
		this.getContentPane().add(lblFile);
		
		textPane = new JTextPane();
		textPane.setBounds(77, 27, 217, 25);
		this.getContentPane().add(textPane);
		
		lblPlayer = new JLabel("Player 1:");
		lblPlayer.setBounds(12, 123, 70, 15);
		this.getContentPane().add(lblPlayer);
		
		lblPlayer_1 = new JLabel("Player 2:");
		lblPlayer_1.setBounds(12, 193, 70, 15);
		this.getContentPane().add(lblPlayer_1);
	
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand() == "Browse")
		{
			int val = chooser.showOpenDialog(this);
			if(val == chooser.APPROVE_OPTION)
				this.textPane.setText(chooser.getSelectedFile().toString());
		}
	}

}