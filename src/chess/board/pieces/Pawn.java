package chess.board.pieces;

public class Pawn extends ChessPiece {

    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        if (isWhite()) {
            return "\u2659";
        }
        else {
            return "\u265F";
        }
    }

}
