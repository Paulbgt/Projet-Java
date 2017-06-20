package model;

public class Diamond extends MotionElement{

	
	
	
    /**
     * Moove diamond    
     * 
     *  
     *  the diamond fall or not 
     *
     * @param the map (a matrice) / x y for the location in the map
     *            the query
     * 
     * 
     * 
     * 
     */
	
	
	public static void DiamondMoove(String[][] map, int x, int y ){
		
		if(map[x][y+1] == "B" ){				
			
			map[x][y+1] = "D";					
			map[x][y] = "B";								
		}
		
		
		if(map[x][y+1] == "R" ){				
			
			map[x][y] = "B";					 
			//reload the map									 
			//rockford lost a hp									 
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