package edu.aptashynskyi.aws.probe.domain;

import jakarta.persistence.*;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Persistable;

@Entity
@Table(name = "attendees")
public class Attendee implements Persistable<AttendeeId> {

    @EmbeddedId
    private AttendeeId id;
    private String firstName;
    private String lastName;

    @Transient
    private boolean isNew = false;

    public Attendee() {
    }

    public Attendee(AttendeeId id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isNew = true;
    }

    @Override
    public @NonNull AttendeeId getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return this.isNew;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Attendee attendee)) return false;

        return id.equals(attendee.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
