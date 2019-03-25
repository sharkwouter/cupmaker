/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupmaker;

/**
 *
 * @author wouter
 */
public class CupPart {
    public int WidthTop, WidthBottom, Height;

    public CupPart(int wt, int wb, int h){
        this.WidthTop = wt;
        this.WidthBottom = wb;
        this.Height = h;
    }
    
    //returns the volume in mililiters
    public float getVolume(){
        if (this.WidthBottom == this.WidthTop){
            return this.getVolumeCilinder();
        }
        return this.getVolumeConePart();
    }
    
    private float getVolumeCilinder(){
        //This calculation below is pi*radius^2*height
        //Source: https://nl.wikibooks.org/wiki/Wiskunde/Volume
        
        float radius = (float) WidthTop/2;
        double pi = Math.PI;
        
        //Devide by 1000 to convert to ml from mm^3
        return (float) (pi*((radius)*(radius))*Height)/1000;
    }
    
    private float getVolumeConePart(){
        //The calculation here is 1/3*pi*height*(r^2+R^2+r*R)
        //Source: https://nl.wikibooks.org/wiki/Wiskunde/Volume
        
        float radius1 = (float) WidthTop/2;
        float radius2 = (float) WidthBottom/2;
        double pi = Math.PI;
        
        //Devide by 1000 to convert to ml from mm^3
        double answer = pi/3*((radius1*radius1)+(radius2*radius2)+(radius1*radius2))*Height;
        
        return (float) answer/1000;
    }
}
