package noapplet.newAnother;

/**
 * The Board class represents the game board for Omok console app.
 * <p>
 * The board is a 2D integer array, where:
 * 0 represents an empty position.
 * 1 represents a position occupied by Player O.
 * 2 represents a position occupied by Player X.
 * </p>
 */
public class Board{
    /**
     * The 2D integer array representing the game board.
     */
    protected int[][] board;
    /**
     * Initializes a new game board with the specified size.
     *
     * @param size The width and height of the board.
     */
    public Board(int size) {
        this.board = new int[size][size];
    }
    /**
     * Creates and displays the current game board on the console.
     * <p>
     * The board is displayed with coordinate labels on the top and left side.
     * Each cell will be shown as:
     * . for empty cells
     * O for Player O cells
     * X for Player X cells
     * </p>
     */
    public void createBoard(){
        int n = board.length;
        for(int x = 1; x <= n; x++){
            if(x == 1){
                System.out.print("      " + x + " ");
            }
            else if(x == n){
                System.out.println(" " + x);
            }
            else if(x > 9){
                System.out.print(" " + x + " ");
            }
            else {
                System.out.print("  " + x + " ");
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                switch(board[j][i]){
                    case 0:
                        if(j == 0){
                            if(i > 8){
                                System.out.print(i+1 + "    .   ");
                            }
                            else {
                                System.out.print(i+1 + "     .   ");
                            }
                        }
                        else if(j == board[i].length){
                            System.out.println(".");
                        }
                        else{
                            System.out.print(".   ");
                        }

                        break;
                    case 1:
                        if(j == 0){
                            if(i > 8){
                                System.out.print(i+1 + "    O   ");
                            }
                            else {
                                System.out.print(i+1 + "     O   ");
                            }
                        }
                        else if(j == board[i].length){
                            System.out.println("O");
                        }
                        else{
                            System.out.print("O   ");
                        }
                        //System.out.print("X ");
                        break;
                    case 2:
                        if(j == 0){
                            if(i > 8){
                                System.out.print(i+1 + "    X   ");
                            }
                            else {
                                System.out.print(i+1 + "     X   ");
                            }
                        }
                        else if(j == board[i].length){
                            System.out.println("X");
                        }
                        else{
                            System.out.print("X   ");
                        }
                        //System.out.print("X");
                        break;
                    default:
                        System.out.print("? ");
                        break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    /**
     * Makes a move for a player at a specified position.
     *
     * @param x       The x-coordinate of the move (0-based index).
     * @param y       The y-coordinate of the move (0-based index).
     * @param player  The player making the move (1 for O and 2 for X).
     * @return        True if the position was already occupied, otherwise false.
     */
    public boolean move(int x, int y, int player){
        if(board[x][y] == 0){
            board[x][y] = player;
        }
        else{
            System.out.println();
            System.out.println("Position already occupied!!! Please try again.");
            return true;
        }
        return false;
    }
    /**
     * Retrieves the current state of the game board.
     *
     * @return A 2D integer array representing the current state of the board.
     */
    public int[][] getBoardInfo(){

        return this.board;
    }
}
