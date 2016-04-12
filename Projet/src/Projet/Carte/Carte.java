package Projet.Carte;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math.*;

public class Carte extends Projet.Autre.Jeu {
ArrayList<Salle> Salles = new ArrayList<Salle>();
protected int minimum_size;
protected int nombre_de_salles;
protected int taille_de_la_carte; 
Random random = new Random();

// contructeur:

public Carte(ArrayList<Salle> Salles, int minimum_size, int nombre_de_salles,int taille_de_la_carte){
	
	this.Salles = Salles;
	this.minimum_size = minimum_size;
	this.taille_de_la_carte = taille_de_la_carte;
	this.nombre_de_salles = nombre_de_salles;
	
	int taille_max = Math.round(taille_de_la_carte/nombre_de_salles);
	int rdl = minimum_size + random.nextInt(taille_max- minimum_size +1);
	int rdh = minimum_size + random.nextInt(taille_max-minimum_size+1);
	int rdx = random.nextInt(taille_de_la_carte - rdl+1);
	int rdy = random.nextInt(taille_de_la_carte - rdh+1);
	
	Salle premiere_salle = new Salle(rdx,rdy,rdl,rdh);
	Salles.add( premiere_salle);
	
	for(int i = 1 ; i <=nombre_de_salles; i++ ){
		
		Salle Salle = new Salle ( rdx, rdy,  rdl,  rdh );
		for(int j; j < Salles.size(); j++){
			if(Salle.touch(premiere_salle, Salles.get(j))){
				
			
		
		
	}
}


