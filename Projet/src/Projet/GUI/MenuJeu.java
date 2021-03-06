package Projet.GUI;
import javax.swing.*;

public class MenuJeu extends JPanel{
	//Menu du jeu instanciant la partie (soit une nouvelle, soit un chargement)
	private JFrame frame;
	private JPanel panel;
	private JButton startButton;
	private JButton loadButton;
	private JTextArea textArea;
	
	public MenuJeu(){
		initialize();
	}
	private void initialize(){
		JFrame frame = new JFrame("Gandalf vs the JARS JARS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		JLabel label1 = new JLabel("Nouvelle partie ! Taille :");
	    panel.add(label1);
		frame.getContentPane().add(panel);
		textArea = new JTextArea(1,5);
		loadButton = new JButton("Charger");
		startButton = new JButton("Commencer");
		startButton.addActionListener(new startActionListener(textArea)); 
		loadButton.addActionListener(new loadActionListener(textArea)); 
		panel.add(textArea); 
		panel.add(startButton); 
		panel.add(loadButton); 
		frame.pack();
		frame.setVisible(true);
	}
}
