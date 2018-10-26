package chess.board.exceptions;

public class ChessException extends Exception {

    public String errorMessage;

    public ChessException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
