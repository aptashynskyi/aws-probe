package edu.aptashynskyi.aws.probe.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "attendees")
public class Attendee {

    @EmbeddedId
    private AttendeeId id;
    private String firstName;
    private String lastName;

    public Attendee() {
    }

    public Attendee(AttendeeId id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AttendeeId id() {
        return id;
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
