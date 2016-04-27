package Projet.GUI;
import java.awt.*;
import javax.swing.*;

public class MenuJeu extends JPanel{
	JFrame frame;
	private JPanel panel;
	private JButton startButton;
	private JButton loadButton;
	private JTextArea textArea;
	
	public MenuJeu(){
		initialiaze();
	}
	public void initialiaze(){
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
