package ar.edu.utnfrc.sping_service_web.model.dtos;

import ar.edu.utnfrc.sping_service_web.model.entities.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UnpaidDetail {
    //   1. Listado de alquileres a cobrar a la compañía, (Ver Nombre de la compañía del cliente,
    //   nombre completo del cliente que alquilo
    //   , el codigo del alquiler
    //   , datos del vehículo
    //   , fecha de entrega y de devolución del vehículo
    //   el total a cobrar para esa compañia (cost_hour del vehiculo por travel_total_hours))
    private String companyName;
    private String clientFullName;
    private Long rentId;
    private Vehicle vehicle;
    private LocalDate rentalDate;
    private LocalDate returnedDate;
    private int totalToPay;

    public UnpaidDetail(String companyName, String firstName, String lastName, Long rentId, Vehicle vehi,
                        LocalDate rentalDate, LocalDate returnedDate, int totalHours) {
        this.companyName = companyName;
        this.clientFullName = firstName +" "+  lastName;
        this.rentId = rentId;
        this.vehicle = vehi;
        this.rentalDate = rentalDate;
        this.returnedDate = returnedDate;
        this.totalToPay = vehi.getCostHour()*totalHours;
    }
}
