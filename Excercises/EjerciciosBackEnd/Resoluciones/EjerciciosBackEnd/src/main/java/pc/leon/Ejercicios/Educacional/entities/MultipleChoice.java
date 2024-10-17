package pc.leon.Ejercicios.Educacional.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@Entity
@Table
public class MultipleChoice extends Question {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "choice_x_option",
            joinColumns = @JoinColumn(name = "multiple_choice_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id")
    )
    private List<Option> options;
    private int optionChosen = 0;
    private int correctOption;

    @Override
    public int studentScore() {
        //if the student doesn't choose anything
        if (optionChosen == 0) return 0;

        //option chosen is correct
        if (optionChosen == correctOption) return getScore();

        //option incorrect
        else return -getScore();

    }
}

//        Multiple Choice, clase hija de Pregunta, que representa una pregunta con cuatro opciones de
//las cuales solo una opción es la correcta. Esta clase además de los atributos heredados tiene
//como atributos propios:
//        * una colección con las opciones posibles (Instancias de la clase Opción)
//* opciónElegidaAlumno: número de la opción seleccionada por el alumno
//* opciónCorrecta: número de la opción correcta.
//Con el siguiente metodo polimórfico:
//        * puntajeAlumno: en este caso se debe tener en cuenta que si el alumno responde mal se le
//resta el puntaje que tiene asignado la pregunta. Por lo tanto:
//        * Si la opción elegida por el alumno es correcta este metodo retorna el puntaje total
//asignado a la pregunta
//    * Si la opción elegida es “incorrecta” retorna el puntaje que tiene asignado la pregunta
//en valor negativo
//    * Si la pregunta no tiene opción elegida por el alumno (es decir, que el atributo opción
//        elegida por el alumno es cero), debe retornar cero
