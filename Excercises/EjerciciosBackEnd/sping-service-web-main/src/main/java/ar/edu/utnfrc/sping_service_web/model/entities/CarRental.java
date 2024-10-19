package ar.edu.utnfrc.sping_service_web.model.entities;


import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
@Getter
@Setter
@Schema(title = "rent of a car", description = "model to represent a rent of a car")
public class CarRental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(title = "started rent", description = "date when the rent started", required = true)
    private LocalDate rentalDate;

    @Schema(title = "end rent", description = "date when the rent finished", required = true)
    private LocalDate returnedDate;

    @Schema(title = "paid status", description = "if the rent is paid or not", required = true, example = "false")
    private boolean paid;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "carRental")
    @ArraySchema(schema = @Schema(title = "rent details", description = "details of the current rent"))
    private List<CarRentalDetail> details;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    @Schema(title = "payment detail", description = "detail of the payment of the current rent", required = false)
    private Payment payment;

    @Schema(title = "total hours traveled", description = "total hours traveled during the rent")
    private int totalHoursTraveled;

    public void setTotalHoursTraveled() {
        int total = details.stream()
                .mapToInt(CarRentalDetail::getHoursTraveled)
                .sum();
        this.totalHoursTraveled = total;
    }

    public int getTotalHoursTraveled() {
        setTotalHoursTraveled();
        return this.totalHoursTraveled;
    }

    public CarRental() {
        this.details = new ArrayList<>();
    }

}
