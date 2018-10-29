package chess.board.exceptions;

import chess.board.Field;
import chess.board.Move;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    // todo doesn't work for Pawn

    public static boolean isStraightMovePossible(Move move, Field[][] board, boolean canEat) {

        List<Field> fieldsOnTheWay = new ArrayList<>();

        if (move.from.x != move.to.x) {

            Integer startX = move.from.x < move.to.x ? move.from.x : move.to.x;
            Integer endX = move.from.x < move.to.x ? move.to.x : move.from.x;

            for (int i = startX + 1; i <= endX; ++i) {
                fieldsOnTheWay.add(board[i][move.from.y]);
            }
        } else {

            int startY = move.from.y < move.to.y ? move.from.y : move.to.y;
            int endY = move.from.y < move.to.y ? move.to.y : move.from.y;

            for (int i = startY + 1; i <= endY; ++i) {
                fieldsOnTheWay.add(board[move.from.x][i]);
            }
        }

        for (int i = 0; i < fieldsOnTheWay.size() -1; ++i) {
            if (!fieldsOnTheWay.get(i).isEmpty()) {
                return false;
            }
        }

        if (!canEat) {
            return fieldsOnTheWay.get(fieldsOnTheWay.size() - 1).isEmpty();
        }

        return true;

    }

}
