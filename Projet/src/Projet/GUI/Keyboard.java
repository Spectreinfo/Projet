package Projet.GUI;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Projet.Autre.Jeu;

public class Keyboard implements KeyListener{
	private Jeu jeu;
	
	public Keyboard(Jeu jeu){
		this.jeu = jeu;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();
		
		switch (key){
			// MOVE
			case KeyEvent.VK_RIGHT: 
				jeu.movePlayerRight();
				break;
			case KeyEvent.VK_LEFT:
				jeu.movePlayerLeft();
				break;
			case KeyEvent.VK_DOWN:
				jeu.movePlayerDown();
				break;
			case KeyEvent.VK_UP:
				jeu.movePlayerUp();
				break;	
			// ATTAQUE 
			case KeyEvent.VK_SPACE:
				jeu.persoAttaque();
				break;
			case KeyEvent.VK_SHIFT:
				jeu.actionBoule();
				break;
				
			// Inventaire
			case KeyEvent.VK_E:
				jeu.ramasse();
				break;
			case KeyEvent.VK_1:
				jeu.actionPotion();
				break;
				
			case KeyEvent.VK_2:
				jeu.actionArmure();
				break;
				
			case KeyEvent.VK_3:
				jeu.actionArme();
				break;
				
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}