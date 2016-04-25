package Projet.GUI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import Projet.Autre.Jeu;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

public class InventaireAffichage extends JPanel  {
	private int[] inventaire = {1,0,1};
	private int life; 
	public InventaireAffichage(){
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	public void paint(Graphics g) { 
		if(inventaire == null){
		}else{
			for(int i = 0; i<inventaire.length; i++){
					int x = i;
					int type = inventaire[i];
					if(type == 0){
						g.setColor(Color.RED);
					}else if(type == 1){
						g.setColor(Color.DARK_GRAY);
					}else if(type == 3){
						g.setColor(Color.BLUE);
					}
		
			}
		}
	
	}
	public void setInventaire(int[]inventaire){
		this.inventaire = inventaire;
		//this.repaint();
	}
}
