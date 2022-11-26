package character;

import game.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class NCP_OldMan extends Character{

    public NCP_OldMan(GamePanel gp){
        super(gp);

        direction = "down";
        speed = 1;
        getImage();
        setDialogue();
    }
    File f1 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/npc/wizardFront1.png");
    File f2 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/npc/wizardFront1.png");
    File f3 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/npc/wizardBack1.png");
    File f4 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/npc/wizardBack2.png");
    File f5 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/npc/wizardLeft1.png");
    File f6 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/npc/wizardLeft2.png");
    File f7 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/npc/wizardLeft1.png");
    File f8 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/npc/wizardLeft2.png");

    public void getImage(){
        try{
            up1 = ImageIO.read(f3);
            up2 = ImageIO.read(f4);
            down1 = ImageIO.read(f1);
            down2 = ImageIO.read(f2);
            left1 = ImageIO.read(f5);
            left2 = ImageIO.read(f6);
            right1 = ImageIO.read(f7);
            right2 = ImageIO.read(f8);



        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setDialogue(){
        dialogues[0] = "OLD MAN: (burp) FUCK ME!! You scared me fella!";
        dialogues[1] = "OLD MAN: You don't seem to be from around here...";
        dialogues[2] = "OLD MAN: I guess you're just as lost as the rest of us...";
        dialogues[3] = "OLD MAN: You don't want to stick around for long...";
        dialogues[4] = "OLD MAN: Ever since the bombs went off our humanity went along\n with them...All that's left is a corpse of a fucking broken society...";
        dialogues[5] = "OLD MAN: ...and the mutants of course...";
        dialogues[6] = "OLD MAN: (sigh)...so many of them...";
        dialogues[7] = "OLD MAN: Here is something that will help you\n kill those bastards quickly! Good Luck stranger!";

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

    }
    public void speak(){
        super.speak();
    }

}
