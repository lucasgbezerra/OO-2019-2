package snakegame.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import snakegame.Game;
import snakegame.entities.Barreira;
import snakegame.entities.Fruit;
import snakegame.entities.SnakeComum;
import snakegame.entities.SnakeKitty;
import snakegame.entities.SnakePlayer;
import snakegame.entities.SnakeStar;

public class GameState extends State 
{
	private SnakePlayer snake;
	private Fruit fruit;
	private Barreira barreira;

	public Random random;
	
	public int score;
	
	public GameState(Game game) 
	{
		super(game);
		State.setState(this);
		selecionandoSnake();
		random = new Random();
		fruit = new Fruit(game);
		barreira = new Barreira(game, 250 ,100);
		score =0;
		game.getKeyManager().jogoIniciado = true;
	}

	@Override
	public void update() 
	{	
		snake.update();
		fruit.update();
		colisaoFruta();
		verificacolisao();
	}
	public void selecionandoSnake()
	{
		if(SnakePlayer.getCurrentSnake() == "COMUM")
			snake = new SnakeComum(game,100,100);
		if(SnakePlayer.getCurrentSnake() == "STAR")
			snake = new SnakeStar(game,100,100);
		if(SnakePlayer.getCurrentSnake() == "KITTY")
			snake = new SnakeKitty(game,100,100);
	}
	@Override
	public void render(Graphics g) 
	{
		snake.render(g);
		fruit.render(g);
		barreira.render(g);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN,12));
		g.drawString("SCORE: "+ score, 700, 50);
		g.drawString("TAMANHO: "+ snake.getSizeSnake(), 700, 30);		
		
	}
	private void colisaoFruta()
	{
		if (snake.getxPosHead() == fruit.getxPos() && snake.getyPosHead() == fruit.getyPos())
		{
			if (SnakePlayer.getCurrentSnake() == "STAR")
			{
				if(fruit.getTypeFruit() == 1 )
					score+=2;
				if(fruit.getTypeFruit() == 2)
					score+=4;
			}else
			{
				if(fruit.getTypeFruit() == 1 )
					score++;
				if(fruit.getTypeFruit() == 2)
					score+=2;
			}

			snake.comeFruta(fruit.getTypeFruit());
			fruit.setTemporizador(0);

		}
	}
	private boolean colisaoCorpoSnake() 
	{
		for(int c =1 ; c<snake.getxPosSnakeList().size();c++)
		{
			if (snake.getxPosHead() == snake.getxPosSnakeList().get(c) && snake.getyPosHead() == snake.getyPosSnakeList().get(c))
			{
				return true;
			}
				
		}
		return false;
			
	}
	public void verificacolisao()
	{
		if(colisaobarreiraA() || colisaoCorpoSnake())
			State.setState(new GameOver(game,snake));

	}
	public boolean colisaobarreiraA()
	{
		if(SnakePlayer.getCurrentSnake() != "KITTY")
		{
			for (int c:barreira.getxBarreira())
			{
				if( c == snake.getxPosHead()  )
				{
					for(int i : barreira.getyBarreira())	
						if(i == snake.getyPosHead())
							return true;
				}
			}
			for (int c:barreira.getxBarreira())
			{
				if(c == snake.getxPosHead())
				{
					for(int i : barreira.getyBarreira())
						if(i == snake.getyPosHead())
							return true;	
				}
			}
			for (int c:barreira.getxBarreiraB())
			{
				if( c == snake.getxPosHead()  )
				{
					for(int i : barreira.getyBarreiraB())	
						if(i == snake.getyPosHead())
							return true;
				}
			}
			for (int c:barreira.getxBarreiraB())
			{
				if(c == snake.getxPosHead())
				{
					for(int i : barreira.getyBarreiraB())
						if(i == snake.getyPosHead())
							return true;	
				}
			}
		}
		return false;
	}
}