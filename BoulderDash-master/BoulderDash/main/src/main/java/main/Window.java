package main;

import javax.swing.JFrame;


/**
 * Window , this class allows to show a new window.
 * @author Group 5 Arras
 * @version 1.0
 */
public class Window extends JFrame {
	private static final long serialVersionUID = 1L;

public Window(final String nb){                

	Panel s = new Panel(nb);
	this.add(s);
    this.setTitle("Projet Java");
    this.setSize(1300, 1010);
    this.setLocationRelativeTo(null);               
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(new Panel(nb));
    this.setVisible(true);

  }     
}