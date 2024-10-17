package ar.edu.utnfrc.backend.entities.compositeKey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PreguntaExamenKey implements Serializable {

    @Column(name = "pregunta_id")
    private int preguntaId;

    @Column(name = "examen_id")
    private int examenId;

    public PreguntaExamenKey() {}

    public PreguntaExamenKey(int preguntaId, int examenId) {
        this.preguntaId = preguntaId;
        this.examenId = examenId;
    }

    public int getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(int preguntaId) {
        this.preguntaId = preguntaId;
    }

    public int getExamenId() {
        return examenId;
    }

    public void setExamenId(int examenId) {
        this.examenId = examenId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreguntaExamenKey that = (PreguntaExamenKey) o;
        return preguntaId == that.preguntaId && examenId == that.examenId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(preguntaId, examenId);
    }
}
