import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*KeyHandler class implements the KeyListener interface to handle keyboard events*/

public class KeyHandler implements KeyListener {
    private int x;  //Current x and y positions
    private int y;

    //Booleans tracking which keys are pressed
    public boolean upPressed, downPressed, leftPressed, rightPressed;


    public void moveX(int X) {
        this.x += X;
    }//Method to update the x position

    public void moveY(int Y) {
        this.y += Y;
    }//Method to update the y position

 
    public int getX() {
        return x;
    }//Method for getting the x position

    public int getY() {
        return y;
    }//Method for getting the y position

    //KeyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                upPressed = true;
                moveY(-5);           //Moves up by decrementing y
                break;
            case KeyEvent.VK_LEFT:
                leftPressed = true; 
                moveX(-5);          //Moves left by decrementing x
                break;
            case KeyEvent.VK_DOWN:
                downPressed = true;
                moveY(5);          //Moves down by incrementing y
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = true;
                moveX(5);          //Moves right by incrementing x
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);            //Calls the stop method if the escape key is pressed
                break;
            default:
                System.out.println("Unsupported key typed: " + e.getKeyCode()); //Handles unsupported key inputs
                break;
        }
    }

    //KeyReleased = called whenever a button is released
    //Resets corresponding boolean when key is released
    @Override
    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                upPressed = false;
                break;
            case KeyEvent.VK_LEFT:
                leftPressed = false;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = false;
                break;
            default:
                System.out.println("Unsupported key typed: " + e.getKeyCode()); //Handles unsupported key inputs
                break;
        }
    }

    //KeyTyped = Invoked when a key is typed. Uses KeyChar, char output
    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyChar()){
			case 'w': 
                upPressed = true;
                moveY(-5);           //Moves up by decrementing y
				break;
			case 'a': 
                leftPressed = true; 
                moveX(-5);          //Moves left by decrementing x
			case 's': 
                rightPressed = true;
                moveX(5);          //Moves right by incrementing x
				break;
			case 'd': 
                rightPressed = true;
                moveX(5);          //Moves right by incrementing x
				break;
            default:
                System.out.println("Unsupported key typed: " + e.getKeyChar()); //Handles unsupported key inputs
                break;
		}
    }

    
   /*  public void stop() {
      //
    }*/
}