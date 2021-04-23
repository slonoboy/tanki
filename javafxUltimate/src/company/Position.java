package company;

public class Position {
    private int y, x;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Position position){
        return this.getY() == position.getY() && this.getX() == position.getX();
    }

    public String toString(){
        return "(" + x + "," + y + ")";
    }
}
