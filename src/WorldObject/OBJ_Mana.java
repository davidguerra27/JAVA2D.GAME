package WorldObject;

import character.Character;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OBJ_Mana extends Character {
    GamePanel gp;
    File mana1 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/objects/mana_bar_1.png");
    File mana2 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/objects/mana_bar_empty.png");

    public OBJ_Mana(GamePanel gp) {
        super(gp);
        this.gp = gp;

        name = "Mana";

        try {
            image = ImageIO.read(mana1);
            image2 = ImageIO.read(mana2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
