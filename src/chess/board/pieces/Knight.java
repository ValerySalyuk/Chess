package chess.board.pieces;

public class Knight extends ChessPiece {

    public Knight(boolean white) {
        super(white);
    }

    @Override
    public String toString() {
        if (isWhite()) {
            return "\u2658";
        }
        else {
            return "\u265E";
        }
    }

}
