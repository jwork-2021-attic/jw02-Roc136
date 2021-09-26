package S191220112;

import S191220112.Line.Position;

public class Gourds {

    private static Gourds theGourdManger;
    private static Gourd[] gourds;
    private static int index;

    // number 写 8 或 16
    public static void initGourds(int number) {
        if (theGourdManger == null) {
            theGourdManger = new Gourds();
        }
        gourds = new Gourd[number*number];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++){
                int rank, r, g, b;
                rank = i * number + j + 1;
                // TODO : cal rgb
                g = 256 / number * i;
                b = 256 / number * j;
                r = (g + b) / 2;
                gourds[rank - 1] = theGourdManger.new Gourd(r, g, b, rank);
            }
        }
        index = 1;
    }
    
    public static Gourd getGourdByRank(int rank) {
    
        if (rank <= gourds.length) {
            return gourds[rank - 1];
        }
        return null;

    }

    public static Gourd getRandom() {
        index = (index + 1) % gourds.length;
        return gourds[index];
    }
    
    public class Gourd implements Linable {

        private final int r;
        private final int g;
        private final int b;
        private final int rank;
    
        private Position position;
    
        Gourd(int r, int g, int b, int rank) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.rank = rank;
        }
    
        public int rank() {
            return this.rank;
        }
    
        @Override
        public String toString() {
            String text = "   ";
            if (true) {
                text = String.format("  %03d  ", this.rank());
            }
            return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m" + text + "\033[0m";
        }
    
        @Override
        public void setPosition(Position position) {
            this.position = position;
        }
    
        @Override
        public Position getPosition() {
            return this.position;
        }
    
        public void swapPosition(Gourd another) {
            Position p = another.position;
            this.position.setLinable(another);
            p.setLinable(this);
        }
    
        @Override
        public int getValue() {
            return this.rank();
        }
    
    }
}