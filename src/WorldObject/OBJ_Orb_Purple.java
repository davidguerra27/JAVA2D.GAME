package WorldObject;

import character.Character;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OBJ_Orb_Purple extends Character {

    GamePanel gp;
    File orb1 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/objects/orb_1.png");
    int value = 1;
    public OBJ_Orb_Purple(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_pickUpOnly;
        name = "Purple Orb";
        direction = "down";

        solidArea.x = 4;
        solidArea.y = 10;
        solidArea.width = 60;
        solidArea.height = 54;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        try {
            objImage = ImageIO.read(orb1);
        }
        catch (IOException e)  {
            e.printStackTrace();
        }

    }
    public void use(Character character){
       gp.playSE(1);
       gp.ui.addMessage("Orb +" + value);
       gp.player.orb += value;
    }
}
