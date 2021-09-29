package S191220112;

public class Matrix implements Set {

    private int size;
    private Position[][] positions;

    public Matrix(int size) {
        this.size = size;
        this.positions = new Position[size][size];
    }

    public void put(Linable linable, int i, int j) {
        if ((i < 0 ) || (i > size) || (j < 0) || (j > size)) {
            return;
        }
        if (this.positions[i][j] == null) {
            this.positions[i][j] = new Position(null);
        }
        this.positions[i][j].setLinable(linable);
    }

    public Linable get(int i, int j) {
        if ((i < 0 ) || (i > size) || (j < 0) || (j > size)) {
            return null;
        } else {
            return positions[i][j].linable;
        }
    }

    @Override
    public void put(Linable linable, int i) {
        this.put(linable, i / size, i % size);
    }

    @Override
    public Linable get(int i) {
        return this.get(i / size, i % size);
    }

    @Override
    public String toString() {
        String lineString = "";

        for (Position[] line : positions) {
            for (Position p : line) {
                lineString += p.linable.toString();
            }
            lineString += "\n";
        }

        return lineString;
    }

    @Override
    public Linable[] toArray() {
        Linable[] linables = new Linable[size * size];
        int i = 0;

        for (Position[] line : positions) {
            for (Position p : line) {
                linables[i++] = p.linable;
            }
        }

        return linables;
    }
}
