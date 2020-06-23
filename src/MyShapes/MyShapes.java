/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyShapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
/**
 *
 * @author marcos
 */
public interface MyShapes extends Serializable{
    Color DefaultColor = Color.WHITE;
    
    public Point getCenter();
    public void setCenter(Point p);
    
    public int getOrder();
    
    public Point getDimension();
    public void setSize(Point p);
    public Rectangle getRect();
    
    public void setColor(Color c);
    public Color getColor();
    
    public void setStrokeWidth(float w);
    public float getStrokeWidth();
    
    public void paint(Graphics g);
}
