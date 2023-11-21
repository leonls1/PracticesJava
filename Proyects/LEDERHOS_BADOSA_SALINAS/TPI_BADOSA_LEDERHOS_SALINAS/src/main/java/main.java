
import java.util.List;
import java.util.stream.Collectors;
import model.businessLogic.entity.Employee;
import model.businessLogic.entity.Incident;
import model.service.IncidentImp;
import model.service.IncidentService;


public class main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    
    /*
    
    b) Quién fue el técnico con más incidentes resueltos de una determinada especialidad en los últimos N días
    c) Quién fue el técnico que más rápido resolvió los incidentes
    */
    
    //a)Quién fue el técnico con más incidentes resueltos en los últimos N días
    public static Employee masIncidentesResueltosEnPeriodo(int n){
        IncidentService service = new IncidentImp();

        List<Incident> incidentesCompletadosNdias = service.getAll()
                .stream()
                .filter(incident -> incident.isState())
                .collect(Collectors.toList());
        
    }
    
}
