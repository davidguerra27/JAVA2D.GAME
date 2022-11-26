package WorldObject;

import character.Character;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OBJ_Juice extends Character {

    File juice1 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/objects/juice_vial.png");
    int value = 1;

    public OBJ_Juice(GamePanel gp){
        super(gp);
        type = type_consumable;
        name = "Juice vial";

        direction = "down";
        description = "[" + name + "]\nIncreases your Juice by "+ value + ".";
        solidArea.x = 4;
        solidArea.y = 10;
        solidArea.width = 60;
        solidArea.height = 54;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        try {
            objImage = ImageIO.read(juice1);
        }
        catch (IOException e)  {
            e.printStackTrace();
        }


    }
    public void use(Character character){
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You take the " + name + "!\n"
                +value+" units have been restored!";
        character.mana += value;
        if(gp.player.life > gp.player.maxLife){
            gp.player.life = gp.player.maxLife;
        }
        gp.playSE(5);
    }
}
