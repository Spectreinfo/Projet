package Projet.GUI;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JTextArea;
import Projet.Autre.*;

public class loadActionListener implements ActionListener {
	//Classe gérant le chargement d'une partie sauvegardée.
	private JTextArea textArea;
	public loadActionListener(	JTextArea textArea){
		this.textArea = textArea; 
		}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			Jeu jeu = null;
			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(new FileInputStream("Sauvegarde"));
				jeu = (Jeu) ois.readObject();
				ois.close();
				Window window = new Window();			//crée une nouvelle fenêtre
				jeu.window = window;					//la connecte au jeu
		    	Keyboard keyboard = new Keyboard(jeu); 	//connecte le clavier
		    	window.setKeyListener(keyboard); 
		    	jeu.relance();							//relance les threads
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
