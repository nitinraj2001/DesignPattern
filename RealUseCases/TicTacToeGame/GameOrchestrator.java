package DesignPattern.RealUseCases.TicTacToeGame;

import java.util.List;

/**
 *  Class representing the orchestrator of a tic-tac-toe game. This class is responsible for managing the game flow, including player turns,
 *  checking for a winner, and determining the game status.
 */
public class GameOrchestrator {

    Board board;
    List<Player> players;
    Player currentPlayer;
    GameStatus gameStatus;

    /**
     *  Constructor for the GameOrchestrator class. Initializes the game with a board and a list of players.
     *  @param board the game board
     *  @param players the list of players participating in the game
     */
    public GameOrchestrator(Board board, List<Player> players) {
        if (players == null || players.size() < 2) {
            throw new IllegalArgumentException("At least two players are required.");
        }
        Player player1 = players.get(0);
        Player player2 = players.get(1);
        if (player1 == null || player2 == null) {
            throw new IllegalArgumentException("Both players are required.");
        }
        if (player1.getSymbol() == player2.getSymbol()) {
            throw new IllegalArgumentException("Players must use different symbols.");
        }
        this.board = board;
        this.players = players;
    }

    /**
     *  Method to start the game.
     */
    public void startGame(){
        System.out.println("Starting the game...");
        board.initializeBoard();
        this.currentPlayer = players.get(0);
        System.out.println("Current player: " + currentPlayer.getName() + " with symbol: " + currentPlayer.getSymbol());
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    /**
     *  Method to make a move for the current player at the specified row and column.
     *  @param row the row index for the move
     *  @param col the column index for the move
     * @return  true if the move was successful, false otherwise
     */
    public boolean makeMove(int row, int col) {
        if (gameStatus != GameStatus.IN_PROGRESS) {
            System.out.println("Game is not in progress. Current status: " + gameStatus);
            return false;
        }

        if (row < 0 || row >= board.size || col < 0 || col >= board.size) {
            System.out.println("Invalid move. Row and column must be between 0 and " + (board.size - 1));
            return false;
        }

        if (!board.isCellEmpty(row, col)) {
            System.out.println("Cell is already occupied. Choose another cell.");
            return false;
        }

        board.placeMove(row, col, currentPlayer.getSymbol());
        gameStatus = board.checkGameStatus();

        if (gameStatus == GameStatus.IN_PROGRESS) {
            switchTurn();
        } else {
            System.out.println("Game over! Status: " + gameStatus);
        }

        return true;
    }

    /**
     *  Method to switch the turn to the next player. This method is called after a successful move.
     *  It updates the current player to the next player in the list.
     *  If the current player is the last in the list, it wraps around to the first player.
     *  This method does not perform any checks on the game status or the validity of the move; it simply updates the current player.
     *  It is assumed that this method is called only when the game is in progress and a valid move has been made.
     */
    public void switchTurn(){
        currentPlayer = currentPlayer == players.get(0) ? players.get(1) : players.get(0);
        System.out.println("Next player: " + currentPlayer.getName() + " with symbol: " + currentPlayer.getSymbol());
    }

    /**
     * This method is used to check the game status
     * @return  the current game status
     */
    public GameStatus getGameStatus(){
        return this.gameStatus;
    }

    /**
     *  Method to get the game board.
     *  @return the game board
     */
    public Board getBoard() {
        return board;
    }

    /**
     *  Method to get the current player whose turn it is to make a move.
     * @return  the current player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
