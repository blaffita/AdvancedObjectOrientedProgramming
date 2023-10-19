package noapplet.newAnother;

import noapplet.newAnother.Board;
/**
 * This class represents the main logic for the Gomoku (Omok) game.
 * It handles the game logic, player moves, and checks for game end conditions.
 */
public class Gomoku {
    /**
     * Player 1 instance.
     */
   private Player player1;
    /**
     * Player 2 instance.
     */
   private Player player2;
    /**
     * The type of game being played (e.g., vs computer, 2 player mode).
     */
   private GameType gameType;
    /**
     * The game board instance. Default size is 15x15.
     */
   public Board board = new Board(15);
    /**
     * 2D integer array representing the board's state.
     */
   int[][] b1 = board.getBoardInfo();
    /**
     * UI interface to interact with the game.
     */
   private  GameUI gameUI;
    /**
     * Computer opponent for single player mode.
     */
   private ComputerOpponent com;
    /**
     * Default constructor initializing the game.
     */
   public Gomoku(){
       this.player1 = new Player("Player 1");
       this.player2 = new Player("Player 2");
       this.gameUI = new GameUI(this);
       this.com = new ComputerOpponent();
   }
    /**
     * Initiates the game by displaying the welcome message,
     * prompting for game mode, and starting the game loop.
     */
    public void startGame(){
       gameUI.welcomeUser();


       //gameType = (GameType) gameUI.promptForGameMode();
        int choice = gameUI.promptForGameMode();
       if(choice == 1) {


           board.createBoard();

           while (true) {
               int[] movePlayer1 = player1.move();
               if(movePlayer1 == null){
                   System.out.println("Thank You For Playing!");
                   return;
               }
               boolean repeat = false;
               repeat = board.move(movePlayer1[0], movePlayer1[1], 1);
               while(repeat == true){
                   movePlayer1 = player1.move();
                   repeat = board.move(movePlayer1[0], movePlayer1[1], 1);

               }
               gameUI.placeStone(movePlayer1[0], movePlayer1[1], 1);
               if (findWinner()) {
                   System.out.println("Player 1 wins!");
                   System.out.println("Thank You For Playing!");
                   return;
               }
               if (endGame()) {
                   System.out.println("Its a draw!");
                   System.out.println("Thank You For Playing!");
                   return;
               }
               int[] movePlayer2 = player2.move();
               if(movePlayer2 == null){
                   System.out.println("Thank You For Playing!");
                   return;
               }
               boolean repeat2 = false;
               repeat2 = board.move(movePlayer2[0], movePlayer2[1], 2);
               while(repeat2 == true){
                   movePlayer2 = player2.move();
                   repeat2 = board.move(movePlayer2[0], movePlayer2[1], 2);

               }
               gameUI.placeStone(movePlayer2[0], movePlayer2[1], 2);

               if (findWinner()) {
                   System.out.println("Player 2 wins!");
                   System.out.println("Thank You For Playing!");
                   return;
               }
               if (endGame()) {
                   System.out.println("Its a draw!");
                   System.out.println("Thank You For Playing!");
                   return;

               }
           }
       }
       else{
           board.createBoard();
           boolean repeat = true;
           while (repeat) {
               int[] movePlayer1 = player1.move();
               if(movePlayer1 == null){
                   System.out.println("Thank You For Playing!");
                   break;
               }


               repeat = playerTurn(movePlayer1);
               if(repeat == false){break;}
               repeat = computerTurn(1, movePlayer1);
               if(repeat == false){break;}
               movePlayer1 = player1.move();
               if(movePlayer1 == null){
                   System.out.println("Thank You For Playing!");
                   break;
               }
               repeat = playerTurn(movePlayer1);
               if(repeat == false){break;}
               repeat = computerTurn(2, movePlayer1);
               if(repeat == false){break;}
               movePlayer1 = player1.move();
               if(movePlayer1 == null){
                   System.out.println("Thank You For Playing!");
                   break;
               }
               repeat = playerTurn(movePlayer1);
               if(repeat == false){break;}
               repeat = computerTurn(3, movePlayer1);
               if(repeat == false){break;}
               movePlayer1 = player1.move();
               if(movePlayer1 == null){
                   System.out.println("Thank You For Playing!");
                   break;
               }
               repeat = playerTurn(movePlayer1);
               if(repeat == false){break;}
               repeat = computerTurn(4, movePlayer1);
               if(repeat == false){break;}

           }
       }
   }
    /**
     * Manages the move for Player 1.
     *
     * @param movePlayer1 Array containing the x and y coordinates of the move.
     * @return true if game continues, false otherwise.
     */
   public boolean playerTurn(int[] movePlayer1){

       board.move(movePlayer1[0], movePlayer1[1], 1);
       gameUI.placeStone(movePlayer1[0], movePlayer1[1], 1);
       if (findWinner()) {
           System.out.println("Player 1 wins!");
           return false;
       }
       if (endGame()) {
           System.out.println("Its a draw!");
           return false;
       }
       return true;
   }
    /**
     * Manages the move for the computer opponent.
     *
     * @param x Represents the level or strategy the computer should use.
     * @param movePlayer1 Last move made by player1.
     * @return true if game continues, false otherwise.
     */
   public boolean computerTurn(int x, int[] movePlayer1){
       int[] moveComputer = {0};
       if(x == 1){
           moveComputer = com.nextMove(movePlayer1);
       }
       if(x == 2){
           moveComputer = com.nextMove2(movePlayer1);
       }
       if(x == 3){
           moveComputer = com.nextMove3(movePlayer1);
       }
       if(x == 4){
           moveComputer = com.nextMove4(movePlayer1);
       }
       board.move(moveComputer[0], moveComputer[1], 2);
       gameUI.placeStone(moveComputer[0], moveComputer[1], 2);

       if (findWinner()) {
           System.out.println("Player 2 wins!");
           return false;
       }
       if (endGame()) {
           System.out.println("Its a draw!");
           return false;

       }
       return true;
   }

    /**
     * Checks if any player has won the game.
     *
     * @return true if a player has won, false otherwise.
     */
    public boolean findWinner() {
        for (int i = 0; i < b1.length; i++) {
            for (int j = 0; j < b1[i].length; j++) {
                if (b1[i][j] != 0 &&
                        (checkDirection(b1, i, j, 1, 0) ||
                                checkDirection(b1, i, j, 0, 1) ||
                                checkDirection(b1, i, j, 1, 1) ||
                                checkDirection(b1, i, j, 1, -1))) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * A helper method to check for a winning sequence in a specific direction.
     *
     * @param board The current game board state.
     * @param x Starting x coordinate.
     * @param y Starting y coordinate.
     * @param dx Change in x direction.
     * @param dy Change in y direction.
     * @return true if a winning sequence is found, false otherwise.
     */
    private boolean checkDirection(int[][] board, int x, int y, int dx, int dy) {
        int n = board.length;
        int player = board[x][y];

        for (int i = 0; i < 5; i++){
            int newX = x + dx * i;
            int newY = y + dy * i;
            if (newX < 0 || newX >= n || newY < 0 || newY >= n || board[newX][newY] != player) {
                return false;
            }
        }
        return true;
    }
    /**
     * Checks if the game has ended in a draw.
     *
     * @return true if game is a draw, false otherwise.
     */
   public boolean endGame(){
       for (int i = 0; i < board.board.length ; i++) {
           for (int j = 0; j < board.board[i].length; j++) {
               if(board.board[i][j] == 0){
                   return false;
               }
           }
       }
       return true;
   }
    /**
     * Retrieves the game board instance.
     *
     * @return The current game board.
     */
   public Board getBoard(){
       return this.board;
   }

}
