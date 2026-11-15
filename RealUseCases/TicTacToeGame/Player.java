package DesignPattern.RealUseCases.TicTacToeGame;

/**
 * Class representing a player in a tic-tac-toe game.
 * Each player has a name and a move symbol (X or O).
 */
public class Player {

    private final String name;
    private final MoveSymbol symbol;

    public Player(String name, MoveSymbol symbol){
        this.name  = name;
        this.symbol = symbol;
    }

    /**
     * Method to get the name of the player.
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get the move symbol of the player.
     * @return the move symbol of the player
     */
    public MoveSymbol getSymbol() {
        return symbol;
    }

    /**
     * Method to place a move on the board for the player.
     */
    public void makeMove(Board board, int row, int column) {
        if (board == null) {
            throw new IllegalArgumentException("Board cannot be null.");
        }
        board.placeMove(row, column, this.symbol);
    }
}
