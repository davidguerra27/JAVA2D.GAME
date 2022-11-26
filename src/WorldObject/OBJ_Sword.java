package WorldObject;

import character.Character;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;



public class OBJ_Sword extends Character {

    File sword1 = new File("src/res/objects/weapon_final1.png");
    GamePanel gp;
    public OBJ_Sword(GamePanel gp){
        super(gp);

        name = "Sword";
        attack = 2;
        try {
            image = ImageIO.read(sword1);
        }
        catch (IOException e)  {
            e.printStackTrace();
        }

    }
}
