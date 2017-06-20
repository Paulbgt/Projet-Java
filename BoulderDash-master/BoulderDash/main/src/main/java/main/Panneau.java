package main;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import controller.ControllerFacade;
import model.ModelFacade;
import view.ViewFacade;
import model.Rockford;

public class Panneau extends JPanel implements KeyListener{
	private static final long serialVersionUID = 1L;
	String[] essai = new String[41];
	String[][] tbl = new String[40][30];
	ImageIcon tbl_image[][] =new ImageIcon[40][30];

	public void paintComponent(Graphics g){
		
		final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());
	
		try{
		    ImageIcon img_wall = new ImageIcon("Pictures/mur.gif");
		    ImageIcon img_durt = new ImageIcon("Pictures/pierre.gif");
		    ImageIcon img_rockford = new ImageIcon("Pictures/icone2.gif");
		    ImageIcon img_stone = new ImageIcon("Pictures/stone.gif");
		    ImageIcon img_background = new ImageIcon("Pictures/fond.gif");
		    ImageIcon img_diamond = new ImageIcon("Pictures/diamond.gif");
		    
			for(int x=2; x<42; x++){essai=(String[]) controller.start(x);
				for(int y=0; y<30; y++){tbl[x-2][y]=essai[y];}
			}
			
			for(int y=0;y<30;y++){
			for(int x=0; x<40; x++){
					tbl[x][y]=tbl[x][y].intern();
					if(tbl[x][y]=="#"){tbl_image[x][y]=img_wall;}
					else if(tbl[x][y]=="0"){tbl_image[x][y]=img_durt;}
					else if(tbl[x][y]=="S"){tbl_image[x][y]=img_stone;}
					else if(tbl[x][y]=="B"){tbl_image[x][y]=img_background;}
					else if(tbl[x][y]=="D"){tbl_image[x][y]=img_diamond;}
					else{tbl_image[x][y]=img_rockford;}
					g.drawImage(tbl_image[x][y].getImage(), x*32, y*32,32,32,this);
				}
			}
			}catch (SQLException e) {e.printStackTrace();}
		
			
			}
 
	
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==38){
				Rockford.TurnRight(tbl,0,0);
			}
		}
	
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void keyTyped(KeyEvent e) {
			}
			
		}

