package Projet.Carte;

import Projet.Autre.Jeu;

public class Lave extends Bloc implements Runnable{
	public transient Thread thread; 
	private int attaque;
	private Jeu jeu;		
	private int sleepTime =1000;

	
	public Lave(Jeu jeu, int attaque, int posx, int posy){
		super(posx, posy);
		thread = new Thread(this);
		thread.start();
		thread.suspend();
		this.attaque = attaque;
		this.jeu=jeu;
	}
	public void pause(){
		thread.suspend();
	}
	public void launch(){
		thread.resume();
	}
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
	public void actionneThread(){
		thread = new Thread(this);
		thread.start();
		thread.suspend();
	}
}

