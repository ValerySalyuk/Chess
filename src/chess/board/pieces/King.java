package chess.board.pieces;

public class King extends ChessPiece {

    public King(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        if (isWhite()) {
            return "\u2654";
        }
        else {
            return "\u265A";
        }
    }

}
