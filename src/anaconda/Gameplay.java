package anaconda;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

//siemka Bart
public class Gameplay extends JPanel implements KeyListener, ActionListener{
	private ImageIcon titleImage;
	private int[] snakeXLength = new int[750];
	private int[] snakeYLength = new int[750];
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon rightMouth;
	private ImageIcon upMouth;
	private ImageIcon downMouth;
	private ImageIcon leftMouth;
	private ImageIcon legs;
	
	private int lengthOfSnake = 3;
	
	private Timer timer;
	private int delay = 100;
	private ImageIcon snakeImage;
	
	private int moves = 0;
	
	
 	//constructor; will run @ start
	public Gameplay()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	@Override
	public void paint(Graphics g)
	{
		if(moves == 0)
		{
			snakeXLength[2] = 50;
			snakeXLength[1] = 75;
			snakeXLength[0] = 100;
			
			snakeYLength[2] = 100;
			snakeYLength[1] = 100;
			snakeYLength[0] = 100;
		}
		
		//draw title image border
		//g.setColor(Color.white);
		//g.drawRect(24, 10, 851, 55);
		//g.drawRect(0, 0, 900, 60);
		
		//draw the title image
		titleImage = new ImageIcon("titleimage.jpg");
		//titleImage.paintIcon(this, g, 25, 11);
		titleImage.paintIcon(this, g, 250, 0);
		
		//draw border for gameplay
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		//draw background for the gameplay
		g.setColor(Color.black);
		g.drawRect(25, 75, 850, 575);
		
		
		rightMouth = new ImageIcon("EduardoMouths/rightMouthEduardo.png");
		leftMouth = new ImageIcon("EduardoMouths/leftMouthEduardo.png");
		upMouth = new ImageIcon("EduardoMouths/upMouthEduardo.png");
		downMouth = new ImageIcon("EduardoMouths/downMouthEduardo.png");
		legs = new ImageIcon("legs.png");
		
		rightMouth.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);
		for(int a = 0; a < lengthOfSnake; ++a)
		{
			if(a==0 && right)
			{
				//rightMouth = new ImageIcon("rightMouthEduardo.png");
				rightMouth.paintIcon(this,  g,  snakeXLength[a], snakeYLength[a]);
			}
			else if(a==0 && left)
			{
				//leftMouth = new ImageIcon("leftMouth.png");
				leftMouth.paintIcon(this,  g,  snakeXLength[a], snakeYLength[a]);
			}
			else if(a==0 && up)
			{
				//upMouth = new ImageIcon("upMouth.png");
				upMouth.paintIcon(this,  g,  snakeXLength[a], snakeYLength[a]);
			}
			else if(a==0 && down)
			{
				//downMouth = new ImageIcon("downMouth.png");
				downMouth.paintIcon(this,  g,  snakeXLength[a], snakeYLength[a]);
			}
			else if(a!=0)
			{
				//legs = new ImageIcon("legs.png");
				legs.paintIcon(this,  g,  snakeXLength[a], snakeYLength[a]);
			}
		}
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.restart();
		if(right)
		{
			for(int r = lengthOfSnake - 1; r >= 0; --r)
				snakeYLength[r+1] = snakeYLength[r];
			
			for(int r = lengthOfSnake; r >= 0; --r)
			{
				if(r==0)
					snakeXLength[r] = snakeXLength[r] + 25;
				else	
					snakeXLength[r] = snakeXLength[r-1];				
				if(snakeXLength[r] > 850)
					snakeXLength[r] = 25;
			}			
			repaint();
			
		}
		if(left)
		{
			for(int r = lengthOfSnake - 1; r >= 0; --r)
				snakeYLength[r+1] = snakeYLength[r];
			
			for(int r = lengthOfSnake; r >= 0; --r)
			{
				if(r==0)
					snakeXLength[r] = snakeXLength[r] - 25;
				else
					snakeXLength[r] = snakeXLength[r-1];
				if(snakeXLength[r] < 25)
					snakeXLength[r] = 850;
			}
			
			repaint();
		}
		if(up)
		{
			for(int r = lengthOfSnake - 1; r >= 0; --r)
			{
				snakeXLength[r+1] = snakeXLength[r];
			}
			
			for(int r = lengthOfSnake; r >= 0; --r)
			{
				if(r==0)
				{
					snakeYLength[r] = snakeYLength[r] - 25;
				}
				else
				{
					snakeYLength[r] = snakeYLength[r-1];
				}
				
				if(snakeYLength[r] < 75)
				{
					snakeYLength[r] = 625;
				}
			}
			
			repaint();
		}
		if(down)
		{
			for(int r = lengthOfSnake - 1; r >= 0; --r)
			{
				snakeXLength[r+1] = snakeXLength[r];
			}
			
			for(int r = lengthOfSnake; r >= 0; --r)
			{
				if(r==0)
				{
					snakeYLength[r] = snakeYLength[r] + 25;
				}
				else
				{
					snakeYLength[r] = snakeYLength[r-1];
				}
				if(snakeYLength[r] > 625)
				{
					snakeYLength[r] = 75;
				}
			}
			
			repaint();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			moves++;
			right = true;
			if(!left)
			{
				right = true;
			}
			else
			{
				right =  false;
				left = true;
			}
			up = false;
			down = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			moves++;
			left = true;
			if(!right)
			{
				left = true;
			}
			else
			{
				left =  false;
				right = true;
			}
			up = false;
			down = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			moves++;
			up = true;
			if(!down)
			{
				up = true;
			}
			else
			{
				up =  false;
				down = true;
			}
			left = false;
			right = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			moves++;
			down = true;
			
			if(!up)
				down = true;
			else
			{
				down =  false;
				up = true;
			}				
				
			left = false;
			right = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
