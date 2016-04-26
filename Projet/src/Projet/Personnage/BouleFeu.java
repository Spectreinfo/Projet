package Projet.Personnage;

import Projet.Autre.Jeu;

public class BouleFeu implements Runnable {
	private Jeu jeu;
	private int pX;
	private int pY;
	private int dirX;
	private int dirY;
	private Thread thread; 
	private int pos;
	private int sleepTime =100;
	
	public BouleFeu(Jeu jeu,int pX, int pY, int dirX, int dirY, int pos){
		this.pX =pX;
		this.pY=pY;
		this.dirX =dirX;
		this.dirY =dirY;
		this.pos = pos;
		this.jeu = jeu; 
		thread = new Thread(this);
		thread.start();
	}
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
	public int getPosY(){
		return this.pY ;
	}
	public int getPosX(){
		return this.pX;
	}
	
	private boolean canMove(){
		int m = pX;
		int l = pY;
		int[][] visible_map = jeu.getMap();
		return(visible_map[dirX+m][dirY+l]==0 ||visible_map[dirX+m][dirY+l]==4 ||visible_map[dirX+m][dirY+l]==5 || visible_map[dirX+m][dirY+l]==6 || visible_map[dirX+m][dirY+l]==7 || visible_map[dirX+m][dirY+l]==8);	
	}
	private void move(){
		pX = pX+dirX;
		pY = pY+dirY;
		jeu.Affiche();
	}
	private void explode(){
		thread.interrupt();
		jeu.personnageSubisse(this);
	}
	
}
