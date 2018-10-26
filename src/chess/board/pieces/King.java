package chess.board.pieces;

import chess.board.Move;

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

    @Override
    public boolean checkTheoreticallyCorrect(Move move) {
        int diffX = move.to.x - move.from.x;
        int diffY = move.to.y - move.from.y;
        return !(Math.abs(diffX) > 1 || Math.abs(diffY) > 1);
    }
}
