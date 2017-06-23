package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
 

public class TestKeyListener extends JFrame {
    private static final long serialVersionUID = -5222658361778310082L;
    private TestKeyListener() {
        super("TestKeyListener");
        JLabel label = new JLabel("Pressez une touche...");
        add(label, BorderLayout.CENTER);
        addKeyListener(new TitreKeyListener(label));
        setPreferredSize(new Dimension(300, 100));
        pack();
    }
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new TestKeyListener();
                frame.setVisible(true);
            }
        });
    }
}
 
 
/**
 * Implémente l'interface KeyListener (écouteur d'événements clavier) : 
 * lorsqu'une touche est appuyée ou relâchée, affiche le code de touche
 * correspondant dans un objet JLabel qui doit être fourni au constructeur.
 */
class TitreKeyListener implements KeyListener {
    private final JLabel label;
     
    public TitreKeyListener(JLabel label_) {
        label = label_;
    }
 
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
        label.setText("Touche pressée : " + e.getKeyCode() + 
                " (" + e.getKeyChar() + ")");
	}

}









