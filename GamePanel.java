import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

	class GamePanel extends JPanel implements Runnable
{
	final int origionalTileSize = 16;
	final int scale = 3;
	final int tileSize = origionalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = 768;
	final int screenHeight = tileSize * maxScreenRow;
	// FPS
	int FPS = 60;
	KeyHandler keyH = new KeyHandler();
	// For the proccessing of time within the game
	Thread gameThread; 

	// set players default position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public GamePanel()
	{
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		this.setDoubleBuffered(true);
	}

	public void startGaneThread()
	{
		gameThread = new Thread(this);
		gameThread.start();
	} 
	@Override
	public void run()
	{
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
		// GAme loop starts here 
		while (gameThread != null) // will run As long  as game excecutes whatveer is specified in the brackets
		{
			System.out.println("loop is running");
			long currentTime = System.nanoTime();

			
			update(); // updates all new changes in the coordinates of charector 

			repaint(); // call the paint component method

			
			try 
			{
				double remTime = nextDrawTime - System.nanoTime();
				remTime  = remTime/1000000;

				if (remTime < 0)
				{
					remTime = 0;
				}

				Thread.sleep((long)remTime);
				nextDrawTime += drawInterval;	
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}

			
		}
	}


	public void update()
	{
 		// Changes the position of the main  charector in the screen by 4px
		if (keyH.upPressed == true)
		{
			playerY -= playerSpeed;
		}

		else if (keyH.downPressed == true)
		{
			playerY += playerSpeed;
		}

		else if (keyH.leftPressed == true)
		{
			playerX -= playerSpeed;
		}

		else if (keyH.downPressed == true)
		{
			playerY += playerSpeed;
		}
		
	 
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		// This is for displyoing our main charector
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		g2.dispose();

		
	} 
}