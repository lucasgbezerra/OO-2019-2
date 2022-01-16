package snakegame.entities;

import java.awt.Graphics;

import snakegame.Game;

public abstract class Entity {
	protected int x, y;
	protected Game game;
	
	public Entity(Game game, int x, int y)
	{
		this.x = x;
		this.y =y;
		this.game =game;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
}