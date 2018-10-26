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
        return false;
    }
}
