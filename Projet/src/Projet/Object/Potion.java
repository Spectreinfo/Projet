package Projet.Object;

public class Potion extends Objet{
	private static int gain  = 25; 
	
	public Potion(int x, int y){
		super(x, y);
		this.type =0;
	}
	public static int getGain(){
		return gain;
	}
}
