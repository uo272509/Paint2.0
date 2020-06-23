/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyShapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author marcos
 */
public class Line extends JPanel implements Resizable {
    private Point starting, ending;
    private Color c = MyShapes.DefaultColor;
    private int order;
    private float strokeWidth = 1;
    
    public Line(Point center, int width, int height, int order) {
        starting = center;
        ending = center;
        this.order = order;
    }
    
    public Line(int x, int y, int width, int height, int order) {
        starting = new Point(x, y);
        ending = new Point(x, y);
        this.order = order;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        ((Graphics2D)g).setStroke(new BasicStroke(getStrokeWidth()));
        g.setColor(c);
        g.drawLine(starting.x, starting.y, ending.x, ending.y);
    }

    @Override
    public Point getCenter() {
        return starting;
    }

    @Override
    public void setCenter(Point p) {
        starting = p;
    }

    @Override
    public Point getDimension() {
        return new Point(ending.x-starting.x, ending.y-starting.y);
    }

    @Override
    public void resize(int x, int y){
        ending = new Point(x, y);
    }
    
    @Override
    public void setSize(Point p) {
        int w = p.x-getDimension().x;
        int h = p.y-getDimension().y;
        
        ending.x = (ending.x-w);
        ending.y = (ending.y-h);
    }

    @Override
    public Rectangle getRect() {
        int x2=Math.min(starting.x, ending.x);
        int y2=Math.min(starting.y, ending.y);
        int width=Math.abs(starting.x - ending.x);
        int height=Math.abs(starting.y - ending.y);
        
        return new Rectangle(x2, y2, width, height);
    }

    @Override
    public void setColor(Color c) {
        this.c = c;
    }

    @Override
    public Color getColor() {
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
