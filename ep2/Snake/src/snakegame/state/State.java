package snakegame.state;

import java.awt.Graphics;

import snakegame.Game;

public abstract class State {
	protected Game game;
	
	public State(Game game) 
	{
		this.game =game;
	}

	private static State currentState = null;
	
	public static void setState(State state)
	{
		currentState = state;
	}
	public static State getState()
	{
		return currentState;
	}
	public abstract void update();
	
	public abstract void render(Graphics g);
}