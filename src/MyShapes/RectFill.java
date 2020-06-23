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
public class RectFill extends ARect{

    public RectFill(Point center, int width, int height, int order) {
        super(center, width, height, order);
    }
    
    public RectFill(int x, int y, int width, int height, int order) {
        super(x, y, width, height, order);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        ((Graphics2D)g).setStroke(new BasicStroke(getStrokeWidth()));
        g.setColor(getColor());
        g.fillRect(getCenter().x, getCenter().y, getDimension().x, getDimension().y);
    }
}
