package Projet.Carte;

import java.io.Serializable;

import Projet.Autre.Jeu;

public class Lave extends Bloc implements Runnable, Serializable {
	private static final long serialVersionUID = 0L;
	private transient Thread thread; 
	private int attaque;
	private Jeu jeu;		
	private int sleepTime =1000;

	
	public Lave(Jeu jeu, int attaque, int posx, int posy){
		super(posx, posy);
		thread = new Thread(this);
		thread.start();
		pause();					//suspendu car sera réactivé lors du passage du joueur
		this.attaque = attaque;
		this.jeu=jeu;
	}
	
//GESTION THREADS
	public void pause(){
		thread.suspend();
	}
	
	public void launch(){
		thread.resume();
	}
	
	//Recrée les threads lors du chargement
	public void actionneThread(){
		thread = new Thread(this);
		thread.start();
		thread.suspend();
	}

//ACTION LAVE
	public void run(){
		try{
			while(true){
				this.act();
				Thread.sleep(sleepTime);
			}
		}catch(Exception e){};
	}
	
	private void act(){
		jeu.joueurSouffre(attaque);
	}
	
	
}

