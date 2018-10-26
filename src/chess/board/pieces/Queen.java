package chess.board.pieces;

import chess.board.Move;

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

    @Override
    public boolean checkTheoreticallyCorrect(Move move) {
        int diffX = move.to.x - move.from.x;
        int diffY = move.to.y - move.from.y;
        return  ((Math.abs(diffX) > 0 && Math.abs(diffY) > 0 && Math.abs(diffX) == Math.abs(diffY)))
                || !(Math.abs(diffX) > 0 && Math.abs(diffY) > 0);
    }
}
