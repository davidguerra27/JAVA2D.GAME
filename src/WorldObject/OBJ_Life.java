package WorldObject;

import character.Character;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

public class OBJ_Life extends Character {
    GamePanel gp;
    File life1 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/objects/empty_bar_2.png");
    File life2 = new File("src/res/objects/quarter_bar.png");
    File life3 = new File("src/res/objects/half_bar.png");
    File life4 = new File("src/res/objects/three_quarter_bar.png");
    File life5 = new File("src/res/objects/full_bar.png");
    public OBJ_Life(GamePanel gp){
        super(gp);

        name = "Life";
        try {
            image = ImageIO.read(life1);
            /*image2 = ImageIO.read(life2);
            image3= ImageIO.read(life3);
            image4 = ImageIO.read(life4);
            image5 = ImageIO.read(life5);*/
        }
        catch (IOException e)  {
            e.printStackTrace();
        }


    }

}
