package pc.leon.Ejercicios.abogados;

public class Civil extends Abogado {
    //cobran un porcentaje sobre el monto total obtenido por causas con sentencia favorables que tuvieron a cargo.
    private float porcentajeGanancia;

    @Override
    public float calcularHaberes() {
        float montoTotal = 0;
        for (Causa causa : obtenerCausasFavorables()) {
            montoTotal += causa.getAmount() * porcentajeGanancia/100;
        }

        return montoTotal;
    }
}
