package game;
import WorldObject.*;
//import WorldObject.OBJ_Gate;
import character.NCP_OldMan;
import game.monster.MON_mushroom;
import tile_interactive.IT_DryTree;
import tile_interactive.InteractiveTile;

public class AssetSetter  {

    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
       gp.obj[0] = new OBJ_Ring(gp);
       gp.obj[0].worldX = gp.tileSize*10;
       gp.obj[0].worldY= gp.tileSize*15;




        gp.obj[1] = new OBJ_PurpleAxe(gp);
        gp.obj[1].worldX = gp.tileSize*41;
        gp.obj[1].worldY= gp.tileSize*13;

        gp.obj[2] = new OBJ_RedBow(gp);
        gp.obj[2].worldX = gp.tileSize*41;
        gp.obj[2].worldY= gp.tileSize*11;

        gp.obj[3] = new OBJ_AmphetamineRed(gp);
        gp.obj[3].worldX = gp.tileSize*40;
        gp.obj[3].worldY= gp.tileSize*10;



        gp.obj[4] = new OBJ_Orb_Purple(gp);
        gp.obj[4].worldX = gp.tileSize*39;
        gp.obj[4].worldY= gp.tileSize*10;
        gp.obj[5] = new OBJ_Orb_Purple(gp);
        gp.obj[5].worldX = gp.tileSize*38;
        gp.obj[5].worldY= gp.tileSize*9;
        gp.obj[6] = new OBJ_Orb_Purple(gp);
        gp.obj[6].worldX = gp.tileSize*38;
        gp.obj[6].worldY= gp.tileSize*11;

        gp.obj[7] = new OBJ_Juice(gp);
        gp.obj[7].worldX = gp.tileSize*39;
        gp.obj[7].worldY= gp.tileSize*13;

        gp.obj[8] = new OBJ_Juice(gp);
        gp.obj[8].worldX = gp.tileSize*38;
        gp.obj[8].worldY= gp.tileSize*14;
    }
    public void setNPC(){

        gp.npc[0] = new NCP_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize*39;
        gp.npc[0].worldY = gp.tileSize*43;



    }
    public void setMonster(){
        gp.monster[0] = new MON_mushroom(gp);
        gp.monster[0].worldX = gp.tileSize*40;
        gp.monster[0].worldY = gp.tileSize*43;

        gp.monster[1] = new MON_mushroom(gp);
        gp.monster[1].worldX = gp.tileSize*40;
        gp.monster[1].worldY = gp.tileSize*44;

        gp.monster[2] = new MON_mushroom(gp);
        gp.monster[2].worldX = gp.tileSize*22;
        gp.monster[2].worldY = gp.tileSize*22;

        gp.monster[3] = new MON_mushroom(gp);
        gp.monster[3].worldX = gp.tileSize*25;
        gp.monster[3].worldY = gp.tileSize*23;



    }
    public void setInteractiveTile(){
        int i= 0;
        gp.iTile[i] = new IT_DryTree(gp,34,5);i++;
        gp.iTile[i] = new IT_DryTree(gp,35,5);i++;
        gp.iTile[i] = new IT_DryTree(gp,36,5);i++;
        gp.iTile[i] = new IT_DryTree(gp,36,6);i++;
        gp.iTile[i] = new IT_DryTree(gp,36,7);i++;
        gp.iTile[i] = new IT_DryTree(gp,24,29);i++;
        gp.iTile[i] = new IT_DryTree(gp,23,29);i++;
        gp.iTile[i] = new IT_DryTree(gp,19,23);i++;
        gp.iTile[i] = new IT_DryTree(gp,19,24);i++;
        gp.iTile[i] = new IT_DryTree(gp,24,19);i++;
        gp.iTile[i] = new IT_DryTree(gp,23,19);i++;
    }
}
