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
public abstract class ARect extends JPanel implements Resizable{
    private Rectangle dimensions;
    private Color c = MyShapes.DefaultColor;
    private Point initialMouseDown;
    private int order;
    private float strokeWidth = 1;
    
    public ARect(Point center, int width, int height, int order){
        dimensions = new Rectangle(center.x, center.y, width, height);
        initialMouseDown = center;
        this.order = order;
    }
    
    public ARect(int x, int y, int width, int height, int order){
        dimensions = new Rectangle(x, y, width, height);
        initialMouseDown = new Point(x, y);
        this.order = order;
    }
    
    @Override
    public Point getCenter() {
        return dimensions.getLocation();
    }

    @Override
    public void setCenter(Point p) {
        dimensions.setLocation(p);
    }

    @Override
    public Point getDimension() {
        return new Point((int)dimensions.getWidth(), (int)dimensions.getHeight());
    }

    @Override
    public void setSize(Point p) {}
    
    @Override
    public void resize(int x, int y) {
        int x2=Math.min(initialMouseDown.x, x);
        int y2=Math.min(initialMouseDown.y, y);
        int width=Math.abs(initialMouseDown.x - x);
        int height=Math.abs(initialMouseDown.y - y);
        
        dimensions = new Rectangle(x2, y2, width, height);
    }

    @Override
    public Rectangle getRect() {
        return dimensions;
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
