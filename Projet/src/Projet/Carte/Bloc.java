package Projet.Carte;


public class Bloc{
  private int posx; 
  private int posy; 
  
  public Bloc(int posx, int posy){
    this.posx = posx; 
    this.posy = posy; 
  }  
  public int getPosX(){
	  return this.posx;
  }
  public int getPosY(){
	  return this.posy;
  }
}
