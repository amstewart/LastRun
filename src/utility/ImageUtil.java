package utility;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author darien
 */
public class ImageUtil {

    //<editor-fold desc="ASSET PATHS" defaultstate="collapsed">
    private static final String DIR_RES = "res/";
    private static final String DIR_SPRITES = DIR_RES + "sprites/";
    //
    public static final String NULL_ASSET = DIR_RES + "null.png";
    //
    public static final String MAIN_MENU_BACKGROUND = DIR_SPRITES + "menu_bg_2.jpg";
    /* ENTITIES */
    public static final String EN_SKEL_N = DIR_SPRITES + "en_skel_N.png";
    public static final String EN_SKEL_NE = DIR_SPRITES + "en_skel_NE.png";
    public static final String EN_SKEL_SE = DIR_SPRITES + "en_skel_SE.png";
    public static final String EN_SKEL_S = DIR_SPRITES + "en_skel_S.png";
    public static final String EN_SKEL_SW = DIR_SPRITES + "en_skel_SW.png";
    public static final String EN_SKEL_NW = DIR_SPRITES + "en_skel_NW.png";
    //</editor-fold>

    private static boolean initialized = false;
    private static HashMap<String, BufferedImage> assets = new HashMap<>();
    
    public static ImageIcon rescaleImage(ImageIcon image, int width, int height){
        
         BufferedImage bufferedImage = (BufferedImage)image.getImage();
         bufferedImage = scale(width,height,bufferedImage);
         return new ImageIcon( bufferedImage );
    }
   
    public static ImageIcon getImage(String fileName){
        if (!initialized) initialize();

        BufferedImage image = null;
        if (fileName == null) {
            Util.errOut(new Exception("Null asset filepath specified."), false);
        } else {
            image = assets.get(fileName); // search the assets map for the image
            if (image == null) { // if it is not in the map already
                image = extractImage(fileName); // attempt to extract it from the file
                if (image == null) { // if the extraction fails
                    image = assets.get(NULL_ASSET); // set the image to the null asset
                } else { // if the load worked, add them to the assets map
                    assets.put(fileName, image);
                }
            }
        }
        // image should now be either the requested asset or null_asset
        return new ImageIcon( image );
    }

    //TODO UPDATE
    public static ImageIcon getImage(String fileName, int width, int height){
        
         BufferedImage bufferedImage = extractImage(fileName);
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
    
    public static final BufferedImage extractImage(String file_path) {
        try {
            File image_file = new File(file_path);
            if (!image_file.exists()) {
                Util.errOut(new FileNotFoundException(file_path));
                return null;
            }

            return ImageIO.read(image_file);
        } catch (IOException e) {
            Util.dbgOut(System.getProperty("user.dir"), 1);
            e.printStackTrace();
        }
        return null;
    }

    public static void initialize() {
        BufferedImage im_null = extractImage(NULL_ASSET);
        if (im_null == null) {
            Util.errOut(new Exception("Image Utility could not load null image."), true);
        }

        initialized = true;
    }
}
