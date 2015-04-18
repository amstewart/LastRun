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
    private static final String DIR_ITEMS = DIR_RES + "items/";
    private static final String DIR_SPRITES = DIR_RES + "sprites/";
    private static final String DIR_TERRAINS = DIR_RES + "terrain/";
    private static final String DIR_DECALS = DIR_RES + "decal/";
    //
    public static final String NULL_ASSET = DIR_RES + "null.png";
    //
    /* ENTITIES */

    /**
     * ******SMASHER SPRITES***********
     */
    public static final String SMASHER_N = DIR_SPRITES + "Smasher_N.png";
    public static final String SMASHER_NE = DIR_SPRITES + "Smasher_NE.png";
    public static final String SMASHER_SE = DIR_SPRITES + "Smasher_SE.png";
    public static final String SMASHER_S = DIR_SPRITES + "Smasher_S.png";
    public static final String SMASHER_SW = DIR_SPRITES + "Smasher_SW.png";
    public static final String SMASHER_NW = DIR_SPRITES + "Smasher_NW.png";

    /**
     * *******************************
     */
    /**
     * ******SNEAK SPRITES***********
     */
    public static final String SNEAK_N = DIR_SPRITES + "Sneak_N.png";
    public static final String SNEAK_NE = DIR_SPRITES + "Sneak_NE.png";
    public static final String SNEAK_SE = DIR_SPRITES + "Sneak_SE.png";
    public static final String SNEAK_S = DIR_SPRITES + "Sneak_S.png";
    public static final String SNEAK_SW = DIR_SPRITES + "Sneak_SW.png";
    public static final String SNEAK_NW = DIR_SPRITES + "Sneak_NW.png";

    /**
     * *******************************
     */
    /**
     * ******SNEAK SPRITES***********
     */
    public static final String SUMMONER_N = DIR_SPRITES + "Summoner_N.png";
    public static final String SUMMONER_NE = DIR_SPRITES + "Summoner_NE.png";
    public static final String SUMMONER_SE = DIR_SPRITES + "Summoner_SE.png";
    public static final String SUMMONER_S = DIR_SPRITES + "Summoner_S.png";
    public static final String SUMMONER_SW = DIR_SPRITES + "Summoner_SW.png";
    public static final String SUMMONER_NW = DIR_SPRITES + "Summoner_NW.png";

    /**
     * *******************************
     */
    /**
     * ******SKELETON SPRITES********
     */
    public static final String EN_SKEL_N = DIR_SPRITES + "en_skel_N.png";
    public static final String EN_SKEL_NE = DIR_SPRITES + "en_skel_NE.png";
    public static final String EN_SKEL_SE = DIR_SPRITES + "en_skel_SE.png";
    public static final String EN_SKEL_S = DIR_SPRITES + "en_skel_S.png";
    public static final String EN_SKEL_SW = DIR_SPRITES + "en_skel_SW.png";
    public static final String EN_SKEL_NW = DIR_SPRITES + "en_skel_NW.png";
    /**
     * *****************************
     */

    public static final String[] smasherSprites = {null, SMASHER_SW, SMASHER_S, SMASHER_SE, null, null, null, SMASHER_NW, SMASHER_N, SMASHER_NE};
    public static final String[] sneakSprites = {null, SNEAK_SW, SNEAK_S, SNEAK_SE, null, null, null, SNEAK_NW, SNEAK_N, SNEAK_NE};
    public static final String[] summonerSprites = {null, SUMMONER_SW, SUMMONER_S, SUMMONER_SE, null, null, null, SUMMONER_NW, SUMMONER_N, SUMMONER_NE};

    /**
     * ***********TERRAINS**************
     */
    public static final String GrassTerrain = DIR_TERRAINS + "GrassTerrain.png";
    public static final String WaterTerrain = DIR_TERRAINS + "WaterTerrain.png";
    public static final String MountainTerrain = DIR_TERRAINS + "MountainTerrain.png";
    /**
     * ******************************
     */

    /**
     * ***********DECALS**************
     */
    public static final String GoldStar = DIR_DECALS + "GoldStar.png";
    public static final String Crossbone = DIR_DECALS + "Crossbone.png";
    public static final String RedCross = DIR_DECALS + "RedCross.png";
    /**
     * ******************************
     */
    
    /* ITEMS */
    public static final String APPLE = DIR_ITEMS + "apple.png";
    public static final String AXE = DIR_ITEMS + "axe2.png";
    public static final String BANDANA = DIR_ITEMS + "bandana.png";
    public static final String BOOK = DIR_ITEMS + "book2.png";
    public static final String CAP = DIR_ITEMS + "cap.png";
    public static final String CHEESE = DIR_ITEMS + "cheese.png";
    public static final String CLUB = DIR_ITEMS + "club.png";
    public static final String CROSSBOW = DIR_ITEMS + "crossbow.gif";
    public static final String DAGGER = DIR_ITEMS + "dagger.png";
    public static final String HAMMER = DIR_ITEMS + "hammer.png";
    public static final String HELMET = DIR_ITEMS + "helmet.png";
    public static final String KEY = DIR_ITEMS + "key2.png";
    public static final String MACE = DIR_ITEMS + "mace.png";
    public static final String MUSHROOM = DIR_ITEMS + "mushroom.png";
    public static final String HEALTH_POTION = DIR_ITEMS + "potion_health.png";
    public static final String MANA_POTION = DIR_ITEMS + "potion_mana.png";
    public static final String SHIELD = DIR_ITEMS + "shield1.png";
    public static final String SHIRT = DIR_ITEMS + "shirt.png";
    public static final String SPEAR = DIR_ITEMS + "spear1.png";
    public static final String STAFF = DIR_ITEMS + "staff.png";
    public static final String CANDYCANE_STAFF = DIR_ITEMS + "staff4.png";
    public static final String SWORD = DIR_ITEMS + "sword2.png";
    public static final String TORCH = DIR_ITEMS + "torch.png";
    public static final String WATERMELON = DIR_ITEMS + "watermelon.png";
    

    public static String[] inEffect = new String[10];

    public static void initSmasher() {
        for (int i = 0; i < 10; ++i) {
            inEffect[i] = smasherSprites[i];
        }
    }

    public static void initSneak() {
        for (int i = 0; i < 10; ++i) {
            inEffect[i] = sneakSprites[i];
        }
    }

    public static void initSummoner() {
        for (int i = 0; i < 10; ++i) {
            inEffect[i] = summonerSprites[i];
        }
    }
    //</editor-fold>

    private static boolean initialized = false;
    private static HashMap<String, BufferedImage> assets = new HashMap<>();

    /**
     * * MAIN MENU VIEW PORT **
     */
    public static final String MAIN_MENU_EXIT_BUTTON = DIR_SPRITES + "mm_exit_game_button.jpg";
    public static final String MAIN_MENU_LOAD_BUTTON = DIR_SPRITES + "mm_load_game_button.jpg";
    public static final String MAIN_MENU_NEW_GAME_BUTTON = DIR_SPRITES + "mm_new_game_button.jpg";
    public static final String MAIN_MENU_BACKGROUND = DIR_SPRITES + "main_menu_background.jpg";

    /**
     * * CHARACTER SELECTION VIEW PORT **
     */
    public static final String CHARACTER_SELECTION_BACKGROUND = "";
    public static final String CHARACTER_SELECTION_MENU_BUTTON = DIR_SPRITES + "cs_main_menu_button.jpg";
    public static final String CHARACTER_SELECTION_NEW_GAME_BUTTON = DIR_SPRITES + "cs_new_game_button.jpg";
    public static final String CHARACTER_SELECTION_PET = DIR_SPRITES + "cs_pet.jpg";

    /**
     * * MAP VIEW PORT **
     */
    public static final String ZOOM_IN = DIR_SPRITES + "zoom_in.png";
    public static final String ZOOM_OUT = DIR_SPRITES + "zoom_out.png";

    

    public static ImageIcon rescaleImage(ImageIcon image, int width, int height) {

        BufferedImage bufferedImage = (BufferedImage) image.getImage();
        bufferedImage = scale(width, height, bufferedImage);
        return new ImageIcon(bufferedImage);
    }

    public static ImageIcon getImage(String fileName) {
        if (!initialized) {
            initialize();
        }

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
        return new ImageIcon(image);
    }

    //TODO UPDATE
    public static ImageIcon getImage(String fileName, int width, int height) {

        BufferedImage bufferedImage = extractImage(fileName);
        bufferedImage = scale(width, height, bufferedImage);
        return new ImageIcon(bufferedImage);
    }

    private static BufferedImage scale(int width, int height, BufferedImage image) {

        Image i = image;
        i = getScaledImage(i, width, height);
        return (BufferedImage) i;
    }

    private static Image getScaledImage(Image srcImg, int w, int h) {
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
