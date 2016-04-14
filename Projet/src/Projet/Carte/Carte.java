package Projet.Carte;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math.*;

public class Carte {
ArrayList<Salle> Salles = new ArrayList<Salle>();
private int minimum_size;
private int nombre_de_salles;
int taille_de_la_carte = jeu.getTaille_de_la_carte();     //'attention à déf'
Random random = new Random();

// contructeur:

public Carte(ArrayList<Salle> Salles, int minimum_size, int nombre_de_salles,int taille_de_la_carte){
	this.minimum_size = minimum_size;
	this.taille_de_la_carte = taille_de_la_carte;
	this.nombre_de_salles = nombre_de_salles;
	
	int taille_max = Math.round(taille_de_la_carte/nombre_de_salles);
	int rdl;
	int rdh;
	int rdx;
	int rdy;
	
	int i=0;		
	while(i<nombre_de_salles){
		rdl = minimum_size + random.nextInt(taille_max- minimum_size);
		rdh = minimum_size + random.nextInt(taille_max-minimum_size);
		rdx = random.nextInt(taille_de_la_carte-rdl);
		rdy = random.nextInt(taille_de_la_carte-rdh) ;
		Salle Salle= new Salle(rdl, rdh, rdx, rdy);
		if(i==0){
			Salles.add(Salle);
			i++;
		}else{
			for(int j=0;j<Salles.size(); j++ ){
				if(Salle.touch(Salles.get(j), Salle)==false){
					Salles.add(Salle);
					
					i++;
				}
				
			}
		}
	}
		
		
	}
}



