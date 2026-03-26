package edu.aptashynskyi.aws.probe.domain.trainers;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class TrainerId implements Serializable {
    private UUID id;

    public TrainerId() {
    }

    public TrainerId(UUID id) {
        this.id = id;
    }

    public UUID id() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (TrainerId) obj;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TrainerId[" +
                "id=" + id + ']';
    }

}
