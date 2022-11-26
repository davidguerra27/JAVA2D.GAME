package WorldObject;

import character.Character;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OBJ_AmphetamineRed extends Character {
    File amph1 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/objects/amph_vial.png");
    int value = 5;

    public OBJ_AmphetamineRed(GamePanel gp){
        super(gp);
        type = type_consumable;
        name = "Amphetamine vial";

        direction = "down";
        description = "[" + name + "]\nHeals your life by "+ value + ".";
        solidArea.x = 4;
        solidArea.y = 10;
        solidArea.width = 60;
        solidArea.height = 54;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        try {
            objImage = ImageIO.read(amph1);
        }
        catch (IOException e)  {
            e.printStackTrace();
        }


    }
    public void use(Character character){
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You take the " + name + "!\n"
                +value+" life points have been restored!";
        character.life += value;
        if(gp.player.life > gp.player.maxLife){
            gp.player.life = gp.player.maxLife;
        }
        gp.playSE(5);
    }
}
