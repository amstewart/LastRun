/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 *
 * @author darien
 */
public class ImageUtil {

    private static final String DIR_RES = "res/";
    private static final String DIR_SPRITES = DIR_RES + "sprites/";
    //
    public static final String NULL_ASSET = DIR_RES + "null.png";
    //
    public static final String MAIN_MENU_BACKGROUND = DIR_SPRITES + "MainMenuBackground.jpeg";
    
    public static ImageIcon rescaleImage(ImageIcon image, int width, int height){
        
         BufferedImage bufferedImage = (BufferedImage)image.getImage();
         bufferedImage = scale(width,height,bufferedImage);
         return new ImageIcon( bufferedImage );
    }
   
    public static ImageIcon getImage(String fileName){
        
        File file = new File(fileName);
        if ( !file.exists()){System.out.println("Something went wrong!!!!");}
        
         BufferedImage bufferedImage = extractImage(new File(fileName));
         bufferedImage = scale(500,550,bufferedImage);
         return new ImageIcon( bufferedImage );
    }
    
    public static ImageIcon getImage(String fileName, int width, int height){
        
         BufferedImage bufferedImage = extractImage(new File(fileName));
         bufferedImage = scale(width,height,bufferedImage);
         return new ImageIcon( bufferedImage );
    }
    
    private static BufferedImage scale(int width, int height, BufferedImage image) {
            
            Image i = image;
            i = getScaledImage(i, width, height);
            return (BufferedImage) i;
        }

    private static  Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }
    
    public static final BufferedImage extractImage(File file) {
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            Util.dbgOut(System.getProperty("user.dir"), 1);
            e.printStackTrace();
        }
        return null;
    }

}
