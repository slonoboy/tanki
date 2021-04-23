package company;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventType;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Bullet {
    ImageView model = new ImageView("models/bullet.png");
    Tank tank;

    public Bullet(){
        model.setFitWidth(9);
        model.setFitHeight(6);
    }

    public ImageView getModel() {
        return model;
    }

    public void shoot(char direction, int size){
        if (direction == 'r'){
            KeyValue keyvalue = new KeyValue(model.translateXProperty(), 50*size);
            KeyFrame keyframe = new KeyFrame(Duration.seconds(1), keyvalue);
            Timeline timeline = new Timeline(keyframe);
            timeline.play();
        }
        if (direction == 'l'){
            KeyValue keyvalue = new KeyValue(model.translateXProperty(), -50*size);
            KeyFrame keyframe = new KeyFrame(Duration.seconds(1), keyvalue);
            Timeline timeline = new Timeline(keyframe);
            timeline.play();
        }
        if (direction == 'u'){
            KeyValue keyvalue = new KeyValue(model.translateYProperty(), -50*size);
            KeyFrame keyframe = new KeyFrame(Duration.seconds(1), keyvalue);
            Timeline timeline = new Timeline(keyframe);
            timeline.play();
        }
        if (direction == 'd'){
            KeyValue keyvalue = new KeyValue(model.translateYProperty(), 50*size);
            KeyFrame keyframe = new KeyFrame(Duration.seconds(1), keyvalue);
            Timeline timeline = new Timeline(keyframe);
            timeline.play();
        }

    }

}
