package chess.board.pieces;

import chess.board.Coords;
import chess.board.Move;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    private static Pawn whitePawn;
    private static Pawn blackPawn;

    @BeforeEach
    private void setUp() {
        //
    }

    private boolean moveCorrect(Pawn pawn, int fromX, int fromY, int toX, int toY) {
        Move move = new Move.Builder()
                .from(
                        new Coords.Builder()
                                .x(fromX).y(fromY).build()
                )
                .to(
                        new Coords.Builder().x(toX).y(toY).build()
                )
                .build();
        return pawn.checkTheoreticallyCorrect(move);
    }

    @BeforeAll
    public static void beforeAll() {
        whitePawn = new Pawn(true);
        blackPawn = new Pawn(false);
    }

    @Test
    public void shouldMoveForward() {

    }

    @Test
    public void canMoveForward2FieldsAtFirstMove() {

        assertTrue(moveCorrect(whitePawn, 2, 2, 3, 2), "Pawn can't move more than 2 fields forward");

    }

    @Test
    public void shouldNotMoveHorizontally() {

        Pawn p = new Pawn(true);
        Move move = new Move.Builder()
                .from(
                        new Coords.Builder()
                                .x(2).y(2).build()
                )
                .to(
                        new Coords.Builder().x(2).y(2).build()
                )
                .build();
        boolean moveCorrect = p.checkTheoreticallyCorrect(move);

        assertFalse(moveCorrect);

    }

    @Test
    public void shouldNotMoveBackwards() {

        Pawn p = new Pawn(false);
        Move move = new Move.Builder()
                .from(
                        new Coords.Builder()
                                .x(5)
                                .y(2)
                                .build()
                )
                .to(
                        new Coords.Builder()
                                .x(7)
                                .y(2)
                                .build()
                )
                .build();
        boolean moveCorrect = p.checkTheoreticallyCorrect(move);

        assertFalse(moveCorrect);

    }

    @Test
    public void shouldMove1FieldDiagonally() {

        Pawn p = new Pawn(true);
        Move move = new Move.Builder()
                .from(
                        new Coords.Builder()
                                .x(1)
                                .y(2)
                                .build()
                )
                .to(
                        new Coords.Builder()
                                .x(2)
                                .y(1)
                                .build()
                )
                .build();
        boolean moveCorrect = p.checkTheoreticallyCorrect(move);

        assertTrue(moveCorrect);

    }

}