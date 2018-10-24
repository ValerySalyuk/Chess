package chess.board.pieces;

public class Bishop extends ChessPiece {

    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        if (isWhite()) {
            return "\u2657";
        }
        else {
            return "\u265D";
        }
    }

}
