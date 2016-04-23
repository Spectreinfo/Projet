package Projet.Personnage;
import Projet.Autre.Jeu;
import Projet.Object.Potion;

public class Joueur extends Personnage  implements Barbare,Archerie,Magie {
		public Joueur(Jeu jeu, int vie, int attaque, int armure, int orientation, int pX, int pY){
			super(jeu, vie, attaque, armure, orientation, pX, pY);
		}
		public int getVie(){
			return vie; 
		}
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
		
		//public int getPosX(){
			//return super.getPosX();
			//return pX;
		//}
		//public int getPosY(){
			//return super.getPosY();
		//	return pY; 
		//}
}