package Projet.Carte;

import java.io.Serializable;

public class Bloc implements Serializable {
  private static final long serialVersionUID = 0L;
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
