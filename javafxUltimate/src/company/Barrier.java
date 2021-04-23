package company;

import javafx.scene.image.ImageView;

public abstract class Barrier{
    ImageView model;

    public Barrier(ImageView model){
        this.model = model;
        this.model.setFitHeight(50);
        this.model.setFitWidth(50);
    }

    public ImageView getModel() {
        return model;
    }
}
