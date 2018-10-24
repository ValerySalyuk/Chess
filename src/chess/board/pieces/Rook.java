package chess.board.pieces;

public class Rook extends ChessPiece {

    public Rook(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        if (isWhite()) {
            return "\u2656";
        }
        else {
            return "\u265C";
        }
    }


}
