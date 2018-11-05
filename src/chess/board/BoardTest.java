package chess.board;

import chess.board.exceptions.ChessException;
import chess.board.pieces.ChessPiece;
import chess.board.pieces.Pawn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;
    private Pawn whitePawn;
    private Pawn blackPawn;

    private Move makeMove(int startX, int startY, int endX, int endY) {
        Move move = new Move.Builder()
                .from(
                        new Coords.Builder()
                                .x(startX)
                                .y(startY)
                                .build()
                )
                .to(
                        new Coords.Builder()
                                .x(endX)
                                .y(endY)
                                .build()
                )
                .build();

        return move;
    }

    @BeforeEach
    void setUp() {
        board = new Board();
        whitePawn = new Pawn(true);
        blackPawn = new Pawn(false);
    }

    @Test
    void shouldBeWhiteTurnAtFirstMove() {
        assertTrue(board.isWhiteTurn());
    }

    @Test
    void shouldBeBlackTurnAtSecondMove() throws ChessException {
        board.makeMove(this.makeMove(1, 2, 2, 2));
        assertFalse(board.isWhiteTurn());
    }
    
    
}