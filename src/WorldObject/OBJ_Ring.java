package WorldObject;

import character.Character;
import character.Graphics2D;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class OBJ_Ring extends Character {

    File ring1 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/objects/ring1.png");

    public OBJ_Ring(GamePanel gp){
        super(gp);

        name = "Ring";
        type = 3;
        direction = "down";
        description = "[" + name + "]\nUse it to open gates or doors..";
        solidArea.x = 4;
        solidArea.y = 10;
        solidArea.width = 60;
        solidArea.height = 54;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        try {
            objImage = ImageIO.read(ring1);
        }
        catch (IOException e)  {
            e.printStackTrace();
        }


    }

}
