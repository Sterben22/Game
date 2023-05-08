package gameManager;

import java.awt.Rectangle;
import javax.swing.*;

public class GameManager {

    private Personaje player;
    private Personaje npc;

    private Graphics g;
    private MKeyListener input;

    public GameManager() {
        this.player = new Personaje(1, 5, 15, 5);
        this.npc = new Personaje(10, 0, 5, 15);

        this.g = new Graphics(60, 15);
        this.input = new MKeyListener();
        JTextField textField = new JTextField();
        textField.addKeyListener(this.input);
        JFrame jframe = new JFrame();
        jframe.add(textField);
        jframe.setSize(400, 350);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void exec() {
        Personaje[] temp = new Personaje[2];
        temp[0] = this.player;
        temp[1] = this.npc;
        this.g.print(temp);
        while (true) {
            if(this.player.move(this.input.code)){
                this.g.print(temp);
            }
            this.input.code = -1;
            if (checkCollision(player, npc)) {
                System.out.println("\nTe has chocado con un npc!");
                System.exit(0);
            }
        }
    }

    private boolean checkCollision(Personaje a, Personaje b) {
        Rectangle aRect = new Rectangle(a.getX(), a.getY(), a.getWidth(), a.getHeight());
        Rectangle bRect = new Rectangle(b.getX(), b.getY(), b.getWidth(), b.getHeight());

        return aRect.intersects(bRect);
    }
}

