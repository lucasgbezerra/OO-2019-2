package snakegame.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import snakegame.Game;

import snakegame.entities.SnakePlayer;

public class GameOver extends State{

	SnakePlayer snake;
	public GameOver(Game game ,SnakePlayer snake) {
		super(game);
		this.snake = snake;
		State.setState(this);
		game.getKeyManager().jogoIniciado = false;

	}

	@Override
	public void update() 
	{
		if (game.getKeyManager().spaceBar)
			State.setState(new MenuState(game));
		if(game.getKeyManager().enter)
			State.setState(new GameState(game));
	
	}

	@Override
	public void render(Graphics g) 
	{
		g.setColor(Color.GREEN);
		g.setFont(new Font("arial",Font.BOLD, 50));
		g.drawString("Game over", 230, 200);
		
		g.setFont(new Font("arial",Font.PLAIN, 20));
		if(SnakePlayer.getCurrentSnake() == "STAR")
		{
			g.drawString("SCORE FINAL: "+ snake.getAuxScore()*2, 250, 300);
		}else
		{
			g.drawString("SCORE FINAL: "+ snake.getAuxScore(), 250, 300);

		}
		g.drawString("Pressione ENTER para Reiniciar", 220, 350);
		g.drawString("Pressione SPACE para voltar ao MENU", 220, 380);
		
	}
	
}
