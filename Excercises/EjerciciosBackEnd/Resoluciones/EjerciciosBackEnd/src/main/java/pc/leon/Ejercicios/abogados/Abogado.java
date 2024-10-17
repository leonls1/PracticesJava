package pc.leon.Ejercicios.abogados;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public abstract class Abogado {
    //Con respecto a los **abogados** el estudio registra los siguientes datos: número de documento, apellido,
    //nombre, dirección de correo y causas que le fueron asignadas.

    private int nroDocumento;
    private String nombre;
    private String apellido;
    private String direccionCorreo;
    private List<Causa> causas = new ArrayList<>();

    public int obtenerTotalCausasAbiertas(){
        return (int) causas.stream().filter(causa -> causa.getState() == 1).count();
    }

    public List<Causa> obtenerCausasAbiertas(){
        return causas.stream().filter(causa -> causa.getState() == 1).collect(Collectors.toList());
    }

    public void añadirCausa(Causa causa){
        causas.add(causa);
    }

    protected int obtenerTotalCausasFavorables(){
        return  obtenerCausasFavorables().size();
    }

    protected List<Causa> obtenerCausasFavorables(){
        return   causas.stream()
                .filter(causa -> causa.getState() == 2 && causa.getSentencia() == 1)
                .collect(Collectors.toList());
    }

    protected abstract float calcularHaberes();
}
