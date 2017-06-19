package model;

public class Monster extends MotionElement{
	
	Monster(){
		
	}
	
	public static void MonsterMoove(String[][] map, int x, int y){
		
		
		if (map[x + 1][y] == "B"){				//if at right it s a background or a background
			map[x + 1][y] = "M";
			map[x][y] = "B";	
		}
		
		else if (map[x][y - 1] == "B"){				//if at down it s a background or a background
			map[x][y + 1] = "M";
			map[x][y] = "B";	
		}
		
		else  {				//else moove up
			map[x][y - 1] = "M";
			map[x][y] = "B";	
		}
		
		
	}
	
	
	public void MonsterExplosed (String[][] map, int x, int y){ // if the monster explosed
		
		map[x][y] = "D";
		map[x][y+1] = "D";	
		map[x][y-1] = "D";
		map[x+1][y+1] = "D";
		map[x+1][y-1] = "D";
		map[x+1][y] = "D";
		map[x-1][y+1] = "D";
		map[x-1][y] = "D";
		map[x-1][y-1] = "D";
		
	}

}
