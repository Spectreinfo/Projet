package Projet.Carte;

import Projet.Autre.Jeu;

public class Lave extends Bloc implements Runnable{
	public Thread thread; 
	private static int attaque;
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
				System.out.println("coucou");
				this.act();
				System.out.println(attaque);
				Thread.sleep(sleepTime);
			}
		}catch(Exception e){};
	}
	private void act(){
		System.out.println("caca");
		jeu.joueurSouffre(attaque);
	}
}

