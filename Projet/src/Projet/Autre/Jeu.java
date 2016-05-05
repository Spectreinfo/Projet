package Projet.Autre;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import Projet.Carte.Bloc;
import Projet.Carte.Lave;
import Projet.Carte.Salle;
import Projet.Personnage.*;
import Projet.GUI.Window;
import Projet.Object.*;
import java.util.Random;

public  class Jeu implements Serializable { 
	//Attributs pratiques
	private static final long serialVersionUID = 0L;
	private Random random = new Random();
	public transient Window window;
	
	//Attributs construction de la carte
	public static int view =10; 
	private int minimum_size=5;
	private int taille_max;
	private int nombre_de_salles;   
	public int taille_de_la_carte;
	private ArrayList<Bloc> blocs= new ArrayList<Bloc>();
	private int[][] mapVisible = new int[2*view+1][2*view+1];
	
	//Attributs inventaire
	private Inventaire inventaire = new Inventaire(6,0, 0, 0, 2);
	private int emploi = 0;
	
	//Attributs personnages et objets
	
	private int nombreEnnemi;
	private int nbObjet;
	private int nLave;
	
	private int attaqueJ = 30; 			//Attaque de base du joueur
	private int attaqueE = 10; 			//Attaque des ennemis
	private int attaqueB = 5; 			//Attaque des blocs de lave
	private int attaqueF = 100;			//Attaque boule de feu
	private int port�e = 2; 
	public int vie =100;
	
	public ArrayList<Personnage> players= new ArrayList<Personnage>();
	private transient ArrayList<Thread> threadList = new ArrayList<Thread>();
	private ArrayList<Objet> objets = new ArrayList<Objet>();
	private ArrayList<Potion> objetsPotions = new ArrayList<Potion>();
	private ArrayList<Arme> objetsArmes = new ArrayList<Arme>();
	private ArrayList<Armure> objetsArmures = new ArrayList<Armure>();
	private ArrayList<Lave> laveList = new ArrayList<Lave>();
	private ArrayList<BouleFeu> listBoules = new ArrayList<BouleFeu>();
	private ArrayList<Parchemin> listParchemins = new ArrayList<Parchemin>();

	
//CONSTRUCTEUR
	
	public Jeu(int Taille, Window window){
		
		//g�n�re les param�tres en fonction de la taille entr�e.
		taille_de_la_carte=Taille +2*view ;
		taille_max = Math.round(Taille/6);
		nombre_de_salles = Math.round(Taille/10);
		nombreEnnemi= Math.round(Taille/5);
		nbObjet =Math.round(Taille/8);
		nLave =Math.round(Taille/2);
		
		//instancie fen�tre et carte
		this.window = window; 
		blocs.addAll(setBlocks());  //forme la liste de blocs
		int taille = blocs.size();
		
		//g�n�re des listes d'indices al�atoires
		ArrayList<Integer> posRand = new ArrayList<Integer>();
		ArrayList<Integer> posRand2 = new ArrayList<Integer>();
		ArrayList<Integer> posRand3 = new ArrayList<Integer>();
		
		//ajoute les blocs laves sur positions al�atoires
		for(int k=0; k<=nLave; k++){
			posRand3.add(random.nextInt(taille));
			Bloc blocStart = blocs.get(posRand3.get(k)); 
			laveList.add(new Lave(this,attaqueB, blocStart.getPosX(),  blocStart.getPosY()));
		}
		
		//ajoute les personnages sur positions al�atoires
		for(int w=0; w<=nombreEnnemi; w++){
			posRand.add(random.nextInt(taille));
            Bloc blocStart = blocs.get(posRand.get(w)); 
            if(w==0){
            	players.add(new Joueur(this, vie, attaqueJ, 0, 0,   blocStart.getPosX(),  blocStart.getPosY()));
            }else{
            	players.add(new Ennemi(this, vie, attaqueE, 0, 0,   blocStart.getPosX(),  blocStart.getPosY()));
            	threadList.add(players.get(w).getThread());
            }
		}
		//ajoute les objets sur positions al�atoires
		for(int n=0; n<nbObjet;n++){
			posRand2.add( random.nextInt(taille));
            Bloc blocStart = blocs.get(posRand2.get(n)); 
            if(n<=nbObjet/2){
            	objetsPotions.add(new Potion(blocStart.getPosX(),  blocStart.getPosY()));
            }else if(n>=nbObjet/2 && n<=nbObjet*3/4){
            	objetsArmes.add(new Arme(blocStart.getPosX(),  blocStart.getPosY()));
            }else{
            	objetsArmures.add(new Armure(blocStart.getPosX(),  blocStart.getPosY()));
            }
		}
		objets.addAll(objetsPotions);
		objets.addAll(objetsArmes);
		objets.addAll(objetsArmures);
				
		Affiche();	//dessine la carte
	}
	
	
//GESTION & CREATION CARTE
	
	
	//Cr�e la liste de blocs
	private ArrayList<Bloc> setBlocks(){
	// retourne une liste de blocs accessible � partir de salles g�n�r�es al�atoirement et reli�es.
		ArrayList<Salle> Salles = new ArrayList<Salle>();
		boolean value;
		int rdl;
		int rdh;
		int rdx;
		int rdy;
		ArrayList<Bloc> blocs = new ArrayList<Bloc>();
		ArrayList<Salle> couloir = new ArrayList<Salle>();
		int i=0; 
		while(i<nombre_de_salles){											//boucle cr�ant un nombre d�termin� de salles ne se touchant pas 
			value = true;													//et positionn�es al�atoirement (ainsi que de taille al�atoire).
			rdl = minimum_size + random.nextInt(taille_max- minimum_size);
			rdh = minimum_size + random.nextInt(taille_max-minimum_size);
			rdx =view +random.nextInt(taille_de_la_carte-rdl-2*view);
			rdy =view +random.nextInt(taille_de_la_carte-rdh-2*view) ;
			Salle Salle= new Salle(rdx, rdy, rdl, rdh);
			if(i==0){
				Salles.add(Salle);
				i++;
			}else{
				for(int j=0;j<Salles.size(); j++ ){
					if(Salles.get(j).touch(Salle)){
						value =false;
						break;
					}
				}
				if(value){
					Salles.add(Salle);
				    i++;
				}
			}
		}
		for(int v=1; v<=nombre_de_salles-1; v++){							//connecte les salles par des couloirs.
			couloir.addAll(Salles.get(v-1).salleLien(Salles.get(v)));
		}
		couloir.addAll(Salles.get(nombre_de_salles-1).salleLien(Salles.get(0)));
		Salles.addAll(couloir);
		for(Salle elem:Salles){
			ArrayList<Bloc> blocAdd= elem.inSalle();
			blocs.addAll(blocAdd);
		}
		return(blocs);
		}
	
	
	// Forme un tableau de la carte compl�te
	public int[][] getMap(){
		int[][] map = new int[this.taille_de_la_carte][this.taille_de_la_carte];
		for(int i = 0; i<this.taille_de_la_carte; i++)
			for(int j = 0; j<this.taille_de_la_carte; j++)
				map[i][j] = 1;
		for(Bloc bloc : blocs){
			int x = bloc.getPosX();
			int y = bloc.getPosY();
			map[x][y] = 0;
		}
		for(Potion potion: objetsPotions){
			int x = potion.getPosX();
			int y = potion.getPosY();
			map[x][y] = 4;
		}
		for(Armure armure: objetsArmures){
			int x = armure.getPosX();
			int y = armure.getPosY();
			map[x][y] = 5;
		}
		for(Arme arme: objetsArmes){
			int x = arme.getPosX();
			int y = arme.getPosY();
			map[x][y] = 6;
		}
		for(Parchemin parchemin:listParchemins){
			int x = parchemin.getPosX();
			int y = parchemin.getPosY();
			map[x][y] = 8;
		}
		for(BouleFeu boule:listBoules){
			int x = boule.getPosX();
			int y = boule.getPosY();
			map[x][y] = 9;
		}
		for(int c=0;c<players.size(); c++){
			
			int x = players.get(c).getPosX();
			int y =  players.get(c).getPosY();
			if(c==0){
				map[x][y] = 2;
			}else{
				map[x][y] = 3;
			}
		}
		for(Lave lave:laveList){
			int a = players.get(0).getPosX();
			int b =  players.get(0).getPosY();
			int x = lave.getPosX();
			int y = lave.getPosY();
			if(a==x && b==y){
				map[x][y] = 10;
			}else{
			map[x][y] = 7;
			}
		}
		return map;
	}
	
	// Forme un tableau de la carte visible (centr�e sur le joueur)
	public int[][] setVisibleMap(int[][] map){
		int a = players.get(0).getPosX();
		int b = players.get(0).getPosY();
		for(int i = a-view; i<=a+view; i++){
			int x= i - (a-view);
			for(int j =  b-view; j<= b+view; j++){
				int y= j - (b-view);
				mapVisible[x][y] = map[i][j];
			}
		}
	return(mapVisible);
	}
	
	// Renvoie la map visible
	public int[][] getVisibleMap(){
		return this.mapVisible; 
	}
	
	
// MOVE 
	
	
	public void movePlayerLeft(){
		players.get(0).changeOrientation(0);
		if(players.get(0).canMove(-1,0)){
			actionLaveIn();
			players.get(0).move(-1, 0);
			actionLaveSt();
			Affiche();	
		}
	}
	
	public void movePlayerRight(){
		players.get(0).changeOrientation(2);
		if(players.get(0).canMove(1,0)){
			actionLaveIn();
			players.get(0).move(1, 0);	
			actionLaveSt();
			Affiche();	
		}
	}
	
	public void movePlayerDown(){
		players.get(0).changeOrientation(3);
		if(players.get(0).canMove(0, 1)){
			actionLaveIn();
			players.get(0).move(0, 1);
			actionLaveSt();
			Affiche();	
		}
	}
	
	public void movePlayerUp(){
		players.get(0).changeOrientation(1);
		if(players.get(0).canMove(0, -1)){
			actionLaveIn();
			players.get(0).move(0, -1);
			actionLaveSt();
			Affiche();
		}
	}
	
	
// AFFICHAGE
	
	
	public void Affiche(){
		window.draw(this.setVisibleMap(getMap()), players.get(0).getVie(), players.get(0).getAttaque(),players.get(0).getArmure(), inventaire.getEquipement(), players.size()-1);
	}

	
// ATTAQUE
	
	
	//Attaque corps � corps du joueur
	public void persoAttaque(){
		int[][] Map =getMap();
		int a = players.get(0).getPosX();
		int b = players.get(0).getPosY();
		int orient = players.get(0).getOrientation();
		int c =0;
		int d =0;
		if(orient ==0){					//n�cessaire pour d�finir la case attaqu�e par le joueur
			 c=-1; 
		}else if(orient ==1){
			 d=-1; 
		}else if(orient ==2){
			c=1;
		}else if(orient ==3){
			d=1;
		}
		int x = a+c;
		int y = b+d;
		if(Map[a+c][b+d]==3){
			for(Personnage player:players){
				int r = player.getPosX();
				int t = player.getPosY();
				if(x==r && y==t){
					player.changeVie(players.get(0).getAttaque());
					if(inventaire.canThrowArme()){
						emploi+=1;
						if(emploi ==5){
							actionArme();
							emploi=0;
						}
					}
					if(player.getVie()<=0){				//Si ennemi meurt
						player.getThread().interrupt();
						players.remove(player);
						loot(r, t);					    //L'ennemi l�che un objet al�atoire (ou rien)
						renitialise();					//Si tous les ennemis sont morts : r�nitialise
					}
					break;
				}
			}
		}
		Affiche();	
	}
	
	//Inflige des d�g�ts au joueur
	public void joueurSouffre(int degat){
		players.get(0).changeVie(degat-players.get(0).getArmure());
		Affiche();	
		renitialise();				//Si joueur meurt, arr�te le jeu
	}
	
	//L�che un objet al�atoire
	private void loot(int x, int y){
		int i = random.nextInt(8);
		if (i ==0){
			objetsPotions.add(new Potion(x,  y));
			objets.addAll(objetsPotions);
		}else if(i==1){
			objetsArmes.add(new Arme(x,  y));
			objets.addAll(objetsArmes);
		}else if(i==2){
			objetsArmures.add(new Armure(x,  y));
			objets.addAll(objetsArmures);
		}else if(i==3){
			listParchemins.add(new Parchemin(x,  y));
			objets.addAll(listParchemins);
		}
	}
	
	//Renvoie vrai si le joueur est sur un bloc de lave
	private boolean isOnLave(){
		int t = players.get(0).getPosX();
		int v = players.get(0).getPosY();
		boolean value = false;
		for(Lave lave:laveList){
			if(t==lave.getPosX() && v==lave.getPosY()){
				value = true;
			}
		}
		return (value);
	}
	
	//Action du bloc lave interrompue
	private void actionLaveIn(){
		if(isOnLave()){
			int t = players.get(0).getPosX();
			int v = players.get(0).getPosY();
			for(Lave lave:laveList){
				if(t==lave.getPosX() && v==lave.getPosY()){
					lave.pause();
				}
			}
		}
	}
	
	//Action du bloc lave start
	private void actionLaveSt(){
		if(isOnLave()){
			int t = players.get(0).getPosX();
			int v = players.get(0).getPosY();
			for(Lave lave:laveList){
				if(t==lave.getPosX() && v==lave.getPosY()){
					lave.launch();
				}
			}
		}
	}
	
	//Cause des d�g�ts de zone due � une boule de feu aux personnages
	public void personnageSubisse(BouleFeu boule){
		int a = boule.getPosX();
		int b = boule.getPosY();
		listBoules.remove(boule);
		for(int i = a-port�e; i<=a+port�e; i++){
			for(int j =  b-port�e; j<= b+port�e; j++){
				for(int g=0;g<players.size();g++){
					if(i == players.get(g).getPosX() && j == players.get(g).getPosY()){
						personnageSouffre(players.get(g) ,g);
					}
				}
			}
		}
	}
	
	//Inflige les d�g�ts aux personnages concern�s par l'attaque de zone de la boule de feu
	private void personnageSouffre(Personnage player, int pos){
		if(pos==0){
			joueurSouffre(attaqueF);
		}else{
			player.changeVie(attaqueF);
			if(player.getVie()<=0){
				player.getThread().interrupt();
				players.remove(player);
				renitialise();
				
			}
		}
		Affiche();	
	}
	
	
// UTIISE EQUIPEMENT
	
	
	//Le joueur utilise une boule de feu
	public void actionBoule(){
		if(inventaire.canUseBoule()){
			inventaire.useBoule();
			int a = players.get(0).getPosX();
			int b = players.get(0).getPosY();
			int orient = players.get(0).getOrientation();
			int c =0;
			int d =0;
			if(orient ==0){
				c=-1; 
			}else if(orient ==1){
				d=-1; 
			}else if(orient ==2){
				c=1;
			}else if(orient ==3){
				d=1;
			}
			listBoules.add(new BouleFeu(this, a+c, b+d, c, d));
			Affiche();	
		}
		
	}

	//Le joueur utilise une potion de sant�
	public void actionPotion(){
		if(inventaire.canUtilisePotion()){
			inventaire.utilisePotion();
			players.get(0).heal(); 
			Affiche();	
		}
	}
	
	//Le joueur l�che une arme
	public void actionArme(){
		if(inventaire.canThrowArme()){
			inventaire.throwArme();
			players.get(0).perdAttaque();
			Affiche();	
		}
	}
	
	//Le joueur utilise l�che une armure
	public void actionArmure(){
		if(inventaire.canThrowArmure()){
			inventaire.throwArmure();
			players.get(0).perdArmure();
			Affiche();	
		}
	}
	
	//Le joueur ramasse un objet
	public void ramasse(){
		if(inventaire.getEquipement()[0]<6){
			int x = players.get(0).getPosX();
			int y =  players.get(0).getPosY();
			int a,b; 
			for(Objet objet:objets){
				a = objet.getPosX();
				b = objet.getPosY();
				if (x==a && y==b){
					if(objet.getType()==0){
						inventaire.addPotion();
						objetsPotions.remove(objet);
						objets.remove(objet);
						break;
					}else if(objet.getType()==1){
						inventaire.addArmure();
						players.get(0).changeArmure();
						objetsArmures.remove(objet);
						objets.remove(objet);
						break;
					}else if(objet.getType()==2){
						inventaire.addArme();
						players.get(0).changeAttaque();
						objetsArmes.remove(objet);
						objets.remove(objet);
						break;
					}else if(objet.getType()==3){
						inventaire.addParchemin();
						listParchemins.remove(objet);
						objets.remove(objet);
						break;
					}
				}
			}
			Affiche();	
		}
	}
	
	
// RENITIALISE 	
	
	
	private void renitialise(){
		//Si les ennemis sont tous morts ou si le joueur est mort, lance un menu sp�cial pour recommencer une partie
		if(players.size() ==1 ||  players.get(0).getVie()<=0){
			for (Thread thread: threadList){
				thread.interrupt();
			}
			window = new Window(players.size()-1);
		}
	}
	
	
// SAUVEGARDE
	
	
	// Sauvegarde le jeu
	public void sauvegarde(){
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("Sauvegarde"));
			oos.writeObject(this);
			oos.flush(); 
			oos.close(); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//R�active tous les threads du jeu (Ennemis et Laves)
	public void relance(){
		for(int i=1; i<players.size();i++){
			players.get(i).actionneThread();
		}
		for (Lave lave:laveList){
			lave.actionneThread();;
		}
	}
}