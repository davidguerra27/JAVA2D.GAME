package character;
import java.awt.*;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import WorldObject.*;
import game.GamePanel;
import game.KeyHandler;
import game.Sound;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Player extends Character{

    KeyHandler keyH;
    Sound sound = new Sound();






    public final int screenX;
    public final int screenY;
    public boolean attackCancel = false;
    public ArrayList<Character> inventory = new ArrayList<>();
    public int maxInventorySize = 20;




    public Player(GamePanel gp,  KeyHandler keyH){

        super(gp);

        this.keyH = keyH;


        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 28;
        solidArea.y = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 12;
        solidArea.height = 16;



        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();
        setItems();







    }



    public void setDefaultValues(){
        worldX = gp.tileSize*24;
        worldY = gp.tileSize*22;
        speed=3;
        direction = "down";


        //PLAYER STATUS
        level = 1;
        maxLife = 4;
        life = maxLife;
        maxMana = 3;
        mana = maxMana;
        strength = 1;//the more strength player has, more damage he gives
        dexterity = 1;//the more dexterity player has, less damage he recieves
        exp = 0;
        nextLevelExp = 5;
        orb = 0;

        currentWeapon = new OBJ_Sword_Normal(gp);
        currentShield = new OBJ_Shield_Wood(gp);
        projectile = new OBJ_Shockball(gp);
        attack = getAttack();//strength and weapon
        defense = getDefense();//dexterity and shield

    }
    public void setItems(){
        inventory.add(currentWeapon);
        inventory.add(currentShield);
        inventory.add(new OBJ_Ring(gp));




    }
    public int getAttack(){

        attackArea = currentWeapon.attackArea;

        return attack = strength * currentWeapon.attackValue;
    }
    public int getDefense(){
        return defense = strength * currentShield.defenseValue;
    }
    File f1 = new File("src/res/player2/player_back_1.png");
    File f2 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_back_2.png");
    File f3 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_front_1.png");
    File f4 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_front_2.png");
    File f5 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_left_1.png");
    File f6 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_left_2.png");
    File f7 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_right_1.png");
    File f8 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_right_2.png");
    //ATTACK
    File f9 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_attack_back_1.png");
    File f10 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_attack_back_2.png");
    File f11 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_attack_back_3.png");
    File f12 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_attack_front_1.png");
    File f13 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_attack_front_2.png");
    File f14 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_attack_front_3.png");
    File f15 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_attack_left_1.png");
    File f16 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_attack_left_2.png");
    File f17 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_attack_left_3.png");
    File f18 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_attack_right_1.png");
    File f19 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_attack_right_2.png");
    File f20 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_attack_right_3.png");

    File f21 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_axe_back_1.png");
    File f22 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_axe_back_2.png");
    File f23 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_axe_front_1.png");
    File f24 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_axe_front_2.png");
    File f25 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_axe_left_1.png");
    File f26 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_axe_left_2.png");
    File f27 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_axe_right_1.png");
    File f28 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/player2/player_axe_right_2.png");



    public void getPlayerImage(){
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
    public void getPlayerAttackImage(){
        if(currentWeapon.type == type_sword){
            try {
                attackUp1 = ImageIO.read(f9);
                attackUp2 = ImageIO.read(f10);
                attackUp3 = ImageIO.read(f11);
                attackDown1 = ImageIO.read(f12);
                attackDown2 = ImageIO.read(f13);
                attackDown3 = ImageIO.read(f14);
                attackLeft1 = ImageIO.read(f15);
                attackLeft2 = ImageIO.read(f16);
                attackLeft3 = ImageIO.read(f17);
                attackRight1 = ImageIO.read(f18);
                attackRight2 = ImageIO.read(f19);
                attackRight3 = ImageIO.read(f20);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(currentWeapon.type == type_axe){
            try {
                attackUp1 = ImageIO.read(f1);
                attackUp2 = ImageIO.read(f22);
                attackUp3 = ImageIO.read(f21);
                attackDown1 = ImageIO.read(f3);
                attackDown2 = ImageIO.read(f23);
                attackDown3 = ImageIO.read(f24);
                attackLeft1 = ImageIO.read(f5);
                attackLeft2 = ImageIO.read(f25);
                attackLeft3 = ImageIO.read(f26);
                attackRight1 = ImageIO.read(f7);
                attackRight2 = ImageIO.read(f27);
                attackRight3 = ImageIO.read(f28);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    
    public void update() {
        if(attacking == true){
            attacking();
        }
        else if(keyH.upPressed == true ||keyH.downPressed == true ||
        keyH.leftPressed == true ||keyH.rightPressed == true || keyH.enterPressed == true){
            if(keyH.upPressed == true){
                direction = "up";

            }
            else if(keyH.downPressed == true){
                direction = "down";

            }
            else if(keyH.leftPressed == true){
                direction = "left";

            }
            else if(keyH.rightPressed == true){
                direction = "right";

            }
            //CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this,true);
            pickUpObject(objIndex);

            //CHECK NPC COLLISION
            int npcIndex = gp.cChecker.checkCharacter(this,gp.npc);
            interactNPC(npcIndex);

            //CHECK MONSTER COLLISION
            int monsterIndex = gp.cChecker.checkCharacter(this,gp.monster);
            contactMonster(monsterIndex);
            //CHECK INTERACTIVE TILE COLLISION
            int iTileIndex = gp.cChecker.checkCharacter(this, gp.iTile);

            //CHECK EVENT COLLISION
            gp.eHandler.checkEvent();



            //IF COLLISION IS FALSE,PLAYER CAN MOVE
            if(collisionOn == false && keyH.enterPressed == false){

                switch(direction){
                    case "up":worldY -=speed;break;
                    case "down":worldY +=speed;break;
                    case "left":worldX -=speed;break;
                    case "right":worldX +=speed;break;

                }
            }

            if(keyH.enterPressed == true && attackCancel == false){
                gp.playSE(6);
                attacking = true;
                spriteCounter = 0;

            }
            attackCancel = false;
            gp.keyH.enterPressed = false;
            spriteCounter++;

            if(spriteCounter > 12){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }

            spriteCounter = 0;
            }
        }

        if(gp.keyH.shootKeyPressed == true && projectile.alive == false
                && shotAvailableCounter == 30 && projectile.haveResource(this)== true){

            //SET DEFAULT COORDINATES;DIRECTION;AND USER
            projectile.set(worldX,worldY,direction,true,this);
            //SUBTRACT THE COST
            projectile.subtractResource(this);
            // ADD IT TO THE LIST
            gp.projectileList.add(projectile);
            shotAvailableCounter = 0;

            gp.playSE(6);

        }
        if(invincible == true){
            invincibleCounter++;
            if(invincibleCounter > 60){
                invincible = false;
                invincibleCounter = 0;
            }
        }
        if( shotAvailableCounter < 30){
            shotAvailableCounter++;
        }
        
    }

    public void attacking(){
        spriteCounter++;

        if( spriteCounter <= 5){
            spriteNum = 1;
        }
        if( spriteCounter > 5 && spriteCounter <= 10){
            spriteNum = 2;
            //SAVE THE PLAYERS ORIGINAL POSITION(solid area)
            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int soledAreaHeight = solidArea.height;
            //ADJUST THE POSITION(solid area) DURING ATTACK
            switch(direction){
                case "up":worldY -= attackArea.height;break;
                case "down":worldY += attackArea.height;break;
                case "left":worldX -= attackArea.width;break;
                case "right":worldX += attackArea.width;break;

            }
            //ATTACK AREA BECOMES SOLID AREA
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;
            //CHECK MONSTER COLLISION WITH THE PLAYERS NEW POSITION
            int monsterIndex = gp.cChecker.checkCharacter(this,gp.monster);
            damageMonster(monsterIndex, attack);

            int iTileIndex = gp.cChecker.checkCharacter(this, gp.iTile);
            damageInteractiveTile(iTileIndex);

            //RESTORE ORIGINAL VALUES
            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = soledAreaHeight;

        }
        if( spriteCounter > 10 && spriteCounter <= 20){
            spriteNum = 3;
        }
        if( spriteCounter > 30){
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
        }

    }
    public void pickUpObject(int i){

        if(i != 999){

            //PICK UP ONLY ITEMS

            if(gp.obj[i].type == type_pickUpOnly){
                gp.obj[i].use(this);
                gp.obj[i] = null;
            }
            //INVENTORY ITEMS
            else{
                String text;
                if(inventory.size() != maxInventorySize){
                    inventory.add(gp.obj[i]);
                    gp.playSE(5);
                    text = "Found a "+ gp.obj[i].name + "!";
                }
                else{
                    text = "You cannot carry more weight!";
                }
                gp.ui.addMessage(text);
                gp.obj[i] = null;
            }
        }
    }
    public void interactNPC(int i){
        if(gp.keyH.enterPressed == true){

            if(i != 999){
                attackCancel = true;
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
        }


    }
    public void contactMonster(int i){
        if(i != 999){

            if( invincible == false && gp.monster[i].dying == false ){
                gp.playSE(5);

                int damage = gp.monster[i].attack - defense;
                if( damage < 0){
                    damage = 0;
                }
                life -= damage;
                gp.ui.addMessage(damage + " damage received");
                invincible = true;
            }

        }
    }
    public void damageMonster(int i, int attack){
        if( i != 999){
            if(gp.monster[i].invincible == false){
                gp.playSE(4);

                int damage = attack - gp.monster[i].defense;
                if( damage < 0){
                    damage = 0;
                }
                gp.monster[i].life -= damage;
                gp.ui.addMessage(damage + " damage");
                gp.monster[i].invincible = true;
                gp.monster[i].damageReaction();

                if(gp.monster[i].life <= 0){
                    gp.monster[i].dying = true;
                    gp.ui.addMessage("killed the " + gp.monster[i].name +"!");
                    gp.ui.addMessage("Exp  +" + gp.monster[i].exp);
                    exp += gp.monster[i].exp;
                    checkLevelUp();
                }
            }
        }
    }
    public void damageInteractiveTile(int i){

        if(i != 999 && gp.iTile[i].destructible == true &&
                gp.iTile[i].isCorrectItem(this) == true &&
                gp.iTile[i].invincible == false){

            gp.iTile[i].life--;
            gp.iTile[i].invincible = true;
            generateParticle(gp.iTile[i],gp.iTile[i]);

            if( gp.iTile[i].life == 0){
                gp.iTile[i].playSE();
                gp.iTile[i] = gp.iTile[i].getDestroyedForm();
            }

        }

    }
    public void checkLevelUp(){
        if(exp >= nextLevelExp){
            level++;
            nextLevelExp = nextLevelExp*2;

            maxLife += 2;
            life = maxLife;
            mana = maxMana;
            strength++;
            dexterity++;
            attack = getAttack();
            defense = getDefense();
            gp.playSE(7);
            gp.gameState = gp.dialogueState;
            gp.ui.currentDialogue = "You have level up! you are currently ate level "+ level +".";
        }
    }
    public void selectItem(){
        int itemIndex = gp.ui.getItemIndexSlot();

        if(itemIndex < inventory.size()){
            Character selectedItem = inventory.get(itemIndex);

            if(selectedItem.type == type_sword || selectedItem.type == type_axe){
                currentWeapon = selectedItem;
                attack = getAttack();
                getPlayerAttackImage();

            }
            if( selectedItem.type == type_shield){
                currentShield = selectedItem;
                defense = getDefense();

            }
            if( selectedItem.type == type_consumable){
                selectedItem.use(this);
                inventory.remove(itemIndex);
            }
        }
    }

    public void draw(Graphics2D g2){

        BufferedImage image = null;

        switch(direction){

            case "up":
                if(attacking == false){
                    if(spriteNum ==1){ image = up1;}
                    if(spriteNum == 2){ image = up2;}
                }
                if(attacking == true){
                    if(spriteNum ==1){ image = attackUp1;}
                    if(spriteNum == 2){ image = attackUp2;}
                    if(spriteNum == 3){ image = attackUp3;}
                }
                break;
            case "down":
                if(attacking == false){
                    if(spriteNum == 1){image = down1;}
                    if(spriteNum == 2){image = down2;}
                }
                if(attacking == true){
                    if(spriteNum ==1){ image = attackDown1;}
                    if(spriteNum == 2){ image = attackDown2;}
                    if(spriteNum == 3){ image = attackDown3;}
                }

                break;
            case "left":
                if( attacking == false){
                    if(spriteNum == 1){image = left1;}
                    if(spriteNum == 2){image = left2;}
                }
                if(attacking == true){
                    if(spriteNum ==1){ image = attackLeft1;}
                    if(spriteNum == 2){ image = attackLeft2;}
                    if(spriteNum == 3){ image = attackLeft3;}
                }
                break;
           case "right":
               if(attacking == false){
                   if(spriteNum == 1){image = right1;}
                   if(spriteNum == 2){image = right2;}
               }
               if(attacking == true){
                   if(spriteNum ==1){ image = attackRight1;}
                   if(spriteNum == 2){ image = attackRight2;}
                   if(spriteNum == 3){ image = attackRight3;}
               }
                break;
        }
        if( invincible == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }
        g2.drawImage(image , screenX , screenY , gp.tileSize , gp.tileSize , null);
        //RESET THE TRANSPARENCY
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));


        //DEBUG TEST
        /*g2.setFont(new Font("Arial",Font.BOLD,26));
        g2.setColor(Color.WHITE);
        g2.drawString("invicible : "+invincibleCounter,10,400);*/
    }
}
