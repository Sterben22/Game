package gameManager;


import javax.swing.*;

public class GameManager {

    private Personaje player;
    private Personaje npc;

    private Graphics g;
    private MKeyListener input;

    public GameManager() {
        this.player = new Personaje(9, 0, 6, 6);
        this.npc = new Personaje(4, 0, 4, 4);

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
                System.out.println("Te has chocado con un npc!");
                System.exit(0);
            }
        }
    }

    private boolean areaCheck(Box a_box, Box b_box) {
        //r1 -> l4 //r1 -> l3 //r2 -> l4 //r2 -> l3
        float t  = (b_box.coords[1].x - a_box.coords[0].x)/a_box.getWidth();
        float t1 = (b_box.coords[0].x - a_box.coords[0].x)/a_box.getWidth();
        float t2 = (a_box.coords[0].y - b_box.coords[0].y)/b_box.getHeight();
        float t3 = (a_box.coords[2].y - b_box.coords[0].y)/b_box.getHeight();
        if(   0 <= t  && t  <= 1
           || 0 <= t1 && t1 <= 1
           || 0 <= t2 && t3 <= 1
           || 0 <= t3 && t3 <= 1){
           return true; 
        }
        //r3 -> l1 //r3 -> l2 //r4 -> l1 //r4 -> l2
        t  = (b_box.coords[0].y - a_box.coords[0].y)/a_box.getHeight();
        t1 = (b_box.coords[2].y - a_box.coords[0].y)/a_box.getHeight();
        t2 = (a_box.coords[0].x - b_box.coords[0].x)/b_box.getWidth();
        t3 = (a_box.coords[1].x - b_box.coords[0].x)/b_box.getWidth();
        if(   0 <= t  && t  <= 1
           || 0 <= t1 && t1 <= 1
           || 0 <= t2 && t3 <= 1
           || 0 <= t3 && t3 <= 1){
           return true; 
        }
        
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

