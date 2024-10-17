package ar.edu.utnfrc.backend.services;

import ar.edu.utnfrc.backend.repositories.interfaces.Repository;
import ar.edu.utnfrc.backend.services.interfaces.Service;

public abstract class ServiceImpl<T, K> implements Service<T, K> {

    protected Repository<T, K> repository;

    @Override
    public boolean existData() {
        return this.repository.countRecords() > 0;
    }
}
