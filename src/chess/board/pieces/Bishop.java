package chess.board.pieces;

import chess.board.Move;

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

    @Override
    public boolean checkTheoreticallyCorrect(Move move) {
        return false;
    }
}
