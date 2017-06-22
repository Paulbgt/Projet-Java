package main;

import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.ControllerFacade;
import view.Fenetre;
import model.ModelFacade;
import model.Rockford;
import model.Map;
import view.ViewFacade;


public class Principal {

	
	private Rockford player = new Rockford(5,10,3,3);
	private Map map;

	
	public static void main(String[] args) throws SQLException {
		
		
	    JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
	    String nb = jop.showInputDialog(null, "Select level", "Game Level Selector", JOptionPane.QUESTION_MESSAGE);
	    
		
		
		final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());
		
		Map map = new Map(controller.start(nb));
		
		Fenetre fenetre = new Fenetre(map.getMap());		
		fenetre.setVisible(true);
		
		while(player.getDiamondLeft() != 0){
			
		}

			
		}
		
		public void keyReleased(KeyEvent e) {
			int code = e.getKeyCode();
			if(code == KeyEvent.VK_UP){player.TurnUp(map.getMap() , player.getPosX() , player.getPosY());}
			if(code == KeyEvent.VK_DOWN){player.TurnDown(map.getMap() , player.getPosX() , player.getPosY());}
			if(code == KeyEvent.VK_LEFT){player.TurnLeft(map.getMap() , player.getPosX() , player.getPosY());}
			if(code == KeyEvent.VK_RIGHT){player.TurnRight(map.getMap() , player.getPosX() , player.getPosY());}

	}

}
