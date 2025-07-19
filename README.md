# Simple Chess

<<<<<<< HEAD
A simple, fully functional chess game implemented in Java using Swing. Play classic chess against another player on the same computer, with all standard rules supported.

## Features

- Complete chess rules: legal moves, check, checkmate, stalemate
- Special moves: castling, pawn promotion, en passant
- Visual board and piece movement
- Turn-based play (White vs Black)
- Game status display (turn, check, checkmate, stalemate)

## Screenshots

*Add screenshots here if available*

## Getting Started

### Prerequisites
- Java JDK 8 or higher

### Setup & Run
1. **Clone or download this repository.**
2. **Compile the source code:**
   - Using command line:
     ```sh
     javac -d out src/main/*.java src/piece/*.java
     ```
   - Or use your favorite IDE (IntelliJ IDEA, Eclipse, etc.) to import the project and build.
3. **Run the game:**
   - Using command line:
     ```sh
     java -cp out main.Main
     ```
   - Or run `Main.java` from your IDE.

## Project Structure

```
src/
  main/
    Main.java         # Entry point
    GamePanel.java    # Main game logic and rendering
    Board.java        # Board drawing
    Mouse.java        # Mouse input handling
    Type.java         # Piece type enum
  piece/
    Piece.java        # Base class for all pieces
    Pawn.java         # Pawn logic
    Rook.java         # Rook logic
    Knight.java       # Knight logic
    Bishop.java       # Bishop logic
    Queen.java        # Queen logic
    King.java         # King logic
```

## How to Play
- Click and drag pieces to move them.
- Only legal moves are allowed.
- When a pawn reaches the last rank, select a piece to promote to.
- The game will display messages for check, checkmate, and stalemate.

## Credits
- Developed by Anish Ghanwat
- Piece images and board colors inspired by classic chess sets.

## License
This project is licensed under the MIT License.
=======
A basic console-based Chess game implemented in Java. This project simulates a standard chess game between two players, focusing on simplicity and functionality. It is perfect for beginner programmers looking to learn game development concepts or chess enthusiasts wanting to explore game mechanics.

## Features
- **Classic 8x8 Chessboard**: Full chess game simulation.
- **Player vs Player**: Two-player mode where each player takes turns.
- **Move Validation**: Ensures that only legal moves can be made.
- **Check and Checkmate Detection**: Automatically detects check and checkmate situations.
- **Command-Line Interface**: Simple text-based interface for ease of use.

## Installation
1. Clone this repository to your local machine:
   git clone https://github.com/your-username/simple-chess.git
>>>>>>> c0c738ed09c7c51abe2b1adb1beb124b60e3ad22
