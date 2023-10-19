package noapplet.newAnother;

import noapplet.newAnother.Gomoku;
/**
 * This is the main entry point of the Omok console app.
 */
public class Main {
    /**
     * The main method initializes and starts the game.
     *
     * @param args Command-line arguments (not used in this app).
     */
    public static void main(String[] args){
        Gomoku game = new Gomoku();
        game.startGame();
    }
}
