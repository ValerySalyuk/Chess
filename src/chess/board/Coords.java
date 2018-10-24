package chess.board;

public class Coords {

    public byte x;
    public byte y;

    private Coords(Builder builder) {
        x = builder.x;
        y = builder.y;
    }


    public static final class Builder {
        private byte x;
        private byte y;

        public Builder() {
        }

        public Builder x(byte val) {
            x = val;
            return this;
        }

        public Builder y(byte val) {
            y = val;
            return this;
        }

        public Coords build() {
            return new Coords(this);
        }
    }
}
