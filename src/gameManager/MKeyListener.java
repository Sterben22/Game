package gameManager;
import java.awt.event.*;

public class MKeyListener extends KeyAdapter {
    public int code;

    @Override
    public void keyPressed(KeyEvent event) {
        this.code = event.getKeyCode();
        
    }
}
