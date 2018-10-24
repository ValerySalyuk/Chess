package chess.board;

import chess.board.pieces.ChessPiece;

public class Field {

    private ChessPiece chessPiece;

    public Field(ChessPiece chessPiece) {

        if (chessPiece == null) {
            throw new NullPointerException("Chess piece can't be null");
        }

        this.chessPiece = chessPiece;
    }

    public Field() {
    }

    public boolean isEmpty() {
        return chessPiece == null;
    }

    public void clear(){
        this.chessPiece = null;
    }

    public ChessPiece getChessPiece() {
        return this.chessPiece;
    }

    @Override
    public String toString() {
        return this.chessPiece == null ? "\u2014" : chessPiece.toString();
    }

}
