import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private int x;
    private int y;

    public boolean upPressed, downPressed, leftPressed, rightPressed;


    public void setX(int X) {
        this.x += X;
    }

    public void setY(int Y) {
        this.y += Y;
    }

 
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();


        switch (keyCode) {
            case KeyEvent.VK_UP:
                upPressed = true;
                setY(-5);
                break;
            case KeyEvent.VK_LEFT:
                leftPressed = true;
                setX(-5);
                break;
            case KeyEvent.VK_DOWN:
                downPressed = true;
                setY(5);
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = true;
                setX(5);
                break;
            case KeyEvent.VK_ESCAPE:
                stop();
                break;
        }
    }


    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
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
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //
    }

    
    public void stop() {
      //
    }
}
