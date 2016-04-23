package Projet.GUI;

import java.awt.Color;
import java.awt.event.KeyListener;
import javax.swing.*;


public class Window {
	private Map map = new Map();
	//private InventaireAffichage inv = new InventaireAffichage();
	
	public Window(){
	    JFrame window = new JFrame("Jeu");
	    window.setLocationRelativeTo(null);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setBounds(0, 0, 1000, 1020);
	    window.setLocationRelativeTo(null);
	    window.getContentPane().setBackground(Color.BLACK);
	    window.getContentPane().add(this.map);
	    window.setVisible(true); 
	   }	
	
	public void draw(int[][] mapMatrix, int Life, int Attaque, int Armure , int[] Equipement){
		map.setMapMatrix(mapMatrix);
		map.setLife(Life);
		map.setArmure(Armure);
		map.setAttaque(Attaque);
		map.setEquipement(Equipement);
		map.repaint();
	}

	//public void draw(int Life){
	//	Life.repaint();
	//}
	public void setKeyListener(KeyListener keyboard){
	    this.map.addKeyListener(keyboard);
	}
}