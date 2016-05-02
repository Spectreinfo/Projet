package Projet.Object;

import java.io.Serializable;

public class Arme extends Objet implements Serializable {
	private static final long serialVersionUID = 0L;
	public Arme(int x, int y){
		super(x, y);
		this.type =2;
	}
}
