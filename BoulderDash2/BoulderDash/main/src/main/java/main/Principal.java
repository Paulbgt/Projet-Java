package main;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		String nb = JOptionPane.showInputDialog(null,"Select level"," Game level selector", JOptionPane.QUESTION_MESSAGE);
		Fenetre fenetre = new Fenetre(nb);
		fenetre.setVisible(true);

	}

}
