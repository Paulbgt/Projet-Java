package model;

public class Diamond extends MotionElement implements IDiamondMoove{

	
	
	
	
	public static void DiamondMoove(String[][] map, int x, int y ){
		
		if(map[x][y+1] == "B" ){				//if at right it s a dirt or a background
			map[x][y+1] = "D";
			map[x][y] = "B";
		}
		
		if(map[x][y+1] == "R" ){
			map[x][y] = "B";
			//Rockford.decRockford_Hp();			
		}
		
		else if (map[x+1][y] == "B" || map[x+1][y+1] == "B"){
			map[x+1][y+1] = "D";
			map[x][y] = "B";
		}
		
		else {
			map[x][y] = "D";
		}
		
		
	}
}