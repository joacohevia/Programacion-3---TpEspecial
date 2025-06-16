public class Maquina {
    private String nombre;
    private int numPiezas;

    public Maquina(String nombre, int numPiezas) {
        this.nombre = nombre;
        this.numPiezas = numPiezas;
    }

    @Override
    public String toString() {
        return getNombre()+";"+getNumPiezas();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumPiezas() {
        return numPiezas;
    }

    public void setNumPiezas(int numPiezas) {
        this.numPiezas = numPiezas;
    }
}
