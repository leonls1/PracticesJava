package ar.edu.utnfrc.sping_service_web.controllers;

import ar.edu.utnfrc.sping_service_web.controller.CarRentalController;
import ar.edu.utnfrc.sping_service_web.exceptionHandling.exceptions.CarRentalNotFoundException;
import ar.edu.utnfrc.sping_service_web.model.entities.CarRental;
import ar.edu.utnfrc.sping_service_web.service.CarRentalService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jfr.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(CarRentalController.class)
public class CarRentalControllerTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarRentalService serviceMock;

    private CarRental carRental;


    @BeforeEach
    public void setUp() {
        carRental = new CarRental();
        carRental.setId(1l);
        carRental.setPaid(false);
        carRental.setTotalHoursTraveled(10);
    }


    @Test
    public void createCarRental() throws Exception {
        //arrange(en el setup)
        //act
        mockMvc.perform(post("/api/v1/car-rental/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(carRental)))
                .andExpect(status().isOk())
                .andExpect(content().string("Car Rental successfully created"));
        System.out.println("paso el test de createCarRental");
    }

    @Test
    public void getCarRentalWithId_shouldReturnCarRental_WhenIdIsExists() throws Exception {
        when(serviceMock.findById(1l)).thenReturn(carRental);
        mockMvc.perform(get("/api/v1/car-rental/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1l))
                .andExpect(jsonPath("$.totalHoursTraveled").value(0))
                .andExpect(jsonPath("$.paid").value(false));

        System.out.println("test get by id passed");
    }

    @Test
    public void getCarRentalWithId_shouldThrowException_WhenIdDoesNotExists() throws Exception {
        when(serviceMock.findById(anyLong())).thenThrow(new CarRentalNotFoundException("there is no rentals with that id:1"));
        mockMvc.perform(get("/api/v1/car-rental/1"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("there is no rentals with that id:1"));
    }


    @Test
    public void getAllRentalPaged_ShouldReturnAPageWithRentals() throws Exception {
        //arrange
        List<CarRental> rentals = new ArrayList<>();
        rentals.add(carRental);
        CarRental rental2 = new CarRental();
        rental2.setId(2l);
        rental2.setPaid(false);
        rentals.add(rental2);
        Page<CarRental> page = new PageImpl<>(rentals, PageRequest.of(0, 10), rentals.size());
        when(serviceMock.findAll(0, 10)).thenReturn(page);

        //act and verify
        mockMvc.perform(get("/api/v1/car-rental/")
                        .param("page", "0")
                        .param("size", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content.length()").value(2))
                .andExpect(jsonPath("$.content[1].id").value(2l))
                .andExpect(jsonPath("$.content[0].id").value(1l))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllRentalsPaged_ShouldReturnAMessage_WhenThereIsNotRentalsSaved() throws Exception {
        //arrange
        when(serviceMock.findAll(0,10))
                .thenReturn(new PageImpl<CarRental>(new ArrayList<>(),PageRequest.of(0,10),0));

        mockMvc.perform(get("/api/v1/car-rental/")
                .param("page","0")
                .param("size","10"))
                .andExpect(status().isNoContent())
                .andExpect(content().string("No rentals to show"));
    }

}
