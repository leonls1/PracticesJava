package ar.edu.utnfrc.sping_service_web.services;


import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ClientServiceImplTest {
//
//    private ClientService clientService;
//    private ClientRepository clientRepositoryMock;
//    private ClientCompanyRepository companyRepositoryMock;
//
//    @BeforeEach
//    public void setup() {
//        clientRepositoryMock = mock(ClientRepository.class);
//        companyRepositoryMock = mock(ClientCompanyRepository.class);
//        clientService = new ClientServiceImpl(clientRepositoryMock, companyRepositoryMock);
//    }
//
//    @AfterEach
//    public void tearDown(){
//        reset(clientRepositoryMock, companyRepositoryMock);
//    }
//
//    @Test
//    public void clientServiceFindByIdThrowExceptionWhenNotExists() {
//        // arrange
//        when(clientRepositoryMock.findById(anyInt())).thenReturn(Optional.empty());
//
//        // act
//        NoSuchElementException ex = assertThrows(NoSuchElementException.class, () -> {
//            clientService.findById(anyInt());
//        });
//
//        // assert
//        assertEquals("No existe", ex.getMessage());
//        verify(clientRepositoryMock, atLeastOnce()).findById(anyInt());
//    }
//
//    @Test
//    public void clientServiceFindByIdSuccessfullyGetAClient() {
//        // arrange
//        Client clientToReturn = new Client(1, "Juan", "Perez");
//        when(clientRepositoryMock.findById(anyInt())).thenReturn(Optional.of(clientToReturn));
//
//        // act
//        Client client = clientService.findById(1);
//
//        // assert
//        assertNotNull(client);
//        assertEquals(clientToReturn.getId(), client.getId());
//        assertEquals(clientToReturn.getFirstName(), client.getFirstName());
//        assertEquals(clientToReturn.getLastName(), client.getLastName());
//        verify(clientRepositoryMock, atLeastOnce()).findById(anyInt());
//    }


}
