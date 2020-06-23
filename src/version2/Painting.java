/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version2;

import MyShapes.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author marcos
 */
public class Painting extends JPanel implements Serializable{
    private static final long serialVersionUID = 6529685098267757690L;
    
    public static enum Brush {
        RECT_STROKE,
        RECT_FILL,
        OVAL_STROKE,
        OVAL_FILL,
        STRAIGHT_LINE,
        HANDDRAWN_LINE
    }
    
    private Color background;
    private Color currentColor = MyShapes.DefaultColor;
    private ArrayList<MyShapes> drawings;
    private Brush currentBrush = Brush.OVAL_STROKE;
    private MyShapes currentShape;
    private Point initialMouseDown;
    private MainWindow mainWindow;
    private File myName;
    private float strokeWidth = 1;
    
    public Painting(){
        background = new Color(41, 41, 41);
        
        drawings = new ArrayList<>();
    }
    
    public Painting(MainWindow mainWindow){
        background = new Color(41, 41, 41);
        
        drawings = new ArrayList<>();
        
        this.mainWindow = mainWindow;
    }
    
    @Override
    public void paint(Graphics g){
        try{
            super.paint(g);
        }catch(NullPointerException e){
            System.out.println("Oops!");
        }
        
        RenderingHints rh = new RenderingHints(
             RenderingHints.KEY_ANTIALIASING,
             RenderingHints.VALUE_ANTIALIAS_ON
        );
        
        ((Graphics2D)g).setRenderingHints(rh);
        
        g.setColor(background);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        drawings.stream().forEach((s) -> {
            s.paint(g);
        });
        
        if(currentShape != null)
            currentShape.paint(g);
    }
    
    public void mousePressed(int x, int y){        
        switch(currentBrush){
            case RECT_STROKE:
                currentShape = new RectStroke(x, y, 0, 0, 0);
                break;
            case RECT_FILL:
                currentShape = new RectFill(x, y, 0, 0, 0);
                break;
            case OVAL_STROKE:
                currentShape = new EllipseStroke(x, y, 0, 0, 0);
                break;
            case OVAL_FILL:
                currentShape = new EllipseFill(x, y, 0, 0, 0);
                break;
            case STRAIGHT_LINE:
                currentShape = new Line(x, y, 0, 0, 0);
                break;
            case HANDDRAWN_LINE:
                currentShape = new LineFree(x, y, 0, 0, 0);
                break;
            default:
                currentShape = new EllipseStroke(x, y, 0, 0, 0);   
        }
        
        currentShape.setColor(currentColor);
        currentShape.setStrokeWidth(strokeWidth);
        
        if(mainWindow!=null)
            mainWindow.changeMade();
    }
    
    public void mouseDragged(int x, int y){
        if(currentShape instanceof Resizable)
            ((Resizable)currentShape).resize(x, y);
        else
            currentShape.setSize(new Point(currentShape.getCenter().x-x, currentShape.getCenter().y-y));
    }
    
    public void mouseReleased(int x, int y){
        if(currentShape != null){
            drawings.add(currentShape);
            currentShape = null;
        }
    }
    
    public void mouseCancel(){
        currentShape=null;
        
        if(mainWindow!=null)
            mainWindow.changeSaved();
    }
    
    public void setStrokeWidth(float w){
        strokeWidth = w;
        
        if(currentShape != null)
            currentShape.setStrokeWidth(w);
    }
    
    public void setBrush(Brush b){
        currentBrush = b;
    }
    
    public void changeColor(Color c){
        currentColor = c;
    }
    
    public Color getColor(){
        return currentColor;
    }
    
    @Override
    public void setBackground(Color c){
        background = c;
    }
    
    @Override
    public Color getBackground(){
        return background;
    }
    
    public Point getInitialMouseDown(){
        return initialMouseDown;
    }
    
    public boolean undo(){
        if(drawings.isEmpty())
            return false;
        
        drawings.remove(drawings.size()-1);
        return true;
    }
    
    public void deleteEverything(){
        int option = JOptionPane.showConfirmDialog(this, "Are you sure?", "Deleting everything", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

        if(option == JOptionPane.OK_OPTION)
            drawings = new ArrayList<>();
    }
    
    public File getFile(){
        return myName;
    }
    
    public void setFile(File f){
        myName = f;
    }
    
    public int getNumberShapes(){
        return drawings.size();
    }
}
