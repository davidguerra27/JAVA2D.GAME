package game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


import javax.swing.JPanel;

//import WorldObject.SuperObject;
import character.Character;
import tile.TileManager;
import character.Player;
import tile_interactive.InteractiveTile;

public class GamePanel extends JPanel implements Runnable{


    public final int tileSize = 64
            ;

    public final int maxScreenCol = 18;
    public final int maxScreenRow = 10;
    public final int screenWidth = (tileSize) * maxScreenCol;//864 pixels
    public final int screenHeight = (tileSize) * maxScreenRow;//672 pixels
    /////WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow =50;
    /////
    int FPS = 60;
    //SYSTEM
    TileManager tileM = new TileManager(this) ;
    public KeyHandler keyH = new KeyHandler(this);
    Sound sound = new Sound();
    public CollisionChecker  cChecker = new CollisionChecker(this);
    public UI ui = new UI(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public EventHandler eHandler = new EventHandler(this);
    Thread gameThread;

    //CHARACTERS AND OBJECTS
    public Player player = new Player(this,keyH);
    //public SuperObject obj[] = new SuperObject[10];
    public Character obj[] = new Character[20];
    public Character npc[] = new Character[10];
    public Character monster[] = new Character[20];
    public InteractiveTile iTile[] = new InteractiveTile[50];
    public ArrayList<Character> projectileList = new ArrayList<>();
    public ArrayList<Character> particleList = new ArrayList<>();
    public ArrayList<Character> characterList = new ArrayList<>();




    //GAME STATES
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int characterState = 4;
    public final int optionsState = 5;




   
    //Player default position
    

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void setupGame (){

        aSetter.setNPC();
        aSetter.setMonster();
        aSetter.setObject();
        aSetter.setInteractiveTile();
        playMusic(0);
        sound.play();
        gameState = titleState;

    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawTime = 1000000000/FPS;//0,01666 seconds
        double nextDrawTime = System.nanoTime() + drawTime;


        while(gameThread != null){
       

            update();


            repaint();

           ;
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0 ){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawTime;

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            
        }
        // TODO Auto-generated method stub
        
    }
    public void update(){

        if(gameState == playState){
            //PLAYER
            player.update();
            //NPC
            for( int i = 0 ; i <npc.length ; i++){
                if(npc[i] != null){
                    npc[i].update();
                }
            }
            for( int i = 0 ; i <monster.length ; i++){
                if(monster[i] != null){
                    if(monster[i].alive == true && monster[i].dying == false){
                        monster[i].update();
                    }
                    if(monster[i].alive == false){
                        monster[i].checkDrop();

                        monster[i] = null;
                    }

                }
            }
           for( int i = 0 ; i <projectileList.size() ; i++){

                if(projectileList.get(i) != null){
                    if(projectileList.get(i).alive == true){
                        projectileList.get(i).update();
                    }
                    if(projectileList.get(i).alive == false){
                        projectileList.remove(i);
                    }

                }
            }
            for( int i = 0 ; i <particleList.size() ; i++){

                if(particleList.get(i) != null){
                    if(particleList.get(i).alive == true){
                        particleList.get(i).update();
                    }
                    if(particleList.get(i).alive == false){
                        particleList.remove(i);
                    }

                }
            }
           for(int i = 0; i < iTile.length ; i++){
               if(iTile[i] != null){
                   iTile[i].update();
               }
           }
        }
        if(gameState == pauseState){
            //it does not draw the player, so there's no movement
        }



    }
    /**
     * 
     */
    public void paintComponent(java.awt.Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;

        //DEBUG DRAWTIME
        long drawStart = 0;
        if(keyH.checkDrawTime == true){
            drawStart = System.nanoTime();
        }

        //TTLE SCREEN
        if(gameState == titleState){
            ui.draw(g2);
        }
        //OTHERS

        else{



            //TILE
            tileM.draw(g2);
            //INTERACTIVE TILE
            for(int i = 0; i < iTile.length ; i++){
                if(iTile[i] != null){
                    iTile[i].draw(g2);
                }
            }

            //ADD CHARACTERS TO THE LIST

            characterList.add(player);

            for(int i = 0 ; i < npc.length ; i++){
                if(npc[i] != null){
                    characterList.add(npc[i]);
                }
            }
            for(int i = 0 ; i < monster.length ; i++){
                if(monster[i] != null){
                    characterList.add(monster[i]);
                }
            }
            for(int i = 0; i < obj.length ; i++){
                if(obj[i] != null){
                    characterList.add(obj[i]);

                   //obj[i].draw(g2);
                }
            }
            for(int i = 0 ; i < projectileList.size() ; i++){

                if(projectileList.get(i) != null){
                    characterList.add(projectileList.get(i));

                }
            }
            for(int i = 0 ; i < particleList.size() ; i++){

                if(particleList.get(i) != null){
                    characterList.add(particleList.get(i));
                    System.out.println("particle");


                }
            }

            //SORT
            Collections.sort(characterList, (c1, c2) -> {
                int result = Integer.compare(c1.worldY, c2.worldY);
                return result;
            });
            // DRAW CHARACTERS
            for(int i = 0; i < characterList.size(); i++){


                characterList.get(i).draw(g2);
            }
            characterList.clear();

            //UI
            ui.draw(g2);
        }


        //DEBUG DRAWTIME
        if( keyH.checkDrawTime == true){
            long drawEnd = System.nanoTime();
            long passed = drawEnd -drawStart;
            g2.setColor(Color.WHITE);
            g2.drawString("Draw time : "+ passed , 10 , 200 );
            System.out.println("drawTime : "+ passed);
            g2.drawString(this.player.worldX/this.maxWorldCol+":"+this.player.worldY/this.maxWorldRow,10,300);
        }



        g2.dispose();
    }

    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();

    }
    public void stopMusic(){
        sound.stop();
    }
    public void playSE(int i){
       sound.setFile(i);
       sound.play();
    }

    
}
