package model;

import java.util.ArrayList;
import java.util.Observer;

import model.Observable;

public class Map {

	
	public String[][] tbl;
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	
	// Récupération du tbl
	




	public Map(String[][] tbl){
		this.tbl = tbl;
		
	}
	
	
	
	public void ScanMap(){
		for(int y = 30 ; y != -1 ; y -- ){
			for(int x = 40 ; x != -1 ; x -- ){
				
				if(this.tbl[x][y] == "S"){
					Stone.StoneMoove(this.tbl, x, y);
				}
				
				if(this.tbl[x][y] == "D"){
					Diamond.DiamondMoove(this.tbl, x , y);
				}
				
				if(this.tbl[x][y] == "M"){
					Monster.MonsterMoove(this.tbl, x , y);
				}
			}
		}
	}
	
	
	public String[][] getMap() {
		return tbl;
	}



	public void setMap(String[][] tbl) {
		this.tbl = tbl;
	}


/*
	@Override
	public void addObserver(Observer obs) {
		this.listObserver.add(obs);
		
	}



	@Override
	public void removeObserver() {
		listObserver = new ArrayList<Observer>();
		
	}



	@Override
	public void notifyObserver(String str) {
	    if(str.matches("^0[0-9]+"))
	        str = str.substring(1, str.length());

	    for(Observer obs : listObserver)
	        obs.update(str);
		
	}

*/
	
}
