package chess.board;

public class Coords {

    public int x;
    public int y;

    public Coords(Builder builder) {
        x = builder.x;
        y = builder.y;
    }


    public static final class Builder {
        private int x;
        private int y;

        public Builder() {
        }

        public Builder x(int val) {
            x = val;
            return this;
        }

        public Builder y(int val) {
            y = val;
            return this;
        }

        public Coords build() {
            return new Coords(this);
        }
    }
}
