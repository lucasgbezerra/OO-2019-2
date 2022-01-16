package snakegame.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	public boolean right,left,down,up,escolhaSnakeKitty,escolhaSnakeStar,escolhaSnakeComum;
	public boolean enter,spaceBar,jogoIniciado =false, parada= true;
	
	private boolean[] keys;
	public KeyManager()
	{
		keys = new boolean[256];
	}
	
	public void update()
	{
		up = keys[KeyEvent.VK_UP];					
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		escolhaSnakeStar = keys[KeyEvent.VK_S];
		escolhaSnakeComum = keys[KeyEvent.VK_C];
		escolhaSnakeKitty = keys[KeyEvent.VK_K];
		enter = keys[KeyEvent.VK_ENTER];
		spaceBar = keys[KeyEvent.VK_SPACE];

	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(jogoIniciado)
		{
			keys[KeyEvent.VK_ENTER] = false;
			keys[KeyEvent.VK_SPACE] = false;

			parada =false;
			if (key == KeyEvent.VK_RIGHT && !left )
			{
				keys[KeyEvent.VK_DOWN] = false;
				keys[KeyEvent.VK_UP] = false;
				keys[KeyEvent.VK_RIGHT] = true;
			}
			if (key == KeyEvent.VK_LEFT && !right)
			{
				keys[KeyEvent.VK_DOWN] = false;
				keys[KeyEvent.VK_UP] = false;
				keys[KeyEvent.VK_LEFT] = true;
			}
			if (key == KeyEvent.VK_UP && !down)
			{
				keys[KeyEvent.VK_RIGHT] = false;
				keys[KeyEvent.VK_LEFT] = false;
				keys[KeyEvent.VK_UP] = true;
			}
			if (key == KeyEvent.VK_DOWN  && !up)
			{
				keys[KeyEvent.VK_LEFT] = false;
				keys[KeyEvent.VK_RIGHT] = false;
				keys[KeyEvent.VK_DOWN] = true;
			}
		}
		if (key == KeyEvent.VK_S && key != KeyEvent.VK_K && key != KeyEvent.VK_C)
			keys[KeyEvent.VK_S] = true;
		
		if (key != KeyEvent.VK_S && key == KeyEvent.VK_K && key != KeyEvent.VK_C)
			keys[KeyEvent.VK_K] = true;
		
		if (key != KeyEvent.VK_S && key != KeyEvent.VK_K && key == KeyEvent.VK_C)
			keys[KeyEvent.VK_C] = true;
		
		
		if (key == KeyEvent.VK_ENTER)
		{
			 keys[KeyEvent.VK_UP] = false;					
			 keys[KeyEvent.VK_DOWN]= false;
			 keys[KeyEvent.VK_LEFT]= false;
			 keys[KeyEvent.VK_RIGHT]= false;
			 keys[KeyEvent.VK_ENTER]= true;
			 parada = true;

		}
		if(key == KeyEvent.VK_SPACE)
		{
			
			 keys[KeyEvent.VK_UP] = false;					
			 keys[KeyEvent.VK_DOWN]= false;
			 keys[KeyEvent.VK_LEFT]= false;
			 keys[KeyEvent.VK_RIGHT]= false;
			 keys[KeyEvent.VK_ENTER]= false;
			 keys[KeyEvent.VK_S]= false;
			 keys[KeyEvent.VK_C]= false;
			 keys[KeyEvent.VK_K]= false;
			 keys[KeyEvent.VK_SPACE] = true;
			 parada = true;


		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}