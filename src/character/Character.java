package character;

import game.GamePanel;

import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Character {
    public GamePanel gp;


    public Rectangle solidArea = new Rectangle(0, 0 , 64 ,64);
    public Rectangle attackArea = new Rectangle(0,0,0,0);
    public BufferedImage appear1,appear2,appear3,fire1,fire2,fire3;
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    public BufferedImage attackUp1, attackUp2, attackUp3,
            attackDown1,attackDown2,attackDown3,
            attackLeft1,attackLeft2,attackLeft3,
            attackRight1,attackRight2,attackRight3;
    public BufferedImage objImage,image,image2,image3,image4,image5;
    public int solidAreaDefaultX , solidAreaDefaultY;
    public boolean collision;
    String dialogues[] = new String[20];
    //STATE
    public int worldX, worldY;
    int dialogueIndex = 0;
    public String direction = "down";
    public int spriteNum =1;


    public boolean collisionOn = false;
    public boolean invincible = false;

    public boolean attacking = false;
    public boolean alive = true;
    public boolean dying = false;
    public boolean hpBarOn = false;


    //COUNTERS
    public int spriteCounter = 0;
    public int actionLockCounter;

    public int invincibleCounter = 0;
    public int shotAvailableCounter = 0;
    public int dyingCounter = 0;
    public int hpBarCounter = 0;




    // CHARACTER ATTRIBUTES

    public String name;
    public int maxLife;
    public int life;
    public int maxMana;
    public int mana;
    public int speed;
    public int level;
    public int strength;
    public int dexterity;
    public int attack;
    public int defense;
    public int exp;
    public int nextLevelExp;
    public int orb;

    public Character currentWeapon;
    public Character currentShield;
    public Projectile projectile;

    //ITEM ATTRIBUTES
    public int attackValue;
    public int defenseValue;
    public String description = "";
    public int useCost;
    //TYPE
    public int type; // 0 = player, 1 = npc, 2 = monster, 3 = object;
    public final int type_player = 0;
    public final int type_npc = 1;
    public final int type_monster = 2;
    public final int type_obj = 3;
    public final int type_sword = 4;
    public final int type_axe = 5;
    public final int type_shield = 6;
    public final int type_consumable = 7;

    public final int type_pickUpOnly = 8;
    public final int type_destructible = 9;
    public final int type_particle = 10;



    public Character(GamePanel gp){
        this.gp =gp;
    }
    public void setAction(){

    }
    public void damageReaction(){}
    public void speak(){
        if( dialogues[dialogueIndex] == null){
            dialogueIndex = 0;
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;

        switch (gp.player.direction){
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;
        }
    }
    public void use(Character character){};
    public void checkDrop(){
    }
    public void dropItem(Character droppedItem ){
        for( int i= 0 ; i < gp.obj.length ; i++){
            if(gp.obj[i] == null){
                gp.obj[i] = droppedItem;
                gp.obj[i].worldX = worldX;//DEAD MONSTER?S WORLDX
                gp.obj[i].worldY = worldY;//DEAD MONSTER?S WORLDY
                break;
            }
        }
    }
    public Color getParticleColor(){
        Color color = null;
        return color;
    }
    public int getParticleSize(){
        int size = 0;
        return size;
    }
    public int getParticleSpeed(){
        int speed = 0;
        return speed;
    }
    public int getParticleMaxLife(){
        int maxLife = 0;
        return maxLife;
    }
    public void generateParticle(Character generator, Character target){
        Color color = generator.getParticleColor();
        int size = generator.getParticleSize();
        int speed = generator.getParticleSpeed();
        int maxLife = generator.getParticleMaxLife();

        Particle p1 = new Particle(gp, target, color, size, speed, maxLife,-2,-1);
        Particle p2 = new Particle(gp, target, color, size, speed, maxLife,2,-1);
        Particle p3 = new Particle(gp, target, color, size, speed, maxLife,-2,1);
        Particle p4 = new Particle(gp, target, color, size, speed, maxLife,2,1);
        gp.particleList.add(p1);
        gp.particleList.add(p2);
        gp.particleList.add(p3);
        gp.particleList.add(p4);
    }
    public void update() {
        setAction();

        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkCharacter(this, gp.npc);
        gp.cChecker.checkCharacter(this, gp.monster);
        gp.cChecker.checkCharacter(this, gp.iTile);
        boolean contactPlayer = gp.cChecker.checkPlayer(this);

        if (this.type == type_monster && contactPlayer == true) {
            damagePlayer(attack);
        }

        if (collisionOn == false) {


            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;

            }

            if (life <= 0) {
                alive = false;
            }
        }


                spriteCounter++;

                if (spriteCounter > 12) {
                    if (spriteNum == 1) {
                        spriteNum = 2;
                    } else if (spriteNum == 2) {
                        spriteNum = 1;
                    }

                    spriteCounter = 0;
                }
                if (invincible == true) {
                    invincibleCounter++;
                    if (invincibleCounter > 10) {
                        invincible = false;
                        invincibleCounter = 0;
                    }
                }
        if( shotAvailableCounter < 30){
            shotAvailableCounter++;
        }

    }
    public void damagePlayer(int attack){
        if (gp.player.invincible == false) {
            gp.playSE(5);

            int damage = attack - gp.player.defense;
            if (damage < 0) {
                damage = 0;
            }

            gp.player.life -= damage;
            gp.player.invincible = true;
        }
    }
    public void draw(Graphics2D g2){

        BufferedImage image = null;

        int screenX = worldX -gp.player.worldX + gp.player.screenX;
        int screenY = worldY -gp.player.worldY + gp.player.screenY;

        if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

            switch(direction){

                case "up":
                    if(spriteNum ==1){image = up1;}
                    if(spriteNum == 2){image = up2;}
                    break;
                case "down":
                    if(spriteNum == 1){image = down1;}
                    if(spriteNum == 2){image = down2;}
                    break;
                case "left":
                    if(spriteNum == 1){image = left1;}
                    if(spriteNum == 2){image = left2;}
                    break;
                case "right":
                    if(spriteNum == 1){image = right1;}
                    if(spriteNum == 2){image = right2;}
                    break;
            }
            if(type == type_obj || type == type_consumable ||
                    type == type_pickUpOnly ||
                    type == type_destructible ){
                g2.drawImage(objImage,screenX,screenY,gp.tileSize,gp.tileSize,null);

            }
            if(type == type_sword){
                g2.drawImage(objImage,screenX,screenY,gp.tileSize/2,gp.tileSize/2,null);

            }
            if(type == type_axe){
                g2.drawImage(objImage,screenX,screenY,gp.tileSize/2,gp.tileSize/2,null);
                System.out.println("draw");
            }

        }


            //MONSTER HEALTH BAR
            if(type == type_monster && hpBarOn == true){

                double oneScale = (double)gp.tileSize/maxLife;
                double hpBarValue = oneScale*life;

                g2.setColor(new Color(25,25,25));
                g2.fillRect(screenX-1,screenY-16,gp.tileSize+2,7);
                g2.setColor(new Color(200,0,255));
                g2.fillRect(screenX,screenY - 15,(int)hpBarValue,5);

                hpBarCounter++;
                if( hpBarCounter > 600){
                    hpBarCounter = 0;
                    hpBarOn = false;
                }
            }

            if( invincible == true){
                hpBarOn = true;
                hpBarCounter = 0;
                changeAlpha(g2,0.4f);

            }
            if(dying == true){
                dyingAnimation(g2);
            }
            g2.drawImage(image , screenX , screenY , gp.tileSize , gp.tileSize , null );


            changeAlpha(g2,1f);
        }


    public void dyingAnimation(Graphics2D g2){
        dyingCounter++;
        int i = 5;
        if( dyingCounter <= i){changeAlpha(g2,0f);}
        if( dyingCounter > i && dyingCounter <= i*2){changeAlpha(g2,1f);}
        if( dyingCounter > i*2 && dyingCounter <= i*3){changeAlpha(g2,0f);}
        if( dyingCounter > i*3 && dyingCounter <= i*4){changeAlpha(g2,1f);}
        if( dyingCounter > i*4 && dyingCounter <= i*5){changeAlpha(g2,0f);}
        if( dyingCounter > i*5 && dyingCounter <= i*6){changeAlpha(g2,1f);}
        if( dyingCounter > i*6 && dyingCounter <= i*7){changeAlpha(g2,0f);}
        if( dyingCounter > i*7 && dyingCounter <= i*8){changeAlpha(g2,1f);}
        if( dyingCounter > i*8){

            alive = false;
        }

    }
    public void changeAlpha(Graphics2D g2, float alphaValue){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
    }
}
