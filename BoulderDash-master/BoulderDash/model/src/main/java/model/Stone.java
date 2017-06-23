package model;

import java.sql.SQLException;

/**
 * <h1>The Class ExampleDAO.</h1>
 *
 * @author Group 5 Arras
 * @version 1.0
 */
public class Stone extends MotionElement{
	
	
	
    /**
     * constructor Stone
     */
	public Stone(){
		
	}

	
    /**
     * StoneMoove, this function run the behavior of the stone
     *
     * @param map the matrix who contains the map 
 	* @param x is the int that refer to the column
 	* @param y is the int that refer to the line
     */
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