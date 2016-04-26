package Projet.Personnage;
import Projet.GUI.Window;
import Projet.Autre.Jeu; 

public abstract class Personnage implements Runnable{
	protected Jeu jeu;
	protected int pX;
	protected int pY;
	public int vie; 
	protected int attaque;
	protected int armure;
	protected int orientation; 
	public Thread thread;
	
	public Personnage(Jeu jeu, int vie, int attaque, int armure, int orientation, int pX, int pY){
		this.pX =pX;
		this.pY=pY;
		this.jeu = jeu; 
		this.vie = vie; 
		this.attaque =attaque;
		this.armure = armure; 
		this.orientation = orientation;
	}
	
	public int getPosX(){
		return this.pX;
	}
	
	public int getPosY(){
		return this.pY ;
	}
	public void move(int x, int y){
		this.pX = this.pX + x;
		this.pY = this.pY + y;
	}
	public boolean canMove(int x, int y){
		final int C =jeu.view ;
		int[][] visible_map = jeu.getVisibleMap();
		return(visible_map[x+C][y+C]==0 ||visible_map[x+C][y+C]==4 ||visible_map[x+C][y+C]==5 || visible_map[x+C][y+C]==6 || visible_map[x+C][y+C]==7|| visible_map[x+C][y+C]==8);	
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
	public void changeVie(int a){
		this.vie -=a;
	}
	public int getOrientation(){
		return this.orientation; 
	}
	public void changeOrientation(int i){
		this.orientation=i; 
	}
	public void run(){	
	}
	public Thread getThread(){
		return thread;
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

}
