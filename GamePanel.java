import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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
	
	 private static final String[] map = {
        "############################",
		"#==#======#=====#==========#",
		"#==##====####===#==========#",
		"#===#==#=###====#==========#",
		"#===#==#=####===#==========#",
		"#==#==#=#####===#==========#",
		"#==#==#==#=##D==#####=######",
		"#===#####===#=###==========# ",
		"#====T======#=###==========# ",
		"#==#======#=====#==========#",
		"#==#======#=====#==========#",
		"#==#======#=====#==========#",
		"#==########=====#==========#",
		"#==#======#=====#==========#",
		"#==#======#=====#==========#",
		"#==#============#==========#",
		"#==#======#=====#====#####=#",
		"#==#======#=====#====#=====#",
		"############################"
	};

    private static final int CELL_SIZE = 30; // Size of each cell
    private BufferedImage wallImage;
    private BufferedImage pathImage;
    private BufferedImage treasureImage;
    private BufferedImage doorImage;


	
	public GamePanel()
	{
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		this.setDoubleBuffered(true);
		
		try {
            wallImage = ImageIO.read(new File("wall.png"));
            pathImage = ImageIO.read(new File("path.jpg"));
            treasureImage = ImageIO.read(new File("pixel.jpg"));
            doorImage = ImageIO.read(new File("pixel.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length(); x++) {
                char cell = map[y].charAt(x);
                switch (cell) {
                    case '#':
                        g.drawImage(wallImage, x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE, null);
                        break;
                    case '=':
                        g.drawImage(pathImage, x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE, null);
                        break;
                    case 'T':
                        g.drawImage(treasureImage, x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE, null);
                        break;
                    case 'D':
                        g.drawImage(doorImage, x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE, null);
                        break;
                    default:
                        
                        break;
                }
            }
        }
    } 
}
	
