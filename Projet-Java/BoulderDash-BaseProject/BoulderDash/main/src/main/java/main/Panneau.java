package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controller.ControllerFacade;
import model.ModelFacade;
import view.ViewFacade;


public class Panneau extends JPanel implements KeyListener{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void paintComponent(Graphics g) {

	final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());
	String[] essai = new String[41];
	String[][] tbl = new String[40][30];
	Image tbl_image[][] =new Image[40][30];
	String a="#";
	String c="0";
	String d="S";
	String f="B";
	String h="D";
	
	try{
	    Image img = ImageIO.read(new File("Pictures/mur.gif"));
	    Image img2 = ImageIO.read(new File("Pictures/pierre.gif"));
	    Image img3 = ImageIO.read(new File("Pictures/icone2.gif"));
	    Image img4 = ImageIO.read(new File("Pictures/rocher.gif"));
	    Image img5 = ImageIO.read(new File("Pictures/fond.gif"));
	    Image img6 = ImageIO.read(new File("Pictures/diamond.gif"));
	    
		for(int x=2; x<42; x++){
			essai=(String[]) controller.start(x);
			for(int y=0; y<30; y++){
				tbl[x-2][y]=essai[y];
			}
		}
		

		int y=0;
		while(y<30){
		for(int x=0; x<40; x++){
				tbl[x][y]=tbl[x][y].intern();
				if(tbl[x][y]==a){
					System.out.println("oki");
					tbl_image[x][y]=img;
					g.drawImage(tbl_image[x][y], x*32, y*32,32,32,this);
				}
				else if(tbl[x][y]==c){
					tbl_image[x][y]=img2;
					g.drawImage(tbl_image[x][y], x*32, y*32,32,32,this);
				}
				else if(tbl[x][y]==d){
					tbl_image[x][y]=img4;
					g.drawImage(tbl_image[x][y], x*32, y*32,32,32,this);
				}
				else if(tbl[x][y]==f){
					tbl_image[x][y]=img5;
					g.drawImage(tbl_image[x][y], x*32, y*32,32,32,this);
				}
				else if(tbl[x][y]==h){
					tbl_image[x][y]=img6;
					g.drawImage(tbl_image[x][y], x*32, y*32,32,32,this);
				}
				else{
					System.out.println("oké");
					tbl_image[x][y]=img3;
					g.drawImage(tbl_image[x][y], x*32, y*32,32,32,this);
				}	
			}
			y++;
		}
		


		
		
		
		
		
		
		
		
		
		
		
		
	
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}               

}