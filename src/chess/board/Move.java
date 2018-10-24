package chess.board;

public class Move {

    public Coords from;
    public Coords to;

    private Move(Builder builder) {
        from = builder.from;
        to = builder.to;
    }


    public static final class Builder {
        private Coords from;
        private Coords to;

        public Builder() {
        }

        public Builder from(Coords val) {
            from = val;
            return this;
        }

        public Builder to(Coords val) {
            to = val;
            return this;
        }

        public Move build() {
            return new Move(this);
        }
    }

}
