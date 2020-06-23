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
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author marcos
 */
public class LineFree extends JPanel implements Resizable{
    public static final float RESOLUTION = 0.2f;
    
    private ArrayList<Point> points;
    private Color c = MyShapes.DefaultColor;
    private int order;
    private float strokeWidth = 1;
    
    public LineFree(Point p, int width, int height, int order){
        points = new ArrayList<>();
        points.add(p);
        this.order = order;
    }
    
    public LineFree(int x, int y, int width, int height, int order){
        points = new ArrayList<>();
        points.add(new Point(x, y));
        this.order = order;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(c);
        ((Graphics2D)g).setStroke(new BasicStroke(getStrokeWidth()));
        
        for(int i = 0; i<points.size()-1; i++){
            Point p1 = points.get(i);
            Point p2 = points.get(i+1);
            
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
    
    @Override
    public Point getCenter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCenter(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Point getDimension() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSize(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rectangle getRect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    @Override
    public void resize(int x, int y){
        Point p = new Point(x, y);
        
        if(p.distance(points.get(points.size()-1)) >= RESOLUTION){
            points.add(p);
        }
    }
}
