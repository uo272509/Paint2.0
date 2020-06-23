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
 * @author margu
 */
public abstract class AEllipse extends JPanel implements MyShapes{
    private Point center;
    private int r1, r2;
    private Color c = MyShapes.DefaultColor;
    private int order = 0;
    private float strokeWidth = 1;    
    
    public AEllipse(Point center, int r1, int r2, int order){
        this.center = center;
        this.r1 = r1;
        this.r2 = r2;
        this.order = order;
    }
    
    public AEllipse(int x, int y, int r1, int r2, int order){
        this.center = new Point(x, y);
        this.r1 = r1;
        this.r2 = r2;
        this.order = order;
    }
    
    public void setCenter(int x, int y){
        center = new Point(x, y);
    }
    
    public void setRadius(Point p){
        this.r1 = Math.abs(p.x);
        this.r2 = Math.abs(p.y);
    }
    
    @Override
    public Rectangle getRect(){
        return new Rectangle(center.x-r1, center.y-r2, r1*2, r2*2);
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
        return new Point(r1, r2);
    }

    @Override
    public void setSize(Point p) {
        setRadius(p);
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
