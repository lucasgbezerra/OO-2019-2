package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import snakegame.display.Display;
import snakegame.graphics.Assets;
import snakegame.inputs.KeyManager;
import snakegame.state.MenuState;
import snakegame.state.State;

public class Game implements Runnable  {
	
	private Display display;
	public int width, height;
	public String title;
	
	//Thread
	private Thread thread;
	private boolean running = false;
	
	//Desenhar tela
	private BufferStrategy bs;
	private Graphics g;
	
	// Estado do jogo
	private State menuState;
	
	// gerenciador de inputs por meio do teclado
	private KeyManager keyManager;
	

	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	// inicializa o display, as imagens e set o estado
	public void init ()
	{
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		menuState =new MenuState(this);
		State.setState(menuState);
	}
	
	public void update()
	{
		keyManager.update();
		if (State.getState() != null)
			State.getState().update();
	}
	
	// Renderização da tela
	public void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		//draw
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		if (State.getState() != null)
			State.getState().render(g);		
		bs.show();
		g.dispose();
		
	}
	
	public void run()
	{
		init();
		
		int fpsUpdate = 200;
		int fpsRender = 1000;
		double timePerTick = 1000000000 /fpsUpdate;
		double timePerRender = 1000000000 /fpsRender;
		double deltaRender = 0;
		double deltaUpdate =0;
		long now;
		long lastTime = System.nanoTime();

		while (running)
		{
			now = System.nanoTime();
			deltaUpdate += (now - lastTime) / timePerTick;
			deltaRender+= (now - lastTime) / timePerRender;
			lastTime = now;
			
			if(deltaUpdate >= 1)
			{
				update();
				deltaUpdate--;
			}
			if(deltaRender >= 1)
			{
				render();
				deltaRender--;
			}
			try {
	            Thread.sleep(1);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		
		}
		
		stop();
	}
	//Start Thread
	public synchronized void start()
	{
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public KeyManager getKeyManager()
	{
		return keyManager;
	}
}
