package pc.leon.Ejercicios.Educacional.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Written extends Question{
    private String studentResponse;

    @Enumerated(value = EnumType.STRING)
    private TeacherEvaluation teacherEvaluation;

    @Override
    public int studentScore(){
        return getScore();
    }
}


//Redactada, clase hija de Pregunta, que representa una pregunta a desarrollar, es decir, cuya
//respuesta debe ser redactada por un alumno. Esta clase además de los atributos heredados
//tiene como atributos propios:
//* respuestaAlumno: respuesta dada por el alumno (de texto libre) y,
//* evaluaciónDocente: evaluación dada por el docente que puede ser [Mal/Regular/Bien/Muy
//Bien/Excelente].
//Con el siguiente metodo polimórfico:
//  * puntajeAlumno: el sistema determina cual es el puntaje obtenido por el alumno en la
//  pregunta. Para ello se tiene en cuenta el siguiente criterio: Si la evaluación dada por el
//  docente es:
//  *“Mal”: retorna cero.
//  *“Regular”: retorna el 45 % del puntaje total que tiene asignado la pregunta.
//  * “Bueno”: retorna el 55 % del puntaje total que tiene asignado la pregunta.
//  * “Muy bueno”: retorna el 80 % del puntaje total que tiene asignado la pregunta.
//  * “Excelente”: retorna el puntaje total que tiene asignada la pregunto en el examen.
