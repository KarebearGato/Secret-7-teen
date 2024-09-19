import javax.swing.ImageIcon;
import javax.swing.JFrame;
//import GamePanel;
 class Main
{
	public static void main(String[] args)
	{
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Dungeon Quest");
		window.setIconImage("Insert an image file for the game logo");
		//new ImageIcon("file name");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
