package game;

import java.awt.*;

public class EventHandler {

    GamePanel gp;
    Graphics2D g2;
    EventRect eventRect[][];

    int previousEventX, previousEventY;
    boolean canTouchEvent = true;


    public EventHandler(GamePanel gp){


        this.gp = gp;
        eventRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow];
        int col = 0;
        int row = 0;
        while(col < gp.maxWorldCol && row < gp.maxWorldRow){

            eventRect[col][row] = new EventRect();

            eventRect[col][row].x = 0;
            eventRect[col][row].y = 0;
            eventRect[col][row].width = 32;
            eventRect[col][row].height = 32;
            eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;
            col++;
            if(col == gp.maxWorldCol){
                col = 0;
                row++;
            }
        }






    }
    public void checkEvent(){
        //CHECK IF THE PLAYER IS 1 TILE AWAY FROM EVENT
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if(distance > gp.tileSize){
            canTouchEvent = true;
        }
        if(canTouchEvent){
            if(hit(26,5,"any")){damagePit(26,5,gp.dialogueState);}
            if(hit(10,16,"any")){damagePit(11,16,gp.dialogueState);}
            if(hit(23,1,"any")){healingPool(23,1,gp.dialogueState);}
        }

    }

    public boolean hit(int col, int row, String reqDirection){
        boolean hit = false;

        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect[col][row].x = col*gp.tileSize + eventRect[col][row].x;
        eventRect[col][row].y = row*gp.tileSize + eventRect[col][row].y;

        if(gp.player.solidArea.intersects(eventRect[col][row]) && !eventRect[col][row].eventDone){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;

                previousEventX = gp.player.worldX;
                previousEventY = gp.player.worldY;



            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
        eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;


        return hit;
    }
    public void damagePit(int col, int row, int gameState){
        gp.gameState = gameState;
        gp.playSE(5);
        gp.ui.currentDialogue = "you fell into a radioactive pit!!";
        gp.player.life -= 1;
       // eventRect[col][row].eventDone = true;
        canTouchEvent = false;

    }

    public void healingPool(int col, int row, int gameState){
        if( gp.keyH.enterPressed){
            gp.gameState = gameState;
            gp.player.attackCancel = true;
            gp.playSE(1);
            gp.ui.currentDialogue = "You drink fresh water..... \nYour Health and your Juice have increased!";
            gp.player.life = gp.player.maxLife;
            gp.player.mana = gp.player.maxMana;
            gp.aSetter.setMonster();
        }

    }


}
