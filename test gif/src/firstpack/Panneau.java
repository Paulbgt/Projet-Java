package firstpack;

import java.awt.Graphics;

import java.awt.Image;

import java.io.File;

import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JPanel;

 

public class Panneau extends JPanel {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void paintComponent(Graphics g){

    try {
    	
      Image tbl[][] =new Image[3][3];
      Image img1 = ImageIO.read(new File("Picture/icone.gif"));
      Image img2 = ImageIO.read(new File("Picture/icone2.gif"));
      Image img3 = ImageIO.read(new File("Picture/icone3.gif"));
      Image img4 = ImageIO.read(new File("Picture/test.gif"));
      tbl[0][0] = img1;
      tbl[1][0] = img2;
      tbl[2][0]= img3;
      tbl[3][0]= img4;
      

      g.drawImage(tbl[0][0], 0, 0,16 ,16, this);
      g.drawImage(tbl[1][0], 0, 16,16 ,16, this);
      g.drawImage(tbl[2][0], 0, 32,16 ,16, this);
      g.drawImage(tbl[3][0], 0, 48,16 ,16, null);

      //Pour une image de fond

      //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

    } catch (IOException e) {

      e.printStackTrace();

    }                

  }               

}