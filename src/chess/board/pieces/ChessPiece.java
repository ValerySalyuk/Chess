package chess.board.pieces;

import chess.board.Move;

public abstract class ChessPiece {

    protected boolean white;

    public ChessPiece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    public abstract boolean checkTheoreticallyCorrect (Move move);

    @Override
    public abstract String toString();

}
