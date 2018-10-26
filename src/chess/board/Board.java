package chess.board;

import chess.board.exceptions.ChessException;
import chess.board.pieces.*;

import java.util.Optional;

public class Board extends Constants {

    private Field[][] board;
    private boolean whiteTurn;

    public Board() {

        this.board = new Field[ROW_COLUMN_SIZE][ROW_COLUMN_SIZE];
        this.whiteTurn = true;

        this.initBoard();
        this.fillPrawns(true);
        this.fillPrawns(false);
        this.fillRooks();
        this.fillKnights();
        this.fillBishops();
        this.fillKings();
        this.fillQueens();

    }

    public void makeMove(Move move) throws ChessException {

        validateMove(move);

        board[move.to.x][move.to.y] = board[move.from.x][move.from.y];
        board[move.from.x][move.from.y] = new Field();

        this.whiteTurn = !this.whiteTurn;


    }

    // 0. Coord in board
    // 1. Empty
    // 2. Own color
    // 3. Check move theoretically correct
    // 4. Context validation (not jump over, correctly eat other piece)
    // 5. Check check (шах)

    private void validateMove(Move move) throws ChessException {
        if (!coordsInBoard(move)) {
            throw new ChessException("Coordinates are outside of the board");
        }

        if (!pieceExists(move.from)) {
            throw new ChessException("Nothing to move from empty field");
        }

        if (!pieceColorMatchTurn(move.from)) {
            throw new ChessException("It's " + (this.whiteTurn ? "white" : "black") + " turn");
        }

        ChessPiece fromChessPiece = board[move.from.x][move.from.y].getChessPiece();
        if (!fromChessPiece.checkTheoreticallyCorrect(move)) {
            String pieceName = "";
            if (fromChessPiece instanceof Pawn) pieceName = "pawn";
            if (fromChessPiece instanceof Rook) pieceName = "rook";
            if (fromChessPiece instanceof Knight) pieceName = "knight";
            if (fromChessPiece instanceof Bishop) pieceName = "bishop";
            if (fromChessPiece instanceof King) pieceName = "king";
            if (fromChessPiece instanceof Queen) pieceName = "queen";
            throw new ChessException("That's not " + pieceName +"'s move");
        }

    }

    private boolean coordsInBoard(Move move) {
        return move.from.x >= 0 && move.from.y >= 0 && move.from.x <= 7 && move.from.y <= 7
                && move.to.x >= 0 && move.to.y >= 0 && move.to.x <= 7 && move.to.y <= 7;
    }

    private boolean pieceExists(Coords from) {
        Field field = board[from.x][from.y];
        return !field.isEmpty();
    }

    private boolean pieceColorMatchTurn(Coords from) {
        Field field = board[from.x][from.y];
        return field.getChessPiece().isWhite() == this.whiteTurn;
    }

    public Field[][] getBoard() {
        return this.board;
    }

    public boolean isWhiteTurn() {
        return whiteTurn;
    }

    private void initBoard() {

        for (int i = 0; i < ROW_COLUMN_SIZE; ++i) {
            for (int j = 0; j < ROW_COLUMN_SIZE; ++j) {
                board[i][j] = new Field();
            }
        }

    }

    private void fillPrawns(boolean isWhite) {

        int rowIndex = isWhite ? 1 : 6;

        for (int i = 0; i < ROW_COLUMN_SIZE; ++i) {
            board[rowIndex][i] = new Field(new Pawn(isWhite));
        }

    }

    private void fillRooks() {

        final int leftCol = 0;
        final int rightCol = 7;

        board[0][leftCol] = new Field(new Rook(true));
        board[0][rightCol] = new Field(new Rook(true));
        board[7][leftCol] = new Field(new Rook(false));
        board[7][rightCol] = new Field(new Rook(false));

    }

    private void fillKnights() {

        final int leftCol = 1;
        final int rightCol = 6;

        board[0][leftCol] = new Field(new Knight(true));
        board[0][rightCol] = new Field(new Knight(true));
        board[7][leftCol] = new Field(new Knight(false));
        board[7][rightCol] = new Field(new Knight(false));

    }

    private void fillBishops() {

        final int leftCol = 2;
        final int rightCol = 5;

        board[0][leftCol] = new Field(new Bishop(true));
        board[0][rightCol] = new Field(new Bishop(true));
        board[7][leftCol] = new Field(new Bishop(false));
        board[7][rightCol] = new Field(new Bishop(false));

    }

    private void fillKings() {

        final int kingCol = 3;

        board[0][kingCol] = new Field(new King(true));
        board[7][kingCol] = new Field(new King(false));

    }

    private void fillQueens() {

        final int queenCol = 4;

        board[0][queenCol] = new Field(new Queen(true));
        board[7][queenCol] = new Field(new Queen(false));

    }

}
