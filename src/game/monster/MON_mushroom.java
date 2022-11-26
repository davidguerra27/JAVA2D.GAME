package game.monster;

import WorldObject.OBJ_Acid;
import WorldObject.OBJ_AmphetamineRed;
import WorldObject.OBJ_Juice;
import WorldObject.OBJ_Orb_Purple;
import character.Character;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MON_mushroom extends Character {

    public MON_mushroom(GamePanel gp) {
        super(gp);
        type = type_monster;
        name = "Poison Mushroom";
        speed = 1;
        maxLife = 20;
        life = maxLife;
        attack = 3;
        defense = 0;
        exp = 2;
        projectile = new OBJ_Acid(gp);

        solidArea.x = 4;
        solidArea.y = 10;
        solidArea.width = 60;
        solidArea.height = 54;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        getImage();
    }

    File f1 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/monsters/mushroom_back_1.png");
    File f2 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/monsters/mushroom_back_2.png");
    File f3 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/monsters/mushroom_front_1.png");
    File f4 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/monsters/mushroom_front_2.png");
    File f5 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/monsters/mushroom_left_1.png");
    File f6 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/monsters/mushroom_left_2.png");
    File f7 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/monsters/mushroom_right_1.png");
    File f8 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/monsters/mushroom_right_2.png");

    public void getImage(){
        try{
            up1 = ImageIO.read(f1);
            up2 = ImageIO.read(f2);
            down1 = ImageIO.read(f3);
            down2 = ImageIO.read(f4);
            left1 = ImageIO.read(f5);
            left2 = ImageIO.read(f6);
            right1 = ImageIO.read(f7);
            right2 = ImageIO.read(f8);



        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setAction(){

        actionLockCounter++;
        if( actionLockCounter == 120){
            Random random = new Random();
            int i = random.nextInt(100)+1;

            if( i <= 25) {
                direction = "up";
            }
            if( i > 25 && i <= 50){
                direction = "down";
            }
            if(i > 50 && i <= 75){
                direction = "left";
            }
            if( i > 75){
                direction = "right";
            }
            actionLockCounter = 0;

        }
        int i = new Random().nextInt(100)+1;
        if( i > 99 && projectile.alive == false && shotAvailableCounter == 30){
            projectile.set(worldX,worldY,direction,true,this);
            gp.projectileList.add(projectile);
            shotAvailableCounter = 0;
        }
    }
    public void damageReaction(){
        actionLockCounter = 0;
        direction = gp.player.direction;

    }
    public void checkDrop(){

        int i = new Random().nextInt(100)+1;
        //SET THE MONSTER DROP
        if( i < 60){
            dropItem(new OBJ_Orb_Purple(gp));
        }
        if( i >= 60 && i < 80){
            dropItem(new OBJ_Juice(gp));
        }
        if( i >= 80 && i < 100){
            dropItem(new OBJ_AmphetamineRed(gp));
        }

    }
}
