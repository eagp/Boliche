package rd.window;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import rd.boliche.BowlingScoreFile;
import rd.boliche.frame.Score;
import rd.boliche.frame.ScoreFrame;

public class BowlingWindow extends JFrame implements ActionListener
{
	// Parte Grafica Del Programa
	
	private static final long serialVersionUID = 1L;
	// Componentes que se utilizan para el Cliente
	private JFileChooser chooser = new JFileChooser();
	private BowlingScoreFile bsf;
	private JTextPane textPane;
	private JTextArea textArea = new JTextArea();
	private JTextArea textArea_1 = new JTextArea();
	private JButton btnBack;
	private JButton btnNext;
	// Variable que se usan para almacenar en memoria los puntos
	private int printLim = 0;
	private Score [] ss1;
	private Score [] ss2;

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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(this);
		btnBrowse.setActionCommand("BROWSE");
		btnBrowse.setBounds(306, 27, 117, 25);
		this.getContentPane().add(btnBrowse);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(this);
		btnStart.setActionCommand("START");
		btnStart.setBounds(87, 59, 117, 25);
		getContentPane().add(btnStart);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(this);
		btnClear.setActionCommand("CLEAR");
		btnClear.setBounds(213, 59, 117, 25);
		getContentPane().add(btnClear);
		
		JLabel lblFile = new JLabel("File:");
		lblFile.setBounds(39, 32, 70, 15);
		this.getContentPane().add(lblFile);
		
		this.textPane = new JTextPane();
		this.textPane.setBounds(77, 27, 217, 25);
		this.textPane.setEditable(false);
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
		textArea_1.setEditable(false);
		textArea_1.setBounds(100, 193, 880, 45);
		getContentPane().add(textArea_1);
		
		this.btnBack = new JButton("Back");
		this.btnBack.setEnabled(false);
		this.btnBack.addActionListener(this);
		this.btnBack.setActionCommand("BACK");
		btnBack.setBounds(100, 250, 117, 25);
		getContentPane().add(btnBack);
		
		this.btnNext = new JButton("Next");
		this.btnNext.setEnabled(false);
		this.btnNext.addActionListener(this);
		this.btnNext.setActionCommand("NEXT");
		btnNext.setBounds(228, 250, 117, 25);
		getContentPane().add(btnNext);
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand() == "BROWSE") // Funcion del boton que permite leer el archivo
		{ 
			int val = chooser.showOpenDialog(this);
			if(val == JFileChooser.APPROVE_OPTION)
				this.textPane.setText(chooser.getSelectedFile().toString());
			this.btnNext.setEnabled(false);
			this.btnBack.setEnabled(false);
		}
		
		if(e.getActionCommand() == "BACK") //Funcion del boton que permite hechar para atras  un score anterior 
		{
			this.btnNext.setEnabled(true);
			if(this.printLim == 1)
				this.btnBack.setEnabled(false);
			this.printLim = this.printLim == 0 ? 0: this.printLim -1;
			this.scorePrint();
		}
		
		if(e.getActionCommand() == "NEXT")//Funcion del boton que permite avanzar un score para alante.
		{
			this.btnBack.setEnabled(true);
			if(this.ss2[this.printLim/2] == null)
			{
				if(this.printLim == 0)
				{
					this.printLim = this.printLim == 20 ? 20 : this.printLim + 1;
					this.scorePrint();
					this.btnNext.setEnabled(false);
					return;
				}
				else
				{
					this.scorePrint();
					this.btnNext.setEnabled(false);
					return;
				}
			}
			if(this.printLim == 19) //revisa si llego al final de un juego completo
			{
				this.printLim = this.printLim == 20 ? 20 : this.printLim + 1;
				this.scorePrint();
				this.btnNext.setEnabled(false);
			}
			try
			{
				this.printLim = this.printLim == 20 ? 20 : this.printLim + 1;
				if(this.ss1[this.printLim/2] == null)
				{	
					this.scorePrint();
					this.btnNext.setEnabled(false);
					return;
				}
				else if(this.ss1[this.printLim/2] != null && this.ss2[this.printLim/2] == null)
				{
					this.scorePrint();
					//this.btnNext.setEnabled(false);
					return;
				}
				this.scorePrint();
			}
			catch(ArrayIndexOutOfBoundsException aie)
			{
				this.scorePrint();
			}
		}
		
		if(e.getActionCommand() == "START") //Funcion del boton que permite calcular los puntos
		{
			this.printLim = 0;
			this.textArea.setText("");
			this.textArea_1.setText("");
			try // Se leer el archivo y se calculan los puntos y se manejan las excepciones
			{
				this.bsf = new BowlingScoreFile(new File(this.textPane.getText()));
				ScoreFrame sf = new ScoreFrame(bsf);
				this.ss1 = sf.getScoreOne();
				this.ss2 = sf.getScoreTwo();
				this.btnNext.setEnabled(true);
				
				
				if(!bsf.isGameComplete())
					new BowlingErrorWindow("Advertencia: No es un juego completo.\nIgual puede continuar");
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
		
		if(e.getActionCommand() == "CLEAR") //Funcion del boton que permite borrar lo Text Area
		{
			this.printLim = 0;
			this.textArea.setText("");
			this.textArea_1.setText("");
		}
		
	}
	
	private void scorePrint() //Funcion del boton que permite imprimir los puntos 
	{
		this.textArea.setText("");
		this.textArea_1.setText("");
		if(this.printLim == 0)
			return;
		for(int i = 0; i<this.printLim && this.ss1[i/2] != null;i++)
		{
			if(i%2 == 0)
				this.textArea.append(ss1[i/2].toString() + "\t");
			else
				if(this.ss2[i/2] != null)
					this.textArea_1.append(ss2[i/2].toString() + "\t");
		}
		this.textArea.append("\n");
		this.textArea_1.append("\n");
		for(int i = 0; i<this.printLim && this.ss1[i/2] != null;i++)
		{
			if(i%2 == 0)
				this.textArea.append(ss1[i/2].getTotal()+ "\t");
			else
				if(this.ss2[i/2] != null)
					this.textArea_1.append(ss2[i/2].getTotal() + "\t");
		}
	} 
}