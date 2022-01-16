package snakegame.entities;


import java.awt.Graphics;

import snakegame.Game;
import snakegame.graphics.Assets;


public class SnakeKitty extends SnakePlayer{

	public SnakeKitty(Game game, int x, int y) {
		super(game, x, y);
		SnakePlayer.setCurrentSnake("KITTY");
	}
	@Override
	public void render(Graphics g) {
		for(int i = 0; i < xPosSnakeList.size(); i++) {
			if (i == 0)
			{
				if(game.getKeyManager().parada)
					g.drawImage(Assets.kittyRightMouth, xPosSnakeList.get(i), yPosSnakeList.get(i), null);
				
				if(game.getKeyManager().up && !game.getKeyManager().down) 	
					g.drawImage(Assets.kittyUpMouth, xPosSnakeList.get(i), yPosSnakeList.get(i), null);
				
				if(game.getKeyManager().down && !game.getKeyManager().up) 
					g.drawImage(Assets.kittyDownMouth, xPosSnakeList.get(i), yPosSnakeList.get(i), null);
				
				if(game.getKeyManager().left && !game.getKeyManager().right) 	
					g.drawImage(Assets.kittyLeftMouth, xPosSnakeList.get(i), yPosSnakeList.get(i), null);
				
				if(game.getKeyManager().right  && !game.getKeyManager().left) 	
					g.drawImage(Assets.kittyRightMouth, xPosSnakeList.get(i), yPosSnakeList.get(i), null);
	
			}else
			{
				g.drawImage(Assets.kittySnakeBody, xPosSnakeList.get(i), yPosSnakeList.get(i), null);

			}
		}
	}

	
}