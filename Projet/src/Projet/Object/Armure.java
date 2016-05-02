package Projet.Object;

import java.io.Serializable;

public class Armure extends Objet implements Serializable {
	private static final long serialVersionUID = 0L;
	public Armure(int x, int y){
		super(x, y);
		this.type =1;
	}
}
