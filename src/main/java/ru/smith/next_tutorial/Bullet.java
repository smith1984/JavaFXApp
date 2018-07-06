package ru.smith.next_tutorial;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class Bullet extends Pane {
    public Point2D velocity = new Point2D(0,0);

    Bullet(){
        getChildren().addAll(new Rectangle(20,2, Color.RED));
    }

    public void setTarget(double x, double y){
        velocity = new Point2D(x,y).subtract(getTranslateX(), getTranslateY()).normalize().multiply(5);
        double angle = calcAngle(velocity.getX(), velocity.getY());
        getTransforms().clear();
        getTransforms().add(new Rotate(angle,0,0));
    }

    public void move(){
        setTranslateX(getTranslateX() + velocity.getX());
        setTranslateY(getTranslateY() + velocity.getY());
    }

    public double calcAngle(double vecX, double vecY){
        double angle = new Point2D(vecX, vecY).angle(1, 0);
        return vecY>0?angle:-angle;
    }
}
