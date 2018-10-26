package chess.controller;

import chess.board.*;
import chess.board.exceptions.ChessException;

import java.util.Scanner;

public class GameController extends Constants {

    private Board board;

    public void start() {

        board = new Board();
        this.startGameLoop();

    }

    private void startGameLoop() {
        while (true) {

            this.print();
            Move move = readPlayerMove();

            try {
                board.makeMove(move);
            } catch (ChessException e) {
                System.out.println(e.errorMessage);
            }

        }
    }

    private Move readPlayerMove() {

        Scanner sc = new Scanner(System.in);
        System.out.printf("It's %s turn. Enter your move: \n From: \n", this.board.isWhiteTurn() ? "white" : "black");
        String fromX = sc.nextLine();
        String fromY = sc.nextLine();

        System.out.println("To:");
        String toX = sc.nextLine();
        String toY = sc.nextLine();

        return new Move.Builder()
                .from(new Coords.Builder()
                        .x(Integer.parseInt(fromX) - 1)
                        .y(Integer.parseInt(fromY) - 1)
                        .build())
                .to(new Coords.Builder()
                        .x(Integer.parseInt(toX) - 1)
                        .y(Integer.parseInt(toY) - 1)
                        .build())
                .build();

    }

    private void print() {

        for (int i = 0; i < ROW_COLUMN_SIZE; ++i) {
            for (int j = 0; j < ROW_COLUMN_SIZE; ++j) {
                System.out.print(board.getBoard()[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }

}
