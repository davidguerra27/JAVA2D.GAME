package tile;
import java.io.IOException;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;

import game.GamePanel;
public class TileManager {
    
    File f1 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/light_grass1.png");
    File f2 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/tall_grass1.png");
    File f3 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/dry_grass_1.png");
    File f4 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/mud1.png");
    File f5 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/water.middle.final.png");
    File f6 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/road.png");
    File f7 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/road.png");
    File f8 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/road.png");
    File f9 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/road.png");
    File f10 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/water.grass.btl.png");
    File f11 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/water.grass.btr.png");
    File f12 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/water.grasstpl.png");
    File f13 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/water.grass.tpr.png");
    File f14 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/grass.watertpl.png");
    File f15 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/grass.watertpr.png");
    File f16 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/grass.waterbtl.png");
    File f17 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/grass.waterbtr.png");
    File f18 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/grass.watertop.png");
    File f19 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/grass.watertop.png");
    File f20 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/grass.waterright.png");
    File f21 = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/tiles/grass.waterleft.png");


    
    
    
    

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    File fileMap = new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/maps/map02.txt");
    public final String filepath = fileMap.getAbsolutePath(); 
    
    public TileManager(GamePanel gp){
        this.gp = gp;

        tile = new Tile[30];
        mapTileNum = new int [gp.maxWorldCol] [gp.maxWorldRow];

        getTileImage();
        
        
        try {
            loadMap("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/maps/map02.txt");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     
    
    }
    
    public void getTileImage(){

        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(f1);
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(f2);
            tile[1].collision = true;
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(f3);
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(f4);
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(f5);
            tile[4].collision = true;
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(f6);
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(f7);
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(f8);
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(f9);

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(f10);
            tile[9].collision = true;
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(f11);
            tile[10].collision = true;
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(f12);
            tile[11].collision = true;
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(f13);
            tile[12].collision = true;
            tile[13] = new Tile();
            tile[13].image = ImageIO.read(f14);
            tile[13].collision = true;
            tile[14] = new Tile();
            tile[14].image = ImageIO.read(f15);
            tile[14].collision = true;
            tile[15] = new Tile();
            tile[15].image = ImageIO.read(f16);
            tile[15].collision = true;
            tile[16] = new Tile();
            tile[16].image = ImageIO.read(f17);
            tile[16].collision = true;
            tile[17] = new Tile();
            tile[17].image = ImageIO.read(f18);
            tile[17].collision = true;
            tile[18] = new Tile();
            tile[18].image = ImageIO.read(f19);
            tile[18].collision = true;
            tile[19] = new Tile();
            tile[19].image = ImageIO.read(f20);
            tile[19].collision = true;
            tile[20] = new Tile();
            tile[20].image = ImageIO.read(f21);
            tile[20].collision = true;


        }
        catch(IOException e){
            e.printStackTrace();
        }
    } 
    public void loadMap(String filepath) throws FileNotFoundException {
        try {
            Scanner scanner = new Scanner(new File("/Users/codecadet/Documents/temp/my_exercises/THEBIGnothing/JAVA2D.GAME/src/res/maps/map02.txt"));

        int col = 0;
        int row = 0;
        while(scanner.hasNextInt()){
            System.out.println(col);
            mapTileNum[col++][row] = scanner.nextInt();
            if( col >= gp.maxWorldCol  ){
                row++;
                col = 0;
            }
        }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    /*public void loadMap(){

        try{

            InputStream is = getClass().getResourceAsStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
             while( col < gp.maxScreenCol && row < gp.maxScreenRow ){

                String line = br.readLine();

                while( col < gp.maxScreenCol){

                    String numbers[] = line.split(" ");

                    System.out.println(col+"#");
                    int num = Integer.parseInt(numbers[col]);
                    System.out.println(col+"%");

                    mapTileNum[col][row] = num;
                    
                    col++;


                }
                if( col == gp.maxScreenCol){
                    col = 0;
                    
                    row++;
                }
            }
            br.close();

        }
        catch(Exception e){

        }
    } */

    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;


        while( worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow ){
            
            final int tileNumber =  mapTileNum[worldCol][worldRow];
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;

            int screenX = worldX -gp.player.worldX + gp.player.screenX;
            int screenY = worldY -gp.player.worldY + gp.player.screenY;

            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

                g2.drawImage(tile[tileNumber].image , screenX , screenY , gp.tileSize , gp.tileSize , null );
            }



            worldCol++;


           
            if( worldCol == gp.maxWorldCol){
                worldCol = 0;

                worldRow++;

            }
            
        }
        
        
       



    }  

}
