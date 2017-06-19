package firstpack;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Element {

	private String spriteName;
	private static BufferedImage sprite;
	private static String PictureFolder = "Picture/";
	
	

	
	public BufferedImage loadSprite(String spriteName) {
		BufferedImage sprite = null;

		try {
			sprite = ImageIO.read(new File(PictureFolder + spriteName + ".gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setSprite(sprite);

		return sprite;
	}




	public static BufferedImage getSprite() {
		return sprite;
	}




	public static void setSprite(BufferedImage sprite) {
		Element.sprite = sprite;
	}
}
