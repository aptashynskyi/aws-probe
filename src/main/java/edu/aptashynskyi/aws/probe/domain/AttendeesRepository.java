package edu.aptashynskyi.aws.probe.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import static java.util.UUID.randomUUID;

@Repository
public interface AttendeesRepository extends JpaRepository<Attendee, AttendeeId> {
    default AttendeeId newId() {
        return new AttendeeId(randomUUID());
    }
}
