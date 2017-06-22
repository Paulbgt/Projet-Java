package view;

import javax.swing.JFrame;


public class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;

public Fenetre(String[][] map){                

	Panneau s = new Panneau(map);
	this.add(s);
    this.setTitle("Projet Java");
    this.setSize(1300, 1010);
    this.setLocationRelativeTo(null);               
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(new Panneau(map));
    this.setVisible(true);

  }     
}