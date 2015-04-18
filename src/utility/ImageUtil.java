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
 * 
 */
public class ImageUtil {

    //<editor-fold desc="ASSET PATHS" defaultstate="collapsed">
    private static final String DIR_RES = "res/";
    private static final String DIR_ITEMS = DIR_RES + "items/";
    private static final String DIR_SPRITES = DIR_RES + "sprites/";
    private static final String DIR_TERRAINS = DIR_RES + "terrain/";
    private static final String DIR_DECALS = DIR_RES + "decal/";
    private static final String DIR_PROJECTILES = DIR_RES + "projectiles/";
    public static final String DIR_CHAR_SELECT = DIR_RES + "characterSelect/";
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
    public static final String TERRAIN_GRASS = DIR_TERRAINS + "GrassTerrain.png";
    public static final String TERRAIN_WATER = DIR_TERRAINS + "WaterTerrain.png";
    public static final String TERRAIN_MOUNTAIN = DIR_TERRAINS + "MountainTerrain.png";
    /**
     * ******************************
     */

    /**
     * ***********DECALS**************
     */
    public static final String GOLDSTAR = DIR_DECALS + "GoldStar.png";
    public static final String CROSSBONE = DIR_DECALS + "Crossbone.png";
    public static final String REDCROSS = DIR_DECALS + "RedCross.png";
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
    public static final String WERID_STAFF = DIR_ITEMS + "staff3.png";
    public static final String SWORD = DIR_ITEMS + "sword2.png";
    public static final String TORCH = DIR_ITEMS + "torch.png";
    public static final String WATERMELON = DIR_ITEMS + "watermelon.png";
    public static final String SPIKETRAP = DIR_ITEMS + "SpikeTrap.png";
    public static final String WINE = DIR_ITEMS + "wine.png";
    public static final String OINTMENT = DIR_ITEMS + "ointment.png";
    public static final String PROTEIN = DIR_ITEMS + "protein.png";
    public static final String LEGS1 = DIR_ITEMS + "Legs1.png";
    public static final String LEGS2 = DIR_ITEMS + "Legs2.png";
    public static final String LEGS3 = DIR_ITEMS + "Legs3.png";
    //Projectiles//

    public static final String GOLDBAR = DIR_ITEMS + "bar_gold.png";
    public static final String CLOSEDCHEST = DIR_ITEMS + "treasure_chest_closed.png";
    public static final String OPENCHEST = DIR_ITEMS + "treasure_chest_open.jpg";
    public static final String FIREBALL = DIR_PROJECTILES + "apple.png";
    
    //Stati//
    public static final String SLEEPING = DIR_ITEMS + "apple.png";
    public static final String SMELLY = DIR_ITEMS + "watermelon.png";
    public static final String SINGING = DIR_ITEMS + "torch.png";
    public static final String INVISIBLE = DIR_ITEMS + "torch.png";
    
    
    

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
    
    
    /*** CHARACTER SELECTION VIEW PORT ***/    
    public static final String CHARACTER_SELECTION_MENU_BUTTON = DIR_SPRITES + "cs_main_menu_button.jpg";
    public static final String CHARACTER_SELECTION_NEW_GAME_BUTTON = DIR_SPRITES + "cs_new_game_button.jpg";
    public static final String CHARACTER_SELECTION_PET = DIR_SPRITES + "cs_pet.jpg";
    public static final String CHARACTER_SELECTION_SMASHER = DIR_CHAR_SELECT + "smasher.gif";
    public static final String CHARACTER_SELECTION_SUMMONER = DIR_SPRITES + "cs_summoner.jpg";
    public static final String CHARACTER_SELECTION_SNEAK = DIR_SPRITES + "cs_sneak.jpg";
    public static final String CHARACTER_SELECTION_BACKGROUND = DIR_SPRITES + "main_menu_background.jpg";
    
    /*** CHARACTER SELECTION VIEW PORT ***/
    public static final String INTRO_BACKGROUND = DIR_SPRITES + "dialogue_background.jpg";
    
     /*** GAME VIEW SELECTION VIEW PORT ***/   
    public static final String GAME_BACKGROUND = DIR_SPRITES + "dialogue_background.jpg";
    
    /*** CHARACTER SELECTION VIEW PORT ***/
    public static final String SKILLS_DECAL = DIR_DECALS + "GoldStart.png";
    
     /*** STATISTIC VIEW PORT ***/ 
    public static final String STATS_LIVES_LEFT_DECAL = DIR_SPRITES + "st_lives_left.png";
    public static final String STATS_OFFESIVE_RATING_DECAL = DIR_SPRITES + "st_offensive_rating.png";
    public static final String STATS_DEFENSIVE_RATING_DECAL = DIR_SPRITES + "st_defensive_rating.png";
    public static final String STATS_ARMOR_RATING_DECAL = DIR_SPRITES + "st_armor_rating.png";
    public static final String STATS_ARMOR_DECAL = DIR_SPRITES + "st_equipped_weapon.png";
    public static final String STATS_EQUIPPED_WEAPON_DECAL = DIR_SPRITES + "st_armor.png";
    public static final String STATS_MANA_DECAL = DIR_SPRITES + "st_mana.png";
    public static final String STATS_AGILITY_DECAL = DIR_SPRITES + "st_agility.png";
    public static final String STATS_LEVEL_DECAL = DIR_SPRITES + "st_level.png";
    public static final String STATS_MOVEMENT_DECAL = DIR_SPRITES + "st_movement.png";
    public static final String STATS_STRENGTH_DECAL = DIR_SPRITES + "st_strength.png";
    public static final String STATS_EXPERIENCE_DECAL = DIR_SPRITES + "st_experience.png";
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
            image = assets.get(NULL_ASSET);
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
    /**
     * Get a rescaled version of an image asset.
     * @param fileName The asset filename to get
     * @param width The final width of the image as an integer
     * @param height The final height of the image as an integer
     * @return The resultant, scaled image
     */
    public static ImageIcon getImage(String fileName, int width, int height){
        return new ImageIcon(scale(width, height, getImage(fileName).getImage()));
    }
    
    private static BufferedImage scale(int width, int height, Image image) {
            return (BufferedImage)getScaledImage(image, width, height);
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
        assets.put(NULL_ASSET, im_null);

        initialized = true;
    }
}
