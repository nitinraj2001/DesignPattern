package DesignPattern.RealUseCases.TicTacToeGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Player 1 name: ");
        String player1Name = scanner.nextLine().trim();
        if (player1Name.isEmpty()) {
            player1Name = "Alice";
        }

        System.out.print("Enter Player 2 name: ");
        String player2Name = scanner.nextLine().trim();
        if (player2Name.isEmpty()) {
            player2Name = "Bob";
        }

        Player player1 = new Player(player1Name, MoveSymbol.X);
        Player player2 = new Player(player2Name, MoveSymbol.O);

        Board board = new Board(3);
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        GameOrchestrator game = new GameOrchestrator(board,players) ;
        game.startGame();

        System.out.println("Game started. " + player1.getName() + " is X and " + player2.getName() + " is O.");
        game.getBoard().displayBoard();

        while (game.getGameStatus() == GameStatus.IN_PROGRESS) {
            Player currentPlayer = game.getCurrentPlayer();
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");
            System.out.print("Enter row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0-2): ");
            int col = scanner.nextInt();

            try {
                boolean moveSuccessful = game.makeMove(row, col);
                if (!moveSuccessful) {
                    System.out.println("Invalid move. Choose an empty cell.");
                    continue;
                }

                System.out.println("Successful move! Current board:");
                game.getBoard().displayBoard();
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Game over. Final status: " + game.getGameStatus());
        if (game.getGameStatus() == GameStatus.X_WON) {
            System.out.println(player1.getName() + " wins!");
        } else if (game.getGameStatus() == GameStatus.O_WON) {
            System.out.println(player2.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }

        scanner.close();
    }
}
