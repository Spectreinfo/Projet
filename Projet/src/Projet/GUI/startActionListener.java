package Projet.GUI;
import java.awt.event.*; 
import javax.swing.JTextArea;
import Projet.GUI.*;
import Projet.Autre.*;

public class startActionListener implements ActionListener {
	JTextArea textArea;
	static int taille;
	public startActionListener(JTextArea textArea){
		this.textArea = textArea; 
		}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{
			String s = textArea.getText();
			taille = Integer.valueOf(s);
			Window window = new Window();
			Jeu jeu= new Jeu(taille, window);
	    	Keyboard keyboard = new Keyboard(jeu); 
	    	window.setKeyListener(keyboard); 
		}catch(java.lang.NumberFormatException e){
			textArea.setText("un nombre, merde !");
		}
	}
}
