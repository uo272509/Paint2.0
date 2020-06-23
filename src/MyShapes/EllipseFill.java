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
public class EllipseFill  extends AEllipse{

    public EllipseFill(Point center, int r1, int r2, int order) {
        super(center, r1, r2, order);
    }
    
    public EllipseFill(int x, int y, int r1, int r2, int order) {
        super(x, y, r1, r2, order);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        ((Graphics2D)g).setStroke(new BasicStroke(getStrokeWidth()));
        g.setColor(getColor());
        g.fillOval(getCenter().x-getDimension().x, getCenter().y-getDimension().y, getDimension().x*2, getDimension().y*2);
    }
}