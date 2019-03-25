/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupmaker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author wouter
 */
public class Cup extends JPanel {
    
    public List<CupPart> Parts;
    
    public Cup(int w, int h) {
        setPreferredSize(new Dimension(w, h));
        this.Parts = new ArrayList<>();
    }
    
    public void addToCup(int wt, int wb, int h){
        this.Parts.add(new CupPart(wt, wb, h));
    }
    
    public float getVolume(){
        float totalVolume = 0;
        for (CupPart part : Parts){
            totalVolume += part.getVolume();
        }
        return totalVolume;
    }
    
    public void reset(){
        Parts = new ArrayList<>();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        
        int startx = getWidth()/2;
        int starty = 10;
        
        g.setColor(Color.black);
        for(CupPart part : Parts){
            g.drawLine(startx-part.WidthTop/2, starty, startx+part.WidthTop/2, starty);
            g.drawLine(startx-part.WidthBottom/2, starty+part.Height, startx+part.WidthBottom/2, starty+part.Height);
            g.drawLine(startx-part.WidthTop/2, starty, startx-part.WidthBottom/2, starty+part.Height);
            g.drawLine(startx+part.WidthTop/2, starty, startx+part.WidthBottom/2, starty+part.Height);
            starty += part.Height;
        }
    }
}
