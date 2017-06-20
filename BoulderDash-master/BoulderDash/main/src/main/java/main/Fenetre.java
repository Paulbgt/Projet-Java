package main;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
	
	
	
	/**
	 * Fenetre, this function allows to show a new window.  
	 * @author Balentin's
	 */
	
	
	private static final long serialVersionUID = 1L;

	
public Fenetre(){                

    this.setTitle("Projet Java");
    this.setSize(1300, 1010);
    this.setLocationRelativeTo(null);               
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(new Panneau());
    this.setVisible(true);

  }     
}