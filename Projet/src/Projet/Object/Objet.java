package Projet.Object;

public abstract class Objet {
	private int x; 
	private int y; 
	protected int type; 
	
	public Objet(int x, int y){
		this.x = x;
		this.y = y; 
	}
	
	public int getPosX(){
		return this.x; 
	}
	public int getPosY(){
		return this.y; 
	}
	public int getType(){
		return this.type; 
	}
}
