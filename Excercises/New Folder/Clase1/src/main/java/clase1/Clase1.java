/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package clase1;

import java.util.ArrayList;

public class Clase1 {

    public static void main(String[] args) {
        Alumno alumno = new Alumno("Leon", "Lederhos Sturich", "INg en sistemas");
        Materia  paradigmasDeProgramacion, disenioSistemas, AED;
        Inscripcion inscripcion = new Inscripcion();
        
        AED = new Materia("Algoritmos y estructuras de datos", EstadoMateria.APROBADA);
        
        paradigmasDeProgramacion = new Materia("Paradigmas de programacio", EstadoMateria.CURSANDO);
        paradigmasDeProgramacion.getCorrelativas().add(AED); //agregada AED para que sea correlativa
        
        disenioSistemas = new Materia("Diseño de sistemas", EstadoMateria.CURSANDO);
        disenioSistemas.getCorrelativas().add(paradigmasDeProgramacion);
        
        alumno.getMatAprobadas().add(AED);
        
        inscripcion.inscribirseMateria(alumno, paradigmasDeProgramacion);
        inscripcion.inscribirseMateria(alumno, disenioSistemas);
        System.out.println("una vez tenga aprogabada ppr ... \n");
        
        inscripcion.inscribirseMateria(alumno, disenioSistemas);
        
        
        
    }

    enum EstadoMateria {
        CURSANDO,
        APROBADA,
        ABANDONO,
        REGULAR,
        LIBRE,
        INSCRIPTO
    }

    static class Alumno {

        String nombre;
        String apellido;
        long legajo;
        static long legajoActual = 1;
        String carrera;
        ArrayList<Materia> matInscripto;
        ArrayList<Materia> matAprobadas;
        //ArrayList<Materia> matTotal;

        public Alumno(String nombre, String apellido, String carrera) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.legajo = legajoActual;
            this.carrera = carrera;
            this.matAprobadas = new ArrayList<>();
            this.matInscripto = new ArrayList<>();
            // this.matTotal = new ArrayList<>();

            legajoActual++;

        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public void setCarrera(String carrera) {
            this.carrera = carrera;
        }

        public void addMateriaAprobada(Materia mat) {
            this.matAprobadas.add(mat);
        }

        public void addMateriaInscripto(Materia mat) {
            this.matInscripto.add(mat);
        }

        public void rmvMateriaInscripto(Materia mat) {
            this.matAprobadas.add(mat);
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public long getLegajo() {
            return legajo;
        }

        public String getCarrera() {
            return carrera;
        }

        public ArrayList<Materia> getMatInscripto() {
            return matInscripto;
        }

        public ArrayList<Materia> getMatAprobadas() {
            return matAprobadas;
        }

    }

    static class Materia {

        ArrayList<Materia> correlativas;
        String nombre;
        long id;
        static long idGlobal = 1;
        EstadoMateria estado;

        public Materia(String nombre, EstadoMateria estado) {
            this.nombre = nombre;
            this.id = idGlobal;
            correlativas = new ArrayList<>();
            idGlobal++;
        }

        public String getNombre() {
            return nombre;
        }

        public long getId() {
            return id;
        }

        public EstadoMateria getEstado() {
            return estado;
        }

        public ArrayList<Materia> getCorrelativas() {
            return correlativas;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setEstado(EstadoMateria estado) {
            this.estado = estado;
        }

        public void addCorrelativa(Materia materia) {
            this.correlativas.add(materia);

        }

        //al igual que arriva aca podria agregar la materia directamente con un id, suponiendo que esta ya existe en el registro
        public void rmvCorrelativa(Materia materia) {
            this.correlativas.remove(materia);
        }

    }

    static class Inscripcion {

        void inscribirseMateria(Alumno alumno, Materia materia) {
            boolean puedeInscribirse = true;
            int total_aprobadas = alumno.matAprobadas.size();
            if (materia.correlativas.size() != 0) {
                for (int i = 0; i < materia.correlativas.size(); i++) {
                    if(puedeInscribirse){
                      for (int j = 0; j < total_aprobadas; j++) {
                        if (materia.correlativas.get(i).getId() == alumno.matAprobadas.get(j).getId()) {
                            if (!aprobada(alumno.matAprobadas.get(j))) {
                                puedeInscribirse = false;
                                break;
                            }
                        }
                    }  
                    }else{
                        break;
                    }
                    
                }
                if (puedeInscribirse) {
                    materia.estado = EstadoMateria.INSCRIPTO;
                    alumno.matInscripto.add(materia);
                    System.out.println("Se ha inscripto correctamente en la materia");
                } else {
                    System.out.println("Hay una o mas correlativas sin aprobar");
                }
            }else{
                alumno.matInscripto.add(materia);
                System.out.println("Se ha inscripto correctamente en la materia");
            }

        }

        boolean aprobada(Materia materia) {
            if (materia.estado == EstadoMateria.APROBADA) {
                return true;
            }
            return false;
        }
    }

}
