package ar.edu.utnfrc.sping_service_web.model.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PaymentDTO {

    //   2. Ingresar un pago, en el body viajan los datos de la fecha de pago, el monto total y el
    //   listado de codigos de  alquileres que paga
    private LocalDate paymentDate;

    private int totalAmount;

    private List<Long> rentsId;
}
