package gameManager;


import javax.swing.*;

public class GameManager {

    private Personaje player;
    private Personaje npc;

    private Graphics g;
    private MKeyListener input;

    public GameManager() {
        this.player = new Personaje(17, 5, 15, 5);
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
    
    private boolean areaCheck(Personaje p1, Personaje p2) {
        boolean temp=false;
        int[] a = new int[2]; int[] b = new int[2];

        int x1 = p1.getX(); int x1_w = p1.getX()+p1.getWidth();
        int x2 = p2.getX(); int x2_w = p2.getX()+p2.getWidth();

        int y1 = p1.getY(); int y1_h = p1.getY()+p1.getHeight();
        int y2 = p2.getY(); int y2_h = p2.getY()+p2.getHeight();

        if(x1 >= x2){a[0]=x1;}else{a[0]=x2;}  //max
        if(x1_w >= x2_w){a[1]=x2_w;}else{a[1]=x1_w;}  //min
        
        if(y1 >= y2){b[0]=y1;}else{b[0]=y2;}  //max
        if(y1_h >= y2_h){a[1]=y2_h;}else{b[1]=y1_h;}  //min

        if(a[1] > a[0] && b[1] > b[0]){ temp = true;}
       
        return temp;
    }

    private boolean checkCollision(Personaje p1, Personaje p2) {
        boolean result = areaCheck(p1, p2);
        return result;
    }
}

