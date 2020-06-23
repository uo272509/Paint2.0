/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extras;

import MyShapes.ACircle;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author marcos
 */
public class LoadCircle extends ACircle {
    private double angle = 0;
    
    public LoadCircle(int x, int y, int radius, int order){
        super(x, y, radius, order);
    }
    
    public LoadCircle(Point center, int radius, int order){
        super(center, radius, order);
    }
    
    @Override
    public void paint(Graphics g){
        Rectangle r = getRect();
        
        ((Graphics2D)g).setStroke(new BasicStroke(7));
        g.drawArc(r.x, r.y, r.width, r.height, (int)angle, 90);
        g.drawArc(r.x, r.y, r.width, r.height, (int)(angle+180), 90);
        ((Graphics2D)g).setStroke(new BasicStroke(1));
    }
    
    public double getAngle(){
        return angle;
    }
    
    public void setAngle(double angle){
        this.angle = angle;
    }
}
