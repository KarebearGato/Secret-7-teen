import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JButton startButton;

    public Main() {
        super("Main Menu");

        setContentPane(new background());

        setLayout(new FlowLayout());
        startButton = new JButton("Start");
		/*
		startButton.setBounds(500, 200, 500, 100);
		startButton.setSize(400,400);*/
		
		//startButton.setPreferredSize(new Dimension(200, 100));
		startButton.setOpaque(false);
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(false);
		startButton.setBorder( null );
		startButton.setFont(new Font("Piccolo", Font.BOLD, 40));
		startButton.setForeground(Color.WHITE);
		
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
		
        add(startButton);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 600);
        setLocationRelativeTo(null);
    }

    private void startGame() {
        dispose();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Dungeon Quest");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    
    
}



