import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FabricaBacktracking {
    private List<Maquina> maquinasDisponibles;
    private List<Maquina> caminoActual;
    private List<Maquina> solucion;
    private int piezasAproducir; //las piezas totales a producir
    private int estados;

    public FabricaBacktracking(){
        maquinasDisponibles = new ArrayList<>();
        caminoActual = new ArrayList<>();
        solucion = new ArrayList<>();
    }

    public Solucion secuenciaMaquinasBack(){
        secuenciaMaquinasBack(0);
        if (!solucion.isEmpty())
            return new Solucion(estados,piezasAproducir, solucion.size(), solucion);
        return null;
    }

    private void secuenciaMaquinasBack(int piezasAct){
        estados++;
        if (piezasAct == piezasAproducir){
            if (solucion.isEmpty() || solucion.size() > caminoActual.size()){
                solucion.clear();
                solucion.addAll(caminoActual);
            }
        }else{//si tengo una solucion con mas maquinas no me interesa
            if (!solucion.isEmpty() && caminoActual.size() >= solucion.size()){
                return;
            }
            for (Maquina maq : maquinasDisponibles){
                piezasAct += maq.getNumPiezas();
                if (piezasAct <= piezasAproducir){
                    caminoActual.add(maq);
                    secuenciaMaquinasBack(piezasAct);
                    caminoActual.remove(caminoActual.size()-1);
                }//si la maquina genera mas piezas de las que necesito
                piezasAct -= maq.getNumPiezas();
            }
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
    public List<Maquina> getMaquinasDisponibles() {
         return new ArrayList<>(maquinasDisponibles);
    }

    @Override
    public String toString() {
        String resultado = "Piezas a producir: " + getPiezasAproducir() + "\n";
        for (Maquina m : maquinasDisponibles) {
            resultado += m.toString() + "\n";
        }
        return resultado;
    }


    public int getPiezasAproducir() {
        return piezasAproducir;
    }

}
