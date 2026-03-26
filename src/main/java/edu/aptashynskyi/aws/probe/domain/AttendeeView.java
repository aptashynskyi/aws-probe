package edu.aptashynskyi.aws.probe.domain;

import java.util.UUID;

public record AttendeeView(UUID id, String firstName, String lastName) {
    static AttendeeView from(Attendee attendee) {
        return new AttendeeView(attendee.id().id(), attendee.firstName(), attendee.lastName());
    }
}
