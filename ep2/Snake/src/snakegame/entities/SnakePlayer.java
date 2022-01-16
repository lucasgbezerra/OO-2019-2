package snakegame.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import snakegame.Game;
import snakegame.state.GameOver;
import snakegame.state.State;

public abstract class SnakePlayer extends Entity {

	public static final int DIM_SNAKE = 25;
	public static final int SIZE_INICIAL = 3;
	private int auxScore;

	protected int sizeSnake = SIZE_INICIAL;

	protected ArrayList<Integer> xPosSnakeList;
	protected ArrayList<Integer> yPosSnakeList;
	
	protected int xPosHead;
	protected int yPosHead;
	
	protected int xMove;
	protected int yMove;
	

	private static String currentSnake = null;

	
	public SnakePlayer(Game game, int x, int y) {
		super(game, x, y);
		
		xPosSnakeList = new ArrayList<Integer>();
		yPosSnakeList = new ArrayList<Integer>();
		
		for (int c =0;c <sizeSnake;c++)
		{
			xPosSnakeList.add(x - DIM_SNAKE * c);
			yPosSnakeList.add(y);
		}

		xPosHead = xPosSnakeList.get(0);
		yPosHead = yPosSnakeList.get(0);
		sizeSnake = xPosSnakeList.size();
		xMove = 0;
		yMove = 0;
		
		auxScore =0;
	}
	
	
	@Override
	public void update() {
		getInput();
		move();
	}

	@Override
	public void render(Graphics g) {
		
	}
	
	public void getInput() {
		
		if(game.getKeyManager().up && !game.getKeyManager().down)
		{
			yMove--;
			xMove =0;
		}
		
		if(game.getKeyManager().down && !game.getKeyManager().up)
		{
			yMove++;
			xMove =0;
		}
		
		if(game.getKeyManager().left && !game.getKeyManager().right) 
		{
			xMove--;
			yMove =0;
		}
		
		if(game.getKeyManager().right  && !game.getKeyManager().left)
		{
			xMove++;
			yMove= 0;
		}
	}
	
	public void move() {
		if(Math.abs(xMove) == DIM_SNAKE) {
			x += xMove;
			colisaoBorda();
			
			xPosSnakeList.add(0, x);
			yPosSnakeList.add(0, y);
			
			xPosSnakeList.remove(sizeSnake);
			yPosSnakeList.remove(sizeSnake);
			
			xPosHead = xPosSnakeList.get(0);
			yPosHead = yPosSnakeList.get(0);
			
			xMove = 0;
		}
		if(Math.abs(yMove) == DIM_SNAKE) {
			y += yMove;
			colisaoBorda();

			xPosSnakeList.add(0, x);
			yPosSnakeList.add(0, y);
			
			xPosSnakeList.remove(sizeSnake);
			yPosSnakeList.remove(sizeSnake);
			
			xPosHead = xPosSnakeList.get(0);
			yPosHead = yPosSnakeList.get(0);
			
			yMove = 0;
			
		}
	}
	public void colisaoBorda()
	{
		if(auxScore > 30)
		{
			if (x-xMove < 0)
				x = game.width;
			if(x+xMove > game.width)
				x = 0;
			if (y-yMove < 0 )
				y = game.height;
			if(y+yMove>game.height)
				y = 0;
		}else
		{
			if (x < 0 || x == game.width || y < 0 || y == game.height)
				State.setState(new GameOver(game, this));
		}
	}

	public void comeFruta(int typeFruit) 
	{

		if(typeFruit == 1 || typeFruit == 2)
		{
			xPosSnakeList.add(xPosSnakeList.get(sizeSnake-1));
			yPosSnakeList.add(yPosSnakeList.get(sizeSnake-1));
			sizeSnake++;
			if(typeFruit == 2)
			{
				auxScore+=2;

			}else
			{
				auxScore++;
			}
			
		}else if(typeFruit == 3 )
		{
			if(sizeSnake > SIZE_INICIAL)
			{
				while(sizeSnake > SIZE_INICIAL)
				{
					xPosSnakeList.remove(xPosSnakeList.get(sizeSnake-1));
					yPosSnakeList.remove(yPosSnakeList.get(sizeSnake-1));
					sizeSnake--;
				}
						
			}
		}else if(typeFruit == 4)
		{
			State.setState(new GameOver(game,this));
		}
		
		
	}
	
	public int getSizeSnake() {
		return sizeSnake;
	}


	public void setSizeSnake(int sizeSnake) {
		this.sizeSnake = sizeSnake;
	}


	public ArrayList<Integer> getxPosSnakeList() {
		return xPosSnakeList;
	}


	public void setxPosSnakeList(ArrayList<Integer> xPosSnakeList) {
		this.xPosSnakeList = xPosSnakeList;
	}


	public ArrayList<Integer> getyPosSnakeList() {
		return yPosSnakeList;
	}

	public int getxPosHead() {
		return xPosHead;
	}


	public void setxPosHead(int xPosHead) {
		this.xPosHead = xPosHead;
	}


	public int getyPosHead() {
		return yPosHead;
	}


	public void setyPosHead(int yPosHead) {
		this.yPosHead = yPosHead;
	}


	public static String getCurrentSnake() {
		return currentSnake;
	}


	public static void setCurrentSnake(String currentSnake) {
		SnakePlayer.currentSnake = currentSnake;
	}


	public int getAuxScore() {
		return auxScore;
	}
	
	
}