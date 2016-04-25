package Projet.GUI;
import java.awt.*;
import javax.swing.*;

public class MenuJeu extends JPanel{
	JFrame frame;
	private JPanel panel;
	private JButton startButton;
	private JTextArea textArea;
	
	public MenuJeu(){
		initialiaze();
	}
	public void initialiaze(){
		JFrame frame = new JFrame("Inglorious batârds");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		JLabel label1 = new JLabel("Nouvelle partie ! Taille :");
	    panel.add(label1);
		frame.getContentPane().add(panel);
		textArea = new JTextArea(1,5);
		startButton = new JButton("Commencer");
		startButton.addActionListener(new startActionListener(textArea)); 
		panel.add(textArea); 
		panel.add(startButton); 
		frame.pack();
		frame.setVisible(true);
	}
}
