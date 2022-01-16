package snakegame.graphics;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage rightMouth, downMouth, leftMouth, upMouth, snakeBody;
	public static BufferedImage starRightMouth, starDownMouth, starLeftMouth, starUpMouth, starSnakeBody;
	public static BufferedImage kittyRightMouth, kittyDownMouth, kittyLeftMouth, kittyUpMouth, kittySnakeBody;
	public static BufferedImage fruitSimple,fruitBig,fruitDecrease,fruitBomb;
	public static BufferedImage snakeStarIcon,snakeComumIcon,snakeKittyIcon;
	public static BufferedImage barreira, teclas;


	public static void init()
	{
		
		
		fruitSimple = ImageLoader.loadImage("/textures/fruitSimple.png");
		
		fruitBig = ImageLoader.loadImage("/textures/fruitBig.png");
		
		fruitDecrease = ImageLoader.loadImage("/textures/fruitDecrease.png");
		
		fruitBomb = ImageLoader.loadImage("/textures/fruitBomb.png");

		starSnakeBody = ImageLoader.loadImage("/textures/starsnakebody.png");

		starUpMouth = ImageLoader.loadImage("/textures/starupmouth.png");

		starLeftMouth = ImageLoader.loadImage("/textures/starleftmouth.png");

		starDownMouth = ImageLoader.loadImage("/textures/stardownmouth.png");
		
		starRightMouth = ImageLoader.loadImage("/textures/starrightmouth.png");

		kittySnakeBody = ImageLoader.loadImage("/textures/kittysnakebody.png");

		kittyUpMouth = ImageLoader.loadImage("/textures/kittyupmouth.png");

		kittyLeftMouth = ImageLoader.loadImage("/textures/kittyleftmouth.png");

		kittyDownMouth = ImageLoader.loadImage("/textures/kittydownmouth.png");
		
		kittyRightMouth = ImageLoader.loadImage("/textures/kittyrightmouth.png");

		snakeBody = ImageLoader.loadImage("/textures/snakebody.png");

		upMouth = ImageLoader.loadImage("/textures/upmouth.png");

		leftMouth = ImageLoader.loadImage("/textures/leftmouth.png");

		downMouth = ImageLoader.loadImage("/textures/downmouth.png");
		
		rightMouth = ImageLoader.loadImage("/textures/rightmouth.png");
		
		snakeStarIcon = ImageLoader.loadImage("/textures/snakestaricon.png");

		snakeComumIcon = ImageLoader.loadImage("/textures/snakecomumicon.png");
		
		snakeKittyIcon = ImageLoader.loadImage("/textures/snakekittyicon.png");
		
		barreira = ImageLoader.loadImage("/textures/barreira.png");
		
		teclas = ImageLoader.loadImage("/textures/teclas.png");
	}
}