package pc.leon.Ejercicios.transporte;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transporte {
    private String matricula;
    private float precioBase;
    private String nombre;

    public Transporte(String nombre, String matricula, float precioBase) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.precioBase = precioBase;
    }

    public Transporte(String matricula, float precioBase, String nombre) {
        this.matricula = matricula;
        this.precioBase = precioBase;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "matricula='" + matricula + '\'' +
                ", precioBase=" + precioBase +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
