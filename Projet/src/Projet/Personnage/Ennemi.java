package Projet.Personnage;

import java.util.Random;
import Projet.Autre.Jeu;

public class Ennemi  extends Personnage  implements Barbare,Archerie,Magie,Runnable {
	Random random = new Random();
	private Thread thread; 
	private int sleepTime =500;
	
	public Ennemi(Jeu jeu,int vie, int attaque, int armure, int orientation, int pX, int pY){
		super(jeu, vie, attaque, armure, orientation, pX, pY);
    	thread = new Thread(this);
    	thread.start();
    	
	}
	public void move(){
		sleepTime =500;
		if( (canMove(1,0) ||  canMove(-1,0)  || canMove(0,1) ||  canMove(0,-1))){
			if (inVisibleMap()){
				int a = jeu. players.get(0).getPosX();
				int b =  jeu. players.get(0).getPosY();
				if (Math.abs(a-pX)<=Math.abs(b-pY)){
					if(a-pX>0){
						if(canMove(1,0)){
							pX= pX+1;
						}else{
							if(b-pY>0){
								if(canMove(0,1)){
									pY = pY+1;
								}
							}else{
								if(canMove(0,-1)){
									pY = pY-1;
								}
							}	
						}
					}else if(a-pX<0){
						if(canMove(-1,0)){
							pX= pX-1;
						}else{
							if(b-pY>0){
								if(canMove(0,1)){
									pY = pY+1;
								}
							}else{
								if(canMove(0,-1)){
									pY = pY-1;
								}
							}
						}
					}else if(a-pX==0){
						if(b-pY>0){
							if(canMove(0,1)){
								pY = pY+1;
							}
						}else{
							if(canMove(0,-1)){
								pY = pY-1;
							}
						}	
					}
				}else{
					if(b-pY>0){
						if(canMove(0,1)){
							pY = pY+1;
						}else{
							if(a-pX>0){
								if(canMove(1,0)){
									pX= pX+1;
								}
							}else{
								if(canMove(-1,0)){
									pX= pX-1;
								}
							}
						}
					}else if(b-pY<0){
						if(canMove(0,-1)){
							pY = pY-1;
						}else{
							if(a-pX>0){
								if(canMove(1,0)){
									pX= pX+1;
								}
							}else{
								if(canMove(-1,0)){
									pX= pX-1;
								}
							}
						}
					}else if(b-pY==0){
						if(a-pX>0){
							if(canMove(1,0)){
								pX= pX+1;
							}
						}else{
							if(canMove(-1,0)){
								pX= pX-1;
							}
						}
					}
				}

			}else{
				int i = random.nextInt(4);
				if(i==0 && canMove(1,0)){
					pX= pX+1;
				}
				if(i==1 && canMove(-1,0)){
					pX= pX-1;
					
				}
				if(i==2 && canMove(0,1)){
					pY = pY+1;
					
				}
				if(i==3 && canMove(0,-1)){
					pY = pY-1;
				}
			}
			jeu.Affiche();
		}
	}
	
	public void run(){
		try{	
			while(true){
				this.act();
				Thread.sleep(sleepTime);
			}
		}catch(Exception e){};
	}
	
	private void act(){
		int a = posVisX();
		int b =  posVisY();
		final int c =jeu.view ;
		if((a==c-1 &&b==c)||(a==c+1 &&b==c)||(a==c &&b==c+1)||(a==c &&b==c-1)){
			jeu.joueurSouffre(attaque);
			sleepTime =1000;
		}else{
			move();
		}
	}
	
	
	private boolean inVisibleMap(){
		return (posVisX()>=0 && posVisX()<=2*jeu.view && posVisY()>=0 && posVisY()<=2*jeu.view);
	}
	
	public Thread getThread(){
		return this.thread;
	}
	private int posVisX(){
		int a = jeu. players.get(0).getPosX();
		final int C =jeu.view ;
		return(C-(a-this.pX));
		
	}
	private int posVisY(){
		int b =  jeu. players.get(0).getPosY();
		final int C =jeu.view ;
		return(C-(b-this.pY));
	}
	
	public boolean canMove(int x, int y){
		//int m = posVisX();
		//int l =posVisY();
		int m = pX;
		int l = pY;
		int[][] visible_map = jeu.getMap();
		return(visible_map[x+m][y+l]==0 ||visible_map[x+m][y+l]==4 ||visible_map[x+m][y+l]==5 || visible_map[x+m][y+l]==6 || visible_map[x+m][y+l]==8);	
	}

	
}