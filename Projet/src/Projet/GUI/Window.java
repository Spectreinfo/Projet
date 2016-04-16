package Projet.GUI;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Map extends JPanel {
	private int[][] mapMatrix;
	
	public Map(){
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	public void paint(Graphics g) { 
		if(mapMatrix == null){
		}else{
			for(int i = 0; i<mapMatrix.length; i++){
				for(int j = 0; j<mapMatrix.length; j++){
					int x = i;
					int y = j;
					int color = mapMatrix[i][j];
					
					if(color == 0){
						g.setColor(Color.GRAY);
					}else if(color == 1){
						g.setColor(Color.DARK_GRAY);
					}else if(color == 2){
						g.setColor(Color.RED);
					}

					g.fillRect(x*12, y*12, 12, 12); 

					g.setColor(Color.BLACK);
					//g.drawRect(x*24, y*24, 24, 24); 
					System.out.print(color);
					System.out.print(" ");
				}
				System.out.println("");
			}
		}
	}
	
	public void setMapMatrix(int[][] mapMatrix){
		this.mapMatrix = mapMatrix;
		this.repaint();
	}

}