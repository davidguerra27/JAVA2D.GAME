package tile_interactive;

import character.Character;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class IT_DryTree extends InteractiveTile{
    GamePanel gp;
    File tree = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles_interactive/cut_tree_1.png");



    public IT_DryTree(GamePanel gp, int col, int row) {
        super(gp, col, row);
        this.gp = gp;
        this.worldX = gp.tileSize * col;
        this.worldY = gp.tileSize * row;

        direction = "down";
        type = type_destructible;


        try {
            objImage = ImageIO.read(tree);
            destructible = true;
            life = 3;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 54;
        solidArea.height = 54;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

    }
    public boolean isCorrectItem(Character character){
        boolean isCorrectItem = false;
        if(character.currentWeapon.type == type_axe){
            isCorrectItem = true;
        }
        return isCorrectItem;
    }
    public void playSE(){
        gp.playSE(3);
    }
    public InteractiveTile getDestroyedForm(){
        InteractiveTile tile = new IT_Root(gp, worldX/gp.tileSize, worldY/gp.tileSize);
        return tile;
    }
    public Color getParticleColor(){
        Color color = new Color(148,0,211);
        return color;
    }
    public int getParticleSize(){
        int size = 5;
        return size;
    }
    public int getParticleSpeed(){
        int speed = 1;
        return speed;
    }
    public int getParticleMaxLife(){
        int maxLife = 20;
        return maxLife;
    }
}
