package gameManager;


import javax.swing.*;

public class GameManager {

    private Personaje player;
    private Personaje npc;

    private Graphics g;
    private MKeyListener input;

    public GameManager() {
        this.player = new Personaje(0, 0, 6, 6);
        this.npc = new Personaje(10, 0, 4, 4);

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

    private boolean areaCheck(Box a_box, Box b_box) {
        
        
        return false;
    }

    private boolean checkCollision(Personaje a, Personaje b) {
        Box a_box = a.getBoundingBox();
        Box b_box = b.getBoundingBox();

        boolean result;
        result = areaCheck(a_box, b_box);
        if (result) {
            return result;
        }
        result = areaCheck(b_box, a_box);
        return result;
    }
}

