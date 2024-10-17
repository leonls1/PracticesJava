### Trabajo JPA ###

Una institución pedagógica nos ha solicitado desarrollar un sistema a través del cual se puedan
registrar los exámenes evaluados a sus alumnos de forma de obtener resultados y sacar
conclusiones con respecto a sus instrumentos de evaluación. Importante,La institución nos informa que los exámenes
además de los datos del alumno contienen un set de preguntas. La preguntas pueden ser de múltiple opción
(donde una sola opción es la correcta) o bien, una pregunta cuya respuesta se espera sea redactada por el alumno.
Para ello se han identificado las siguientes entidades:

Pregunta, tiene como atributos    
* Número de pregunta
* Texto: descripción de la pregunta en sí, por ejemplo, “qué es un objeto?”
* Puntaje: puntaje asignado a la pregunta dentro del examen (por ejemplo, dentro del examen
la pregunta tiene asignado 10 puntos).

Redactada, clase hija de Pregunta, que representa una pregunta a desarrollar, es decir, cuya
respuesta debe ser redactada por un alumno. Esta clase además de los atributos heredados
tiene como atributos propios:
* respuestaAlumno: respuesta dada por el alumno (de texto libre) y,
* evaluaciónDocente: evaluación dada por el docente que puede ser [Mal/Regular/Bien/Muy
Bien/Excelente].
Con el siguiente metodo polimórfico:
  * puntajeAlumno: el sistema determina cual es el puntaje obtenido por el alumno en la
  pregunta. Para ello se tiene en cuenta el siguiente criterio: Si la evaluación dada por el
  docente es:
  *“Mal”: retorna cero.
  *“Regular”: retorna el 45 % del puntaje total que tiene asignado la pregunta.
  * “Bueno”: retorna el 55 % del puntaje total que tiene asignado la pregunta.
  * “Muy bueno”: retorna el 80 % del puntaje total que tiene asignado la pregunta.
  * “Excelente”: retorna el puntaje total que tiene asignada la pregunto en el examen.

Multiple Choice, clase hija de Pregunta, que representa una pregunta con cuatro opciones de
las cuales solo una opción es la correcta. Esta clase además de los atributos heredados tiene
como atributos propios:
* una colección con las opciones posibles (Instancias de la clase Opción)
* opciónElegidaAlumno: número de la opción seleccionada por el alumno
* opciónCorrecta: número de la opción correcta.
Con el siguiente metodo polimórfico:
  * puntajeAlumno: en este caso se debe tener en cuenta que si el alumno responde mal se le
  resta el puntaje que tiene asignado la pregunta. Por lo tanto:
    * Si la opción elegida por el alumno es correcta este método retorna el puntaje total
    asignado a la pregunta
    * Si la opción elegida es “incorrecta” retorna el puntaje que tiene asignado la pregunta
    en valor negativo
    * Si la pregunta no tiene opción elegida por el alumno (es decir, que el atributo opción
    elegida por el alumno es cero), debe retornar cero

Opción, representa una opción de una pregunta multiple choice que posee como atributos:
número de opción y descripción de la opción.

Alumno, representa al alumno que rinde el examen. Los atributos que se registran del alumno
son: legajo (entero), documentoIdentidad, nombre, direccion, telefono, email.

Examen, representa el examen rendido por un alumno, que posee como atributos:
* Un alumno (instancia de la clase Alumno) y,
* Una colección con las preguntas que se evalúan.

Todas las entidades tendran un campo Id que los identificará univocamente