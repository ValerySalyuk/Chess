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
        return false;
    }
}
