import company.*;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import javax.xml.stream.EventFilter;
import java.util.Scanner;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception{

        Scanner input = new Scanner(System.in);

        Player player = new MyPlayer();
        Game game = null;

        try{
            game = new Game(new Map(input));
        }
        catch(InvalidMapException e){ // custom exception
            System.out.println(e.getMessage());
            System.exit(0);
        }

        game.addPlayer(player);
        Position playerPosition = player.getPosition();

        GridPane root = new GridPane();
        root.setGridLinesVisible(true);
        final int numCols = game.map.getSize() ;
        final int numRows = game.map.getSize() ;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(50);
            root.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(50);
            root.getRowConstraints().add(rowConst);
        }

        int size = game.map.getSize();



        Tank tank = new Tank(new ImageView("models/grey_tank.png"));

        tank.model.setFitHeight(50);
        tank.model.setFitWidth(50);

        tank.model.setPreserveRatio(false);

        root.add(tank.model, playerPosition.getX(), playerPosition.getY());

        Bounds[][] bounds = new Bounds[size][size];

        for(int i = 0; i < game.map.getSize(); i++){
            for(int j = 0; j < game.map.getSize(); j++){
                if (game.map.getValueAt(i, j) == 'S'){
                    Steel steel = new Steel();
                    root.add(steel.getModel(), j, i);
                    bounds [i][j] = steel.getModel().getBoundsInParent();
                }
                if (game.map.getValueAt(i, j) == 'B'){
                    Brick brick = new Brick();
                    root.add(brick.getModel(), j, i);
                    bounds [i][j] = brick.getModel().getBoundsInParent();
                }
                if (game.map.getValueAt(i, j) == 'W'){
                    Water water = new Water();
                    root.add(water.getModel(), j, i);
                    bounds [i][j] = water.getModel().getBoundsInParent();
                }
                if (game.map.getValueAt(i, j) == 'T'){
                    Trees trees = new Trees();
                    root.add(trees.getModel(), j, i);
                    bounds [i][j] = trees.getModel().getBoundsInParent();
                }
            }
        }

        Scene scene = new Scene(root, game.map.getSize()*50, game.map.getSize()*50, Color.BLACK);


        scene.setOnKeyPressed(e -> {
            switch (e.getCode()){
                case D:
                    if (tank.getDirection() != 'r'){
                        tank.model.setRotate(90);
                        tank.setDirection('r');
                    }
                    else{
                        System.out.println("moved right");
                        player.moveRight();
                        GridPane.setColumnIndex(tank.model, player.getPosition().getX());
                    }
                    break;
                case A:
                    if (tank.getDirection() != 'l'){
                        tank.model.setRotate(270);
                        tank.setDirection('l');
                    }
                    else{
                        System.out.println("moved left");
                        player.moveLeft();
                        GridPane.setColumnIndex(tank.model, player.getPosition().getX());
                    }
                    break;
                case W:
                    if (tank.getDirection() != 'u'){
                        tank.model.setRotate(0);
                        tank.setDirection('u');
                    }
                    else{
                        System.out.println("moved up");
                        player.moveUp();
                        GridPane.setRowIndex(tank.model, player.getPosition().getY());
                    }
                    break;
                case S:
                    if (tank.getDirection() != 'd'){
                        tank.model.setRotate(180);
                        tank.setDirection('d');
                    }
                    else{
                        System.out.println("moved down");
                        player.moveDown();
                        GridPane.setRowIndex(tank.model, player.getPosition().getY());
                    }
                    break;
            }
        });

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Bullet bullet = new Bullet();
                GridPane.setHalignment(bullet.getModel(), HPos.CENTER);
                if (tank.getDirection() == 'd'){
                    bullet.getModel().setRotate(90);
                }
                if (tank.getDirection() == 'r'){
                    bullet.getModel().setRotate(0);
                }
                if (tank.getDirection() == 'l'){
                    bullet.getModel().setRotate(180);
                }
                if (tank.getDirection() == 'u'){
                    bullet.getModel().setRotate(270);
                }
                root.add(bullet.getModel(), player.getPosition().getX(), player.getPosition().getY());
                Bounds bulletBound = bullet.getModel().getBoundsInParent();
                bullet.shoot(tank.getDirection(), size);
                for(int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (bounds[i][j] != null){
                            if (bulletBound.intersects(bounds[i][j])) {
                            }
                        }
                    }
                }
                System.out.println("Shooting");
            }
        };

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}