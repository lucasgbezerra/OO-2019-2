package snakegame.entities;

import java.awt.Graphics;

import snakegame.Game;
import snakegame.graphics.Assets;


public class SnakeComum extends SnakePlayer {

	public SnakeComum(Game game, int x, int y) {
		super(game, x, y);
		SnakePlayer.setCurrentSnake("COMUM");

	}
	@Override
	public void render(Graphics g) {
		for(int i = 0; i < xPosSnakeList.size(); i++) {
			if (i == 0)
			{
				if(game.getKeyManager().parada)
					g.drawImage(Assets.rightMouth, xPosSnakeList.get(i), yPosSnakeList.get(i), null);
				
				if(game.getKeyManager().up && !game.getKeyManager().down) 	
					g.drawImage(Assets.upMouth, xPosSnakeList.get(i), yPosSnakeList.get(i), null);
				
				if(game.getKeyManager().down && !game.getKeyManager().up) 
					g.drawImage(Assets.downMouth, xPosSnakeList.get(i), yPosSnakeList.get(i), null);
				
				if(game.getKeyManager().left && !game.getKeyManager().right) 	
					g.drawImage(Assets.leftMouth, xPosSnakeList.get(i), yPosSnakeList.get(i), null);
				
				if(game.getKeyManager().right  && !game.getKeyManager().left) 	
					g.drawImage(Assets.rightMouth, xPosSnakeList.get(i), yPosSnakeList.get(i), null);
	
			}else
			{
				g.drawImage(Assets.snakeBody, xPosSnakeList.get(i), yPosSnakeList.get(i), null);

			}
		}

	}
}
