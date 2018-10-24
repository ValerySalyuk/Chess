package chess.board.pieces;

public class Queen extends ChessPiece {

    public Queen(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        if (isWhite()) {
            return "\u2655";
        }
        else {
            return "\u265B";
        }
    }

}
