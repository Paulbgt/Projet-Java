package main;

public class PhysicalGame extends Game {
	
	 @Override
	public void update() {
		n = n++;
		if (n>10000){
			end = true;
		}
			
	}
	 @Override
	public void render() {
		p.repaint();
	}

}
