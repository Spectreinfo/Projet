package Projet.Personnage;

import java.io.Serializable;
import Projet.Autre.Jeu; 

public abstract class Personnage implements Runnable,Serializable {
	private static final long serialVersionUID = 0L;
	protected Jeu jeu;
	protected int pX;
	protected int pY;
	protected int vie; 
	protected int attaque;
	protected int armure;
	protected int orientation; 
	private transient Thread thread;
	
	
//CONSTRUCTEUR
	
	
	public Personnage(Jeu jeu, int vie, int attaque, int armure, int orientation, int pX, int pY){
		this.pX =pX;
		this.pY=pY;
		this.jeu = jeu; 
		this.vie = vie; 
		this.attaque =attaque;
		this.armure = armure; 
		this.orientation = orientation;
	}
	
//GETTERS
	public int getPosX(){
		return this.pX;
	}
	
	public int getPosY(){
		return this.pY ;
	}
	
	public int getAttaque(){
		return this.attaque;
	}
	
	public int getArmure(){
		return this.armure; 
	}
	
	public int getVie(){
		return this.vie; 
	}

	public int getOrientation(){
		return this.orientation; 
	}
	
	public Thread getThread(){
		return thread;
	}
	
//CHANGE
	public void changeVie(int a){
		if(a>0){ 	//si les dégâts infligés sont négatifs, cela signifierait que le personnage se soigne, ce qui est impossible
			this.vie -=a;
		}
	}
	
	public void changeOrientation(int i){
		this.orientation=i; 
	}

//SIGNATURE
	public void move(int x, int y){
	}
	public boolean canMove(int x, int y){
		return(false);	     //Par défaut
	}
	public void run(){	
	}
	public void heal(){
	}
	public void changeAttaque(){
	}
	public void perdAttaque(){
	}
	public void changeArmure(){
	}
	public void perdArmure(){
	}
	public void actionneThread(){
	}

}
