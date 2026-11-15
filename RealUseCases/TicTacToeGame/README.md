# Tic-Tac-Toe Game System Design

## 1. Requirements

The Tic-Tac-Toe system should provide a simple but reliable 2-player game experience with the following core requirements:

- A 3x3 board is used for gameplay.
- Players take turns placing marks (`X` and `O`) on empty cells.
- The system should validate moves and reject invalid positions.
- A winner is determined when a player aligns three marks horizontally, vertically, or diagonally.
- If the board is full and no player has won, the game ends in a draw.
- The game should support restarting a new round without restarting the application.
- The state of the board and current turn should be tracked consistently throughout the session.
- The design should remain easy to extend for future features such as AI mode, score tracking, or multiplayer support.

## 2. Approach

The solution is designed as a small domain-driven system with clear separation between game rules and user interaction.

- Board: Represents the 3x3 grid and tracks occupied cells.
- Player: Represents each participant and their symbol (`X` or `O`).
- Game State: Maintains the current status of the game such as active, won, or draw.
- Move Validation: Ensures a move is not made on an already occupied cell.
- Win Detection: Checks all winning combinations after each valid move.
- Turn Management: Alternates between players after each successful move.
- Restart Logic: Resets the board and state for the next round.

This approach keeps the logic easy to test and enables future enhancements without tightly coupling the rules to the UI or input layer.

## 3. Design Pattern Used

The primary design pattern used is the State Pattern.

Why this fits well:

- The game moves through well-defined states such as `INITIAL`, `PLAYING`, `PLAYER_WIN`, and `DRAW`.
- Each state has clear behavior and transition rules.
- Logic for handling user actions is separated from the state transitions themselves.
- It makes the system easier to extend when adding new gameplay states or screen-level behaviors.

In short, the game is modeled as a finite state machine, where each move changes the system from one valid game state to another.

## 4. Summary

This Tic-Tac-Toe design focuses on a clean, manageable architecture: requirements define the behavior, the approach separates domain responsibilities, and the State Pattern provides a natural and scalable way to manage the game's lifecycle.
