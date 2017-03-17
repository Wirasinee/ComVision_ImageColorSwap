/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comv;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author win8
 */
public class BrightnessInverse { ///กลับด าเป็นขาว กลับขาวเป็นด า
    public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    BufferedImage img = null;
    File file = new File(in.nextLine());
        try {
            img = ImageIO.read(file);
        } catch (IOException ex) {
            System.err.println("err");
            return;
        }
    
        
        int colorPixel[] = new int[1];
        
        for(int r=0;r<img.getHeight();r++){
            for(int c=0;c<img.getWidth();c++){
            
            
            WritableRaster wraster = img.getRaster();
            
            
            
            wraster.getPixel(c, r, colorPixel);
            
            colorPixel[0] = 255-colorPixel[0];
        
            wraster.setPixel(c, r, colorPixel);
        }
        }
        
        try{
            File fileNew = new File(in.nextLine());//รับที่อยู่ไฟล์ภาพใหม่   
            ImageIO.write(img, "png", fileNew);
        }catch (IOException ex) {
            System.err.println("Cannot write file");
            return;
        }
    }
    //C:\\Users\\win8\\Desktop\\Tsukuyomi_gray_256.png
    }
    

