/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author margu
 */

public class LoadingAnimation extends JPanel{
    LoadCircle c1, c2;
    Color c1Color, c2Color;
    
    public LoadingAnimation(int x, int y, int r1, int r2){
        c1 = new LoadCircle(x, y, r1, 0);
        c2 = new LoadCircle(x, y, r2, 0);
        
        c1Color = Color.RED;
        c2Color = Color.GREEN;
    }
    
    public LoadingAnimation(int x, int y, int r1, int r2, Color cc1, Color cc2){
        c1 = new LoadCircle(x, y, r1, 0);
        c2 = new LoadCircle(x, y, r2, 0);
        
        c1Color = cc1;
        c2Color = cc2;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        g.setColor(c1Color);
        c1.paint(g);
        c1.setAngle(c1.getAngle()+5);
        
        g.setColor(c2Color);
        c2.paint(g);
        c2.setAngle(c2.getAngle()-5);
    }
    
    public Point getCenter(){
        return c1.getCenter();
    }

    public int getRadius() {
        return Math.max(c1.getRadius(), c2.getRadius());
    }
}
