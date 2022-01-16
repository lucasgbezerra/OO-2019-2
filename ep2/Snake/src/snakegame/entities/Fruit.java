package snakegame.entities;

import java.awt.Graphics;
import java.util.Random;

import snakegame.Game;
import snakegame.graphics.Assets;

public class Fruit 
{
	protected int[] xPosFruit = {0,25,50,75,100,125,150,175,200,225,250,275,300,
								325,350,375,300,425,450,475,500,525,550,575,600,635,650,675,700,725,
								750,775,800};
	protected int[] yPosFruit = {0,25,50,75,100,125,150,175,200,225,250,275,300,
								325,350,375,300,425,450,475,500,525,550,575,600};
	
	private int xPos,yPos;
	
	private int[] listTypeFruit= {1,1,1,1,1,1,1,1,2,2,2,3,4,4};
	//1 = Simple; 2 = Big ; 3 = Decrease ; 4 Bomb 
	
	
	private int typeFruit;
	private int temporizador;

	public Random random;
	
	public Fruit(Game game) 
	{
		temporizador = 0;
	}
	
	
	public void update()
	{

		if (temporizador == 1500  || temporizador == 0)
		{

			setPosition();
			temporizador =0;
		}
		temporizador ++;

	}
	public void setPosition()
	{
		random = new Random();
	
		do 
		{
			xPos = xPosFruit[random.nextInt(24)];
			yPos = yPosFruit[random.nextInt(24)];
		}while((xPos >= 250 && xPos <=275 && yPos >= 100 && yPos <= 250) ||( xPos >= 500 && xPos <=525 && yPos >= 300 && yPos <= 450));
		
		typeFruit = listTypeFruit[random.nextInt(14)];
		
	}

	public void render(Graphics g)
	{

		switch(typeFruit)
		{
			case 1:
				g.drawImage(Assets.fruitSimple, xPos, yPos, null);
				break;
			case 2:
				g.drawImage(Assets.fruitBig, xPos, yPos, null);
				break;
			case 3:
				g.drawImage(Assets.fruitDecrease, xPos, yPos, null);
				break;
			case 4:
				g.drawImage(Assets.fruitBomb, xPos, yPos, null);
				break;
			default:
				g.drawImage(Assets.fruitSimple, xPos, yPos, null);
				break;

		}
	}


	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getTypeFruit() {
		return typeFruit;
	}

	public void setTypeFruit(int typeFruit) {
		this.typeFruit = typeFruit;
	}


	public int getTemporizador() {
		return temporizador;
	}


	public void setTemporizador(int temporizador) {
		this.temporizador = temporizador;
	}

	
	
}