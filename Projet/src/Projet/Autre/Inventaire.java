package Projet.Autre;
import java.util.ArrayList;

public class Inventaire {
	private int taille;
	private int nbPotion; 
	private int nbArmure; 
	private int nbArme;
	private int occup;
	int[] equipement = new int[4]; 
	
	Inventaire(int taille, int nbPotion, int nbArmure, int nbArme){
		this.taille=taille; 
		this. nbArmure= nbArmure;
		this. nbPotion= nbPotion;
		this.nbArme = nbArme;
		this.occup = this.nbPotion + this.nbArmure + this.nbArme;
		this.equipement[0]= this.occup; 
		this.equipement[1]= this.nbPotion; 
		this.equipement[2]= this.nbArmure; 
		this.equipement[3]= this.nbArme;
	}
	
	public int[] getEquipement(){
		return this.equipement; 
	}
	
	public int[] setEquipement(){
		this.equipement[0]= this.occup; 
		this.equipement[1]= this.nbPotion; 
		this.equipement[2]= this.nbArmure; 
		this.equipement[3]= this.nbArme;
		return this.equipement;
	}
	
	
	
	

	public boolean canUtilisePotion(){
		return(nbPotion !=0);
	}
	public int[] utilisePotion(){
		if( canUtilisePotion()){
			 this.nbPotion -=1; 
			 this.occup-=1;
			 setEquipement(); 
		}
		return this.equipement; 
	}
	
	public int[] addPotion(){
		 this.nbPotion +=1; 
		 this.occup +=1;
		 setEquipement();
		 return this.equipement; 
	}
	
	
	
	

	public boolean canThrowArme(){
		return(nbArme !=0);
	}
	public int[] throwArme(){
		if(canThrowArme()){
			this.nbArme -=1;
			 this.occup-=1;
			 setEquipement(); 
		}
		return this.equipement; 
	}
	public int[] addArme(){
		 this.nbArme +=1; 
		 this.occup +=1;
		 setEquipement();
		 return this.equipement; 
	}
	
	
	
	
	
	
	public boolean canThrowArmure(){
		return(nbArmure !=0);
	}
	public  int[] throwArmure(){
		if(canThrowArmure()){
			this.nbArmure-=1;
			 this.occup-=1;
			 setEquipement(); 
		} 
		return this.equipement; 
	}
	public int[] addArmure(){
		 this.nbArmure +=1; 
		 this.occup +=1;
		 setEquipement();
		 return this.equipement; 
	}


}
