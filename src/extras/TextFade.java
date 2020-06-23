/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extras;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;

/**
 *
 * @author marcos
 */
public class TextFade extends JPanel{
    private final String text;
    private float alpha = 0;
    private Color c = Color.BLACK;
    private Point position;
    private Font font;
    
    public TextFade(String text, int x, int y){
        this.text = text;
        
        position = new Point(x, y);
        
        font = new Font("TimesRoman", Font.PLAIN, 30);
    }
    
    public TextFade(String text, int size, int x, int y){
        this.text = text;
        
        position = new Point(x, y);
        
        font = new Font("TimesRoman", Font.PLAIN, size);
        
        this.setAlpha(0);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        g.setFont(font);
        
        g.setColor(getColor());
        g.drawString(text, (int)(position.x-g.getFontMetrics().stringWidth(text)/2.0), position.y-font.getSize()/2);
    }
    
    public Point getPosition(){
        return position;
    }
    
    public void setPosition(Point p){
        position = (Point) p.clone();
    }
    
    public void setPosition(int x, int y){
        position = new Point(x, y);
    }
    
    public Color getColor(){
        return c;
    }
    
    public void setColor(Color c){
        this.c = new Color(c.getRed(), c.getBlue(), c.getGreen(), (int)alpha);
    }
    
    public float getAlpha(){
        return alpha;
    }
    
    public void addAlpha(float a){
        alpha = clamp(alpha+a, 0, 255);
        c = new Color(c.getRed(), c.getGreen(), c.getBlue(), (int)alpha);
    }
    
    public void addAlpha(){
        alpha = clamp(alpha+1, 0, 255);
        c = new Color(c.getRed(), c.getGreen(), c.getBlue(), (int)alpha);
    }
    
    public void setAlpha(float a){
        this.alpha = a;
        c = new Color(c.getRed(), c.getGreen(), c.getBlue(), (int)alpha);
    }
    
    public int getFontSize(){
        return font.getSize();
    }
    
    public void setSize(int s){
        font = new Font("TimesRoman", Font.PLAIN, s);
    }
    
    public float getTextWidth(){
        return (float) font.getStringBounds(text, new FontRenderContext(new AffineTransform(),true,true)).getWidth();
    }
    
    public float getTextHeight(){
        return (float) font.getStringBounds(text, new FontRenderContext(new AffineTransform(),true,true)).getHeight();
    }
    
    public static float clamp(float val, float min, float max) {
        return Math.max(min, Math.min(max, val));
    }
}
