package model;

/**
 * <h1>The Class ExampleDAO.</h1>
 * monster Class run the movement of the monster
 * @author Group 5 Arras
 * @version 1.0
 */
public class Monster extends MotionElement{
	
	Monster(){
		
	}
	
	
	

	/**
	 * MonsterMoove is the function that run the movement of the monster
	 * @param map is the matrix where the map is stock
	 * @param x is the int that refer to the column
	 * @param y is the int that refer to the line
	 */
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
	
	/**
	 * MonsterExplosed is the function that manage the monster's reaction when they die
	 * @param map is the matrix where the map is stock
	 * @param x is the int that refer to the column
	 * @param y is the int that refer to the line
	 */
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