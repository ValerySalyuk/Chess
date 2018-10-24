package chess.board;

import chess.board.pieces.*;

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

    public void makeMove(Move move) throws WrongFromFieldException {

        if (validateMove(move)) {
            board[move.to.x][move.to.y] = board[move.from.x][move.from.y];
            board[move.from.x][move.from.y] = new Field();

            this.whiteTurn = !this.whiteTurn;
        }

    }

    private boolean validateMove(Move move) throws WrongFromFieldException {

        Field from = board[move.from.x][move.from.y];

        if (from.isEmpty()) {
            throw new WrongFromFieldException("Can't move from empty place");
        }

        if (from.getChessPiece().isWhite() != this.whiteTurn) {
            throw new WrongFromFieldException("It's " + (this.whiteTurn ? "white" : "black") + " turn");
        }

        if (move.from.x < 0 || move.from.y < 0 || move.from.x > 7 || move.from.y > 7
                || move.to.x < 0 || move.to.y < 0 || move.to.x > 7 || move.to.y > 7) {
            throw new WrongFromFieldException("Use coordinates from 1 to 8");
        }

        // Validation of piece move

        ChessPiece chessPiece = board[move.from.x][move.from.y].getChessPiece();

        // Validate Pawn move
        if (chessPiece instanceof Pawn) {
            boolean wrongMove = false;
            if (move.to.y == move.from.y) {
                if (this.whiteTurn) {
                    if (move.from.x == 1) {
                        if (move.to.x <= move.from.x || move.to.x > move.from.x + 2) {
                            wrongMove = true;
                        }
                    } else if (move.to.x <= move.from.x || move.to.x > move.from.x + 1) {
                        wrongMove = true;
                    }
                } else {
                    if (move.from.x == 6) {
                        if (move.to.x >= move.from.x || move.to.x > move.from.x - 2) {
                            wrongMove = true;
                        }
                    } else if (move.to.x >= move.from.x || move.to.x > move.from.x - 1) {
                        wrongMove = true;
                    }
                }
            } else {
                if (this.whiteTurn) {
                    if ((move.to.x != move.from.x + 1)
                            || (move.to.y > move.from.y + 1) || (move.to.y > move.from.y - 1)) {
                        wrongMove = true;
                    } else if (board[move.to.x][move.to.y].getChessPiece() == null
                            || board[move.to.x][move.to.y].getChessPiece().isWhite() == this.whiteTurn) {
                        wrongMove = true;
                    }
                } else {
                    if ((move.to.x != move.from.x - 1)
                            || (move.to.y > move.from.y + 1) || (move.to.y > move.from.y - 1)) {
                        wrongMove = true;
                    } else if (board[move.to.x][move.to.y].getChessPiece() == null
                            || board[move.to.x][move.to.y].getChessPiece().isWhite() == this.whiteTurn) {
                        wrongMove = true;
                    }
                }
            }
            if (wrongMove) throw new WrongFromFieldException("That's not a pawn move");
        }

        return true;

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
