package WorldObject;

import character.Character;
import character.Projectile;
import game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OBJ_Shockball extends Projectile {
    GamePanel gp;



    public OBJ_Shockball(GamePanel gp) {
        super(gp);
        this.gp = gp;
       // type=type_projectile;
        name = "ShockBall";
        speed = 10;
        maxLife = 80;
        life = maxLife;
        attack = 3 ;
        useCost = 1;
        alive = false;
        getImage();

    }
    File f1 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/projectiles/shock_ball_up_1.png");
    File f2 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/projectiles/shock_ball_up_2.png");
    File f3 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/projectiles/shock_ball_down_1.png");
    File f4 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/projectiles/shock_ball_down_2.png");
    File f5 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/projectiles/shock_ball_left_1.png");
    File f6 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/projectiles/shock_ball_left_2.png");
    File f7 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/projectiles/shock_ball_right_1.png");
    File f8 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/projectiles/shock_ball_right_2.png");

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
    public boolean haveResource(Character user){
        boolean haveResource = false;
        if( user.mana >= useCost ){
            haveResource = true;
        }
        return  haveResource;
    }
    public void subtractResource(Character user){
        user.mana -= useCost;

    }
    public Color getParticleColor(){
        Color color = new Color(240,50,0);
        return color;
    }
    public int getParticleSize(){
        int size = 10;
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
