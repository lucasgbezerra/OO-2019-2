package snakegame.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import snakegame.Game;

import snakegame.entities.SnakePlayer;
import snakegame.graphics.Assets;


public class MenuState extends State  {

	
	public MenuState(Game game)
	{
		super(game);
		State.setState(this);
	}

	@Override
	public void update() {
		if(game.getKeyManager().escolhaSnakeComum)
		{	
			SnakePlayer.setCurrentSnake("COMUM");
			State.setState(new GameState(game));

		}
		if(game.getKeyManager().escolhaSnakeStar)
		{
			SnakePlayer.setCurrentSnake("STAR");
			State.setState(new GameState(game));
		}
		if(game.getKeyManager().escolhaSnakeKitty)
		{
			SnakePlayer.setCurrentSnake("KITTY");
			State.setState(new GameState(game));
		}
	}

	@Override
	public void render(Graphics g) 
	{
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial",Font.BOLD, 30));
		g.drawString("Escolha a Snake:", 250, 50);
		
		g.setFont(new Font("arial",Font.PLAIN, 16));
		g.drawString("Snake Comum: snake classica, sem habilidades especiais;", 150, 80);
		g.drawString("Snake Star: recebe o dobro de pontos ao comer as frutas;", 150, 110);
		g.drawString("Snake Kitty: atravessa as barreiras do jogo.", 150, 140);
		g.drawString("Ao obter 30 PONTOS com as Snakes COMUM e KITTY e 60 PONTOS", 150, 170);
		g.drawString("com a STAR, TODAS as Snakes podem atravessar a borda;" , 150, 200);

		g.setFont(new Font("arial",Font.ITALIC, 20));
		g.drawString("Comum", 200, 320);
		g.drawImage(Assets.snakeComumIcon,190,220,null);
		g.drawString("Kitty", 400, 320);
		g.drawImage(Assets.snakeKittyIcon,390,220,null);
		g.drawString("Star", 600, 320);
		g.drawImage(Assets.snakeStarIcon,590,220,null);
		g.setFont(new Font("arial",Font.ITALIC, 12));
		g.drawString("Press C", 200, 340);
		g.drawString("Press K", 400, 340);
		g.drawString("Press S", 600, 340);
		
		g.setFont(new Font("arial",Font.PLAIN, 16));
		g.drawImage(Assets.fruitSimple,150,360,null);
		g.drawString("Simple Fruit: 1 PONTO e aumenta o tamanho da cobra em 1;", 200, 380);
		g.drawImage(Assets.fruitBig,150,390,null);
		g.drawString("Big Fruit: 2 PONTOS e aumenta o tamanho da cobra em 1;", 200, 410);
		g.drawImage(Assets.fruitDecrease,150,420,null);
		g.drawString("Decrease Fruit: 0 PONTOS e tamanho da cobra volta ao INICIAL;", 200, 440);
		g.drawImage(Assets.fruitBomb,150,450,null);
		g.drawString("Bomb Fruit: Essa fruta deve levar a MORTE da Snake;", 200, 470);
		g.drawString("TECLAS PARA JOGAR: ", 200, 550);
		g.drawImage(Assets.teclas,400,500,null);

	}
	
}
