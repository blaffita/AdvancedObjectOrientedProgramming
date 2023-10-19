package noapplet.newAnother;

/**
 * Represents a computer opponent in the Omok console game.
 * The ComputerOpponent class provides methods to determine the computer's next move based on the player's move.
 */
public class ComputerOpponent {
    /** An array that stores the x and y coordinates of the next move. */
    int[] nextMove;
    /**
     * Determines the computer's next move based on the player's move.
     * If the x-coordinate of the player's move is 14, it decrements by 2. Otherwise, it increments by 2.
     *
     * @param movePlayer An integer array representing the x and y coordinates of the player's move.
     * @return An integer array representing the x and y coordinates of the computer's next move.
     */
    public int[] nextMove(int[] movePlayer){
        nextMove = movePlayer;
        if(nextMove[0] == 14){
            nextMove[0] = nextMove[0] - 2;
        }
        else {
            nextMove[0] = nextMove[0] + 2;
        }
        return nextMove;
    }
    /**
     * Determines another potential move for the computer based on the player's move.
     * If the x-coordinate of the player's move is 0, it increments by 2. Otherwise, it decrements by 1.
     *
     * @param movePlayer An integer array representing the x and y coordinates of the player's move.
     * @return An integer array representing the x and y coordinates of the computer's next move.
     */
    public int[] nextMove2(int[] movePlayer){
        nextMove = movePlayer;
        if (nextMove[0] == 0){
            nextMove[0] = nextMove[0]+2;
        }
        else {
            nextMove[0] = nextMove[0] - 1;
        }
        return nextMove;
    }
    /**
     * Determines another potential move for the computer based on the player's move.
     * If the y-coordinate of the player's move is 14, it decrements by 2. Otherwise, it increments by 2.
     *
     * @param movePlayer An integer array representing the x and y coordinates of the player's move.
     * @return An integer array representing the x and y coordinates of the computer's next move.
     */
    public int[] nextMove3(int[] movePlayer){
        nextMove = movePlayer;
        if (nextMove[1] == 14){
            nextMove[1] = nextMove[1] -2;
        }
        else {
            nextMove[1] = nextMove[1] + 2;
        }
        return nextMove;
    }
    /**
     * Determines another potential move for the computer based on the player's move.
     * If the y-coordinate of the player's move is 0, it increments by 2. Otherwise, it decrements by 1.
     *
     * @param movePlayer An integer array representing the x and y coordinates of the player's move.
     * @return An integer array representing the x and y coordinates of the computer's next move.
     */
    public int[] nextMove4(int[] movePlayer){
        nextMove = movePlayer;
        if(nextMove[1] == 0){
            nextMove[1] = nextMove[1]+2;
        }
        else {
            nextMove[1] = nextMove[1] - 1;
        }
        return nextMove;
    }

}
