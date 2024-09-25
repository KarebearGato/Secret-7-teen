//  This class will be used to contorl the movement of the main charector and accept key imputs
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener
{

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP)
        {
            upPressed = true;
        }

        if (code == KeyEvent.VK_DOWN)
        {
            downPressed = true;
        }

        if (code == KeyEvent.VK_LEFT)
        {
            leftPressed = true;
        }

        if (code == KeyEvent.VK_RIGHT)
        {
            rightPressed = true;
        }
    }

    //@Override
    public void keyreleased(KeyEvent e)
    {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP)
        {
            upPressed = false;
        }

        if (code == KeyEvent.VK_DOWN)
        {
            downPressed = false;
        }

        if (code == KeyEvent.VK_LEFT)
        {
            leftPressed = false;
        }

        if (code == KeyEvent.VK_RIGHT)
        {
            rightPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
