package firstpack;

import java.awt.Graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import javax.swing.JPanel;

 

public class Panneau extends JPanel {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void paintComponent(Graphics g, BufferedImage[][] map){
	
	
	for (int x = 0; x < 16; x++) {
		for (int y = 0; y < 16; y++) {
				
    g.drawImage(map[0][0], 0, 0,50, 50, this);                
		}
	}  }               

}