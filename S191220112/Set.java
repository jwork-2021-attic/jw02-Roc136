package S191220112;

public interface Set {
    
    class Position {

        protected Linable linable;

        Position(Linable linable) {
            this.linable = linable;
        }

        public void setLinable(Linable linable) {
            this.linable = linable;
            linable.setPosition(this);
        }

    }

    public void put(Linable linable, int i);
    public Linable get(int i);
    public Linable[] toArray();

}
