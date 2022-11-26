package WorldObject;

import character.Character;
import game.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.event.ChangeEvent;
import java.io.File;
import java.io.IOException;

public class OBJ_Sword_Normal extends Character {

    File f1 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/objects/sword_img.png");


    public OBJ_Sword_Normal(GamePanel gp) {
        super(gp);
        type = type_sword;
        name = "Red Crystal Katana";
        attackValue = 2;
        attackArea.width = 24;
        attackArea.height = 24;
        description = "[" + name + "]\nIsn't the fastest \nbut it deals some damage.";

        try {
            objImage = ImageIO.read(f1);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
