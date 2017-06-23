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




/**
 * Panneau, this class allows to associate map's alphanumeric character to their gif
 * @author Group 5 Arras
 * @version 1.0
 */
public class Panel extends JPanel implements ActionListener, KeyListener{
	private static final long serialVersionUID = 1L;
	final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());
	String[][] tbl = new String[40][30];
	ImageIcon tbl_image[][] =new ImageIcon[40][30];
    ImageIcon img_wall = new ImageIcon("Pictures/wall.gif");
    ImageIcon img_dirt = new ImageIcon("Pictures/dirt.gif");
    ImageIcon img_rockford = new ImageIcon("Pictures/rockford.gif");
    ImageIcon img_stone = new ImageIcon("Pictures/stone.gif");
    ImageIcon img_background = new ImageIcon("Pictures/fond.gif");
    ImageIcon img_diamond = new ImageIcon("Pictures/diamond.gif");
    ImageIcon img_monster = new ImageIcon("Pictures/monster.gif");
    ImageIcon img_monster2 = new ImageIcon("Pictures/monster2.gif");
    
    // Initial position of the hero
    int PositionX=3, PositionY=3;
    //
    int WinGame = 0;
	int size_stone=0, size_diams=0, state=0, first=0, Cmpt_Diams=0, Life=2;

	public String Nmap = null;
	
	public Panel(final String nb){
		if(nb=="1"  || nb=="2" || nb=="3" || nb=="4" || nb=="5"){
		this.Nmap=nb;}
		else{this.Nmap=nb;}
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	
	
    	/**
	 * paintComponent this function allows many functionality
	 * convert the string table into picture table 
	 * monter's Movement, this is random
	 * kill monster
	 * push stone in any direciton
	 * detection of stone, diamond and wall
	 * diamond and stone's gravity
	 * display the different element, rockford, score  ans life
	 * 
	 * 
	 * 
	 */
	public void paintComponent(Graphics g){
		try{	
			// Lists containing the position (x and y) of the diamonds, rocks and monsters
		    ArrayList<Integer> Listx_stone = new ArrayList<Integer>();
		    ArrayList<Integer> Listy_stone = new ArrayList<Integer>();
		    ArrayList<Integer> Listx_diams = new ArrayList<Integer>();
		    ArrayList<Integer> Listy_diams = new ArrayList<Integer>();
		    ArrayList<Integer> Listx_monster = new ArrayList<Integer>();
		    ArrayList<Integer> Listy_monster = new ArrayList<Integer>();
		    ArrayList<Integer> Listx_monster2 = new ArrayList<Integer>();
		    ArrayList<Integer> Listy_monster2 = new ArrayList<Integer>();
			// Retrieving the String table from the controller
			if(first==0){tbl=controller.start(Nmap);first++;}
			// Converting the string array to an image table
			for(int y=0;y<30;y++){
				for(int x=0; x<40; x++){
						tbl[x][y]=tbl[x][y].intern();
						if(tbl[x][y]=="#"){tbl_image[x][y]=img_wall;}
						else if(tbl[x][y]=="0"){tbl_image[x][y]=img_dirt;}
						else if(tbl[x][y]=="S"){tbl_image[x][y]=img_stone;Listx_stone.add(x);Listy_stone.add(y);}
						else if(tbl[x][y]=="B"){tbl_image[x][y]=img_background;}
						else if(tbl[x][y]=="D"){tbl_image[x][y]=img_diamond;Listx_diams.add(x);Listy_diams.add(y);}
						else if(tbl[x][y]=="M"){tbl_image[x][y]=img_monster;Listx_monster.add(x);Listy_monster.add(y);}
						else if(tbl[x][y]=="M2"){tbl_image[x][y]=img_monster2;Listx_monster2.add(x);Listy_monster2.add(y);}
						else{System.out.println("Unknown character !");;}
					}
				
				}
			
			
			// Monster Movements
			int list=0;
			int size_monster=Listx_monster.size();
			int move=0;
			
				// Generating a random movement
			while(list<size_monster){
			move = (int) (Math.random() * 5 );
			
				// Kill the Monster 1
			if(move==3){if(tbl[Listx_monster.get(list)][Listy_monster.get(list)-1]=="S" || tbl[Listx_monster.get(list)][Listy_monster.get(list)-1]=="D"){tbl[Listx_monster.get(list)][Listy_monster.get(list)]="D";}}
				// Monster 1 goes down
			if(move==1){if(tbl[Listx_monster.get(list)][Listy_monster.get(list)+1]=="B"){
				tbl[Listx_monster.get(list)][Listy_monster.get(list)+1]="M";
				tbl[Listx_monster.get(list)][Listy_monster.get(list)]="B";
				Listy_monster.set(list, Listy_monster.get(list)+1);}}
				// Monster 1 goes right
			if(move==2){if(tbl[Listx_monster.get(list)+1][Listy_monster.get(list)]=="B"){
				tbl[Listx_monster.get(list)+1][Listy_monster.get(list)]="M";
				tbl[Listx_monster.get(list)][Listy_monster.get(list)]="B";
				Listx_monster.set(list, Listx_monster.get(list)+1);}}
				// Monster 1 goes up
			if(move==3){if(tbl[Listx_monster.get(list)][Listy_monster.get(list)-1]=="B"){
				tbl[Listx_monster.get(list)][Listy_monster.get(list)-1]="M";
				tbl[Listx_monster.get(list)][Listy_monster.get(list)]="B";
				Listy_monster.set(list, Listy_monster.get(list)-1);}}
				// Monster 1 goes left
			if(move==4){if(tbl[Listx_monster.get(list)-1][Listy_monster.get(list)]=="B"){
				tbl[Listx_monster.get(list)-1][Listy_monster.get(list)]="M";
				tbl[Listx_monster.get(list)][Listy_monster.get(list)]="B";
				Listx_monster.set(list, Listx_monster.get(list)-1);}}
			list++;
			}
			
			// Movement of the Monster 2 (he deposits a stone before moving randomly in the map when the player goes to the right)
			if(state==4){
			int size_monster2=Listx_monster2.size();
			int moveX=0;
			int moveY=0;
			list=0;
			while(list<size_monster2){
			moveX = (int) (Math.random() * 39 );
			moveY = (int) (Math.random() * 29 );
			if(moveX!=0 && moveY!=0 ){
				tbl[Listx_monster2.get(list)][Listy_monster2.get(list)]="S";
				tbl[moveX][moveY]="M2";Listx_monster2.set(list, moveX);Listy_monster2.set(list, moveY);}list++;}}

			
			// Push the stones
				// to the right
			list=0;
			if(state==4){if(tbl[PositionX][PositionY]=="S" && tbl[PositionX+1][PositionY]=="B"){
				tbl[PositionX][PositionY]="B";
				tbl[PositionX+1][PositionY]="S";
				while(PositionX!=Listx_stone.get(list)){list++;}
				Listx_stone.set(list,Listx_stone.get(list)+1);
				}
			}
				// to the left
			list=0;
			if(state==3){if(tbl[PositionX][PositionY]=="S" && tbl[PositionX-1][PositionY]=="B"){
				tbl[PositionX][PositionY]="B";
				tbl[PositionX-1][PositionY]="S";
				while(PositionX!=Listx_stone.get(list)){list++;}
				Listx_stone.set(list,Listx_stone.get(list)-1);
				}
			}
				

			// Stop the collision against rocks and walls
			if(state==1){if(tbl[PositionX][PositionY]=="S" || tbl[PositionX][PositionY]=="#"){PositionY++;}}
			if(state==2){if(tbl[PositionX][PositionY]=="S" || tbl[PositionX][PositionY]=="#"){PositionY--;}}
			if(state==3){if(tbl[PositionX][PositionY]=="S" || tbl[PositionX][PositionY]=="#"){PositionX++;}}
			if(state==4){if(tbl[PositionX][PositionY]=="S" || tbl[PositionX][PositionY]=="#"){PositionX--;}}
			

			// Falling stones in cascade
			size_stone=Listx_stone.size();
			size_diams=Listx_diams.size();
			
			while(list<size_stone){
			if(tbl[Listx_stone.get(list)][Listy_stone.get(list)+1]=="S" || tbl[Listx_stone.get(list)][Listy_stone.get(list)+1]=="D"){
				// Look at the bottom right
				if(tbl[Listx_stone.get(list)+1][Listy_stone.get(list)+1]=="B"){
					tbl[Listx_stone.get(list)][Listy_stone.get(list)]="B";
					tbl[Listx_stone.get(list)+1][Listy_stone.get(list)+1]="S";
					Listx_stone.set(list,Listx_stone.get(list)+1);
					Listy_stone.set(list,Listy_stone.get(list)+1);
					}
				// Look at the bottom left
				if(tbl[Listx_stone.get(list)-1][Listy_stone.get(list)+1]=="B"){
					tbl[Listx_stone.get(list)][Listy_stone.get(list)]="B";
					tbl[Listx_stone.get(list)-1][Listy_stone.get(list)+1]="S";
					Listx_stone.set(list,Listx_stone.get(list)-1);
					Listy_stone.set(list,Listy_stone.get(list)+1);
					}
			}
			list++;
			}

			
			// Falling stones (gravity)
			list=0;
			while(list<size_stone){
			if(tbl[Listx_stone.get(list)][Listy_stone.get(list)+1]=="B"){
				tbl[Listx_stone.get(list)][Listy_stone.get(list)+1]="S";
				tbl[Listx_stone.get(list)][Listy_stone.get(list)]="B";
				Listy_stone.set(list,Listy_stone.get(list)+1);}
			list++;
			}
			
			// Detection of diamond / collection
			if(state==1 || state==2 || state==3 || state==4){if(tbl[PositionX][PositionY]=="D"){state=0;Cmpt_Diams++;}}
			// Perte de vie
			if(state==1 || state==2 || state==3 || state==4){if(tbl[PositionX][PositionY]=="M" || tbl[PositionX][PositionY]=="S"){Life--;state=0;}}


			// Falling diamond
			for(int list1=0;list1<size_diams;list1++){
			if(tbl[Listx_diams.get(list1)][Listy_diams.get(list1)+1]=="B"){
				tbl[Listx_diams.get(list1)][Listy_diams.get(list1)]="B";
				tbl[Listx_diams.get(list1)][Listy_diams.get(list1)+1]="D";
				Listy_diams.set(list1,Listy_diams.get(list1)+1);}
			}


			// Display of the picture table
			
				for(int y=0;y<30;y++){
					for(int x=0; x<40; x++){
						g.drawImage(tbl_image[x][y].getImage(), x*32, y*32,32,32,this);
						g.drawImage(img_rockford.getImage(), PositionX*32, PositionY*32,32,32,this);
					}
				}
				
			// Finished Games
				
				size_diams=Listx_diams.size();
				
				
				
				if (WinGame == 1){

					Thread.sleep(3000);
					String nb="0";
					Window windo = new Window(nb);
					windo.exit();
			}
						// YOU WIN !
				if(size_diams==0){
					for(int y=0;y<30;y++){
						for(int x=0; x<40; x++){
							g.drawImage(img_dirt.getImage(), x*32, y*32,32,32,this);}}
					
						WinGame = 1;	
							g.setColor(Color.BLUE);
							g.setFont(new Font("arial", Font.BOLD,100));
							g.drawString("YOU WIN !", 350,450);
					}
					// YOU LOOSE !
				if(Life==0){
					for(int y=0;y<30;y++){
						for(int x=0; x<40; x++){
							g.drawImage(img_dirt.getImage(), x*32, y*32,32,32,this);}}
					
						WinGame = 1;	
							g.setColor(Color.BLUE);
							g.setFont(new Font("arial", Font.BOLD,100));
							g.drawString("YOU LOOSE !", 350,450);
					}


		
			// Hero Display
				
			g.drawImage(img_rockford.getImage(), PositionX*32, PositionY*32,32,32,this);
			
			// Score display
			g.setColor(Color.RED);
			g.setFont(new Font("arial", Font.BOLD,28));
			g.drawString("Diams : "+Cmpt_Diams, 9,30);
			// Life display
			g.setColor(Color.RED);
			g.setFont(new Font("arial", Font.BOLD,28));
			g.drawString("Life : "+Life, 200,30);
			
			state=0;
			

		}catch (SQLException e) {e.printStackTrace();} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	
	// Different player movements
	
	public void Up(){ 	
			tbl[PositionX][PositionY]="B";
			PositionY--;
			state=1;
	}
	public void down(){
		tbl[PositionX][PositionY]="B";
		PositionY++;
		state=2;
	}
	public void left(){
		tbl[PositionX][PositionY]="B";
		PositionX--;
		state=3;
	}
	public void right(){
		tbl[PositionX][PositionY]="B";
		PositionX++;
		state=4;
	}
	

	// Detecting a key press
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_UP){Up();}
		if(code == KeyEvent.VK_DOWN){down();}
		if(code == KeyEvent.VK_LEFT){left();}
		if(code == KeyEvent.VK_RIGHT){right();}	
	}
	// Display the map
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();	
	}
}