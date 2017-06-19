package model;

public class Stone extends MotionElement{
	
	public Stone(){
		
	}

	public static void StoneMoove(String[][] map, int x, int y ){
		
		if(map[x][y+1] == "B" ){				//if at right it s a dirt or a background
			map[x][y+1] = "S";
			map[x][y] = "B";
		}
		if(map[x][y+1] == "R" ){
			map[x][y] = "B";
			//Rockford.decRockford_Hp();
			
		}
		else if (map[x+1][y] == "B" || map[x+1][y+1] == "B"){
			map[x+1][y+1] = "S";
			map[x][y] = "B";
		}
		
		else {
			map[x][y] = "S";
		}
		
		
	}
}
