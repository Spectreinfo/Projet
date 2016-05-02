package Projet.Autre;
import java.io.Serializable;
import java.util.ArrayList;

public class Inventaire implements Serializable {
	private static final long serialVersionUID = 0L;
	private int taille;
	private int nbPotion; 
	private int nbArmure; 
	private int nbArme;
	private int occup;
	private int nbParchemin;
	private int[] equipement = new int[5]; 
	
	
	// Constructeur
	public Inventaire(int taille, int nbPotion, int nbArmure, int nbArme, int nbParchemin){
		this.taille=taille; 
		this. nbArmure= nbArmure;
		this. nbPotion= nbPotion;
		this.nbParchemin = nbParchemin;
		this.nbArme = nbArme;
		this.occup = this.nbPotion + this.nbArmure + this.nbArme + this.nbParchemin;
		setEquipement();
	}
	
	//getter & setter
	
	public int[] getEquipement(){
		return this.equipement; 
	}
	
	public void setEquipement(){
		this.equipement[0]= this.occup; 
		this.equipement[1]= this.nbPotion; 
		this.equipement[2]= this.nbArmure; 
		this.equipement[3]= this.nbArme;
		this.equipement[4]= this.nbParchemin;
	}
	
	
	//GESTION
	
	//Potion
	public boolean canUtilisePotion(){
		return(nbPotion !=0);
	}
	
	public void utilisePotion(){
		if( canUtilisePotion()){
			 this.nbPotion -=1; 
			 this.occup-=1;
			 setEquipement(); 
		}
	}
	
	public void addPotion(){
		 this.nbPotion +=1; 
		 this.occup +=1;
		 setEquipement();
	}
	
	//Arme
	public boolean canThrowArme(){
		return(nbArme !=0);
	}
	public void throwArme(){
		if(canThrowArme()){
			this.nbArme -=1;
			 this.occup-=1;
			 setEquipement(); 
		}
	}
	public void addArme(){
		 this.nbArme +=1; 
		 this.occup +=1;
		 setEquipement();
	}
	
	//Armure
	public boolean canThrowArmure(){
		return(nbArmure !=0);
	}
	public void throwArmure(){
		if(canThrowArmure()){
			this.nbArmure-=1;
			 this.occup-=1;
			 setEquipement(); 
		} 
	}
	public void addArmure(){
		 this.nbArmure +=1; 
		 this.occup +=1;
		 setEquipement(); 
	}

	//Boule de feu (parchemin)
	public boolean canUseBoule(){
		return(nbParchemin !=0);
	}
	public void useBoule(){
		if(canUseBoule()){
			this.nbParchemin-=1;
			 this.occup-=1;
			 setEquipement(); 
		} 
	}
	public void addParchemin(){
		 this.nbParchemin +=1; 
		 this.occup +=1;
		 setEquipement();
	}
	
	
}
