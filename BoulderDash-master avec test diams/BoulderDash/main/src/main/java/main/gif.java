package main;

/** 
* 
* 
* 
*/ 

import java.awt.BorderLayout; 
import java.awt.Dimension; 
import java.awt.Graphics; 

import javax.swing.ImageIcon; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 

public class gif extends JFrame { 
/** 
* 
*/ 
private static final long serialVersionUID = 1L; 
JPanel contentPane; 

JLabel headerLabel = new JLabel(); 

public gif() { 

try { 
setDefaultCloseOperation(EXIT_ON_CLOSE); 
contentPane = (JPanel) getContentPane(); 
contentPane.setLayout(new BorderLayout()); 
setSize(new Dimension(400, 300)); 
setTitle("Your Job Crashed!"); 
setLocationRelativeTo(null); 

contentPane.add(headerLabel, java.awt.BorderLayout.NORTH); 

contentPane.add(new JPanel() { 

@Override 
public void paintComponent(Graphics g) { 

g.drawImage(new ImageIcon("Pictures/diamond.gif").getImage(), m_x, m_y, this); 
} 

private int m_x = 100; 
private int m_y = 20; 
}); 

this.setLocation(0,0);// position de la fen�tre 
this.setVisible(true); 
} 
catch (Exception exception) { 

exception.printStackTrace(); 
} 
} 

public static void main(String[] args) { 
new gif(); 
} 

}