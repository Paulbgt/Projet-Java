package model;

public class Rockford extends MotionElement{
	

	
	// classes to create
	
	public int Rockford_Hp;
	public int DiamondLeft;
	public int posX;
	public int posY;

	// classes to create	
				
	
	
	


	public Rockford(int Rockford_Hp,int DiamondLeft, int posX,int posY){
			
		this.Rockford_Hp = Rockford_Hp;
		this.DiamondLeft = DiamondLeft;
		this.posX = posX;
		this.posY = posY;
	}
		
		public void TurnRight(String[][] map, int x, int y ){ 				// Methode for the rockford turn right 
			
			if (map[x + 1][y] == "T" || map[x + 1][y] == "B"){				//if at right it s a dirt or a background
					map[x + 1][y] = "R";
					map[x][y] = "B";
					
			}
			
			else if (map[x + 1][y] == "D" ){								// if at right it s a monster 
					map[x + 1][y] = "R";
					map[x][y] = "B";
					//decDiamondLeft();
					
			}
			
			else if (map[x + 1][y] == "S" || map[x + 1][y] == "W"){ 		//if at right it s a stone or a Wall 
					map[x][y] = "R";
			}
			
			else if (map[x + 1][y] == "M"){ 								// if at right it s a monster 
				map[x][y] = "R";
				//decRockford_Hp();
			}
			
		}
		
		
		
		public void TurnLeft(String[][] map, int x, int y ){ 				// Methode for the rockford turn left 
			
			if (map[x - 1][y] == "T" || map[x - 1][y] == "B"){				//if at left  it s a dirt or a background
					map[x - 1][y] = "R";
					map[x][y] = "B";
					
			}
			
			else if (map[x - 1][y] == "D" ){								// if at left  it s a monster 
					map[x - 1][y] = "R";
					map[x][y] = "B";
					//ecDiamondLeft();
					
			}
			
			else if (map[x - 1][y] == "S" || map[x - 1][y] == "W"){ 		//if at left  it s a stone or a Wall 
					map[x][y] = "R";
			}
			
			else if (map[x - 1][y] == "M"){ 								// if at left  it s a monster 
				map[x][y] = "R";
				//decRockford_Hp();
			}
			
		}
		
		
		
		public void TurnUp(String[][] map, int x, int y ){ 				// Methode for the rockford turn up 
			
			if (map[x ][y-1] == "T" || map[x][y-1] == "B"){				//if at up  it s a dirt or a background
					map[x][y-1] = "R";
					map[x][y] = "B";
					
			}
			
			else if (map[x][y-1] == "D" ){								// if at up  it s a monster 
					map[x][y-1] = "R";
					map[x][y] = "B";
				//	decDiamondLeft();
					
			}
			
			else if (map[x][y-1] == "S" || map[x][y-1] == "W"){ 		//if at up  it s a stone or a Wall 
					map[x][y] = "R";
			}
			
			else if (map[x][y-1] == "M"){ 								// if at right it s a monster 
				map[x][y] = "R";
				//decRockford_Hp();
			}
			
		}
		
		public void TurnDown(String[][] map, int x, int y ){ 				// Methode for the rockford turn right 
			
			if (map[x ][y+1] == "T" || map[x][y+1] == "B"){				//if at right it s a dirt or a background
					map[x][y-1] = "R";
					map[x][y] = "B";
					
			}
			
			else if (map[x][y+1] == "D" ){								// if at right it s a monster 
					map[x][y+1] = "R";
					map[x][y] = "B";
				//	decDiamondLeft();
					
			}
			
			else if (map[x][y+1] == "S" || map[x][y+1] == "W"){ 		//if at right it s a stone or a Wall 
					map[x][y] = "R";
			}
			
			else if (map[x][y+1] == "M"){ 								// if at right it s a monster 
				map[x][y] = "R";
				//decRockford_Hp(); 
			}
			
		}
		
		
		
		
		
		
				public int getRockford_Hp() {
						return Rockford_Hp;
					}
			
				public void setRockford_Hp(int rockford_Hp) {
						Rockford_Hp = rockford_Hp;
					}
				
				public void decRockford_Hp() {
					Rockford_Hp -= Rockford_Hp;
				}
				
				
				
			
				public int getDiamondLeft() {
						return DiamondLeft;
					}
			
			public void setDiamondLeft(int diamondLeft) {
						DiamondLeft = diamondLeft;
					}
			
			public void decDiamondLeft() {
				DiamondLeft -= DiamondLeft;
			}
			
			
				 public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
			
			
}