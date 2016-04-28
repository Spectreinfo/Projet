package Projet.Personnage;
import Projet.Autre.Jeu;
import Projet.Object.Potion;

public class Joueur extends Personnage{
		public Joueur(Jeu jeu, int vie, int attaque, int armure, int orientation, int pX, int pY){
			super(jeu, vie, attaque, armure, orientation, pX, pY);
		}
		
//GETTER
		
		
		public int getVie(){
			return vie; 
		}
		
		
//ACTION PARAMETRE
		
		
		public void heal(){
			this.vie += Potion.getGain(); 
			if (vie>100){
				this.vie = 100; 
			}
		}
		public void changeAttaque(){
			this.attaque += 15;
		}
		public void perdAttaque(){
			this.attaque -= 15;
		}
		public void changeArmure(){
			this.armure += 1;
		}
		public void perdArmure(){
			this.armure -= 1;
		}
		
//ACTION PHYSIQUE
		public void move(int x, int y){
			this.pX = this.pX + x;
			this.pY = this.pY + y;
		}
		public boolean canMove(int x, int y){
			final int C =jeu.view ;
			int[][] visible_map = jeu.getVisibleMap();
			return(visible_map[x+C][y+C]==0 ||visible_map[x+C][y+C]==4 ||visible_map[x+C][y+C]==5 || visible_map[x+C][y+C]==6 || visible_map[x+C][y+C]==7|| visible_map[x+C][y+C]==8);	
		}
}