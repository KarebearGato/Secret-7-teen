import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class background extends JPanel{
	private Image back;
	
	public background(){
		try{
			back=new ImageIcon("back.png").getImage();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Override 
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(back!=null){
			g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
			
		}
	}
}