package chess.board.pieces;

public abstract class ChessPiece {

    protected boolean white;

    public ChessPiece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    @Override
    public abstract String toString();

}
