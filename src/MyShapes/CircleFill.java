/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyShapes;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author margu
 */
public class CircleFill  extends ACircle {

    public CircleFill(Point center, int radius, int order) {
        super(center, radius, order);
    }
    
    public CircleFill(int x, int y, int radius, int order) {
        super(x, y, radius, order);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        ((Graphics2D)g).setStroke(new BasicStroke(getStrokeWidth()));
        g.setColor(getColor());
        g.fillOval(getCenter().x-getRadius(), getCenter().y-getRadius(), getRadius()*2, getRadius()*2);
    }
}
