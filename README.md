# Simple Chess

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
