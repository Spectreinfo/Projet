package Projet.Personnage;

import java.io.Serializable;

import Projet.Autre.Jeu;

public class BouleFeu implements Runnable,Serializable, Déplacement {
	private static final long serialVersionUID = 0L;
	private Jeu jeu;
	private int pX;
	private int pY;
	private int dirX;
	private int dirY;
	private transient Thread thread; 
	private int sleepTime =100;
	
	
//CONSTRCUTEUR
	
	
	public BouleFeu(Jeu jeu,int pX, int pY, int dirX, int dirY){
		this.pX =pX;
		this.pY=pY;
		this.dirX =dirX;
		this.dirY =dirY;
		this.jeu = jeu; 
		thread = new Thread(this);
		thread.start();
	}
	
	
//GETTERS
	
	
	public int getPosY(){
		return this.pY ;
	}
	public int getPosX(){
		return this.pX;
	}

	
//ACTION
	
	
	public void run(){	
		try{
			while(true){
				this.act();
				Thread.sleep(sleepTime);
			}
		}catch(Exception e){
		}
	}
	
	private void act(){
		if(canMove()){
			move();
		}else{
			explode();
		}
	}
	
	public boolean canMove(){
		//renvoie true si la boule peut se déplacer sur la case suivante dans sa direction de propagation
		int m = pX;
		int l = pY;
		int[][] visible_map = jeu.getMap();
		return(visible_map[dirX+m][dirY+l]==0 ||visible_map[dirX+m][dirY+l]==4 ||visible_map[dirX+m][dirY+l]==5 || visible_map[dirX+m][dirY+l]==6 || visible_map[dirX+m][dirY+l]==7 || visible_map[dirX+m][dirY+l]==8);	
	}
	
	public void move(){
		pX = pX+dirX;
		pY = pY+dirY;
		jeu.Affiche();
	}
	
	private void explode(){
		this.thread.interrupt();
		jeu.personnageSubisse(this);
	}
	
}
