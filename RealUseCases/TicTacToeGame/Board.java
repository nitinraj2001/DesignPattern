package DesignPattern.RealUseCases.TicTacToeGame;

/**
 * Class representing the board of a tic-tac-toe game.
 * The board consists of a grid of cells, each of which can hold a move symbol (X, O, or EMPTY).
 */
public class Board {

     final int size;
     final Cell[][] cells;

    public Board(int size){
        if (size <= 0) {
            throw new IllegalArgumentException("Board size must be greater than zero.");
        }
        this.size = size;
        this.cells = new Cell[size][size];
        initializeBoard();
    }

    /**
     * Method to initialize the board by setting all cells to EMPTY symbol.
     */
    public void initializeBoard(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.cells[i][j] = new Cell(i, j, MoveSymbol.EMPTY);
            }
        }
    }

    /**
     * Method to check if a specific cell on the board is empty.
     * @param row the row index of the cell
     * @param column the column index of the cell
     * @return true if the cell is empty, false otherwise
     */
    public boolean isCellEmpty(int row, int column) {
        if (row >= 0 && row < size && column >= 0 && column < size) {
            return this.cells[row][column].getSymbol() == MoveSymbol.EMPTY;
        }
        return false;
    }

    /**
     * Method to check if the board is full (i.e., no empty cells left).
     * @return true if the board is full, false otherwise
     */
    public boolean isFull(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.cells[i][j].getSymbol() == MoveSymbol.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method to place a move on the board at the specified row and column with the given symbol.
     * @param row the row index where the move is to be placed
     * @param col the column index where the move is to be placed
     * @param symbol the symbol to be placed on the board
     */
    public void placeMove(int row, int col, MoveSymbol symbol){
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new IllegalArgumentException("Move is out of bounds.");
        }
        if (symbol == null || symbol == MoveSymbol.EMPTY) {
            throw new IllegalArgumentException("Only X or O can be placed on the board.");
        }
        if (!isCellEmpty(row, col)) {
            throw new IllegalStateException("Cell is already occupied.");
        }

        this.cells[row][col] = new Cell(row, col, symbol);
    }

    /**
     * Method to check the current status of the game based on the board's state.
     * @return the current game status
     */
    public GameStatus checkGameStatus() {
        for (int i = 0; i < size; i++) {
            if (cells[i][0].getSymbol() != MoveSymbol.EMPTY &&
                cells[i][0].getSymbol() == cells[i][1].getSymbol() &&
                cells[i][1].getSymbol() == cells[i][2].getSymbol()) {
                return cells[i][0].getSymbol() == MoveSymbol.X ? GameStatus.X_WON : GameStatus.O_WON;
            }
            if (cells[0][i].getSymbol() != MoveSymbol.EMPTY &&
                cells[0][i].getSymbol() == cells[1][i].getSymbol() &&
                cells[1][i].getSymbol() == cells[2][i].getSymbol()) {
                return cells[0][i].getSymbol() == MoveSymbol.X ? GameStatus.X_WON : GameStatus.O_WON;
            }
        }

        if (cells[0][0].getSymbol() != MoveSymbol.EMPTY &&
            cells[0][0].getSymbol() == cells[1][1].getSymbol() &&
            cells[1][1].getSymbol() == cells[2][2].getSymbol()) {
            return cells[0][0].getSymbol() == MoveSymbol.X ? GameStatus.X_WON : GameStatus.O_WON;
        }
        if (cells[0][2].getSymbol() != MoveSymbol.EMPTY &&
            cells[0][2].getSymbol() == cells[1][1].getSymbol() &&
            cells[1][1].getSymbol() == cells[2][0].getSymbol()) {
            return cells[0][2].getSymbol() == MoveSymbol.X ? GameStatus.X_WON : GameStatus.O_WON;
        }

        return isFull() ? GameStatus.DRAW : GameStatus.IN_PROGRESS;
    }

    public void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                MoveSymbol symbol = this.cells[i][j].getSymbol();
                System.out.print(symbol == MoveSymbol.EMPTY ? " . " : " " + symbol + " ");
                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < size - 1) {
                for (int k = 0; k < size; k++) {
                    System.out.print("---");
                    if (k < size - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public Cell[][] getCells() {
        return cells;
    }
}
