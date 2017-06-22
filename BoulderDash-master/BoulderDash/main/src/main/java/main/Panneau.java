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
    ImageIcon img_rockford = new ImageIcon("Pictures/icone2.gif");
    ImageIcon img_stone = new ImageIcon("Pictures/stone.gif");
    ImageIcon img_background = new ImageIcon("Pictures/fond.gif");
    ImageIcon img_diamond = new ImageIcon("Pictures/diamond.gif");
    // Position des rochers dans une liste
    ArrayList<Integer> Listx_stone = new ArrayList<Integer>();
    ArrayList<Integer> Listy_stone = new ArrayList<Integer>();
    ArrayList<Integer> Listx_diams = new ArrayList<Integer>();
    ArrayList<Integer> Listy_diams = new ArrayList<Integer>();
	int PositionX=3, PositionY=3;
	int first=0;
	int etat=0;
	int Cmpt_Diams=0;


	
	public Panneau(){
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}


	public void paintComponent(Graphics g){
		try{	
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
						else if(tbl[x][y]=="R"){tbl_image[x][y]=img_rockford;}
						else{;}
					}
				}


			//chute de diaments
			int list=0;
			while(list<4){
			if(tbl[Listx_diams.get(list)][Listy_diams.get(list)+1]=="B"){
				tbl[Listx_diams.get(list)][Listy_diams.get(list)]="B";
				tbl[Listx_diams.get(list)][Listy_diams.get(list)+1]="D";
				Listy_diams.set(list,Listy_diams.get(list)+1);}
			list++;
			}


			// Affichage du tableau d'image
			
				for(int y=0;y<30;y++){
					for(int x=0; x<40; x++){
						g.drawImage(tbl_image[x][y].getImage(), x*32, y*32,32,32,this);
						g.drawImage(img_rockford.getImage(), PositionX*32, PositionY*32,32,32,this);
					}
				}

				//Detection de pierre et mur
			if(etat==1){if(tbl[PositionX][PositionY]=="S" || tbl[PositionX][PositionY]=="#"){PositionY++;}}
			if(etat==2){if(tbl[PositionX][PositionY]=="S" || tbl[PositionX][PositionY]=="#"){PositionY--;}}
			if(etat==3){if(tbl[PositionX][PositionY]=="#"){PositionX++;}}
			if(etat==4){if(tbl[PositionX][PositionY]=="#"){PositionX--;}}
			
			// Pousser les pierres
			if(etat==3){if(tbl[PositionX][PositionY]=="S" && tbl[PositionX-1][PositionY]=="B"){tbl[PositionX-1][PositionY]="S";tbl[PositionX][PositionY]="B";}}
			if(etat==3){if(tbl[PositionX][PositionY]=="S" && tbl[PositionX-1][PositionY]!="B"){PositionX++;}}
			if(etat==4){if(tbl[PositionX][PositionY]=="S" && tbl[PositionX+1][PositionY]=="B"){tbl[PositionX+1][PositionY]="S";tbl[PositionX][PositionY]="B";Listy_stone.set(PositionY, PositionY+1);}}
			if(etat==4){if(tbl[PositionX][PositionY]=="S" && tbl[PositionX+1][PositionY]!="B"){PositionX--;}}
			
			// Chute des pierres ( gravité )
			list=0;
			while(list<8){
			if(tbl[Listx_stone.get(list)][Listy_stone.get(list)+1]=="B"){
				tbl[Listx_stone.get(list)][Listy_stone.get(list)+1]="S";
				tbl[Listx_stone.get(list)][Listy_stone.get(list)]="B";
				Listy_stone.set(list,Listy_stone.get(list)+1);}
			list++;
			}
			
				//Detection de diament
			if(etat==1){if(tbl[PositionX][PositionY]=="D" ){Cmpt_Diams++;System.out.println(Cmpt_Diams);etat=0;}}
			if(etat==2){if(tbl[PositionX][PositionY]=="D" ){Cmpt_Diams++;System.out.println(Cmpt_Diams);etat=0;}}
			if(etat==3){if(tbl[PositionX][PositionY]=="D" ){Cmpt_Diams++;System.out.println(Cmpt_Diams);etat=0;}}
			if(etat==4){if(tbl[PositionX][PositionY]=="D" ){Cmpt_Diams++;System.out.println(Cmpt_Diams);etat=0;}}
			g.drawImage(img_rockford.getImage(), PositionX*32, PositionY*32,32,32,this);
			
			//Affichage du score
			g.setColor(Color.RED);
			g.setFont(new Font("arial", Font.BOLD,28));
			g.drawString("Diams : "+Cmpt_Diams, 9,30);


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