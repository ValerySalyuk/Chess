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
                if (board.gameOver()) {
                    break;
                }
            } catch (ChessException e) {
                System.out.println(e.getMessage());
            }

        }

        GameStatus status = board.getStatus();

        switch (status) {
            case DRAW:
                System.out.println("Draw");
                break;
            case BLACK_VICTORY:
                System.out.println("Black wins!");
                break;
            case WHITE_VICTORY:
                System.out.println("White wins!");
                break;
            case PAT_BLACK:
                break;
            case PAT_WHITE:
                break;
            default:
                System.out.println("Error happened. Sorry");
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
