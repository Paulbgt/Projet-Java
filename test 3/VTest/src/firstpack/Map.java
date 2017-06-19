package firstpack;

import java.awt.image.BufferedImage;


public class Map {
	public BufferedImage[][] map;
	RockfordElement e1 = new RockfordElement();
	
		public Map(){
			for (int x = 0; x < 16; x++) {
				for (int y = 0; y < 16; y++) {
					map[x][y] = e1.getSprite();
				}
			}
	}
}
