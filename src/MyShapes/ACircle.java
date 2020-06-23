/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyShapes;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author marcos
 */
public abstract class ACircle extends JPanel implements MyShapes{
    private Point center;
    private int radius;
    private Color c = MyShapes.DefaultColor;
    private int order;
    private float strokeWidth = 1;
    
    public ACircle(Point center, int radius, int order){
        this.center = center;
        this.radius = radius;
        this.order = order;
    }
    
    public ACircle(int x, int y, int radius, int order){
        this.center = new Point(x, y);
        this.radius = radius;
        this.order = order;
    }
    
    public void setCenter(int x, int y){
        center = new Point(x, y);
    }
    
    public int getRadius(){
        return radius;
    }
    
    public void setRadius(int r){
        radius = Math.abs(r);
    }
    
    @Override
    public Rectangle getRect(){
        return new Rectangle(center.x-radius, center.y-radius, radius*2, radius*2);
    }

    @Override
    public Point getCenter(){
        return center;
    }
    
    @Override
    public void setCenter(Point p){
        center = (Point) p.clone();
    }
    
    @Override
    public Point getDimension() {
        return new Point(getRadius(), getRadius());
    }

    @Override
    public void setSize(Point p) {
        setRadius(Math.abs(p.x));
    }
    
    @Override
    public void setColor(Color c){
        this.c = c;
    }
    @Override
    public Color getColor(){
        return c;
    }
    
    @Override
    public void setStrokeWidth(float w){
        strokeWidth = w;
    }
    
    @Override
    public float getStrokeWidth(){
        return strokeWidth;
    }
    
    @Override
    public int getOrder(){
        return order;
    }
}
