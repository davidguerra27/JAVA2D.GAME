package WorldObject;

import character.Character;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OBJ_PurpleAxe extends Character {
    File axePurple = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/objects/purple_axe.png");

    public OBJ_PurpleAxe(GamePanel gp){
        super(gp);

        name = "Purple Axe";
        type = type_axe;
        direction = "down";
        attackValue = 3;
        attackArea.width = 18;
        attackArea.height = 18;
        description = "[" + name + "]\nUse it to cut trees..or humans..";
        solidArea.x = 4;
        solidArea.y = 10;
        solidArea.width = 60;
        solidArea.height = 54;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        try {
            objImage = ImageIO.read(axePurple);
        }
        catch (IOException e)  {
            e.printStackTrace();
        }


    }
}
