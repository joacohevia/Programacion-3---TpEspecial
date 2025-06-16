import java.util.List;

public class Solucion {
    private List<Maquina> secuenciaDeMaquinas;
    private int piezasProducidas;
    private int puestasEnFuncionamiento;
    private int costoSolucion;

    public Solucion(int costoSolucion, int piezasProducidas, int puestasEnFuncionamiento, List<Maquina> secuenciaDeMaquinas) {
        this.costoSolucion = costoSolucion;
        this.piezasProducidas = piezasProducidas;
        this.puestasEnFuncionamiento = puestasEnFuncionamiento;
        this.secuenciaDeMaquinas = secuenciaDeMaquinas;
    }


    @Override
    public String toString() {
        return "Solucion obtenida: " + secuenciaDeMaquinas+
                "\nCantidad de piezas producidas: " + piezasProducidas +
                "\nCantidad de puestas en funcionamiento: " + puestasEnFuncionamiento +
                "\nCosto de la solucion: " + costoSolucion;
    }
}

