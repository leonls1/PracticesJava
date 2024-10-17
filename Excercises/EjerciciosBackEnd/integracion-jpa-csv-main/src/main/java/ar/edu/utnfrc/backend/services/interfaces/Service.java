package ar.edu.utnfrc.backend.services.interfaces;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public interface Service <T, K> {

    void bulkInsert(URI fileCsvPath) throws IOException;
    List<T> findAll();
    boolean existData();

}
