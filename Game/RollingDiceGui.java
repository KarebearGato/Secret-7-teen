import javax.swing.*;
import java.awt.*;

public class RollingDiceGui extends JFrame {
	public RollingDiceGui() {
		super(title "Rolling Double Dice");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(width 700,height 700));
		pack();
		setResizedable(false);
		setLocationRelativeTo(null);
		
		addGuiComponenents();
	}//should create a window from this point
	
	private void addGuiComponenents() {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(null);
		
		
		//Jlabel
	}
}