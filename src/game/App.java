package game;
import javax.swing.JFrame;
public class App {
   
    public static void main(String[] args) throws Exception {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        window.setTitle("GAME OF LIFE");
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
        
       
        
       
    }
}
