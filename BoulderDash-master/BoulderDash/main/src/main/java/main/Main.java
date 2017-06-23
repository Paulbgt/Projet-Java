package main;

import javax.swing.JOptionPane;



/**
 * Principal, is the main, it instantiate
 * @author Group 5 Arras
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {
		String nb = JOptionPane.showInputDialog(null,"Select level"," Game level selector", JOptionPane.QUESTION_MESSAGE);
		Window windo = new Window(nb);
		windo.setVisible(true);

	}

}
