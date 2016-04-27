package Projet.GUI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Font;
import Projet.Autre.Jeu;
import Projet.Personnage.Joueur;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.*;


public class Map extends JPanel implements Serializable {
	private static final long serialVersionUID = 0L;
	private int[][] mapMatrix;
	private int Life;
	private int Attaque;
	private int Armure;
	private int dim = 50; 
	private int[] Equipement; 
	private int nEn;
	
	public Map(){
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	public void paint(Graphics g) { 
		  Image heroB = null;
		  Image heroL = null;
		  Image pot=null;
		  Image sol=null;
		  Image eau=null;
		  Image En=null;
		  Image Armu=null;
		  Image Arm=null;
		  Image lave=null;
		  Image parchemin=null;
		  Image boule=null;
		try {
		    heroB = ImageIO.read(new File("HeroB.jpg"));
		    heroL = ImageIO.read(new File("HeroLava.jpg"));
		    pot = ImageIO.read(new File("Potion_vie.jpg"));
		    sol = ImageIO.read(new File("dalle.jpg"));
		    eau = ImageIO.read(new File("eau.jpg"));
		    En = ImageIO.read(new File("Ennemi.jpg"));
		    Armu = ImageIO.read(new File("Armure.jpg"));
		    Arm = ImageIO.read(new File("Arme.jpg"));
		    lave = ImageIO.read(new File("lave.jpg"));
		    parchemin = ImageIO.read(new File("Parchemin.jpg"));
		    boule = ImageIO.read(new File("BouleFeu.png"));
		    
		} catch (IOException e) {
		}
		
		if(mapMatrix == null){
			g.setFont(new Font("TimesRoman", Font.PLAIN, 55)); 
			g.drawString("Mauvais chargement, recommencez" , 100, 400);
		}else if(Life<=0){
			g.setFont(new Font("TimesRoman", Font.PLAIN, 55)); 
			g.drawString("Vous êtes morts" , 400, 400);
		}else if(nEn==0){
			g.setFont(new Font("TimesRoman", Font.PLAIN, 55)); 
			g.drawString("Vous avez gagné" , 400, 400);
		}else{
			for(int i = 0; i<mapMatrix.length; i++){
				for(int j = 0; j<mapMatrix.length; j++){
					int x = i;
					int y = j;
					int color = mapMatrix[i][j];
					
					g.fillRect(x*dim, y*dim, dim,dim);
					if(color == 2){
						g.drawImage(heroB, dim*(Jeu.view), dim*(Jeu.view), dim, dim, this);
					}else if(color == 10){
						g.drawImage(heroL, i*dim, j*dim, dim, dim, this);
					}
					if(color == 0){
						g.drawImage(sol, i*dim, j*dim, dim, dim, this);
					}
						
					if(color == 4){
						//g.setColor(Color.RED);
						g.drawImage(pot, i*dim, j*dim, dim, dim, this);
					}else if(color == 1){
						g.drawImage(eau, i*dim, j*dim, dim, dim, this);
					}else if(color == 5){
						g.drawImage(Armu, i*dim, j*dim, dim, dim, this);
					}else if(color == 6){
						g.drawImage(Arm, i*dim, j*dim, dim, dim, this);
					}else if(color ==7){
						g.drawImage(lave, i*dim, j*dim, dim, dim, this);
					}else if(color ==8){
						g.drawImage(parchemin, i*dim, j*dim, dim, dim, this);
					}else if(color ==9){
						g.drawImage(boule, i*dim, j*dim, dim, dim, this);
					}else if(color == 3){
						g.drawImage(En, i*dim, j*dim, dim, dim, this);
					}
					g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
					g.setColor(Color.BLACK);
					g.drawString("vie : "+ Integer.toString(Life) , 10, 20);
					g.drawString("attaque : "+ Integer.toString(Attaque) , 10, 40);
					g.drawString("armure : "+ Integer.toString(Armure) , 10, 60);
					g.drawString("Inventaire : "+ Integer.toString(Equipement[0]) +"/6" , 10, 80);
					g.drawString("- Potions : "+ Integer.toString(Equipement[1]), 20, 100);
					g.drawString("- Armures : "+ Integer.toString(Equipement[2]), 20, 120);
					g.drawString("- Armes : "+ Integer.toString(Equipement[3]), 20, 140);
					g.drawString("- Parchemins : "+ Integer.toString(Equipement[4]), 20, 160);
					g.drawString("Nombre d'ennemi : "+ Integer.toString(nEn), 20, 950);
				}
			}
		}
	}
	
	public void setMapMatrix(int[][] mapMatrix){
		this.mapMatrix = mapMatrix;
	}
	public void setLife(int Life){
		this.Life = Life;
	}
	public void setArmure(int Armure){
		this.Armure = Armure;
	}
	public void setAttaque(int Attaque){
		this.Attaque = Attaque;
	}
	public void setEquipement(int[] Equipement){
		this.Equipement = Equipement;
	}
	public void setnEn(int nEn){
		this.nEn = nEn;
	}
}