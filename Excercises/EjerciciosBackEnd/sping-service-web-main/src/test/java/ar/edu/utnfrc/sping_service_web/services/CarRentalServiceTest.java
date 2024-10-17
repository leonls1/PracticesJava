package ar.edu.utnfrc.sping_service_web.services;

import ar.edu.utnfrc.sping_service_web.exceptionHandling.exceptions.CarRentalNotFoundException;
import ar.edu.utnfrc.sping_service_web.model.entities.CarRental;
import ar.edu.utnfrc.sping_service_web.repository.CarRentalRepository;
import ar.edu.utnfrc.sping_service_web.service.CarRentalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarRentalServiceTest {

    @Mock
    private CarRentalRepository carRentalRepositoryMock;

    @InjectMocks
    private CarRentalService carRentalService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        //arrange
        CarRental rental = new CarRental();
        rental.setId(1l);
        rental.setPaid(false);
        when(carRentalRepositoryMock.findById(1l)).thenReturn(Optional.of(rental));
    }

    @Test
    public void findById_ShouldReturnCarRental_WhenCarRentalExists(){
        //arrange/preparacion
        //ya definido en el setUp

        //act/Ejecutar
        CarRental result = carRentalService.findById(1l);

        //assert/afirmar
        assertNotNull(result);
        assertEquals(1l, result.getId());
        //verify//verificar
        verify(carRentalRepositoryMock,atLeastOnce()).findById(1l);
    }

    @Test
    public void findById_ShouldThrowsException_WhenCarRentalDoesNotExists(){
        //arrange
        when(carRentalRepositoryMock.findById(1L)).thenReturn(Optional.empty());

        //act
        //aca como no existe el resultado tendria que darme la excepcion personalizada
        CarRentalNotFoundException ex = assertThrows(CarRentalNotFoundException.class,() ->
                carRentalService.findById(1l));

        assertEquals("There isn't a rent with that id:1", ex.getMessage());

        verify(carRentalRepositoryMock, times(1)).findById(1l);
    }

    @Test
    public void setRentalToPaid_WhenRentalExists(){
        //arrange, isn't necessary
        //act
        CarRental rental = carRentalService.findById(1l);
        carRentalService.setRentalToPayed(1l);

        //assert
        assertEquals(true, rental.isPaid());

    }

}
