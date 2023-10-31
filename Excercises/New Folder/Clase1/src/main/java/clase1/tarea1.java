/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase1;

import java.util.ArrayList;

/**
 *
 * @author leon
 */
public class tarea1 {

    public static void main(String[] args) {        
        Materia AED, PPR, DSI;
        Incripcion insc = new Incripcion();
        Alumno alumno = new Alumno("Sasha Leon Alexis", "Lederhos Sturich ", 77971L);
        
        AED = new Materia("Algoritmo y estructura de datos", 1L, true);
        
        PPR = new Materia("Paradigmas de programacio", 2L, false);
        PPR.addCorrelativa(1L);        
        
        DSI = new Materia("Diseño de sistemas", 3L, false);
        DSI.addCorrelativa(2L);
        
        insc.inscribirMateria(AED, alumno);
        insc.inscribirMateria(PPR, alumno);
        insc.inscribirMateria(DSI, alumno); 
        
        System.out.println("\n una vez aprueba ppr... \n");
        PPR.setEstado(true);
        insc.inscribirMateria(DSI, alumno); 
        
  
    }

    static class Incripcion {
        

        boolean inscribirMateria(Materia materia, Alumno alumno) {
            
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
                if(tamañoAprobadas < correlativasTamanio){
                    System.out.println("Faltan correlativas");
                    return false;
                }
                
                for (int i = 0; i < correlativasTamanio; i++) {
                    if(! aprobadas.contains(correlativas.get(i))){
                        System.out.println("Una o mas correlativas no se estan aprobadas para la materia: " + materia.getNombre());
                        return false;
                    }
                }
                System.out.println("Se cumplen las correlativas, se ha inscripto en la materia " + materia.getNombre() +   " correctamente");
                alumno.addMateria(materia);
                return true;

            } else {
                System.out.println("La materia no tiene correlativas, inscripcion realizada");
                alumno.addMateria(materia);
                return true;
            }
        }
    }

    static class Alumno {

        String nombre;
        String apellido;
        Long legajo;
        ArrayList<Materia> materias;

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
