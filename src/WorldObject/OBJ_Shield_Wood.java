package WorldObject;

import character.Character;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OBJ_Shield_Wood extends Character {

    File f1 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/objects/shield_img.png");
    public OBJ_Shield_Wood(GamePanel gp) {


        super(gp);

        name = "Basic Shield";
        defenseValue = 1;
        description = "[" + name + "]\nIt's better than nothing...";

        try {
            objImage = ImageIO.read(f1);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
