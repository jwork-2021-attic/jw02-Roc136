package S191220112;

public class Line implements Set{

    public Line(int length) {
        this.positions = new Position[length];
    }

    private Position[] positions;

    @Override
    public void put(Linable linable, int i) {
        if (this.positions[i] == null) {
            this.positions[i] = new Position(null);
        }
        this.positions[i].setLinable(linable);
    }

    @Override
    public Linable get(int i) {
        if ((i < 0) || (i > positions.length)) {
            return null;
        } else {
            return positions[i].linable;
        }
    }

    @Override
    public String toString() {
        String lineString = "";
        for (Position p : positions) {
            lineString += p.linable.toString();
        }
        return lineString;
    }

    @Override
    public Linable[] toArray() {
        Linable[] linables = new Linable[this.positions.length];

        for (int i = 0; i < linables.length; i++) {
            linables[i] = positions[i].linable;
        }

        return linables;

    }

}
