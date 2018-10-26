package chess.board.pieces;

import chess.board.Move;

public class Pawn extends ChessPiece {

    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean checkTheoreticallyCorrect(Move move) {

        int diffX = move.to.x - move.from.x;
        int diffY = move.to.y - move.from.y;
        int startX = isWhite() ? 1 : 6;

        // Not moves forward or moves more than 2 fields forward
        if (Math.abs(diffX) < 1 || Math.abs(diffX) > 2) {
            return false;
        }

        // Moves more than 2 fields forward when not on the first line
        if (move.from.x != startX && Math.abs(diffX) > 1) {
            return false;
        }

        // Moves left or right and (not moves forward or moves forward too far)
        if (diffY != 0 && Math.abs(diffX) != 1) {
            return false;
        }

        // Moves forward 1 field but left / right more than 1 field
        if (Math.abs(diffX) == 1 && Math.abs(diffY) > 1) {
            return false;
        }

        // Moves left / right to empty field

        // Moves forward but the field is occupied

        return true;

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
