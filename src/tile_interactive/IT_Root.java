package tile_interactive;

import game.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class IT_Root extends InteractiveTile{

    GamePanel gp;
    File root = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles_interactive/dry_tree_2.png");


    public IT_Root(GamePanel gp, int col, int row) {
        super(gp, col, row);
        this.gp = gp;
        this.worldX = gp.tileSize * col;
        this.worldY = gp.tileSize * row;

        direction = "down";
        type = type_destructible;


        try {
            objImage = ImageIO.read(root);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        solidArea.x = 20;
        solidArea.y = 20;
        solidArea.width = 2;
        solidArea.height = 2;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
