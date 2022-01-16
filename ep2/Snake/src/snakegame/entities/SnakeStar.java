package snakegame.entities;

import java.awt.Graphics;

import snakegame.Game;
import snakegame.graphics.Assets;

public class SnakeStar extends SnakePlayer{

	public SnakeStar(Game game, int x, int y) {
		super(game, x, y);
		SnakePlayer.setCurrentSnake("STAR");
	}    
	@Override
	public void render(Graphics g) {
		for(int i = 0; i < yPosSnakeList.size(); i++) {
			if (i == 0)
			{
				if(game.getKeyManager().parada)
					g.drawImage(Assets.starRightMouth, xPosSnakeList.get(i), yPosSnakeList.get(i), null);
				
				if(game.getKeyManager().up && !game.getKeyManager().down) 	
					g.drawImage(Assets.starUpMouth, xPosSnakeList.get(i), yPosSnakeList.get(i), null);
				
				if(game.getKeyManager().down && !game.getKeyManager().up) 
					g.drawImage(Assets.starDownMouth, xPosSnakeList.get(i), yPosSnakeList.get(i), null);
				
				if(game.getKeyManager().left && !game.getKeyManager().right) 	
					g.drawImage(Assets.starLeftMouth, xPosSnakeList.get(i), yPosSnakeList.get(i), null);
				
				if(game.getKeyManager().right  && !game.getKeyManager().left) 	
					g.drawImage(Assets.starRightMouth, xPosSnakeList.get(i), yPosSnakeList.get(i), null);
	
			}else
			{
				g.drawImage(Assets.starSnakeBody, xPosSnakeList.get(i), yPosSnakeList.get(i), null);

			}
		}
	}
}
