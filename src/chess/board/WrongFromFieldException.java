package chess.board;

public class WrongFromFieldException extends Exception {

    public String errorMessage;

    public WrongFromFieldException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
