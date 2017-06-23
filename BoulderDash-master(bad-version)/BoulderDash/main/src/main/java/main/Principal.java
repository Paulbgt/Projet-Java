package main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.ControllerFacade;
import view.Fenetre;
import view.Panneau;
import model.ModelFacade;
import model.Rockford;
import model.Map;
import view.ViewFacade;


public class Principal {

	
	static Rockford player = new Rockford(5,10,3,3);
	private Map map;

	static  public int hp;

	
	public static void main(String[] args) throws SQLException, InterruptedException {
		
		
	    JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
	    String nb = jop.showInputDialog(null, "Select level", "Game Level Selector", JOptionPane.QUESTION_MESSAGE);
	    
		
		
		final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());
		
		Map map = new Map(controller.start(nb));
		
		Fenetre fenetre = new Fenetre(map.getMap());		
		fenetre.setVisible(true);
		
		
		while(player.getDiamondLeft() != 0){
			while(player.getRockford_Hp() != 0){
				map.ScanMap();
				Thread.sleep(500);
				
				
			}
			
		}

			
		}
		


	}


