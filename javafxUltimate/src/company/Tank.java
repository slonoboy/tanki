package company;


import javafx.scene.image.ImageView;

public class Tank extends MyPlayer{
    public ImageView model;
    private char direction = 'u';


    public Tank(ImageView model){
        this.model = model;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }
}
