package WorldObject;

import character.Projectile;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OBJ_Acid extends Projectile {
    GamePanel gp;



    public OBJ_Acid(GamePanel gp) {
        super(gp);
        this.gp = gp;
        // type=type_projectile;
        name = "AcidBall";
        speed = 5;
        maxLife = 80;
        life = maxLife;
        attack = 2;
        useCost = 1;
        alive = false;
        getImage();

    }
    File f1 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/projectiles/mushroom_acid_ball_1.png");
    File f2 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/projectiles/mushroom_acid_ball_1.png");
    File f3 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/projectiles/mushroom_acid_ball_1.png");
    File f4 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/projectiles/mushroom_acid_ball_1.png");
    File f5 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/projectiles/mushroom_acid_ball_1.png");
    File f6 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/projectiles/mushroom_acid_ball_1.png");
    File f7 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/projectiles/mushroom_acid_ball_1.png");
    File f8 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/projectiles/mushroom_acid_ball_1.png");

    public void getImage(){
        try {

            up1 = ImageIO.read(f1);
            up2 = ImageIO.read(f2);
            down1 = ImageIO.read(f3);
            down2 = ImageIO.read(f4);
            left1 = ImageIO.read(f5);
            left2 = ImageIO.read(f6);
            right1 = ImageIO.read(f7);
            right2 = ImageIO.read(f8);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Color getParticleColor(){
        Color color = new Color(0,255,0);
        return color;
    }
    public int getParticleSize(){
        int size = 5 ;
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
