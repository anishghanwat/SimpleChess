package piece;

import main.Board;
import main.GamePanel;
import main.Type;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Piece {

    public Type type;
    public BufferedImage image;
    public int x, y;
    public int col, row, preCol, preRow;
    public int color;
    public Piece hittingP;
    public boolean moved, twoStepped;

    public Piece(int color, int col, int row) {
        this.color = color;
        this.col = col;
        this.row = row;

        x = getX(col);
        y = getY(row);

        preCol = col;
        preRow = row;
    }

    /**
     * Loads an image from the given path.
     * @param imagePath the relative path to the image resource
     * @return BufferedImage if the image is found, otherwise null
     */
    public BufferedImage getImage(String imagePath) {
        BufferedImage image = null;
        try {
            // Use getResourceAsStream to load the image from the classpath
            InputStream imageStream = getClass().getResourceAsStream(imagePath);
            if (imageStream == null) {
                throw new IllegalArgumentException("Image not found: " + imagePath);
            }
            image = ImageIO.read(imageStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public int getX(int col) {
        return col * Board.SQUARE_SIZE;
    }

    public int getY(int row) {
        return row * Board.SQUARE_SIZE;
    }

    public int getCol(int x) {
        return (x + Board.HALF_SQUARE_SIZE) / Board.SQUARE_SIZE;
    }

    public int getRow(int y) {
        return (y + Board.HALF_SQUARE_SIZE) / Board.SQUARE_SIZE;
    }

    public int getIndex() {
        for(int index = 0; index < GamePanel.simPieces.size(); index++) {
            if(GamePanel.simPieces.get(index) == this) {
                return index;
            }
        }
        return 0;
    }

    public void updatedPosition() {
        //to check en passant
        if(type == Type.PAWN) {
            if(Math.abs(row - preRow) == 2) {
                twoStepped = true;
            }
        }
        x = getX(col);
        y = getY(row);
        preCol = getCol(x);
        preRow = getRow(y);
        moved = true;
    }

    public void resetPosition() {
        col = preCol;
        row = preRow;
        x = getX(col);
        y = getY(row);
    }

    public boolean canMove(int targetCol, int targetRow) {
        return false;
    }

    public boolean isWithinBoard(int targetCol, int targetRow) {
        if (targetCol >= 0 && targetCol <= 7 && targetRow >= 0 && targetRow <=7) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSameSquare(int targetCol, int targetRow) {
        if (targetCol == preCol && targetRow == preRow) {
            return true;
        }
        return false;
    }

    public Piece getHittingP(int targetCol, int targetRow) {
        for(Piece piece : GamePanel.simPieces) {
            if(piece.col == targetCol && piece.row == targetRow && piece != this) {
                return piece;
            }
        }
        return null;
    }

    public boolean isValidSquare(int targetCol, int targetRow) {
        hittingP = getHittingP(targetCol, targetRow);
        if(hittingP == null) {
            return true; //this square is VACANT
        } else {  //this square is OCCUPIED
            if(hittingP.color != this.color) {
                return true;
            } else {
                hittingP = null;
            }
        }
        return false;
    }

    public boolean pieceIsOnStraightLine(int targetCol, int targetRow) {
        // When the piece is moving left
        for (int c = preCol - 1; c > targetCol; c--) {
            for (Piece piece : GamePanel.simPieces) {
                if (piece.col == c && piece.row == targetRow) {  // Compare with loop variable 'c'
                    hittingP = piece;
                    return true;
                }
            }
        }
        // When the piece is moving right
        for (int c = preCol + 1; c < targetCol; c++) {
            for (Piece piece : GamePanel.simPieces) {
                if (piece.col == c && piece.row == targetRow) {  // Compare with loop variable 'c'
                    hittingP = piece;
                    return true;
                }
            }
        }
        // When the piece is moving up
        for (int r = preRow - 1; r > targetRow; r--) {
            for (Piece piece : GamePanel.simPieces) {
                if (piece.row == r && piece.col == targetCol) {  // Compare with loop variable 'r'
                    hittingP = piece;
                    return true;
                }
            }
        }
        // When the piece is moving down
        for (int r = preRow + 1; r < targetRow; r++) {
            for (Piece piece : GamePanel.simPieces) {
                if (piece.row == r && piece.col == targetCol) {  // Compare with loop variable 'r'
                    hittingP = piece;
                    return true;
                }
            }
        }
        return false;
    }


    public boolean pieceIsOnDiagonalLine(int targetCol, int targetRow) {

        if(targetRow < preRow) {
            //up left
            for(int c = preCol-1; c > targetCol; c-- ) {
                int diff = Math.abs(c - preCol);
                for(Piece piece : GamePanel.simPieces) {
                    if(piece.col == c && piece.row == preRow - diff)  {
                        hittingP = piece;
                        return true;
                    }
                }
            }
            //up right
            for(int c = preCol+1; c < targetCol; c++) {
                int diff = Math.abs(c - preCol);
                for(Piece piece : GamePanel.simPieces) {
                    if(piece.col == c && piece.row == preRow - diff)  {
                        hittingP = piece;
                        return true;
                    }
                }
            }
        }

        if(targetRow > preRow) {
            //down left
            for(int c = preCol-1; c > targetCol; c-- ) {
                int diff = Math.abs(c - preCol);
                for(Piece piece : GamePanel.simPieces) {
                    if(piece.col == c && piece.row == preRow + diff)  {
                        hittingP = piece;
                        return true;
                    }
                }
            }
            //down right
            for(int c = preCol+1; c < targetCol; c++ ) {
                int diff = Math.abs(c - preCol);
                for(Piece piece : GamePanel.simPieces) {
                    if(piece.col == c && piece.row == preRow + diff)  {
                        hittingP = piece;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void draw(Graphics2D g2) {
        if (image != null) {
            g2.drawImage(image, x, y, 100, 100, null);
        } else {
            System.out.println("Warning: Image not loaded.");
        }
    }
}
