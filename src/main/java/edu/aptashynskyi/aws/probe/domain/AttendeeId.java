package edu.aptashynskyi.aws.probe.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class AttendeeId implements Serializable {
    private UUID id;

    public AttendeeId(UUID id) {
        this.id = id;
    }

    public AttendeeId() {
    }

    public UUID id() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (AttendeeId) obj;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AttendeeId[" +
                "id=" + id + ']';
    }

}
