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

import rd.boliche.BowlingScoreFile;
import rd.boliche.frame.DualScore;
import rd.boliche.frame.TripleScore;
import rd.boliche.frame.Score;
import rd.boliche.frame.ScoreFrame;

public class BowlingWindow extends JFrame implements ActionListener
{

	private JFileChooser chooser = new JFileChooser();
	JTextPane textPane;

	private JTextArea textArea = new JTextArea();
	private JTextArea textArea_1 = new JTextArea();

	public BowlingWindow() 
	{
		super("Bowling Scores");
		this.setResizable(false);
		initialize();
		this.setVisible(true);
	}

	private void initialize() 
	{
		this.setBounds(100, 100, 1000, 300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(this);
		btnBrowse.setActionCommand("BROWSE");
		btnBrowse.setBounds(306, 27, 117, 25);
		this.getContentPane().add(btnBrowse);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(this);
		btnStart.setActionCommand("START");
		btnStart.setBounds(100, 263, 117, 25);
		getContentPane().add(btnStart);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(this);
		btnClear.setActionCommand("CLEAR");
		btnClear.setBounds(229, 263, 117, 25);
		getContentPane().add(btnClear);
		
		JLabel lblFile = new JLabel("File:");
		lblFile.setBounds(39, 32, 70, 15);
		this.getContentPane().add(lblFile);
		
		textPane = new JTextPane();
		textPane.setBounds(77, 27, 217, 25);
		this.getContentPane().add(textPane);
		
		JLabel lblPlayer = new JLabel("Player 1:");
		lblPlayer.setBounds(12, 123, 70, 15);
		this.getContentPane().add(lblPlayer);
		
		JLabel lblPlayer_1 = new JLabel("Player 2:");
		lblPlayer_1.setBounds(12, 193, 70, 15);
		this.getContentPane().add(lblPlayer_1);
		
		this.textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(100, 123, 880, 45);
		getContentPane().add(textArea);
		
		this.textArea_1 = new JTextArea();
		textArea.setEditable(false);
		textArea_1.setBounds(100, 193, 880, 45);
		getContentPane().add(textArea_1);
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand() == "BROWSE")
		{
			int val = chooser.showOpenDialog(this);
			if(val == chooser.APPROVE_OPTION)
				this.textPane.setText(chooser.getSelectedFile().toString());
		}
		
		if(e.getActionCommand() == "START")
		{
			this.textArea.setText("");
			this.textArea_1.setText("");
			try
			{
				ScoreFrame sf = new ScoreFrame(new BowlingScoreFile(new File(this.textPane.getText())));
				Score [] ss1 = sf.getScoreOne();
				Score [] ss2 = sf.getScoreTwo();
				
				for(Score s1 : ss1)
					if(s1!=null)
							this.textArea.append(s1.toString() + "\t");
				this.textArea.append("\n");
				for(Score s1 : ss1)
					if(s1!=null)
						this.textArea.append(s1.getTotal() + "\t");
				
				
				for(Score s2 : ss2)
					if(s2!=null)
							this.textArea_1.append(s2.toString() + "\t");
				this.textArea_1.append("\n");
				for(Score s2 : ss2)
					if(s2!=null)
						this.textArea_1.append(s2.getTotal() + "\t");
			}
			catch(IllegalStateException e1)
			{
				new BowlingErrorWindow(e1.getLocalizedMessage());
			}
			catch(Exception e2)
			{
				new BowlingErrorWindow(e2.getLocalizedMessage());
			}
		}
		
		if(e.getActionCommand() == "CLEAR")
		{
			this.textArea.setText("");
			this.textArea_1.setText("");
		}
		
	}
}