package noapplet.newAnother;
import java.util.Scanner;
/**
 * Represents a player in the Omok console game.
 * Each player has a name and can perform a move on the Omok board.
 */
public class Player{
    /** The name of the player. */
    private String name;
    /**
     * Scanner instance for reading player input from the console.
     * This is a shared instance for all players.
     */
    private static Scanner input = new Scanner(System.in);
    /**
     * Constructs a new Player with the specified name.
     *
     * @param name The name of the player.
     */
    public Player(String name){
        this.name = name;
    }
    /**
     * Prints a message indicating that the current player is playing.
     */
    public void play(){
        System.out.println(name + " is now playing.");
    }
//    public Strategy selectStrategy(){
//        return null;
//    }
    /**
     * Allows the player to enter their move (row and column) on the console.
     * The method prompts the user for a row and column and validates the input.
     * It repeats the prompt until a valid input is given or the user chooses to exit.
     * If the user wants to exit, they can enter -1 for either row or column.
     *
     * @return A 2-element int array where the first element represents the column
     *         and the second element represents the row. If the user chooses to
     *         exit, the method returns null.
     */
    public int[] move(){
        boolean repeat = false;
        System.out.println(name + " Turn   (If you want to exit the game enter -1)");
        System.out.println("Enter row:");
        int row = input.nextInt();
        if(row == -1){
            return null;
        }

        System.out.println("Enter column:");
        int col = input.nextInt();
        if(col == -1){
            return null;
        }

        if(row > 15 || row < 1 || col > 15 || col < 1){
            repeat = true;
        }
        while(repeat){
            System.out.println("Sorry " + name + ", invalid coordinates please input a " +
                    "number greater than 0 and less than 16");
            System.out.println("Enter row:");
            row = input.nextInt();

            System.out.println("Enter column:");
            col = input.nextInt();
            if(row <= 15 && row >= 1 && col <= 15 && col >= 1){
                repeat = false;
            }
        }

        col -= 1;
        row -= 1;
        return new int[] {col, row};
    }

}
