package anaconda;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

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
	private ImageIcon letterA;
	private ImageIcon letterAacc;
	private ImageIcon letterB;
	private ImageIcon letterC;
	private ImageIcon letterD;
	private ImageIcon letterE;
	private ImageIcon letterF;
	private ImageIcon letterEacc;
	private ImageIcon letterG;
	private ImageIcon letterH;
	private ImageIcon letterI;
	private ImageIcon letterIacc;
	private ImageIcon letterJ;
	private ImageIcon letterK;
	private ImageIcon letterL;
	private ImageIcon letterM;
	private ImageIcon letterN;
	private ImageIcon letterNe;
	private ImageIcon letterO;
	private ImageIcon letterOacc;
	private ImageIcon letterP;
	private ImageIcon letterR;
	private ImageIcon letterS;
	private ImageIcon letterT;
	private ImageIcon letterU;
	private ImageIcon letterUacc;
	private ImageIcon letterV;
	private ImageIcon letterW;
	private ImageIcon letterZ;
	
	private ImageIcon enemyImage;
	private Random random = new Random();
	
	private int xPos = random.nextInt(34);
	private int yPos = random.nextInt(23);
	
	private int lengthOfSnake = 3;
	
	private Timer timer;
	private int delay = 100;
	private ImageIcon snakeImage;
	
	private int[] enemyXPos= {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,
			475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
			
	private int[] enemyYPos= {75,100,125,150,175,200,225,250,275,300,325,
			350,375,400,425,450,475,500,525,550,575,600,625};
	
	private String[] Words = {"CASA","ZAPATOS","AMOR","BUENO","BONITO","CHICA"};
	private int whichWord=0;
	private int whichLetter=0;
	
	private int moves = 0;
	
	private String Score="";
	private String enemyLetter="A";
	
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
		g.setColor(Color.gray);
		g.fillRect(25, 75, 850, 575);
		
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("Word: "+Score,780,30);
		
		
		rightMouth = new ImageIcon("EduardoMouths/rightMouthEduardo.png");
		leftMouth = new ImageIcon("EduardoMouths/leftMouthEduardo.png");
		upMouth = new ImageIcon("EduardoMouths/upMouthEduardo.png");
		downMouth = new ImageIcon("EduardoMouths/downMouthEduardo.png");
		legs = new ImageIcon("legs.png");
		
		letterA = new ImageIcon("EnemyLetters/A.png");
		letterAacc=new ImageIcon("EnemyLetters/Aacc.png");
		letterB=new ImageIcon("EnemyLetters/B.png");
		 letterC=new ImageIcon("EnemyLetters/C.png");
		 letterD=new ImageIcon("EnemyLetters/D.png");
		 letterE=new ImageIcon("EnemyLetters/E.png");
		 letterEacc=new ImageIcon("EnemyLetters/Eacc.png");		 
		 letterF=new ImageIcon("EnemyLetters/F.png");
		 letterG=new ImageIcon("EnemyLetters/G.png");
		 letterH=new ImageIcon("EnemyLetters/H.png");
		 letterI=new ImageIcon("EnemyLetters/I.png");
		 letterIacc=new ImageIcon("EnemyLetters/Iacc.png");
		 letterJ=new ImageIcon("EnemyLetters/J.png");
		 letterK=new ImageIcon("EnemyLetters/K.png");
		 letterL=new ImageIcon("EnemyLetters/L.png");
		 letterM=new ImageIcon("EnemyLetters/M.png");
		 letterN=new ImageIcon("EnemyLetters/N.png");
		 letterNe=new ImageIcon("EnemyLetters/Ne.png");
		 letterO=new ImageIcon("EnemyLetters/O.png");
		 letterOacc=new ImageIcon("EnemyLetters/Oacc.png");
		 letterP=new ImageIcon("EnemyLetters/P.png");
		 letterR=new ImageIcon("EnemyLetters/R.png");
		 letterS=new ImageIcon("EnemyLetters/S.png");
		 letterT=new ImageIcon("EnemyLetters/T.png");
		 letterU=new ImageIcon("EnemyLetters/U.png");
		 letterUacc=new ImageIcon("EnemyLetters/Uacc.png");
		 letterV=new ImageIcon("EnemyLetters/V.png");
		 letterW=new ImageIcon("EnemyLetters/W.png");
		 letterZ=new ImageIcon("EnemyLetters/Z.png");
		
		
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
		
		enemyImage=new ImageIcon("EnemyLetters/A.png");
		if( (enemyXPos[xPos]== snakeXLength[0]) && (enemyYPos[yPos] == snakeYLength[0]) )
		{
			lengthOfSnake++;
			xPos = random.nextInt(34);
			yPos = random.nextInt(23);
			Score+=enemyLetter;
			//enemyLetter
		}
		
		enemyImage.paintIcon(this, g, enemyXPos[xPos], enemyYPos[yPos]);
		
		
		
		for(int b=1;b<lengthOfSnake;++b)
		{
			if(snakeXLength[b]==snakeXLength[0] && snakeYLength[b]==snakeYLength[0])
			{
				right=false;
				left = false;
				up=false;
				down=false;
				
				g.setColor(Color.white);
				g.setFont(new Font("arial",Font.BOLD,50));
				g.drawString("Game Over!", 300, 300);
			
				g.setFont(new Font("arial",Font.BOLD,20));
				g.drawString("Press Space to restart", 300, 350);
			}
		}
		
		
		
		g.dispose();
	}

	
	//public String getNextLetter()
	{
		//return Words[whichWord].ge;
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
		
		if(e.getKeyCode()== KeyEvent.VK_SPACE)
		{
			moves=0;
			Score="";
			lengthOfSnake=3;
			repaint();
			
		}
		else
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			moves++;
			//right = true;
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
		else
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			moves++;
			//left = true;
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
		else
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			moves++;
			//up = true;
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
		else
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			moves++;
			//down = true;
			
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
