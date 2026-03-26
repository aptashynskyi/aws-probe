package edu.aptashynskyi.aws.probe.domain;

import java.util.UUID;

public record AttendeeView(UUID id, String firstName, String lastName) {
    static AttendeeView from(Attendee attendee) {
        return new AttendeeView(attendee.getId().id(), attendee.firstName(), attendee.lastName());
    }
}
