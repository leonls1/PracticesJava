package ar.edu.utnfrc.sping_service_web.services;

import ar.edu.utnfrc.sping_service_web.exceptionHandling.exceptions.ClientCompanyHasUnpaidRentException;
import ar.edu.utnfrc.sping_service_web.model.entities.CarRental;
import ar.edu.utnfrc.sping_service_web.model.entities.CarRentalDetail;
import ar.edu.utnfrc.sping_service_web.model.entities.Client;
import ar.edu.utnfrc.sping_service_web.model.entities.ClientCompany;
import ar.edu.utnfrc.sping_service_web.repository.ClientCompanyRepository;
import ar.edu.utnfrc.sping_service_web.service.ClientCompanyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


public class ClientCompanyServiceTest {

    @Mock
    private ClientCompanyRepository repository;

    @InjectMocks
    private ClientCompanyService service;

    private ClientCompany company;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        //arrange
        company = new ClientCompany();
        company.setId(1l);

        when(repository.findById(1l)).thenReturn(Optional.of(company));

    }

    //   2. Dar de baja una empresa (eso quita todos los empleados),
    //   solo si no tiene alquileres impagos
    @Test
    public void deleteById_ThrowsException_WhenThereAreOneOrMoreUnpaidRental() {
        //arrange
        Client client = new Client();
        CarRentalDetail detail = new CarRentalDetail();

        CarRental rental = new CarRental();
        rental.setPaid(false);

        detail.setCarRental(rental);
        client.getDetails().add(detail);
        company.getClients().add(client);

        //act
        ClientCompanyHasUnpaidRentException ex = assertThrows(ClientCompanyHasUnpaidRentException.class,
                () -> service.deleteById(1l));
    }

    @Test
    public void deleteById_CompanyAndItsClientsAreDeleted_WhenThereAreNotUnpaidRentals(){
        //arrange

        Client client = new Client();
        CarRentalDetail detail = new CarRentalDetail();

        CarRental rental = new CarRental();
        rental.setPaid(true);

        detail.setCarRental(rental);
        client.getDetails().add(detail);
        company.getClients().add(client);

        //act
        service.deleteById(1l);

        //verify
        verify(repository, atLeastOnce()).deleteById(1l);

    }

}
