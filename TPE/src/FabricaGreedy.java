import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class FabricaGreedy {
    private List<Maquina> maquinasDisponibles;
    private int piezasAproducir;
    private int contadorEstados;
    private List<Maquina> solucion;
    private List<Maquina> caminoAct;

    public FabricaGreedy(){
        this.maquinasDisponibles = new ArrayList<>();
        this.solucion = new ArrayList<>();
        this.caminoAct = new ArrayList<>();
    }

    public Solucion secuenciaMaquinasGreedy(){
        maquinasDisponibles.sort(Comparator.comparingInt(Maquina::getNumPiezas).reversed());
        //ordeno las maquinas de mayor a menor numero de piezas
        secuenciaMaquinasGreedy(0);
        if (!solucion.isEmpty()){
            return new Solucion(contadorEstados,piezasAproducir, solucion.size(), solucion);
        }
        return null;
    }

    private void secuenciaMaquinasGreedy(int piezasAct){
        int i=0;
        while (i < maquinasDisponibles.size() && piezasAproducir != piezasAct){
            Maquina act = maquinasDisponibles.get(i);

            if ((piezasAct + act.getNumPiezas()) <= piezasAproducir){
                caminoAct.add(act);
                piezasAct += act.getNumPiezas();
                //i++; ELIMINARR
            } else {
                i++;// si produce piezas de mas paso a la siguiente
            }
            contadorEstados++;
        }
        if (piezasAct == piezasAproducir){
            solucion.addAll(caminoAct);
        }
    }
    public void cargarDesdeArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea = br.readLine();
            piezasAproducir = Integer.parseInt(linea);

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0].trim();
                int piezas = Integer.parseInt(partes[1].trim());
                maquinasDisponibles.add(new Maquina(nombre, piezas));
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
