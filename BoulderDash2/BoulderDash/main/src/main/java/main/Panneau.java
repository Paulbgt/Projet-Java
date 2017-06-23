package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.ControllerFacade;
import model.ModelFacade;
import view.ViewFacade;

public class Panneau extends JPanel implements ActionListener, KeyListener{
	private static final long serialVersionUID = 1L;
	final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());
	String[][] tbl = new String[40][30];
	ImageIcon tbl_image[][] =new ImageIcon[40][30];
    ImageIcon img_wall = new ImageIcon("Pictures/mur.gif");
    ImageIcon img_durt = new ImageIcon("Pictures/pierre.gif");
    ImageIcon img_rockford = new ImageIcon("Pictures/rockford.gif");
    ImageIcon img_stone = new ImageIcon("Pictures/stone.gif");
    ImageIcon img_background = new ImageIcon("Pictures/fond.gif");
    ImageIcon img_diamond = new ImageIcon("Pictures/diamond.gif");
    ImageIcon img_monster = new ImageIcon("Pictures/monster.gif");
    ImageIcon img_monster2 = new ImageIcon("Pictures/monster2.gif");
    
    // Position des rochers dans une liste
	int size_stone=0, size_diams=0, etat=0, first=0, Cmpt_Diams=0, PositionX=3, PositionY=3, Life=5;


	
	public Panneau(){
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}


	public void paintComponent(Graphics g){
		try{	
		    ArrayList<Integer> Listx_stone = new ArrayList<Integer>();
		    ArrayList<Integer> Listy_stone = new ArrayList<Integer>();
		    ArrayList<Integer> Listx_diams = new ArrayList<Integer>();
		    ArrayList<Integer> Listy_diams = new ArrayList<Integer>();
		    ArrayList<Integer> Listx_monster = new ArrayList<Integer>();
		    ArrayList<Integer> Listy_monster = new ArrayList<Integer>();
			// Récupération du tbl
			if(first==0){tbl=controller.start();first++;}
			// Convertion du tableau de string en tableau d'image
			for(int y=0;y<30;y++){
				for(int x=0; x<40; x++){
						tbl[x][y]=tbl[x][y].intern();
						if(tbl[x][y]=="#"){tbl_image[x][y]=img_wall;}
						else if(tbl[x][y]=="0"){tbl_image[x][y]=img_durt;}
						else if(tbl[x][y]=="S"){tbl_image[x][y]=img_stone;Listx_stone.add(x);Listy_stone.add(y);}
						else if(tbl[x][y]=="B"){tbl_image[x][y]=img_background;}
						else if(tbl[x][y]=="D"){tbl_image[x][y]=img_diamond;Listx_diams.add(x);Listy_diams.add(y);}
						else if(tbl[x][y]=="M"){tbl_image[x][y]=img_monster;Listx_monster.add(x);Listy_monster.add(y);}
						else if(tbl[x][y]=="M2"){tbl_image[x][y]=img_monster2;}
						else{;}
					}
				}
			
			// Mouvement du monstre
			int list=0;
			int size_monster=Listx_monster.size();
			int move=0;
			
				// Génération d'un mouvement aléatoire
			while(list<size_monster){
			move = (int) (Math.random() * 5 );
			
				// Tuer le monstre 
			if(move==3){if(tbl[Listx_monster.get(list)][Listy_monster.get(list)-1]=="S" || tbl[Listx_monster.get(list)][Listy_monster.get(list)-1]=="D"){tbl[Listx_monster.get(list)][Listy_monster.get(list)]="D";}}
				// Le monstre va en bas
			if(move==1){if(tbl[Listx_monster.get(list)][Listy_monster.get(list)+1]=="B"){
				tbl[Listx_monster.get(list)][Listy_monster.get(list)+1]="M";
				tbl[Listx_monster.get(list)][Listy_monster.get(list)]="B";
				Listy_monster.set(list, Listy_monster.get(list)+1);}}
				// Le monstre va a droite
			if(move==2){if(tbl[Listx_monster.get(list)+1][Listy_monster.get(list)]=="B"){
				tbl[Listx_monster.get(list)+1][Listy_monster.get(list)]="M";
				tbl[Listx_monster.get(list)][Listy_monster.get(list)]="B";
				Listx_monster.set(list, Listx_monster.get(list)+1);}}
				// Le monstre va en haut
			if(move==3){if(tbl[Listx_monster.get(list)][Listy_monster.get(list)-1]=="B"){
				tbl[Listx_monster.get(list)][Listy_monster.get(list)-1]="M";
				tbl[Listx_monster.get(list)][Listy_monster.get(list)]="B";
				Listy_monster.set(list, Listy_monster.get(list)-1);}}
				// Le monstre va a gauche
			if(move==4){if(tbl[Listx_monster.get(list)-1][Listy_monster.get(list)]=="B"){
				tbl[Listx_monster.get(list)-1][Listy_monster.get(list)]="M";
				tbl[Listx_monster.get(list)][Listy_monster.get(list)]="B";
				Listx_monster.set(list, Listx_monster.get(list)-1);}}
			list++;
			}
			
			// Pousser les pierres 
				// à droite
			list=0;
			if(etat==4){if(tbl[PositionX][PositionY]=="S" && tbl[PositionX+1][PositionY]=="B"){
				tbl[PositionX][PositionY]="B";
				tbl[PositionX+1][PositionY]="S";
				while(PositionX!=Listx_stone.get(list)){list++;}
				Listx_stone.set(list,Listx_stone.get(list)+1);
				}
			}
				// à gauche
			list=0;
			if(etat==3){if(tbl[PositionX][PositionY]=="S" && tbl[PositionX-1][PositionY]=="B"){
				tbl[PositionX][PositionY]="B";
				tbl[PositionX-1][PositionY]="S";
				while(PositionX!=Listx_stone.get(list)){list++;}
				Listx_stone.set(list,Listx_stone.get(list)-1);
				}
			}
				

			//Detection de pierre et mur
			if(etat==1){if(tbl[PositionX][PositionY]=="S" || tbl[PositionX][PositionY]=="#"){PositionY++;}}
			if(etat==2){if(tbl[PositionX][PositionY]=="S" || tbl[PositionX][PositionY]=="#"){PositionY--;}}
			if(etat==3){if(tbl[PositionX][PositionY]=="S" || tbl[PositionX][PositionY]=="#"){PositionX++;}}
			if(etat==4){if(tbl[PositionX][PositionY]=="S" || tbl[PositionX][PositionY]=="#"){PositionX--;}}
			

			// Cascade
			size_stone=Listx_stone.size();
			size_diams=Listx_diams.size();
			
			while(list<size_stone){
			if(tbl[Listx_stone.get(list)][Listy_stone.get(list)+1]=="S"){
				// regarde en bas à droite
				if(tbl[Listx_stone.get(list)+1][Listy_stone.get(list)+1]=="B"){
					tbl[Listx_stone.get(list)][Listy_stone.get(list)]="B";
					tbl[Listx_stone.get(list)+1][Listy_stone.get(list)+1]="S";
					Listx_stone.set(list,Listx_stone.get(list)+1);
					Listy_stone.set(list,Listy_stone.get(list)+1);
					}
				// regarde en bas à gauche
				if(tbl[Listx_stone.get(list)-1][Listy_stone.get(list)+1]=="B"){
					tbl[Listx_stone.get(list)][Listy_stone.get(list)]="B";
					tbl[Listx_stone.get(list)-1][Listy_stone.get(list)+1]="S";
					Listx_stone.set(list,Listx_stone.get(list)-1);
					Listy_stone.set(list,Listy_stone.get(list)+1);
					}
			}
			list++;
			}

			
			// Chute des pierres ( gravité )
			list=0;
			while(list<size_stone){
			if(tbl[Listx_stone.get(list)][Listy_stone.get(list)+1]=="B"){
				tbl[Listx_stone.get(list)][Listy_stone.get(list)+1]="S";
				tbl[Listx_stone.get(list)][Listy_stone.get(list)]="B";
				Listy_stone.set(list,Listy_stone.get(list)+1);}
			list++;
			}
			
			//Detection de diament
			if(etat==1 || etat==2 || etat==3 || etat==4){if(tbl[PositionX][PositionY]=="D"){etat=0;Cmpt_Diams++;}}
			// Perte de vie
			if(etat==1 || etat==2 || etat==3 || etat==4){if(tbl[PositionX][PositionY]=="M" || tbl[PositionX][PositionY]=="S"){Life--;etat=0;}}


			//chute de diaments
			for(int list1=0;list1<size_diams;list1++){
			if(tbl[Listx_diams.get(list1)][Listy_diams.get(list1)+1]=="B"){
				tbl[Listx_diams.get(list1)][Listy_diams.get(list1)]="B";
				tbl[Listx_diams.get(list1)][Listy_diams.get(list1)+1]="D";
				Listy_diams.set(list1,Listy_diams.get(list1)+1);}
			}


			// Affichage du tableau d'image
			
				for(int y=0;y<30;y++){
					for(int x=0; x<40; x++){
						g.drawImage(tbl_image[x][y].getImage(), x*32, y*32,32,32,this);
						g.drawImage(img_rockford.getImage(), PositionX*32, PositionY*32,32,32,this);
					}
				}
		
			// Affichage de rockford
				
			g.drawImage(img_rockford.getImage(), PositionX*32, PositionY*32,32,32,this);
			
			//Affichage du score
			g.setColor(Color.RED);
			g.setFont(new Font("arial", Font.BOLD,28));
			g.drawString("Diams : "+Cmpt_Diams, 9,30);
			// Affichage de la vie
			g.setColor(Color.RED);
			g.setFont(new Font("arial", Font.BOLD,28));
			g.drawString("Life : "+Life, 200,30);


		}catch (SQLException e) {e.printStackTrace();}
	  }
	
	public void Up(){ 	
			tbl[PositionX][PositionY]="B";
			PositionY--;
			etat=1;
	}
	public void down(){
		tbl[PositionX][PositionY]="B";
		PositionY++;
		etat=2;
	}
	public void left(){
		tbl[PositionX][PositionY]="B";
		PositionX--;
		etat=3;
	}
	public void right(){
		tbl[PositionX][PositionY]="B";
		PositionX++;
		etat=4;
	}
	


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_UP){Up();}
		if(code == KeyEvent.VK_DOWN){down();}
		if(code == KeyEvent.VK_LEFT){left();}
		if(code == KeyEvent.VK_RIGHT){right();}	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();	
	}
}