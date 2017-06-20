package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControllerFacade;
import model.ModelFacade;
import view.ViewFacade;


public class Panneau extends JPanel {
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
	
		final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());
		String[] essai = new String[41];
		String[][] tbl = new String[40][30];
		Image tbl_image[][] =new Image[40][30];
	
		
		try{
		    Image img_wall = ImageIO.read(new File("Pictures/mur.gif"));
		    Image img_durt = ImageIO.read(new File("Pictures/pierre.gif"));
		    Image img_rockford = ImageIO.read(new File("Pictures/icone2.gif"));
		    Image img_stone = ImageIO.read(new File("Pictures/rocher.gif"));
		    Image img_background = ImageIO.read(new File("Pictures/fond.gif"));
		    Image img_diamond = ImageIO.read(new File("Pictures/diamond.gif"));
		    
			for(int x=2; x<42; x++){essai=(String[]) controller.start(x);
				for(int y=0; y<30; y++){tbl[x-2][y]=essai[y];}
			}
			
	
			for(int y=0;y<30;y++){
			for(int x=0; x<40; x++){
					tbl[x][y]=tbl[x][y].intern();
					if(tbl[x][y]=="#"){
						System.out.println("oki");
						tbl_image[x][y]=img_wall;
						g.drawImage(tbl_image[x][y], x*32, y*32,32,32,this);
					}
					else if(tbl[x][y]=="0"){
						tbl_image[x][y]=img_durt;
						g.drawImage(tbl_image[x][y], x*32, y*32,32,32,this);
					}
					else if(tbl[x][y]=="S"){
						tbl_image[x][y]=img_stone;
						g.drawImage(tbl_image[x][y], x*32, y*32,32,32,this);
					}
					else if(tbl[x][y]=="B"){
						tbl_image[x][y]=img_background;
						g.drawImage(tbl_image[x][y], x*32, y*32,32,32,this);
					}
					else if(tbl[x][y]=="D"){
						tbl_image[x][y]=img_diamond;
						g.drawImage(tbl_image[x][y], x*32, y*32,32,32,this);
					}
					else{
						System.out.println("oké");
						tbl_image[x][y]=img_rockford;
						g.drawImage(tbl_image[x][y], x*32, y*32,32,32,this);
					}	
				}
			}
			
	
	
			
			
			
			
			
			
			
			
			
			
			
			
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	  }  
	
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

}