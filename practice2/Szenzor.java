public abstract class Szenzor {
    protected Pozicio pozicio;

    public Szenzor(Pozicio pozicio) {
        this.pozicio = pozicio;
    }

    public abstract boolean isAktiv();
    public abstract void adatkuldes();

    public Pozicio getPozicio() {
        return pozicio;
    }

    void setPozicio(Pozicio pozicio) {
        this.pozicio = pozicio;
    }

    @Override
    protected abstract Object clone() throws CloneNotSupportedException;
    @Override
    public String toString() {
        return String.format("%s (%d; %d)",
                isAktiv() ? "On" : "Off",
                pozicio.getX(), pozicio.getY());
    }
}
