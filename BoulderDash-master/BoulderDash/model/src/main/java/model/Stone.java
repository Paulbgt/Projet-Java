package model;

public class Stone extends MotionElement{
	
	public Stone(){
		
	}
	
	
	
    /**
     * Moove stone    
     * 
     *  
     *  the stone  fall or not 
     *
     * @param the map (a matrice) / x y for the location in the map
     *            the query
     * 
     * 
     * 
     * 
     */
	
	

	public static void StoneMoove(String[][] map, int x, int y ){
		
		if(map[x][y+1] == "B" ){				
			
			map[x][y+1] = "S";					 
			map[x][y] = "B";								
		}
		
		
		if(map[x][y+1] == "R" ){			
			
			map[x][y] = "B";			
			//reload the map									
			//rockford lost a hp								
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