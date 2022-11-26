package WorldObject;

import character.Character;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OBJ_RedBow extends Character {
    File axePurple = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/objects/red_bow.png");

    public OBJ_RedBow(GamePanel gp){
        super(gp);

        name = "Red Bow";
        type = type_axe;
        direction = "down";
        attackValue = 2;
        attackArea.width = 18;
        attackArea.height = 18;
        description = "[" + name + "]\nUse it to hunt animals..\n... or humans...";
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
