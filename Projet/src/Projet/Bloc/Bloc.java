package Projet.Bloc;

public class Bloc extends Projet.Autre.Jeu{
	private int x;
	private int y;
	
	public Bloc(int x,int y){
		this.x = x;
		this.y = y;
	}
	

public int getBlocX(Bloc Bloc){
	return Bloc.x;
	}
public int getBlocY(Bloc Bloc){
	return Bloc.y;
}
}
