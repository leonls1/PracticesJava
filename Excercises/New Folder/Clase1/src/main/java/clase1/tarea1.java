/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase1;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author leon
 */
public class tarea1 {

    public static void main(String[] args) {
        Materia AED, PPR, DSI;
        Alumno alumno = new Alumno("Sasha Leon Alexis", "Lederhos Sturich ", 77971L);

        AED = new Materia("Algoritmo y estructura de datos", 1L, true);

        PPR = new Materia("Paradigmas de programacio", 2L, false);
        PPR.addCorrelativa(1L);

        DSI = new Materia("Diseño de sistemas", 3L, false);
        DSI.addCorrelativa(2L);
        Inscripcion inscripcionAed = new Inscripcion("1k1", "Juan perez", AED, alumno);
        Inscripcion inscripcionPPR = new Inscripcion("2k1", "Pedro perez", PPR, alumno);
        Inscripcion inscripcionDSI = new Inscripcion("3k1", "Jose perez", DSI, alumno);

        System.out.println("\n una vez aprueba ppr... \n");
        PPR.setEstado(true);
        inscripcionDSI = new Inscripcion("3k1", "Jose perez", DSI, alumno);

    }

    static class Inscripcion {

        Long legajoAlumno, idMateria;
        LocalDate fechaInscripcion;
        String curso, profesor;

        public Inscripcion(String curso, String profesor, Materia materia, Alumno alumno) {
            if (puedeInscribirse(materia, alumno)) {
                alumno.addMateria(materia);
                this.fechaInscripcion = LocalDate.now();
                this.curso = curso;
                this.profesor = profesor;
            }

        }

        boolean puedeInscribirse(Materia materia, Alumno alumno) {
            ArrayList<Long> correlativas = materia.getIdCorrelativas();
            int correlativasTamanio = materia.idCorrelativas.size();

            if (correlativasTamanio > 0) {
                int tamañoAprobadas = 0;
                ArrayList<Long> aprobadas = new ArrayList<>();

                //consiguiendo una lista de todos los id de las materias aprobadas
                for (int i = 0; i < alumno.materias.size(); i++) {
                    if (alumno.materias.get(i).estado) {
                        tamañoAprobadas++;
                        aprobadas.add(alumno.materias.get(i).getId());
                    }
                }
                //si hay mas correlativas que las materias que tiene el alumno aprobadas no es logico que pueda inscribirse
                if (tamañoAprobadas < correlativasTamanio) {
                    System.out.println("Faltan correlativas");
                    return false;
                }

                for (int i = 0; i < correlativasTamanio; i++) {
                    if (!aprobadas.contains(correlativas.get(i))) {
                        System.out.println("Una o mas correlativas no se estan aprobadas para la materia: " + materia.getNombre());
                        return false;
                    }
                }
                System.out.println("Se cumplen las correlativas, se ha inscripto en la materia " + materia.getNombre() + " correctamente");
                return true;

            } else {
                System.out.println("La materia no tiene correlativas, inscripcion realizada");
                return true;
            }
        }

    }

    static class Alumno {

        String nombre;
        String apellido;
        Long legajo;
        ArrayList<Materia> materias; //treu --> aprobada flase no

        public Alumno(String nombre, String apellido, Long legajo) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.legajo = legajo;
            this.materias = new ArrayList<>();
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public Long getLegajo() {
            return legajo;
        }

        public ArrayList<Materia> getMaterias() {
            return materias;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public void addMateria(Materia materia) {
            this.materias.add(materia);
        }

        public void rmvMateria(Materia materia) {
            this.materias.remove(materia);
        }

    }

    static class Materia {

        String nombre;
        Long id;
        Boolean estado;
        ArrayList<Long> idCorrelativas;

        public Materia(String nombre, Long id, Boolean estado) {
            this.nombre = nombre;
            this.id = id;
            this.estado = estado;
            this.idCorrelativas = new ArrayList<>();
        }

        public String getNombre() {
            return nombre;
        }

        public Long getId() {
            return id;
        }

        public Boolean getEstado() {
            return estado;
        }

        public ArrayList<Long> getIdCorrelativas() {
            return idCorrelativas;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setEstado(Boolean estado) {
            this.estado = estado;
        }

        public void addCorrelativa(Long id) {
            this.idCorrelativas.add(id);
        }

        public void rmvCorrelativas(Long id) {
            this.idCorrelativas.remove(id);
        }
    }

}
