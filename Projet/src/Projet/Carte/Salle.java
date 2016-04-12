package Projet.Carte;
import java.lang.Math.*;

public class Salle {
	
//centre de la salle;
	
private int x;
private int y;
// dimensions de la salle ( l = largeur, h = hauteur):

private int l;
private int h;

// constructeur:
public Salle(int x,int y,int l,int h){
	this.x = x;
	this.y = y;
	this.l = l;
	this.h = h;
	  
}
// getters:
public int getSalleX(Salle Salle){
	return this.x;
}
public int getSalleY(Salle Salle){
	return this.y;
}
public int getSalleL(Salle Salle){
	return this.l;
}
public int getSalleH(Salle Salle){
	return this.h;
}

// return "True" si les deux salles ne se superposent pas.

public Boolean touch (Salle s1, Salle s2){
	int X1 = getSalleX(s1);
	int X2 = getSalleX(s2);
	int Y1 = getSalleY(s1);
	int Y2 = getSalleY(s2);
	int L1 = getSalleL(s1);
	int L2 = getSalleL(s2);
	int H1 = getSalleH(s1);
	int H2 = getSalleH(s2);
	
	return (Math.abs(X2-X1)<= Math.max(L1, L2) && Math.abs(Y2-Y1)<= Math.max(H1, H2));
		
	}
		
	
}

