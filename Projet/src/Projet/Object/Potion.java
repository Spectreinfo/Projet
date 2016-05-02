package Projet.Object;

import java.io.Serializable;

public class Potion extends Objet implements Serializable {
	private static final long serialVersionUID = 0L;
	private static int gain  = 25; 
	
	public Potion(int x, int y){
		super(x, y);
		this.type =0;
	}
	public static int getGain(){
		return gain;
	}
}
