package pc.leon.Ejercicios.abogados;

public class Penalista extends Abogado {
    //Los abogados **Penalistas** cobran un
    //monto fijo por cada causa favorable que tuvieron a su cargo
    private float montoFijo;

    public float calcularHaberes(){
        return obtenerTotalCausasFavorables()*montoFijo;
    }

}
