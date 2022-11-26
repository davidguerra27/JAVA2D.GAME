package tile_interactive;

import character.Character;
import game.GamePanel;

public class InteractiveTile extends Character {
    GamePanel gp;
    public boolean destructible = false;

    public InteractiveTile(GamePanel gp, int col, int row) {
        super(gp);
        this.gp = gp;

    }
    public boolean isCorrectItem(Character character){
        boolean isCorrectItem = false;
        return isCorrectItem;
    }
    public void playSE(){

    }
    public InteractiveTile getDestroyedForm(){
        InteractiveTile tile = null;
        return tile;
    }
    public void update(){
        if (invincible == true) {
            invincibleCounter++;
            if (invincibleCounter > 10) {
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }
}
