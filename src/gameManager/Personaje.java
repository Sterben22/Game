package gameManager;

public class Personaje {
    private int x;
    private int y;
    private int width;
    private int height;

    public Personaje(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public boolean move(int code){
        switch(code){
            case 38: this.y -= 1; break;
            case 37: this.x -= 1; break;
            case 40: this.y += 1; break;
            case 39: this.x += 1; break;
            
            case 87: this.y -= 1; break;
            case 65: this.x -= 1; break;
            case 83: this.y += 1; break;
            case 68: this.x += 1; break;
            default: return false;
        }
        return true;
    }
    
    public Box getBoundingBox(){
        return new Box(this.x, this.y, this.width, this.height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
