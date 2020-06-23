/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoadingScreen;

import extras.LoadingAnimation;
import extras.TextFade;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author marcos
 */
public class PaintLoadingScreen extends JPanel{
    private LoadingAnimation anim;
    private TextFade title;
    private TextFade titleVersion;
    private Color bg = new Color(28, 28, 28);
    private long startingTime;
    private String[] loadingMsg;
    private String loadingStr;
    private Random rand;
    private int loadingTime = 8000;
    private Font loadingFont = new Font("TimesRoman", Font.PLAIN, 15);
    
    public PaintLoadingScreen(){
        anim = new LoadingAnimation(450, 400, 40, 60, new Color(255, 183, 0), new Color(255, 111, 0));
        
        title = new TextFade("Paint", 120, 300, 200);
        title.setColor(new Color(229,224,225, 0));
        
        titleVersion = new TextFade("2.0", title.getFontSize(), title.getPosition().x + (int)title.getTextWidth() + 20, title.getPosition().y);
        titleVersion.setColor(new Color(229,224,225, 0));
        
        rand = new Random();
        
        loadingMsg = new String[]{
            "Checking the gravitational constant in your locale...",
            "The server is powered by a lemon and two electrodes.",
            "We\'re testing your patience",
            "Keep calm and npm install",
            "The bits are flowing slowly today",
            "Are we there yet?",
            "Counting backwards from Infinity...",
            "WARNING: Don\'t set yourself on fire.",
            "Adjusting flux capacitor...",
            "Deleting all user data...",
            "Making sure all the i\'s have dots...",
            "Convincing AI not to turn evil...",
            "Computing the secret to life, the universe, and everything.",
            "git happens",
            "If I’m not back in five minutes, just wait longer",
            "I need to git pull --my-life-together",
            "Laughing at your pictures-I mean, loading...",
            "Looking for sense of humour, please hold on.",
            "Help, I\'m trapped in a loader!",
            "Downloading more RAM...",
            "Discovering new ways of making you wait...",
            "Your time is very important to us. \nPlease wait while we ignore you...",
            "Still faster than Windows update",
            "TODO: Insert elevator music"
        };
        
        loadingStr = randomMsg();
        
        startingTime = System.currentTimeMillis();
    }
    
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        RenderingHints rh = new RenderingHints(
             RenderingHints.KEY_ANTIALIASING,
             RenderingHints.VALUE_ANTIALIAS_ON
        );
        
        ((Graphics2D)g).setRenderingHints(rh);
        
        g.setColor(bg);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        anim.paint(g);
        
        g.setFont(loadingFont);
        g.setColor(new Color(229,224,225));
        if(System.currentTimeMillis()-startingTime>=loadingTime*0.9)
            g.drawString("Done!", (int)(anim.getCenter().x-g.getFontMetrics().stringWidth("Done!"
                    + "")/2.0), (int)(anim.getCenter().y-anim.getRadius()*2.5));
        else
            g.drawString(loadingStr, (int)(anim.getCenter().x-g.getFontMetrics().stringWidth(loadingStr)/2.0), (int)(anim.getCenter().y-anim.getRadius()*2.5));
        
        if(rand.nextFloat()<0.005)
            loadingStr = randomMsg();
        
        title.paint(g);
        
        if(System.currentTimeMillis()-startingTime>=500)
            title.addAlpha(2);
        else
            title.setAlpha(0);
        
        if(title.getAlpha()>=250){
            titleVersion.addAlpha((float)1.55);
            titleVersion.paint(g);
        }
    }
    
    private String randomMsg(){
        return loadingMsg[rand.nextInt(loadingMsg.length)];
    }
    
    public boolean finished(){
        return System.currentTimeMillis()-startingTime>=loadingTime;
    }
}
