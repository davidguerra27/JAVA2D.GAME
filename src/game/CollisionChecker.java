package game;
import character.Character;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }

    public void checkTile(Character character){

        int characterLeftWorldX = character.worldX + character.solidArea.x;
        int characterRightWorldX = character.worldX + character.solidArea.x + character.solidArea.width;
        int characterTopWorldY = character.worldY + character.solidArea.y;
        int characterBottomWorldY = character.worldY + character.solidArea.y + character.solidArea.height;

        int characterLeftCol = characterLeftWorldX/gp.tileSize;
        int characterRightCol = characterRightWorldX/gp.tileSize;
        int characterTopRow = characterTopWorldY/gp.tileSize;
        int characterBottomRow = characterBottomWorldY/gp.tileSize;

        int tileNum1 , tileNum2;

        switch(character.direction){
            case "up":
                characterTopRow = (characterTopWorldY - character.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[characterLeftCol][characterTopRow];
                tileNum2 = gp.tileM.mapTileNum[characterRightCol][characterTopRow];
                if(gp.tileM.tile[tileNum1].collision == true||gp.tileM.tile[tileNum2].collision == true){
                    character.collisionOn = true;

                }
                break;
            case "down":
                characterBottomRow = (characterBottomWorldY + character.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[characterLeftCol][characterBottomRow];
                tileNum2 = gp.tileM.mapTileNum[characterRightCol][characterBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true||gp.tileM.tile[tileNum2].collision == true){
                    character.collisionOn = true;

                }

                break;
            case "left":
                characterLeftCol = (characterLeftWorldX - character.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[characterLeftCol][characterTopRow];
                tileNum2 = gp.tileM.mapTileNum[characterLeftCol][characterBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true||gp.tileM.tile[tileNum2].collision == true){
                    character.collisionOn = true;

                }

                break;
            case "right":
                characterRightCol = (characterRightWorldX + character.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[characterRightCol][characterTopRow];
                tileNum2 = gp.tileM.mapTileNum[characterRightCol][characterBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true||gp.tileM.tile[tileNum2].collision == true){
                    character.collisionOn = true;

                }

                break;
        }

    }
    public int checkObject(Character character , boolean player){

        int index = 999;

        for( int i = 0 ; i < gp.obj.length ; i++){

            if(gp.obj[i] != null){
                //Get character's solid Area position
                character.solidArea.x = character.worldX + character.solidArea.x;
                character.solidArea.y = character.worldY + character.solidArea.y;

                //Get the object's solid Area position
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                switch(character.direction){
                    case "up":character.solidArea.y -= character.speed;break;
                    case "down":character.solidArea.y += character.speed;break;
                    case "left":character.solidArea.x -= character.speed;break;
                    case "right":character.solidArea.x += character.speed;break;
                }
                if( character.solidArea.intersects(gp.obj[i].solidArea)){
                    if(gp.obj[i].collisionOn == true){
                        character.collisionOn = true;
                    }
                    if(player == true){
                        index = i;
                    }
                }
                character.solidArea.x = character.solidAreaDefaultX;
                character.solidArea.y = character.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }
        }


        return index;


    }
    //NPC OR ENEMY COLLISION
    public int checkCharacter(Character character, Character[] target){

        int index = 999;

        for( int i = 0 ; i < target.length ; i++){

            if(target[i] != null){
                //Get character's solid Area position
                character.solidArea.x = character.worldX + character.solidArea.x;
                character.solidArea.y = character.worldY + character.solidArea.y;

                //Get the object's solid Area position
                target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
                target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;

                switch(character.direction){
                    case "up": character.solidArea.y -= character.speed; break;
                    case "down": character.solidArea.y += character.speed; break;
                    case "left":character.solidArea.x -= character.speed; break;
                    case "right": character.solidArea.x += character.speed; break;
                }

                if( character.solidArea.intersects(target[i].solidArea)){
                    if(target[i] != character){
                        character.collisionOn = true;
                        index =i;
                    }

                }

                character.solidArea.x = character.solidAreaDefaultX;
                character.solidArea.y = character.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
        }


        return index;
    }
    public boolean checkPlayer(Character character){

        boolean contactPlayer = false;

        character.solidArea.x = character.worldX + character.solidArea.x;
        character.solidArea.y = character.worldY + character.solidArea.y;

        //Get the object's solid Area position
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;

        switch(character.direction){
            case "up":character.solidArea.y -= character.speed; break;
            case "down": character.solidArea.y += character.speed;break;
            case "left": character.solidArea.x -= character.speed; break;
            case "right": character.solidArea.x += character.speed; break;
        }
        if( character.solidArea.intersects(gp.player.solidArea)){
            character.collisionOn = true;
            contactPlayer = true;
        }
        character.solidArea.x = character.solidAreaDefaultX;
        character.solidArea.y = character.solidAreaDefaultY;
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
    return contactPlayer;
    }

}
