import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Panel extends JFrame{
	
		//JFrame frame=new JFrame("Elemental Quest");
		//JPanel background=new JPanel();
		//background.setBackground(Color.WHITE);
		
		static JFrame frame;
		
		public static void main(String[] args){
			frame=new JFrame("Elemental Quest");
			JPanel background=new JPanel();
			background.setBackground(Color.CYAN);
			frame.setSize(1600,1000);
			frame.show();
	}
}
	