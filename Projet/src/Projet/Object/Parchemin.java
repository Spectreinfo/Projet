package Projet.Object;

import java.io.Serializable;

public class Parchemin extends Objet implements Serializable {
	private static final long serialVersionUID = 0L;
	public Parchemin(int x, int y){
		super(x, y);
		this.type =3;
	}
}
