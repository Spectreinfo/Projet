package Projet.Object;

import java.io.Serializable;

public abstract class Objet implements Serializable {
	private static final long serialVersionUID = 0L;
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
