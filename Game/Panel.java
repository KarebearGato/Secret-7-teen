import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Panel {
	
		//JFrame frame=new JFrame("Elemental Quest");
		//JPanel background=new JPanel();
		//background.setBackground(Color.WHITE);
		
	//static JFrame frame;

		
	public static void main(String[] args){
		JFrame frame=new JFrame("Elemental Quest");
			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1600,800);
		
		ImageIcon image1=new ImageIcon("pixe.jpg");
		JLabel label1=new JLabel(image1);
		frame.getContentPane().add(label1);
	
		//JPanel background=new JPanel();
		//background.setBackground(Color.red);

			
			
		frame.setVisible(true);
	}
}	
