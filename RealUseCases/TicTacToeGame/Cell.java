package DesignPattern.RealUseCases.TicTacToeGame;

/**
 * Class representing a cell in a tic-tac-toe game. Each cell can hold a move symbol (X, O, or EMPTY).
 */
public class Cell {

    int row;
    int column;
    MoveSymbol symbol;

    public Cell(int row, int column, MoveSymbol symbol) {
        this.row = row;
        this.column = column;
        this.symbol = symbol;
    }

    /**
     * Method to get the move symbol of the cell.
     * @return the move symbol of the cell
     */
    public MoveSymbol getSymbol() {
        return symbol;
    }
}
