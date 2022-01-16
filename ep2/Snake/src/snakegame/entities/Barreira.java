package snakegame.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import snakegame.Game;
import snakegame.graphics.Assets;

public class Barreira extends Entity{

	private final static int yHeight = 150, xWidth =25;
	
	private ArrayList<Integer> yBarreira,xBarreira;
	private ArrayList<Integer> yBarreiraB,xBarreiraB;

	
	public Barreira(Game game, int x, int y) {
		super(game, x, y);
		
		xBarreira = new ArrayList<Integer>();
		yBarreira = new ArrayList<Integer>();
		xBarreiraB = new ArrayList<Integer>();
		yBarreiraB = new ArrayList<Integer>();
		
		for (int i =0; i < xWidth; i++)
		{
			xBarreira.add(i,  x+i);
			xBarreiraB.add(i,  x*2+i);
		}
		
		for (int i =0; i < yHeight; i++)
		{
			yBarreira.add(i,  y+i);
			yBarreiraB.add(i,  y*3+i);
		}
	
	}

	@Override
	public void update() {

		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.barreira, x, y, null);
		g.drawImage(Assets.barreira, x*2, y*3, null);

	}

	public ArrayList<Integer> getxBarreira() {
		return xBarreira;
	}

	public ArrayList<Integer> getyBarreira() {
		return yBarreira;
	}

	public ArrayList<Integer> getyBarreiraB() {
		return yBarreiraB;
	}

	public ArrayList<Integer> getxBarreiraB() {
		return xBarreiraB;
	}


}
