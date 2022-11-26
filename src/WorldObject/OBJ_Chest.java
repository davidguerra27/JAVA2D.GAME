package WorldObject;

import character.Character;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OBJ_Chest extends Character {

    File chest1 = new File("src/res/objects/small_chest_1.png");

    public OBJ_Chest(GamePanel gp){
        super(gp);

        name = "Chest";
        try {
            image = ImageIO.read(chest1);
        }
        catch (IOException e)  {
            e.printStackTrace();
        }

    }
}
