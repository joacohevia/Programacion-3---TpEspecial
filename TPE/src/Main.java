public class Main {
    public static void main(String[] args) {
        FabricaBacktracking fabricaBack = new FabricaBacktracking();
        fabricaBack.cargarDesdeArchivo("TPE/src/resources/produccion.txt");
        Solucion solucionBack = fabricaBack.secuenciaMaquinasBack();
        System.out.println("Solucion Backtracking");
        if (solucionBack != null){
            System.out.println(solucionBack);
        }else{
            System.out.println("No se encontro solucion");
        }


        FabricaGreedy fabricaGreedy = new FabricaGreedy();
        fabricaGreedy.cargarDesdeArchivo("TPE/src/resources/produccion.txt");
        Solucion solucionGreedy = fabricaGreedy.secuenciaMaquinasGreedy();
        System.out.println("\nSolucion Greedy");
        if (solucionGreedy != null){
            System.out.println(solucionGreedy);
        }else{
            System.out.println("No se encontro solucion");
        }

    }
}