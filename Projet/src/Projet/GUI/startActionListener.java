package Projet.GUI;
import java.awt.event.*; 
import javax.swing.JTextArea;
import Projet.GUI.*;
import Projet.Autre.*;

public class startActionListener implements ActionListener {
	//Pour commencer la première partie
	private JTextArea textArea;
	public static int taille;
	public startActionListener(JTextArea textArea){
		this.textArea = textArea; 
		}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{												//Emploi d'un try catch pour s'assurer de l'entrée d'un nombre
			String s = textArea.getText();
			taille = Integer.valueOf(s);
			Window window = new Window();
			Jeu jeu= new Jeu(taille, window);
	    	Keyboard keyboard = new Keyboard(jeu); 
	    	window.setKeyListener(keyboard); 
		}catch(java.lang.NumberFormatException e){
			textArea.setText("un nombre !");
		}
	}
}
