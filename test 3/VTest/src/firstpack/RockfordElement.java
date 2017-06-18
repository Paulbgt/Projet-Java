package firstpack;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class RockfordElement extends Element{
	
	private static String spriteName = "icone";
	private long speed;
	
	
	
	private final int SIZ_X_OF_SPRITE = 16;
	private final int SIZ_Y_OF_SPRITE = 16;
	
    /**
     * Class constructor
     */
	public RockfordElement() {

		// Speed of the animation of the sprite
		// Init the sprites in arrays
		this.loadSprite("icone");

	}
	
	
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
//	private void initSprites() {
	//		framesBlinking        = new ArrayList<BufferedImage>();
	//		framesRunningLeft     = new ArrayList<BufferedImage>();
	////		framesRunningRight    = new ArrayList<BufferedImage>();
	//		framesRunningUpOrDown = new ArrayList<BufferedImage>();

		/* INIT SPRITE ARRAYS FOR ROCKFORD */
	//		for (int i = 0; i < 8; i++) {
	//			framesBlinking.add(
	//				//					this.grabSprite(this.loadSprite(spriteName), 0 + (16 * i), 79, SIZ_X_OF_SPRITE, SIZ_Y_OF_SPRITE)
	//		);
	//
	//			framesRunningLeft.add(
	//				this.grabSprite(this.loadSprite(spriteName), 0 + (16 * i), 103, SIZ_X_OF_SPRITE, SIZ_Y_OF_SPRITE)
	//		);
	//
	//		framesRunningRight.add(
	//				this.grabSprite(this.loadSprite(spriteName), 0 + (16 * i), 127, SIZ_X_OF_SPRITE, SIZ_Y_OF_SPRITE)
	//		);
			//		}

	//	framesRunningUpOrDown.add(
	//			this.grabSprite(this.loadSprite(spriteName), 0, 7, SIZ_X_OF_SPRITE, SIZ_Y_OF_SPRITE)
				//	);
				//}

	
	public BufferedImage grabSprite(BufferedImage spriteSheet, int x, int y, int width, int height) {
		BufferedImage subImage = spriteSheet.getSubimage(x, y, width, height);

		this.setSprite(subImage);
		return subImage;
	}
}
