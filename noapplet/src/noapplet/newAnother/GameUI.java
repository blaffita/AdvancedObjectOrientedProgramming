package noapplet.newAnother;
import java.util.Scanner;
/**
 * Represents the user interface for the Gomoku/Omok console game.
 * The UI handles player interaction, game mode prompts, and other UI functionalities.*/
public class GameUI{
    /** Represents the main Gomoku game logic. */
    private final Gomoku game;
    /** Scanner object for user input. */
    private final Scanner input;
    /**
     * Constructs a new GameUI object and initializes the game and scanner.
     *
     * @param game The Gomoku game to be used by this UI.*/
    public GameUI(Gomoku game){
        this.game = game;
        this.input = new Scanner(System.in);
    }
    /**
     * Displays a welcome message to the user.*/
    public void welcomeUser(){
        System.out.println("Welcome to Gomoku / Omok");
    }
    /**
     * Prompts the user to select a game mode and returns their choice.
     * Valid modes are "Human" and "Strategy".
     *
     * @return Returns 1 for Human mode, 2 for Strategy mode, and -1 for invalid choices (defaults to Human mode).*/
    public int promptForGameMode(){
        boolean repeat = true;
        int choice;
        System.out.println("Select a game mode: ");
        System.out.println("(1) Human");
        System.out.println("(2) Strategy");
        choice = input.nextInt();
        System.out.println();

        if(choice == 1 || choice == 2){
            repeat = false;
        }

        while(repeat) {
            System.out.println("Sorry, please enter 1 or 2 to Select a game mode: ");
            System.out.println("(1) Human");
            System.out.println("(2) Strategy");
            choice = input.nextInt();
            System.out.println();
            if(choice == 1 || choice == 2){
                repeat = false;
            }


        }

        switch(choice){
            case 1:
//                return GameType.Human();
                return 1;
            case 2:
//                return GameType.Strategy();
                return 2;
            default:
                System.out.println("Invalid choice, going to Human mode");
//                return GameType.Human();
                return -1;
        }
    }
    /**
     * Places a stone on the game board.
     *
     * @param x The x-coordinate of the stone.
     * @param y The y-coordinate of the stone.
     * @param movePlayer1 The player (1 or 2) who is making the move.*/
    public void placeStone(int x, int y, int movePlayer1) {
        game.getBoard().createBoard();
    }

}
