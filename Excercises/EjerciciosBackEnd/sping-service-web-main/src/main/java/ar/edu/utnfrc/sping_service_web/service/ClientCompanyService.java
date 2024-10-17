package ar.edu.utnfrc.sping_service_web.service;

import ar.edu.utnfrc.sping_service_web.exceptionHandling.exceptions.ClientCompanyHasUnpaidRentException;
import ar.edu.utnfrc.sping_service_web.exceptionHandling.exceptions.ClientCompanyNotFoundException;
import ar.edu.utnfrc.sping_service_web.model.entities.Client;
import ar.edu.utnfrc.sping_service_web.model.entities.ClientCompany;
import ar.edu.utnfrc.sping_service_web.repository.ClientCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCompanyService extends ServiceImp<ClientCompany, Long> {
    private final ClientCompanyRepository clientCompanyRepository;
    private final ClientService clientService;

    @Override
    public void create(ClientCompany entity) {
        clientCompanyRepository.save(entity);
    }

    @Override
    public ClientCompany findById(Long id) {
        return clientCompanyRepository.findById(id).
                orElseThrow(() -> new ClientCompanyNotFoundException("The company with that id doesn't exists"));
    }

    @Override
    public List<ClientCompany> findAll() {
        return clientCompanyRepository.findAll();
    }

    @Override
    public ClientCompany update(ClientCompany entity) {
        return clientCompanyRepository.save(entity);
    }

    //   2. Dar de baja una empresa (eso quita todos los empleados), solo si no tiene alquileres impagos
    @Override
    public void deleteById(Long id) {
        ClientCompany company = findById(id);
        if (company.getClients().stream().anyMatch(ClientService::hasUnpaidRents)) {
            throw new ClientCompanyHasUnpaidRentException("there are one or more clients with unpaid rents");
        } else {
            clientCompanyRepository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return clientCompanyRepository.existsById(id);
    }

    public void associateClientToToACompany(Long companyId, Long clientId) {
        Client client = clientService.findById(clientId);
        ClientCompany company = findById(companyId);
        company.getClients().add(client);
        update(company);
    }


}
