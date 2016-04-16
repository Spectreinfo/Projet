package Projet.LeJeu;
import Projet.GUI.*; 
import Projet.Autre.*;

public abstract class Main {

	public static void main(String[] ars){
		Window window = new Window();
		Jeu jeu= new Jeu(window);
		Keyboard keyboard = new Keyboard(jeu); 
		window.setKeyListener(keyboard);
		
	}
}
