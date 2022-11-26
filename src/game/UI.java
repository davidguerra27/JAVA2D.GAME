package game;



import WorldObject.OBJ_Life;
import WorldObject.OBJ_Mana;
import character.Character;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font terminal_80;

    BufferedImage life1,life2,life3,life4,life5,manaFull,manaEmpty;

    public boolean messageOn = false;
    ArrayList<String> message = new ArrayList<>();
    ArrayList<Integer> messageCounter = new ArrayList<>();

    public boolean gameFinished = false;
    public String currentDialogue = "";
    public int commandNum = 0;
    public int slotCol = 0;
    public int slotRow = 0;
    public int subState = 0;


    public UI(GamePanel gp){
        this.gp = gp;
        terminal_80 = new Font("Terminal",Font.BOLD,80);

        //CREATE HUD OBJECT
        Character lifeBar = new OBJ_Life(gp);
        life5 = lifeBar.image5;
        life4 = lifeBar.image4;
        life3 = lifeBar.image3;
        life2 = lifeBar.image2;
        life1 = lifeBar.image;
        Character mana = new OBJ_Mana(gp);
        manaFull = mana.image;
        manaEmpty = mana.image2;

    }
    public void addMessage(String text){
        message.add(text);
        messageCounter.add(0);

    }
    public void draw(Graphics2D g2){
            this.g2 =g2;

            g2.setFont(terminal_80);
            g2.setColor(Color.MAGENTA);

            //TITLE STATE
            if(gp.gameState == gp.titleState){
                drawTitleScreen();
            }
            //PLAY STATE
            if( gp.gameState == gp.playState){
                drawPlayerLife();
                drawMessage();

            }
            //PAUSE STATE
            else if( gp.gameState == gp.pauseState ){
                drawPauseScreen();
                drawPlayerLife();
            }
            //DIALOGUE STATE
            if(gp.gameState == gp.dialogueState){
                drawDialogueScreen();
                drawPlayerLife();
            }
            //CHARACTER STATE
            if(gp.gameState == gp.characterState){
                drawCharacterScreen();
                drawInventory();

                drawPlayerLife();

            }
        if(gp.gameState == gp.optionsState){
            drawOptionScreen();

        }

    }
    public void drawPlayerLife(){
        int x = gp.tileSize;
        int y = gp.tileSize*9;
        int i = 0;



            double oneScale = (double)(gp.tileSize*2)/gp.player.maxLife;
            double hpBarValue = (oneScale*gp.player.life)-(oneScale/(gp.player.maxLife));//-(oneScale*(gp.player.maxLife)/gp.player.maxLife);

            g2.drawImage(life1,x,y,null);
            g2.setColor(new Color(0,255,0));
            g2.fillRect(x+3,y+10,(int)hpBarValue,9);

            //DRAW BLANK BAR

        if(gp.player.life < 0){
            g2.drawImage(life1,x,y,null);

        }
        //DRAW MAX MANA
        x = gp.tileSize;
        y = 62*9;
        i = 0;
        while( i < gp.player.maxMana){
            g2.drawImage(manaEmpty,x,y,null);
            i++;
            x += gp.tileSize;
        }
        //DRAW MANA
        x = gp.tileSize;
        y = 62*9;
        i = 0;
        while( i < gp.player.mana){
            g2.drawImage(manaFull,x,y,null);
            i++;
            x += gp.tileSize;
        }
    }
    public void drawMessage(){
        int messageX = gp.tileSize;
        int messageY = gp.tileSize*6;

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 25F));

        for( int i = 0 ; i< message.size(); i++){
           if(message.get(i) != null){
               g2.setColor(new Color(0,0,0));
               g2.drawString(message.get(i),messageX+2,messageY+2);
               g2.setColor(new Color(0,205,0));
               g2.drawString(message.get(i),messageX,messageY);

               int counter = messageCounter.get(i)+1;
               messageCounter.set(i,counter);
               messageY += 30;

               if( messageCounter.get(i) > 120){
                   message.remove(i);
                   messageCounter.remove(i);
               }

           }
        }

    }
    public void drawTitleScreen(){
        g2.setColor(new Color(100,0,100));
        g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);

        //TITLE NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "the big NOTHING";
        int x = getXForCenteredText(text);
        int y = gp.tileSize*2;

        //SHADOW
        g2.setColor(Color.GREEN);
        g2.drawString(text,x+3,y+3);

        //TITLE COLOR
        Color c = new Color(255,184,191);
        g2.setColor(c);
        g2.drawString(text,x,y);

        //CHARACTER IMAGE
        x = gp.screenWidth/2-gp.tileSize*2;
        y += gp.tileSize*2;
        g2.drawImage(gp.player.down1,x,y,gp.tileSize*3,gp.tileSize*3,null);

        //MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        text = "NEW GAME";
        x = getXForCenteredText(text);
        y += gp.tileSize*3;
        g2.drawString(text,x,y);
        if( commandNum == 0){
            g2.drawString(">",x-gp.tileSize,y);
        }

        text = "LOAD GAME";
        x = getXForCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text,x,y);
        if( commandNum == 1){
            g2.drawString(">",x-gp.tileSize,y);
        }

        text = "QUIT";
        x = getXForCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text,x,y);
        if( commandNum == 2){
            g2.drawString(">",x-gp.tileSize,y);
        }

    }
    public void drawPauseScreen() {
        String text = "PAUSE";
        int x = getXForCenteredText(text);

        int y = gp.screenHeight / 2;
        RoundRectangle2D menu = new RoundRectangle2D() {


            @Override
            public double getArcWidth() {
                return 100;
            }

            @Override
            public double getArcHeight() {
                return 200;
            }

            @Override
            public void setRoundRect(double x, double y, double w, double h, double arcWidth, double arcHeight) {

            }


            @Override
            public double getX() {
                return 220;
            }

            @Override
            public double getY() {
                return 200;
            }

            @Override
            public double getWidth() {
                return 500;
            }

            @Override
            public double getHeight() {
                return 800;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public Rectangle2D getBounds2D() {
                return null;
            }

        };


        g2.drawRoundRect((int) menu.getX(), (int) menu.getY(), (int) menu.getWidth(), (int) menu.getArcHeight(), (int) menu.getArcWidth(), (int) menu.getArcHeight());

        g2.drawString(text , x , y);
    }
    public void drawDialogueScreen(){
        //WINDOW
        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*4;
        drawSubWindow(x,y,width,height);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,20F));
        x += gp.tileSize;
        y += gp.tileSize;

        for(String line : currentDialogue.split("\n")){
            g2.drawString(line,x ,y);
            y += 40;
            x += 100;
        }



    }
    public void drawCharacterScreen(){
        //CREATE A FRAME
        final int frameX = gp.tileSize/2;
        final int frameY = gp.tileSize;
        final int frameWidth = gp.tileSize*5;
        final int frameHeight = gp.tileSize *7;

        drawSubWindow(frameX,frameY,frameWidth,frameHeight);

        //TEXT
        g2.setColor(new Color(245,150,200));
        g2.setFont(g2.getFont().deriveFont(20F));

        int textX = frameX+20;
        int textY = frameY+48;
        final int lineHeight = 32;

        //NAMES
        g2.drawString("Level",textX,textY);
        textY += lineHeight;
        g2.drawString("Health",textX,textY);
        textY += lineHeight;
        g2.drawString("Juice",textX,textY);
        textY += lineHeight;
        g2.drawString("Strength",textX,textY);
        textY += lineHeight;
        g2.drawString("Dexterity",textX,textY);
        textY += lineHeight;
        g2.drawString("Attack",textX,textY);
        textY += lineHeight;
        g2.drawString("Defence",textX,textY);
        textY += lineHeight;
        g2.drawString("EXP",textX,textY);
        textY += lineHeight;
        g2.drawString("Next Level",textX,textY);
        textY += lineHeight;
        g2.drawString("Orbs",textX,textY);
        textY += lineHeight+10;
        g2.drawString("Weapon",textX,textY);
        textY += lineHeight+20;
        g2.drawString("Shield",textX,textY);
        textY += lineHeight;

        //VALUES
        int tailX = (frameX + frameWidth)-20;
        g2.setColor(Color.WHITE);
        textY = frameY + 48;
        String value;
        value = String.valueOf(gp.player.level);
        textX = getXForAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY += lineHeight;
        value = String.valueOf(gp.player.life + "/" + gp.player.maxLife);
        textX = getXForAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY += lineHeight;
        value = String.valueOf(gp.player.mana + "/" + gp.player.maxMana);
        textX = getXForAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY += lineHeight;
        value = String.valueOf(gp.player.strength);
        textX = getXForAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY += lineHeight;
        value = String.valueOf(gp.player.dexterity);
        textX = getXForAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY += lineHeight;
        value = String.valueOf(gp.player.attack);
        textX = getXForAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY += lineHeight;
        value = String.valueOf(gp.player.defense);
        textX = getXForAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY += lineHeight;
        value = String.valueOf(gp.player.exp);
        textX = getXForAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY += lineHeight;
        value = String.valueOf(gp.player.nextLevelExp);
        textX = getXForAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY += lineHeight;
        value = String.valueOf(gp.player.orb);
        textX = getXForAlignRightText(value,tailX);
        g2.drawString(value,textX,textY);

        g2.drawImage(gp.player.currentWeapon.image, tailX - 48,textY,null);
        textY += 64;
        g2.drawImage(gp.player.currentShield.image, tailX - 48,textY,null);




    }
    public void drawInventory(){
        //FRAME
        int framX = gp.tileSize*9;
        int framY = gp.tileSize;
        int frameWidth = (gp.tileSize * 5)+gp.tileSize/2;
        int frameHeight = gp.tileSize * 5;

        drawSubWindow(framX,framY,frameWidth,frameHeight);
        //SLOTS
        final int slotsXStart = framX + 15;
        final int slotsYStart = framY + 25;

        int slotX =  slotsYStart*6+gp.tileSize;
        int slotY = slotsYStart;
        //DRAW PLAYER'S ITEMS
        for( int i = 0; i < gp.player.inventory.size(); i++){

            //EQUIP CURSOR
            if(gp.player.inventory.get(i) == gp.player.currentWeapon ||
            gp.player.inventory.get(i) == gp.player.currentShield){
                g2.setColor(new Color(245,200,200));
                g2.fillRoundRect(slotX-6,slotY,gp.tileSize,gp.tileSize,10,10);
            }


            g2.drawImage(gp.player.inventory.get(i).objImage,slotX,slotY,null);

            slotX += gp.tileSize;
            if( i == 4 || i == 9 || i == 14){
                slotX = slotsYStart*6+gp.tileSize;
                slotY += gp.tileSize;
            }
        }

        // CURSOR

        int cursorX = slotsXStart + (gp.tileSize*slotCol);
        int cursorY = slotsYStart + (gp.tileSize*slotRow);
        int cursorWidth = gp.tileSize;
        int cursorHeight = gp.tileSize;

        //DRAW CURSOR
        g2.setColor(Color.MAGENTA);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX,cursorY,cursorWidth,cursorHeight,10,10);

        //DESCRIPTION FRAME
        int dFrameX = framX;
        int dFrameY = framY + frameHeight + gp.tileSize/2;
        int dFrameWidth = frameWidth;
        int dFrameHeight = gp.tileSize*3;


        //DRAW DESCRIPTION TEXT
        int textX = dFrameX + 20;
        int textY = dFrameY + 30;

        g2.setFont(g2.getFont().deriveFont(20F));

        int itemIndex = getItemIndexSlot();
        if( itemIndex < gp.player.inventory.size()){
            drawSubWindow(dFrameX,dFrameY,dFrameWidth,dFrameHeight);
            for( String line: gp.player.inventory.get(itemIndex).description.split("\n")){
                g2.setColor(new Color(245,150,200));
                g2.drawString(line,textX,textY);
                textY += 32;
            }

        }

    }
    public void drawOptionScreen(){

        g2.setColor(new Color(245,150,200));
        g2.setFont(g2.getFont().deriveFont(32F));

        //SUB WINDOW
        int frameX = gp.tileSize*4;
        int frameY = gp.tileSize;
        int frameWidth = gp.tileSize * 10;
        int frameHeight = gp.tileSize * 8;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        switch(subState){
            case 0: options_top(frameX, frameY);break;
            case 1: break;
            case 2: break;
        }


    }
    public void options_top(int frameX, int frameY){

        int textX;
        int textY;

        //TITLE
        String text = " Options";
        textX = getXForCenteredText(text);
        textY = frameY + gp.tileSize;

        g2.drawString(text,textX,textY);

        //MUSIC
        textX = frameX + gp.tileSize;
        textY = frameY + gp.tileSize*3;

        g2.drawString("Music",textX,textY);
        if(commandNum == 0){
            g2.drawString(">",textX-32,textY);
        }
        //SE
        textX = frameX + gp.tileSize;
        textY = frameY + gp.tileSize*4;

        g2.drawString("SE",textX,textY);
        if(commandNum == 1){
            g2.drawString(">",textX-32,textY);
        }
        //CONTROLS
        textX = frameX + gp.tileSize;
        textY = frameY + gp.tileSize*5;

        g2.drawString("Controls",textX,textY);
        if(commandNum == 2){
            g2.drawString(">",textX-32,textY);
        }
        //END GAME
        textX = frameX + gp.tileSize;
        textY = frameY + gp.tileSize*6;

        g2.drawString("END GAME",textX,textY);
        if(commandNum == 3){
            g2.drawString(">",textX-32,textY);
        }

        //BACK
        textX = frameX + gp.tileSize;
        textY = frameY + gp.tileSize*7 + 32;

        g2.drawString("Back",textX,textY);
        if(commandNum == 4){
            g2.drawString(">",textX-32,textY);
        }

        //MUSIC VOLUME

        textX = frameX + gp.tileSize*7;
        textY = frameY + gp.tileSize*2 + 42;

        g2.drawRect(textX,textY,120,24);

        //SE VOLUME

        textY += gp.tileSize;
        g2.drawRect(textX,textY,120,24);


    }
    public int getItemIndexSlot(){
        int itemIndex = slotCol + (slotRow*5);
        return itemIndex;
    }
    public void drawSubWindow(int x, int y, int width, int height){

            Color c = new Color(0,0,0,220);
            g2.setColor(c);
            g2.fillRoundRect(x,y,width,height,35,35);

            Color frameC = new Color(100,0,100);
            g2.setColor(frameC);
            g2.setStroke(new BasicStroke(5));
            g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);

    }
    public int getXForCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text , g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
    public int getXForAlignRightText(String text,int tailX){
        int length = (int)g2.getFontMetrics().getStringBounds(text , g2).getWidth();
        int x = tailX - length;
        return x;
    }

}
