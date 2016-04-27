package Projet.GUI;

import java.awt.Color;
import java.awt.event.KeyListener;

import javax.swing.*;


public class Window extends JPanel {
	private Map map = new Map();
	private JPanel panel;
	private JButton restartButton;
	private JTextArea textArea;
	JFrame window;
	//private InventaireAffichage inv = new InventaireAffichage();
	
	public Window(){
	    JFrame window = new JFrame("Gandalf vs the JARS JARS");
	    window.setLocationRelativeTo(null);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setBounds(0, 0, 1000, 1020);
	    window.setLocationRelativeTo(null);
	    window.getContentPane().setBackground(Color.BLACK);
	    window.getContentPane().add(this.map);
	    window.setVisible(true); 
	   }	
	public Window(int nEn){
		 
		JFrame newWindow = new JFrame("Gandalf vs the JARS JARS");
		newWindow.setLocationRelativeTo(null);
		newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newWindow.getContentPane().setBackground(Color.BLACK);
	    panel = new JPanel();
	    newWindow.getContentPane().add(panel);
	    textArea = new JTextArea(1,5);
		restartButton = new JButton("Nouveau niveau");
	    restartButton.addActionListener(new restartActionListener(textArea)); 
	    JLabel label1 = new JLabel("Il restait :"+ Integer.toString(nEn) +" ennemis");
	    panel.add(label1);
		panel.add(textArea); 
		panel.add(restartButton); 
		newWindow.pack();
		newWindow.setVisible(true); 
	    
	}
	
	public void draw(int[][] mapMatrix, int Life, int Attaque, int Armure , int[] Equipement, int nEn){
		map.setMapMatrix(mapMatrix);
		map.setLife(Life);
		map.setArmure(Armure);
		map.setAttaque(Attaque);
		map.setEquipement(Equipement);
		map.setnEn(nEn);
		map.repaint();
	}

	//public void draw(int Life){
	//	Life.repaint();
	//}
	public void setKeyListener(KeyListener keyboard){
	    this.map.addKeyListener(keyboard);
	}
}