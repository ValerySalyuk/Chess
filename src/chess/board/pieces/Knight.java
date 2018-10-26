package chess.board.pieces;

import chess.board.Move;

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

    @Override
    public boolean checkTheoreticallyCorrect(Move move) {

        int diffX = move.to.x - move.from.x;
        int diffY = move.to.y - move.from.y;

        return ((Math.abs(diffX) == 2 && Math.abs(diffY) == 1)
                || (Math.abs(diffY) ==2 && Math.abs(diffX) ==1));
    }
}
