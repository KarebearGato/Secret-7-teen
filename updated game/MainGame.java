import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGame extends JFrame {
    private JButton startButton;
    private JComboBox<String> character;

    public MainGame() {
        super("Main Menu");

        setContentPane(new background());

        setLayout(new FlowLayout());
        startButton = new JButton("Start");

        //Creating a characater selection dropdown
        String[] characters = {"Aang", "Katara", "Toph", "Zuko"};
        character = new JComboBox<>(characters);
        character.setFont(new Font("Piccolo", Font.BOLD, 20));
        character.setPreferredSize(new Dimension(200, 40));
		
        //Customizing the start button
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
		
        add(character);
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
        window.setTitle("Elemental Quest");

        String selectedCharacter = (String) character.getSelectedItem();
        GamePanel gamePanel = new GamePanel(selectedCharacter);
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
                new MainGame().setVisible(true);
            }
        });
    }

    
    
}



