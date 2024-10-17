package pc.leon.Ejercicios.Educacional.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int questNumber;
    private String text;
    private int score;

    public abstract int studentScore();
}
//Pregunta, tiene como atributos
//* Número de pregunta
//* Texto: descripción de la pregunta en sí, por ejemplo, “qué es un objeto?”
//* Puntaje: puntaje asignado a la pregunta dentro del examen (por ejemplo, dentro del examen
//la pregunta tiene asignado 10 puntos).