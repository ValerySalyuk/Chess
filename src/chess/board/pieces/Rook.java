package chess.board.pieces;

import chess.board.Move;

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

    @Override
    public boolean checkTheoreticallyCorrect(Move move) {
        int diffX = move.to.x - move.from.x;
        int diffY = move.to.y - move.from.y;
        return !(Math.abs(diffX) > 0 && Math.abs(diffY) > 0);
    }
}
